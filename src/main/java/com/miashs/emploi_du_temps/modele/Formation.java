package com.miashs.emploi_du_temps.modele;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Formation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nom;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "departement_id")
    private Departement departement;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "niveau_id")
    private Niveau niveau;

    @JsonIgnore
    @OneToMany(mappedBy = "formation")
    private List<Matiere> matieres;

    @JsonIgnore
    @OneToMany(mappedBy = "formation")
    private List<Cours> cours;

    public Formation(String nom, Departement departement, Niveau niveau) {
        this.nom = nom;
        this.departement = departement;
        this.niveau = niveau;
    }
}