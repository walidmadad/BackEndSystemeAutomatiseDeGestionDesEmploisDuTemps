package com.miashs.emploi_du_temps.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@DiscriminatorValue("ADMIN")
public class Admin extends Utilisateur {

    @ManyToOne
    @JoinColumn(name = "departement_id")
    private Departement departement;


}
