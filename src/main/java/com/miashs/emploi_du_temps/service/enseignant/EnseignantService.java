package com.miashs.emploi_du_temps.service.enseignant;

import com.miashs.emploi_du_temps.model.Enseignant;
import com.miashs.emploi_du_temps.repository.EnseignantRepository;
import com.miashs.emploi_du_temps.request.EnseignantRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EnseignantService implements IEnseignantService{
    private final EnseignantRepository enseignantRepository;
    
    @Override
    public Enseignant addenseignant(EnseignantRequest enseignantRequest) {
        return null;
    }

    @Override
    public Enseignant updateenseignant(EnseignantRequest enseignantRequest, Long id) {
        return null;
    }

    @Override
    public void deleteEnseignant(Long id) {

    }

    @Override
    public Enseignant getEnseignantByID(long Id) {
        return null;
    }

    @Override
    public Enseignant getEnseignantByNom(String nom) {
        return null;
    }

    @Override
    public Enseignant getEnseignantByPrenom(String prenom) {
        return null;
    }

    @Override
    public Enseignant getEnseignantByEmail(String email) {
        return null;
    }
}
