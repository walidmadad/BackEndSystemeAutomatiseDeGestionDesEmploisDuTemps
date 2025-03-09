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
    private Long id;
    @Column(name = "titre")
    private String titre;
    @Column(name = "type_contrainte")
    private String typeContrainte;
    @Column(name = "description", length = 1000)
    private String description;
    @Column(name = "date_de_contrainte")
    private LocalDate dateDeContrainte;
    @Column(name = "date_debut_contrainte")
    private LocalTime dateDebutContrainte;
    @Column(name = "date_fin_contrainte")
    private LocalTime dateFinContrainte;

    @ManyToOne
    @JoinColumn(name = "enseignant_id")
    private Enseignant enseignant;
}