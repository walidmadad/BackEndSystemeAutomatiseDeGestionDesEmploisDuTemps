package com.miashs.emploi_du_temps.service.departement;

import com.miashs.emploi_du_temps.modele.Departement;

import java.util.List;

public interface IDepartementService {
    // Ajouter, modifier, supprimer, et récupérer des départements

    Departement ajouterDepartement(Departement departement);
    Departement modifierDepartement(Departement departement, Long id);
    void supprimerDepartement(Long id);

    Departement getDepartementById(Long id);
    Departement getDepartementByName(String nom);
    List<Departement> getAllDepartements();

}
