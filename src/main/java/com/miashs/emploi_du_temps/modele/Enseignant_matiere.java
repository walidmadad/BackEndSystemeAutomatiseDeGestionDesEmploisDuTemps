package com.miashs.emploi_du_temps.modele;

import com.miashs.emploi_du_temps.enums.Type_ensei;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Enseignant_matiere {

    private Type_ensei type;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne
    @JoinColumn(name = "enseignant_id")
    private Enseignant enseignant;

    @ManyToOne
    @JoinColumn(name = "matiere_id")
    private Matiere matiere;

}
