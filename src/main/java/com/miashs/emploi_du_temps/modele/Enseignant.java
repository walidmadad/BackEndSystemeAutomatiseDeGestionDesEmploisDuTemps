package com.miashs.emploi_du_temps.modele;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Entity
public class Enseignant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nom;
    private String prenom;
    private Date date_joining;
    private String email;
    private String mdp;


    @JsonIgnore
    @OneToMany(mappedBy = "enseignant")
    private List<Notification> notifications;

    @JsonIgnore
    @OneToMany(mappedBy = "enseignant")
    private List<Contrainte> Contraintes;

    @JsonIgnore
    @OneToMany(mappedBy = "enseignant")
    private List<EnseignantMatiere> Enseignant_matiere;


}
