package com.miashs.emploi_du_temps.service.departement;

import com.miashs.emploi_du_temps.model.Departement;
import com.miashs.emploi_du_temps.request.DepartementRequest;

import java.util.List;

public interface IDepartementService {
    // Ajouter, modifier, supprimer, et récupérer des départements

    Departement addDepartement(DepartementRequest departementRequest);
    Departement updateDepartement(DepartementRequest departementRequest, Long id);
    void deleteDepartement(Long id);

    Departement getDepartementById(Long id);
    Departement getDepartementByNom(String nom);
    List<Departement> getAllDepartements();

}