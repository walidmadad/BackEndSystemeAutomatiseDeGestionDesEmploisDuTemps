package com.miashs.emploi_du_temps.modele;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Matiere {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nom;
    private String code;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "formation_id")
    private Formation formation;

    @JsonIgnore
    @OneToMany(mappedBy = "matiere")
    private List<EnsMat> ensMats;
}
