package com.miashs.emploi_du_temps.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Salle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private Long capacite;
    private String typeSalle;

    @ManyToOne
    @JoinColumn(name = "departement_id")
    private Departement departement;

    @JsonIgnore
    @OneToMany(mappedBy = "salle")
    private List<Occupation> occupations;

    @OneToMany(mappedBy = "salle")
    private List<Equipement> equipements;
}