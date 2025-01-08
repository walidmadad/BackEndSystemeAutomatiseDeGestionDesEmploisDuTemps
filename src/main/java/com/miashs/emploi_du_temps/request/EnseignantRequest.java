package com.miashs.emploi_du_temps.request;

import lombok.Data;

import java.time.LocalDate;

@Data
public class EnseignantRequest extends UtilisateurRequest {
    private LocalDate dateEntree;
}
