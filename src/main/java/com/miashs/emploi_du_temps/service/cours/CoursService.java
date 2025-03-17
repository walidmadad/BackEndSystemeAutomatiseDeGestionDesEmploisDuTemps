package com.miashs.emploi_du_temps.service.cours;

import com.miashs.emploi_du_temps.Exception.ResourceNotFoundException;
import com.miashs.emploi_du_temps.model.Cours;
import com.miashs.emploi_du_temps.model.Enseignant;
import com.miashs.emploi_du_temps.repository.CoursRepository;
import com.miashs.emploi_du_temps.request.CoursRequest;
import com.miashs.emploi_du_temps.request.NotificationRequest;
import com.miashs.emploi_du_temps.service.matiere.MatiereService;
import com.miashs.emploi_du_temps.service.notification.NotificationService;
import com.miashs.emploi_du_temps.service.salle.SalleService;
import com.miashs.emploi_du_temps.service.utilisateur.UtilisateurService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CoursService implements ICoursService {

    private final CoursRepository coursRepository;
    private final NotificationService notificationService;
    private final MatiereService matiereService;
    private final SalleService salleService;
    private final UtilisateurService utilisateurService;

    @Override
    public Cours addCours(CoursRequest coursRequest) {
        Cours cours = new Cours();
        cours.setEnseignant(coursRequest.getEnseignant());
        cours.setSalle(coursRequest.getSalle());
        cours.setMatiere(coursRequest.getMatiere());
        cours.setTypeDeCours(coursRequest.getTypeDeCours());
        cours.setFormation(coursRequest.getFormation());
        cours.setDateDeCours(coursRequest.getDateDeCours());
        cours.setDebutDeCours(coursRequest.getDebutDeCours());
        cours.setFinDeCours(coursRequest.getFinDeCours());

        Cours coursSaved = coursRepository.save(cours);

        String nomMatiere = matiereService.getMatiereById(coursRequest.getMatiere().getId()).getNom();
        String nomFormation = matiereService.getMatiereById(coursRequest.getMatiere().getId()).getFormation().getNom();
        String nomNiveauFormation = matiereService.getMatiereById(coursRequest.getMatiere().getId()).getFormation().getNiveau().getNom();
        String nomSalle = salleService.getSalleById(coursRequest.getSalle().getId()).getNom();
        Enseignant enseignant = utilisateurService.getEnseignantById(coursRequest.getEnseignant().getId());
        String nomEnseignant = enseignant.getNom();
        String prenomEnseignant = enseignant.getPrenom();

        NotificationRequest notificationRequest = new NotificationRequest();
        notificationRequest.setSender("Admin");
        notificationRequest.setTitre("Cours Ajouté");
        notificationRequest.setMessage(
        "Un nouveau cours de " + nomMatiere + " (" + coursRequest.getTypeDeCours() +
                ") a été ajouté pour la formation " + nomNiveauFormation + " " + nomFormation +
                ". Il se déroulera en salle " + nomSalle +
                " le " + coursRequest.getDateDeCours().toString() +
                " de " + coursRequest.getDebutDeCours().toString() + " à " + coursRequest.getFinDeCours().toString() +
                ", et sera assuré par " + nomEnseignant + " " + prenomEnseignant + "."
        );
        notificationRequest.setVue(false);
        notificationRequest.setDateEnvoie(LocalDateTime.now());
        notificationRequest.setEnseignant(coursRequest.getEnseignant());
        notificationService.addNotification(notificationRequest);
        return coursSaved;
    }

    @Override
    public Cours updateCours(CoursRequest coursRequest, Long id) {
        Optional<Cours> coursExiste = coursRepository.findById(id);
        if(coursExiste.isPresent())
        {
            return addCours(coursRequest);
        } else{
            throw new ResourceNotFoundException("Cours Not Found");
        }

    }

    @Override
    public void deleteCours(Long id) {
        Optional<Cours> coursExiste = coursRepository.findById(id);
        if(coursExiste.isPresent())
        {
            Cours cours = coursExiste.get();
            coursRepository.delete(cours);
        } else{
            throw new ResourceNotFoundException("Cours Not Found To Delete");
        }
    }


    @Override
    public List<Cours> getCoursByEnseignant(Long enseignant_id) {
        return coursRepository.findByEnseignantId(enseignant_id);
    }

    @Override
    public List<Cours> getAllCours()
    {
        return  coursRepository.findAll();
    }

}
