package com.miashs.emploi_du_temps.modele;

import jakarta.persistence.Entity;
import lombok.*;

@Data
@Entity
public class Niveau {
    private long id;
    private String nom;
}
