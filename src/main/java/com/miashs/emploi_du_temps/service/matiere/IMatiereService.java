package com.miashs.emploi_du_temps.service.matiere;

import com.miashs.emploi_du_temps.model.Matiere;
import com.miashs.emploi_du_temps.request.MatiereRequest;

import java.util.List;

public interface IMatiereService {

    Matiere addMatiere(MatiereRequest matiereRequest);
    Matiere updateMatiere(MatiereRequest matiereRequest, Long id);
    void deleteMatiere(Long id);

    Matiere getMatiereById(Long id);
    List<Matiere> getAllMatieres();
    Matiere getMatiereByNom(String nomMatiere);
    List<Matiere> getMatieresByFormation(String nomFormation);
    Matiere getMatiereByCode(String codeMatiere);
    List<Matiere> getMatieresByEnseignant(String nomEnseignant);
}
