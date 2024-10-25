package com.miashs.emploi_du_temps.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String titre;
    private String message;
    private Date dateEnvoie;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "enseignant_id")
    private Enseignant enseignant;


}