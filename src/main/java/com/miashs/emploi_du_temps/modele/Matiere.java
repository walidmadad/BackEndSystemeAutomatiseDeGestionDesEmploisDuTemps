package com.miashs.emploi_du_temps.modele;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
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
    private List<Cours> cours;




}