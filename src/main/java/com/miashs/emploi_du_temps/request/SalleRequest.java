package com.miashs.emploi_du_temps.request;

import com.miashs.emploi_du_temps.model.Departement;
import lombok.Data;

@Data
public class SalleRequest {
    private String nom;
    private Long id;
    private Long capacite;
    private String typeSalle;
    private Departement departement;
}