package com.miashs.emploi_du_temps.modele;

import lombok.Data;

import java.util.Date;

@Data
public class Enseignant {
    private long id;
    private String Nom;
    private String prenom;
    private Date date_joining;
    private String email;
    private String mdp;


}
