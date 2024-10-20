package com.miashs.emploi_du_temps.service.formation;

import com.miashs.emploi_du_temps.modele.Formation;
import com.miashs.emploi_du_temps.request.FormationRequest;

import java.util.List;

public interface IFormationService {

    Formation addFormation(FormationRequest formationRequest);
    Formation updateFormation(FormationRequest formationRequest, Long id);
    void deleteFormation(Long id);

    Formation getFormationById(Long id);
    List<Formation> getAllFormations();
    List<Formation> getFormationByNom(String nom);
    List<Formation> getFormationsByNiveau(String niveau);
    List<Formation> getFormationsByDepartement(String departement);
    List<Formation> getFormationsByDepartementAndNiveau(String departement, String niveau);



}