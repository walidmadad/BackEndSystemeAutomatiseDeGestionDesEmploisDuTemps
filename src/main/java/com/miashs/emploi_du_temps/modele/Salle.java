package com.miashs.emploi_du_temps.modele;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
public class Salle {
    private long id;
    private long capacite;
    private enum type_salle {Amphi, TD, TP};


}
