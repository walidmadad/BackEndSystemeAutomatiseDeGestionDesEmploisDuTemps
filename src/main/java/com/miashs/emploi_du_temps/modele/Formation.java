package com.miashs.emploi_du_temps.modele;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
public class Formation {
    private int id;
    private String nom;


}
