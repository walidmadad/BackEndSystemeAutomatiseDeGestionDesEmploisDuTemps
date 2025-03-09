package com.miashs.emploi_du_temps.request;

import com.miashs.emploi_du_temps.model.Enseignant;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class NotificationRequest {
    private Long id;
    private String titre;
    private String message;
    private LocalDateTime dateEnvoie;
    private Boolean vue;
    private String sender;
    private Enseignant enseignant;
}
