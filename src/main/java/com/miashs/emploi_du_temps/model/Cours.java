package com.miashs.emploi_du_temps.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.util.Date;


@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Cours {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String typedecours;

   @ManyToOne
   @JoinColumn(name = "formation_id")
   private Formation formation;

    @ManyToOne
    @JoinColumn(name = "enseignant_id")
    private Enseignant enseignant;

    @ManyToOne
    @JoinColumn(name = "matiere_id")
    private Matiere matiere;

    @ManyToOne
    @JoinColumn(name = "salle_id")
    private Salle salle;

}