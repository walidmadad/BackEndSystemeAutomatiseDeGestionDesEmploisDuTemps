package com.miashs.emploi_du_temps.service.salle;

import com.miashs.emploi_du_temps.model.Salle;
import com.miashs.emploi_du_temps.request.SalleRequest;

import java.util.List;

public interface ISalleService {

    Salle addSalle(SalleRequest salleRequest);
    Salle updateSalle(SalleRequest salleRequest, Long id);
    void deleteSalle(Long id);

    Salle getSalleById(Long id);
    List<Salle> getAllSalles();
    List<Salle> getSalleByDepartement(String nomDepartement);
    List<Salle> getSalleByType(String typeSalle);
    List<Salle> getSalleByNom(String nom);
}