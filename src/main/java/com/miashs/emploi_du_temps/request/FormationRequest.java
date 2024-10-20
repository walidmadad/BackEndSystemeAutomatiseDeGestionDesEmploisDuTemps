package com.miashs.emploi_du_temps.request;

import com.miashs.emploi_du_temps.modele.Departement;
import com.miashs.emploi_du_temps.modele.Niveau;
import lombok.Data;

@Data
public class FormationRequest {
    private long id;
    private String nom;

    private Departement departement;
    private Niveau niveau;
}