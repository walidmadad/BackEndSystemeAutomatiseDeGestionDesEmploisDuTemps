package com.miashs.emploi_du_temps.service.cours;

import com.miashs.emploi_du_temps.modele.Cours;
import com.miashs.emploi_du_temps.request.CoursRequest;

import java.sql.Time;
import java.util.Date;
import java.util.List;

public interface ICoursService {
    Cours addCours(CoursRequest coursRequest);
    Cours updateCours(CoursRequest coursRequest, Long id);
    void deleteCours(Long id);

    Cours getCoursById(Long id);
    List<Cours> getCoursByMatiere(Long idMatiere);
    List<Cours> getCoursByFormation(Long idFormation);
    List<Cours> getAllCours();
    Cours getCoursByJourEtHeure(Date date, Time heureDebut, Time heureFin);
}
