package com.miashs.emploi_du_temps.service.niveau;

import com.miashs.emploi_du_temps.Exception.ResourceNotFoundException;
import com.miashs.emploi_du_temps.modele.Niveau;
import com.miashs.emploi_du_temps.repository.NiveauRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NiveauService implements INiveauService{
    NiveauRepository niveauRepository;

    @Override
    public Niveau getNiveauById(Long id) {
        return niveauRepository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("Niveau non trouvé avec l'id : " + id));
    }

    @Override
    public List<Niveau> getAllNiveaux() {
        return niveauRepository.findAll();
    }

    @Override
    public Niveau getNiveauByName(String nom) {
        return niveauRepository.findByNom(nom);
    }
}
