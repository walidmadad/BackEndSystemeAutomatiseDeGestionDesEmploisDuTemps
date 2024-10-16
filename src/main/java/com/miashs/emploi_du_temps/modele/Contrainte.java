package com.miashs.emploi_du_temps.modele;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Time;
import java.util.Date;
@Data
@Entity
public class Contrainte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String type_contraite ;
    private String description;
    private Date date_begin;
    private Time time_degin;
    private Date date_end;
    private Time time_end;
    private boolean approved;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "enseignant_id")
    private Enseignant enseignant;
}
