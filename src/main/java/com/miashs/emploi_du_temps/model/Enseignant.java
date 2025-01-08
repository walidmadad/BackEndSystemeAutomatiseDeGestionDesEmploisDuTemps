package com.miashs.emploi_du_temps.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
@Data
@DiscriminatorValue("ENSEIGNANT")
public class Enseignant extends Utilisateur{

    private LocalDate dateEntree;

    @JsonIgnore
    @OneToMany(mappedBy = "enseignant")
    private List<Notification> notifications;

    @JsonIgnore
    @OneToMany(mappedBy = "enseignant")
    private List<Contrainte> Contraintes;

    @JsonIgnore
    @OneToMany(mappedBy = "enseignant")
    private List<Cours> cours;


}