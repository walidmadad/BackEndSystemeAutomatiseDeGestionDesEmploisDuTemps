package com.miashs.emploi_du_temps.service.niveau;

import com.miashs.emploi_du_temps.model.Niveau;
import com.miashs.emploi_du_temps.request.NiveauRequest;

import java.util.List;

public interface INiveauService {
    Niveau addNiveau(NiveauRequest niveauRequest);
    Niveau updateNiveau(NiveauRequest niveauRequest, Long id);
    void deleteNiveau(Long id);

    Niveau getNiveauById(Long id);
    List<Niveau> getAllNiveaux();
    Niveau getNiveauByNom(String nom);

}
