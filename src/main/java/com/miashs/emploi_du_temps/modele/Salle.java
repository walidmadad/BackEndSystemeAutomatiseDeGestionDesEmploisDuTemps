package com.miashs.emploi_du_temps.modele;

import lombok.Data;

@Data
public class Salle {
    private long id;
    private long capacite;
    private enum type_salle {Amphi, TD, TP};


}
