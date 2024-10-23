package com.miashs.emploi_du_temps.service.enseignant;

import com.miashs.emploi_du_temps.model.Enseignant;
import com.miashs.emploi_du_temps.model.Formation;
import com.miashs.emploi_du_temps.request.EnseignantRequest;

import java.util.List;

public interface IEnseignantService {

    Enseignant addEnseignant(EnseignantRequest enseignantRequest);
    Enseignant updateEnseignant(EnseignantRequest enseignantRequest, Long id);
    void deleteEnseignant(Long id);

    List<Enseignant> getAllEnseignant();
    Enseignant getEnseignantByID (long Id);
    Enseignant getEnseignantByNom (String nom);
    Enseignant getEnseignantByPrenom (String prenom);
    Enseignant getEnseignantByEmail (String email);




}
