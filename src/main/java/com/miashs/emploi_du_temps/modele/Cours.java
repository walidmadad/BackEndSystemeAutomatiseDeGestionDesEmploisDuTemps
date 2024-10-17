package com.miashs.emploi_du_temps.modele;

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
    private Date Jour;
    private Time heure_debut;
    private Time heure_fin;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "formation_id")
    private Formation formation;
}
