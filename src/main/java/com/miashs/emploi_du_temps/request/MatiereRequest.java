package com.miashs.emploi_du_temps.request;

import com.miashs.emploi_du_temps.modele.Formation;
import lombok.Data;

@Data
public class MatiereRequest {
    private long id;
    private String nom;
    private String code;

    private Formation formation;
}
