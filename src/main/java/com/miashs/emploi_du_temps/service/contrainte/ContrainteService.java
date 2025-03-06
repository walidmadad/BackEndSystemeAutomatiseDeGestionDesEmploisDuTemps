package com.miashs.emploi_du_temps.service.contrainte;

import com.miashs.emploi_du_temps.Exception.ResourceNotFoundException;
import com.miashs.emploi_du_temps.model.Contrainte;
import com.miashs.emploi_du_temps.repository.ContrainteRepository;
import com.miashs.emploi_du_temps.request.ContrainteRequest;
import com.miashs.emploi_du_temps.request.NotificationRequest;
import com.miashs.emploi_du_temps.service.notification.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ContrainteService implements  IContrainteService{

    private final ContrainteRepository contrainteRepository;
    private final NotificationService notificationService;

    @Override
    public Contrainte addContrainte(ContrainteRequest contrainteRequest) {
        Contrainte contrainte = new Contrainte();

        contrainte.setEnseignant(contrainteRequest.getEnseignant());
        contrainte.setTitre(contrainteRequest.getTitre());
        contrainte.setTypeContrainte(contrainteRequest.getTypeContrainte());
        contrainte.setDescription(contrainteRequest.getDescription());
        contrainte.setDateDeContrainte(contrainteRequest.getDateDeContrainte());
        contrainte.setDateDebutContrainte(contrainteRequest.getDateDebutContrainte());
        contrainte.setDateFinContrainte(contrainteRequest.getDateFinContrainte());
        contrainte.setDateFinContrainte(contrainte.getDateFinContrainte());

        Contrainte contrainteSaved = contrainteRepository.save(contrainte);

        NotificationRequest notificationRequest = new NotificationRequest();
        notificationRequest.setSender(contrainteRequest.getEnseignant().getNom() + " " + contrainteRequest.getEnseignant().getPrenom());
        notificationRequest.setTitre("Contrainte Ajouté");
        notificationRequest.setMessage("Une nouvelle contrainte à été ajouté");
        notificationRequest.setVue(false);
        notificationRequest.setDateEnvoie(LocalDate.now());
        notificationRequest.setTimeEnvoie(LocalTime.now());
        notificationRequest.setEnseignant(contrainteRequest.getEnseignant());
        notificationService.addNotification(notificationRequest);

        return contrainteSaved;
    }


    @Override
    public Contrainte updateContrainte(ContrainteRequest contrainteRequest, Long id) {
        Optional<Contrainte> contrainteOptional = contrainteRepository.findById(id);

        if(contrainteOptional.isPresent())
        {
            Contrainte contrainte = contrainteOptional.get();
            contrainte.setEnseignant(contrainteRequest.getEnseignant());
            contrainte.setTitre(contrainteRequest.getTitre());
            contrainte.setTypeContrainte(contrainteRequest.getTypeContrainte());
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
