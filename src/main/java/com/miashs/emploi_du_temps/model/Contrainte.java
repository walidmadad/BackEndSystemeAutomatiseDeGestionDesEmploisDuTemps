package com.miashs.emploi_du_temps.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDate;
import java.time.LocalTime;


@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Contrainte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String titre;
    private String typeContraite ;
    private String description;
    private LocalDate dateDeContrainte;
    private LocalTime dateDebutContrainte;
    private LocalTime dateFinContrainte;

    @ManyToOne
    @JoinColumn(name = "enseignant_id")
    private Enseignant enseignant;
}