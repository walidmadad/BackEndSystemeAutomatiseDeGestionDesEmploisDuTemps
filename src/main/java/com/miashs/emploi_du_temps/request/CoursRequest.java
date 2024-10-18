package com.miashs.emploi_du_temps.request;

import com.miashs.emploi_du_temps.modele.Enseignant;
import com.miashs.emploi_du_temps.modele.Formation;
import com.miashs.emploi_du_temps.modele.Matiere;
import com.miashs.emploi_du_temps.modele.Salle;
import lombok.Data;

import java.sql.Time;
import java.util.Date;

@Data
public class CoursRequest {
    private Date jour;
    private Time heureDebut;
    private Time heureFin;
    private String typeDeCours;
    private Formation formation;
    private Enseignant enseignant;
    private Matiere matiere;
    private Salle salle;
}
