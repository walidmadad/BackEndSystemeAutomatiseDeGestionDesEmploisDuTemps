package com.miashs.emploi_du_temps.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class EmploiDeTemps {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


}
