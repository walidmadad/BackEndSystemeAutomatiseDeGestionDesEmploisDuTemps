package com.miashs.emploi_du_temps.request;

import com.miashs.emploi_du_temps.modele.Departement;
import lombok.Data;

@Data
public class SalleRequest {
    private String nom;
    private long id;
    private long capacite;
    private String typeSalle;

    private Departement departement;
}
