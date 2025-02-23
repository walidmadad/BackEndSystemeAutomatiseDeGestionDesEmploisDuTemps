package com.miashs.emploi_du_temps.service.contrainte;

import com.miashs.emploi_du_temps.Exception.ResourceNotFoundException;
import com.miashs.emploi_du_temps.model.Contrainte;
import com.miashs.emploi_du_temps.repository.ContrainteRepository;
import com.miashs.emploi_du_temps.request.ContrainteRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ContrainteService implements  IContrainteService{

    private final ContrainteRepository contrainteRepository;


    @Override
    public Contrainte addContrainte(ContrainteRequest contrainteRequest) {
        Contrainte contrainte = new Contrainte();

        contrainte.setEnseignant(contrainteRequest.getEnseignant());
        contrainte.setTitre(contrainteRequest.getTitre());
        contrainte.setTypeContraite(contrainteRequest.getTypeContraite());
        contrainte.setDescription(contrainteRequest.getDescription());
        contrainte.setDateDeContrainte(contrainteRequest.getDateDeContrainte());
        contrainte.setDateDebutContrainte(contrainteRequest.getDateDebutContrainte());
        contrainte.setDateFinContrainte(contrainteRequest.getDateFinContrainte());
        contrainte.setDateFinContrainte(contrainte.getDateFinContrainte());

        return contrainteRepository.save(contrainte);
    }


    @Override
    public Contrainte updateContrainte(ContrainteRequest contrainteRequest, Long id) {
        Optional<Contrainte> contrainteOptional = contrainteRepository.findById(id);

        if(contrainteOptional.isPresent())
        {
            Contrainte contrainte = contrainteOptional.get();
            contrainte.setEnseignant(contrainteRequest.getEnseignant());
            contrainte.setTitre(contrainteRequest.getTitre());
            contrainte.setTypeContraite(contrainteRequest.getTypeContraite());
            contrainte.setDescription(contrainteRequest.getDescription());
            contrainte.setDateDeContrainte(contrainteRequest.getDateDeContrainte());
            contrainte.setDateDebutContrainte(contrainteRequest.getDateDebutContrainte());
            contrainte.setDateFinContrainte(contrainteRequest.getDateFinContrainte());

            return contrainteRepository.save(contrainte);
        } else {
            throw new ResourceNotFoundException("contrainte non trouvé avec ID : " + id);
        }
    }

    @Override
    public void deleteContrainte(Long id) {
        Optional<Contrainte> contrainteOptional = contrainteRepository.findById(id);

        if(contrainteOptional.isPresent()) {

            contrainteRepository.deleteById(id);

        } else
        {
            throw new ResourceNotFoundException("contrainte non trouvé avec ID : " + id + " pour le supprimer");
        }
    }


    @Override
    public List<Contrainte> getContraintebyEnseignant(Long id) {

        return contrainteRepository.findByEnseignant_id(id);
    }

    @Override
    public List<Contrainte> getAllContrainte() {
        return  contrainteRepository.findAll();
    }
}
