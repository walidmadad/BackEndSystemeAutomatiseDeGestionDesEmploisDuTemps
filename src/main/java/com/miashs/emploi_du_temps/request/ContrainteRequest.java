package com.miashs.emploi_du_temps.request;


import com.miashs.emploi_du_temps.model.Enseignant;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ContrainteRequest {

    private long id;
    private String titre;
    private String typecontraite ;
    private String description;
    private LocalDateTime dateDebut;
    private LocalDateTime dateFin;

    private Enseignant enseignant;
}
