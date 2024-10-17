package com.miashs.emploi_du_temps.service.departement;

import com.miashs.emploi_du_temps.Exception.AlreadyExistsException;
import com.miashs.emploi_du_temps.Exception.RessourceNotFoundException;
import com.miashs.emploi_du_temps.modele.Departement;
import com.miashs.emploi_du_temps.repository.DepartementRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DepartementService implements IDepartementService {
    private final DepartementRepository departementRepository;

    public Departement ajouterDepartement(Departement departement) {
        return Optional.ofNullable(departement).filter( d -> !departementRepository.existsByName(d.getNom()))
                .map(departementRepository::save)
                .orElseThrow(() -> new AlreadyExistsException("Département déjà existant : " + departement.getNom()));
    }

    public Departement modifierDepartement(Departement departement, Long id) {
        return Optional.ofNullable(getDepartementById(id)).map(oldDepartement -> {
            oldDepartement.setNom(departement.getNom());
            return departementRepository.save(oldDepartement);
        }).orElseThrow(()-> new RuntimeException("Departement Not Found"));
    }

    public void supprimerDepartement(Long id) {
        departementRepository.findById(id).
                ifPresentOrElse(departementRepository :: delete, () -> {
            throw new RuntimeException("Departement Not Found");
        });
    }

    public Departement getDepartementById(Long id) {
        return departementRepository.findById(id)
                .orElseThrow(() -> new RessourceNotFoundException("Departement Not Found"));
    }

    public Departement getDepartementByName(String nom) {
        return departementRepository.findByName(nom);
    }

    public List<Departement> getAllDepartements() {
        return departementRepository.findAll();
    }

}
