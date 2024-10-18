package com.miashs.emploi_du_temps.service.Contrainte;

import com.miashs.emploi_du_temps.Exception.ResourceNotFoundException;
import com.miashs.emploi_du_temps.modele.Contrainte;
import com.miashs.emploi_du_temps.modele.Enseignant;
import com.miashs.emploi_du_temps.repository.ContrainteRepository;
import com.miashs.emploi_du_temps.request.ContrainteRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ContrainteService implements IContrainteService{
    private final ContrainteRepository contrainteRepository;

    @Override
    public Contrainte addContrainte(ContrainteRequest contrainteRequest) {
        Contrainte contrainte = new Contrainte();
        contrainte.setTitre(contrainteRequest.getTitre());
        contrainte.setDateDebut(contrainteRequest.getDateDebut());
        contrainte.setDateFin(contrainteRequest.getDateFin());
        contrainte.setTypeContraite(contrainteRequest.getTypeContraite());
        contrainte.setDescription(contrainteRequest.getDescription());
        contrainte.setEnseignant(contrainteRequest.getEnseignant());

        return contrainteRepository.save(contrainte);
    }

    @Override
    public Contrainte updateContrainte(ContrainteRequest contrainteRequest, Long id) {
        Optional<Contrainte> contrainteExistante = contrainteRepository.findById(id);
        if (contrainteExistante.isPresent()) {
            Contrainte contrainte = contrainteExistante.get();
            contrainte.setTitre(contrainteRequest.getTitre());
            contrainte.setDateDebut(contrainteRequest.getDateDebut());
            contrainte.setDateFin(contrainteRequest.getDateFin());
            contrainte.setTypeContraite(contrainteRequest.getTypeContraite());
            contrainte.setDescription(contrainteRequest.getDescription());
            contrainte.setEnseignant(contrainteRequest.getEnseignant());
            return contrainteRepository.save(contrainte);
        }else {
            throw new ResourceNotFoundException("Contrainte not found");
        }
    }

    @Override
    public void deleteContrainte(Long id) {
        contrainteRepository.deleteById(id);
    }

    @Override
    public Contrainte getContrainteById(Long id) {
        return contrainteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Contrainte not found"));
    }

    @Override
    public List<Contrainte> getAllContraintes() {
        return contrainteRepository.findAll();
    }

    @Override
    public List<Contrainte> getContraintesByType(String type) {
        return contrainteRepository.findByType(type);
    }

    @Override
    public List<Contrainte> getContraintesByEnseignant(Enseignant enseignant) {
        return contrainteRepository.findByEnseignant(enseignant);
    }
}
