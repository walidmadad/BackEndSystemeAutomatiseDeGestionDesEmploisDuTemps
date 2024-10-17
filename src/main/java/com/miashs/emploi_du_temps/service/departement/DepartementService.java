package com.miashs.emploi_du_temps.service.departement;

import com.miashs.emploi_du_temps.Exception.AlreadyExistsException;
import com.miashs.emploi_du_temps.Exception.ResourceNotFoundException;
import com.miashs.emploi_du_temps.modele.Departement;
import com.miashs.emploi_du_temps.repository.DepartementRepository;
import com.miashs.emploi_du_temps.request.DepartementRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DepartementService implements IDepartementService {
    private final DepartementRepository departementRepository;

    @Override
    public Departement ajouterDepartement(DepartementRequest departementRequest) {
        Departement departement = new Departement();
        departement.setNom(departementRequest.getNom());

        return Optional.ofNullable(departement)
                .filter(d -> !departementRepository.existsByName(d.getNom()))
                .map(departementRepository::save)
                .orElseThrow(() -> new AlreadyExistsException("Département déjà existant : " + departement.getNom()));
    }

    @Override
    public Departement modifierDepartement(DepartementRequest departementRequest, Long id) {
        return Optional.ofNullable(getDepartementById(id)).map(oldDepartement -> {
            oldDepartement.setNom(departementRequest.getNom());
            return departementRepository.save(oldDepartement);
        }).orElseThrow(() -> new RuntimeException("Departement Not Found"));
    }

    @Override
    public void supprimerDepartement(Long id) {
        departementRepository.findById(id).
                ifPresentOrElse(departementRepository :: delete, () -> {
            throw new RuntimeException("Departement Not Found");
        });
    }

    @Override
    public Departement getDepartementById(Long id) {
        return departementRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Departement Not Found"));
    }

    @Override
    public Departement getDepartementByName(String nom) {
        return departementRepository.findByName(nom);
    }

    @Override
    public List<Departement> getAllDepartements() {
        return departementRepository.findAll();
    }

}
