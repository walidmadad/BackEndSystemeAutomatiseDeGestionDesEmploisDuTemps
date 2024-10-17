package com.miashs.emploi_du_temps.service.departement;

import com.miashs.emploi_du_temps.modele.Departement;
import com.miashs.emploi_du_temps.request.DepartementRequest;

import java.util.List;

public interface IDepartementService {
    // Ajouter, modifier, supprimer, et récupérer des départements

    Departement ajouterDepartement(DepartementRequest departementRequest);
    Departement modifierDepartement(DepartementRequest departementRequest, Long id);
    void supprimerDepartement(Long id);

    Departement getDepartementById(Long id);
    Departement getDepartementByName(String nom);
    List<Departement> getAllDepartements();

}
