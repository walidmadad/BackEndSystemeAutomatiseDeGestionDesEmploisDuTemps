package com.miashs.emploi_du_temps.modele;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Departement {
    private long id;
    private String nom;

    @OneToMany(mappedBy = "Formation")
    List<Matiere> matieres;

    @OneToMany(mappedBy = "Salle")
    List<Salle> salles;

}
