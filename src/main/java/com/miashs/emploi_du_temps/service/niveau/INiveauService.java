package com.miashs.emploi_du_temps.service.niveau;

import com.miashs.emploi_du_temps.modele.Niveau;
import com.miashs.emploi_du_temps.repository.NiveauRepository;

import java.util.List;

public interface INiveauService {
    Niveau getNiveauById(Long id);
    List<Niveau> getAllNiveaux();
    Niveau getNiveauByName(String nom);

}
