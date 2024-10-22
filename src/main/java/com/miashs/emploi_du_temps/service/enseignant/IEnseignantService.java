package com.miashs.emploi_du_temps.service.enseignant;

import com.miashs.emploi_du_temps.model.Enseignant;
import com.miashs.emploi_du_temps.request.EnseignantRequest;

public interface IEnseignantService {

    Enseignant addenseignant(EnseignantRequest enseignantRequest);
    Enseignant updateenseignant(EnseignantRequest enseignantRequest, Long id);
    void deleteEnseignant(Long id);

    Enseignant getEnseignantByID (long Id);
    Enseignant getEnseignantByNom (String nom);
    Enseignant getEnseignantByPrenom (String prenom);
    Enseignant getEnseignantByEmail (String email);




}
