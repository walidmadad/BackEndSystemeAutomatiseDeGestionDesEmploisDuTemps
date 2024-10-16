package com.miashs.emploi_du_temps.modele;

import jakarta.persistence.Entity;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Niveau {
    private int id;
    private String nom;
}
