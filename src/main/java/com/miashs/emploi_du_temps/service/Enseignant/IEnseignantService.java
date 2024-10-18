package com.miashs.emploi_du_temps.service.Enseignant;

import com.miashs.emploi_du_temps.modele.Enseignant;
import com.miashs.emploi_du_temps.request.EnseignantRequest;

import java.util.List;

public interface IEnseignantService {

    Enseignant addEnseignant(EnseignantRequest enseignantRequest);
    Enseignant updateEnseignant(EnseignantRequest enseignantRequest, Long id);
    void deleteEnseignant(Long id);

    Enseignant getEnseignantById(Long id);
    List<Enseignant> getEnseignantByNom(String nom);
    List<Enseignant> getEnseignantByPrenom(String prenom);
    Enseignant getEnseignantByNomAndPrenom(String nom, String prenom);
    List<Enseignant> getEnseignantsByMatiere(String matiere);
    List<Enseignant> getAllEnseignants();


}
