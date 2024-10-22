package com.miashs.emploi_du_temps.request;


import com.miashs.emploi_du_temps.model.Matiere;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class EnseignantRequest {
    private long ID;
    private String nom;
    private String prenom;
    private Date date_entre;
    private String email;
    private String mdp;

}
