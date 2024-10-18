package com.miashs.emploi_du_temps.request;

import com.miashs.emploi_du_temps.modele.Enseignant;
import lombok.Data;

import java.util.Date;

@Data
public class NotificationRequest {
    private long id;
    private String titre;
    private String message;
    private Date dateEnvoie;

    private Enseignant enseignant;
}
