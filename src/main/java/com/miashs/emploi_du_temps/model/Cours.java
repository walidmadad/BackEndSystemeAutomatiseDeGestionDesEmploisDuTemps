package com.miashs.emploi_du_temps.model;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Time;
import java.util.Date;


@Data
@Entity
public class Cours {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private Date jour;
    private Time heure_debut;
    private Time heure_fin;
    private String TypeDeCours;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "formation_id")
    private Formation formation;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "enseignant_id")
    private Enseignant enseignant;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "matiere_id")
    private Matiere matiere;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "salle_id")
    private Salle salle;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "emploidetemps_id")
    private EmploiDeTemps emploiDeTemps;

}