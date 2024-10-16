package com.miashs.emploi_du_temps.modele;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@Entity
public class Niveau {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nom;

    @JsonIgnore
    @OneToMany(mappedBy = "niveau")
    private List<Formation> formations;
}
