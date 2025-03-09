package com.miashs.emploi_du_temps.request;

import com.miashs.emploi_du_temps.model.Departement;
import com.miashs.emploi_du_temps.model.Niveau;
import lombok.Data;

@Data
public class FormationRequest {
    private Long id;
    private String nom;

    private Departement departement;
    private Niveau niveau;
}