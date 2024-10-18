package com.miashs.emploi_du_temps.modele;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
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

}