package com.miashs.emploi_du_temps.modele;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Matiere {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nom;
    private String code;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "formation_id")
    private Formation formation;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "enseignant_id")
    private Enseignant enseignant;


}
