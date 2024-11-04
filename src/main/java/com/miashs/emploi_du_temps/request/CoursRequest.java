package com.miashs.emploi_du_temps.request;


import com.miashs.emploi_du_temps.model.Enseignant;
import com.miashs.emploi_du_temps.model.Formation;
import com.miashs.emploi_du_temps.model.Matiere;
import lombok.Data;

@Data
public class CoursRequest {

    private Long id;
    private Matiere matiere;
    private Enseignant enseignant;
    private Formation formation;
    private String typeDeCours;
}
