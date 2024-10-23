package com.miashs.emploi_du_temps.model;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Time;
import java.util.Date;

@Data
@Entity
public class Occupation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private Date jour;
    private Time heure_debut;
    private Time heure_fin;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "salle_id")
    private Salle salle;

}
