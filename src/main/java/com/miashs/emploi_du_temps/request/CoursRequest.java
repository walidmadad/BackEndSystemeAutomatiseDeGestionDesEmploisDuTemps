package com.miashs.emploi_du_temps.request;


import com.miashs.emploi_du_temps.model.Enseignant;
import com.miashs.emploi_du_temps.model.Formation;
import com.miashs.emploi_du_temps.model.Matiere;
import com.miashs.emploi_du_temps.model.Salle;
import lombok.Data;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

@Data
public class CoursRequest {

    private Long id;
    private Matiere matiere;
    private Enseignant enseignant;
    private Formation formation;
    private Salle salle;
    private String typeDeCours;

    private LocalDate dateDeCours;
    private LocalTime debutDeCours;
    private LocalTime finDeCours;
}
