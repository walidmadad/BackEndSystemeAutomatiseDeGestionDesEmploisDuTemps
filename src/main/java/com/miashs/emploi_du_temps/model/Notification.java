package com.miashs.emploi_du_temps.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titre;
    private String message;
    private LocalDateTime dateEnvoie;
    private Boolean vue;
    private String sender;

    @ManyToOne
    @JoinColumn(name = "enseignant_id")
    private Enseignant enseignant;


}