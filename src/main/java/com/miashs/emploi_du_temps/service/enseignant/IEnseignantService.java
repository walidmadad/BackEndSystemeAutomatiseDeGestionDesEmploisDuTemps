package com.miashs.emploi_du_temps.service.enseignant;

import com.miashs.emploi_du_temps.model.Enseignant;
import com.miashs.emploi_du_temps.request.EnseignantRequest;

import java.util.List;

public interface IEnseignantService {

    Enseignant addEnseignant(EnseignantRequest enseignantRequest);
    Enseignant updateEnseignant(EnseignantRequest enseignantRequest, Long id);
    void deleteEnseignant(Long id);

    List<Enseignant> getAllEnseignant();
    Enseignant getEnseignantById(Long id);
    List<Enseignant> getEnseignantByNom(String nom);
    List<Enseignant> getEnseignantByPrenom(String prenom);
    Enseignant getEnseignantByEmail(String email);
    List<Enseignant> getEnseignantByNomAndPrenom(String nom, String prenom);
    Boolean verifierConnexionEnseignant(String email, String motDePasse);
}