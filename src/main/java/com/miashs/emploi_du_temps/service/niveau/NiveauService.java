package com.miashs.emploi_du_temps.service.niveau;

import com.miashs.emploi_du_temps.Exception.ResourceNotFoundException;
import com.miashs.emploi_du_temps.model.Niveau;
import com.miashs.emploi_du_temps.repository.NiveauRepository;
import com.miashs.emploi_du_temps.request.NiveauRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class NiveauService implements INiveauService{
    private final NiveauRepository niveauRepository;


    @Override
    public Niveau addNiveau(NiveauRequest niveauRequest) {
        Niveau niveau = new Niveau();
        niveau.setNom(niveauRequest.getNom());
        return niveauRepository.save(niveau);
    }

    @Override
    public Niveau updateNiveau(NiveauRequest niveauRequest, Long id) {
        Optional<Niveau> niveauExistant = niveauRepository.findById(id);
        if (niveauExistant.isPresent()) {
            Niveau niveau = niveauExistant.get();
            niveau.setNom(niveauRequest.getNom());
            return niveauRepository.save(niveau);
        }else {
            throw new ResourceNotFoundException("Niveau non trouvé avec l'id");
        }
    }

    @Override
    public void deleteNiveau(Long id) {
        niveauRepository.deleteById(id);
    }

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
    public Niveau getNiveauByNom(String nom) {
        return niveauRepository.findByNom(nom);
    }
}
