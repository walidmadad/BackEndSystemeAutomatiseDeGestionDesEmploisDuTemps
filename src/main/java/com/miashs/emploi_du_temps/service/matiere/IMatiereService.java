package com.miashs.emploi_du_temps.service.matiere;

import com.miashs.emploi_du_temps.modele.Matiere;
import com.miashs.emploi_du_temps.request.MatiereRequest;

import java.util.List;

public interface IMatiereService {

    Matiere ajouterMatiere(MatiereRequest matiereRequest);
    Matiere modifierMatiere(MatiereRequest matiereRequest, Long id);
    void supprimerMatiere(Long id);

    Matiere getMatiereById(Long id);
    List<Matiere> getAllMatieres();
    List<Matiere> getMatieresByFormation(String nomFormation);
    List<Matiere> getMatieresByEnseignant(String nomEnseignant);

}