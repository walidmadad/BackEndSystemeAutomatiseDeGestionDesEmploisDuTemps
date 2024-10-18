package com.miashs.emploi_du_temps.modele;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class EnseignantMatiere {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String type_enseignement;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "enseignant_id")
    private Enseignant enseignant;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "matiere_id")
    private Matiere matiere;

    @JsonIgnore
    @OneToMany(mappedBy = "enseignantMatiere")
    private List<Cours> cours;
}