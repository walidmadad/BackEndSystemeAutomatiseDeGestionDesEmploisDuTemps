package com.miashs.emploi_du_temps.service.cours;

import com.miashs.emploi_du_temps.modele.Cours;
import com.miashs.emploi_du_temps.request.CoursRequest;

import java.sql.Time;
import java.util.Date;
import java.util.List;

public interface ICoursService {
    Cours ajouterCours(CoursRequest coursRequest);
    Cours modifierCours(CoursRequest coursRequest, Long id);
    void supprimerCours(Long id);

    Cours getCoursById(Long id);
    List<Cours> getCoursBymatiere(Long idMatiere);
    List<Cours> getCoursByFormation(Long idFormation);
    List<Cours> getCoursAll();
    Cours getByJourEtHeure(Date date, Time heureDebut, Time heureFin);
}
