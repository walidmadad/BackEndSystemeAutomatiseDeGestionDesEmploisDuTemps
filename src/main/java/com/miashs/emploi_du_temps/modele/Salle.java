package com.miashs.emploi_du_temps.modele;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Salle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long capacite;
    private typeSalle typeSale;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "departement_id")
    private Departement departement;

}
