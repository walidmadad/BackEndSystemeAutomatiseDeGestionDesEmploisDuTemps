package com.miashs.emploi_du_temps.service.departement;

import com.miashs.emploi_du_temps.Exception.ResourceNotFoundException;
import com.miashs.emploi_du_temps.model.Departement;
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
    public Departement addDepartement(DepartementRequest request) {
        Departement departement = new Departement();
        departement.setNom(request.getNom());
        return departementRepository.save(departement);
    }

    @Override
    public Departement updateDepartement(DepartementRequest request, Long id) {
        Optional<Departement> departementExistant = departementRepository.findById(id);

        if (departementExistant.isPresent()) {
            Departement departement = departementExistant.get();
            departement.setNom(request.getNom());
            return departementRepository.save(departement);
        }else {
            throw new ResourceNotFoundException("Departement Not Found");
        }
    }

    @Override
    public void deleteDepartement(Long id) {
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
    public Departement getDepartementByNom(String nom) {
        return departementRepository.findByNom(nom);
    }

    @Override
    public List<Departement> getAllDepartements() {
        return departementRepository.findAll();
    }

}