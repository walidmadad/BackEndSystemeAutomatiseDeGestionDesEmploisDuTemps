package com.miashs.emploi_du_temps.service.salle;

import com.miashs.emploi_du_temps.modele.Salle;
import com.miashs.emploi_du_temps.request.SalleRequest;

import java.util.List;

public interface ISalleService {

    Salle ajouterSalle(SalleRequest salleRequest);
    Salle modifierSalle(SalleRequest salleRequest, Long id);
    void SupprimerSalle(Long id);

    Salle getSalleById(Long id);
    List<Salle> getAllSalle();
    List<Salle> getSalleByDepartement(String nomDepartement);
    List<Salle> getSalleByName(String nom);
}
