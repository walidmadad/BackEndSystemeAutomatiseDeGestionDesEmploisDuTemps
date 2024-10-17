package com.miashs.emploi_du_temps.service.formation;

import com.miashs.emploi_du_temps.modele.Formation;
import com.miashs.emploi_du_temps.request.FormationRequest;

import java.util.List;

public interface IFormationService {

    Formation ajouterFormation(FormationRequest formationRequest);
    Formation modifierFormation(FormationRequest formationRequest, Long id);
    void supprimerFormation(Long id);

    Formation getFormationById(Long id);
    List<Formation> getAllFormations();
    Formation getFormationByName(String nom);
    List<Formation> getFormationsByNiveau(String niveau);
    List<Formation> getFormationsByDepartement(String departement);
    List<Formation> getFormationsByDepartementAndNiveau(String departement, String niveau);



}
