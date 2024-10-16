package com.miashs.emploi_du_temps.modele;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.sql.Time;
import java.util.Date;
@Data
@Entity
public class Contrainte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private enum type_contraite {Personnel,Vacances, Autres};
    private String description;
    private Date date_begin;
    private Time time_degin;
    private Date date_end;
    private Time time_end;
    private boolean approved;

}
