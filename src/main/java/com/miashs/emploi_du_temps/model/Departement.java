package com.miashs.emploi_du_temps.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Departement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;

    @JsonIgnore
    @OneToMany(mappedBy = "departement")
    List<Formation> formations;

    @JsonIgnore
    @OneToMany(mappedBy = "departement")
    List<Salle> salles;



}