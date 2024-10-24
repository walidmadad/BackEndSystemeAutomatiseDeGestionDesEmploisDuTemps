package com.miashs.emploi_du_temps.request;

import com.miashs.emploi_du_temps.model.Departement;
import lombok.Data;

import java.time.LocalDate;

@Data
public class AdminRequest extends UtilisateurRequest {
    private Departement departement;
}
