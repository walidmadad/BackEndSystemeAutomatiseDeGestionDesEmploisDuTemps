package com.miashs.emploi_du_temps.modele;

import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class Matiere {
    private long id;
    private String nom;
    private String code;

}
