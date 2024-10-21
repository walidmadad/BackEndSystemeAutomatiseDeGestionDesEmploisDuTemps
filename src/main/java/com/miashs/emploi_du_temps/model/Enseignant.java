package com.miashs.emploi_du_temps.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
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
    private List<Cours> cours;


}