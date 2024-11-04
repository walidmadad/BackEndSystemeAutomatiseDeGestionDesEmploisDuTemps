package com.miashs.emploi_du_temps.service.cours;

import com.miashs.emploi_du_temps.model.Cours;
import com.miashs.emploi_du_temps.model.Enseignant;
import com.miashs.emploi_du_temps.model.Matiere;
import com.miashs.emploi_du_temps.request.CoursRequest;

import java.util.List;

public interface ICoursService {

    Cours addCours (CoursRequest coursRequest);
    Cours updateCours (CoursRequest coursRequest, Long id);
    void deleteCours (Long id);

    List<Cours> getCoursByEnseignant(Long enseignant_id);
    List<Cours> getCoursByMatiere(Long matiere_id);
    List<Cours>  getCoursByMatiereAndType(Long matiere_id, String type);
    List<Cours>  getCoursByEnseignantAndType (Long enseigant_id, String type);
    List<Cours> getAllCours();
}
