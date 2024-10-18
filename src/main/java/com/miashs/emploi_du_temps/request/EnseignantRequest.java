package com.miashs.emploi_du_temps.request;

import lombok.Data;

import java.util.Date;

@Data
public class EnseignantRequest {
    private long id;
    private String nom;
    private String prenom;
    private Date date_joining;
    private String email;
    private String mdp;
}
