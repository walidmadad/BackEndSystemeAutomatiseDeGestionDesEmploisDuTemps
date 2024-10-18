package com.miashs.emploi_du_temps.service.Enseignant;

import com.miashs.emploi_du_temps.modele.Enseignant;

import java.util.List;

public interface IEnseignantService {

    Enseignant ajouterEnseignant(Enseignant enseignant);
    Enseignant modifierEnseignant(Enseignant enseignant, Long id);
    void supprimerEnseignant(Long id);

    Enseignant getEnseignantById(Long id);
    List<Enseignant> getEnseignantByNom(String nom);
    List<Enseignant> getEnseignantByPrenom(String prenom);
    Enseignant getEnseignantByNomEtPrenom(String nom, String prenom);
    List<Enseignant> getAllEnseignants();


}
