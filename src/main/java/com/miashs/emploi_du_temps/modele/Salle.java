package com.miashs.emploi_du_temps.modele;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Salle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nom;
    private long capacite;
    private String typeSalle;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "departement_id")
    private Departement departement;

    @JsonIgnore
    @OneToMany(mappedBy = "salle")
    private List<Cours> cours;

    public Salle(String nom, long capacite, String typeSalle, Departement departement) {
        this.nom = nom;
        this.capacite = capacite;
        this.typeSalle = typeSalle;
        this.departement = departement;
    }
}