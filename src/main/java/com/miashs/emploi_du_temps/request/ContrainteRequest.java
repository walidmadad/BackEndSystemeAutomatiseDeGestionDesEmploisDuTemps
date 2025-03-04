package com.miashs.emploi_du_temps.request;


import com.miashs.emploi_du_temps.model.Enseignant;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class ContrainteRequest {

    private Long id;
    private String titre;
    private String typeContrainte ;
    private String description;
    private LocalDate dateDeContrainte;
    private LocalTime dateDebutContrainte;
    private LocalTime dateFinContrainte;

    private Enseignant enseignant;
}
