package com.miashs.emploi_du_temps.request;

import com.miashs.emploi_du_temps.model.Formation;
import lombok.Data;

@Data
public class MatiereRequest {
    private Long id;
    private String nom;
    private String code;

    private Formation formation;
}
