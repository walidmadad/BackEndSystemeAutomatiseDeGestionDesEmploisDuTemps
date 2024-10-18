package com.miashs.emploi_du_temps.service.cours;

import com.miashs.emploi_du_temps.modele.Cours;
import com.miashs.emploi_du_temps.repository.CoursRepository;
import com.miashs.emploi_du_temps.request.CoursRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CoursService implements ICoursService {
    private final CoursRepository coursRepository;

    @Override
    public Cours ajouterCours(CoursRequest coursRequest) {
        Cours cours = new Cours();
        cours.setJour(coursRequest.getJour());
        cours.setHeure_debut(coursRequest.getHeureDebut());
        cours.setHeure_fin(coursRequest.getHeureFin());
        cours.setTypeDeCours(coursRequest.getTypeDeCours());

        cours.setFormation(coursRequest.getFormation());
        cours.setEnseignant(coursRequest.getEnseignant());
        cours.setMatiere(coursRequest.getMatiere());
        cours.setSalle(coursRequest.getSalle());

        return coursRepository.save(cours);
    }

    // Modifier un cours
    @Override
    public Cours modifierCours(CoursRequest coursRequest, Long id) {
        Optional<Cours> coursExistant = coursRepository.findById(id);
        if (coursExistant.isPresent()) {
            Cours cours = coursExistant.get();
            cours.setJour(coursRequest.getJour());
            cours.setHeure_debut(coursRequest.getHeureDebut());
            cours.setHeure_fin(coursRequest.getHeureFin());
            cours.setTypeDeCours(coursRequest.getTypeDeCours());

            cours.setFormation(coursRequest.getFormation());
            cours.setEnseignant(coursRequest.getEnseignant());
            cours.setMatiere(coursRequest.getMatiere());
            cours.setSalle(coursRequest.getSalle());

            return coursRepository.save(cours);
        } else {
            throw new RuntimeException("Cours avec l'ID " + id + " non trouvé");
        }
    }

    @Override
    public void supprimerCours(Long id) {
        coursRepository.deleteById(id);
    }

    @Override
    public Cours getCoursById(Long id) {
        return coursRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cours avec l'ID " + id + " non trouvé"));
    }

    @Override
    public List<Cours> getCoursBymatiere(Long idMatiere) {
        return coursRepository.findByMatiereId(idMatiere);
    }

    // Obtenir les cours par formation
    @Override
    public List<Cours> getCoursByFormation(Long idFormation) {
        return coursRepository.findByFormationId(idFormation);
    }

    // Obtenir tous les cours
    @Override
    public List<Cours> getCoursAll() {
        return coursRepository.findAll();
    }

    // Obtenir un cours par jour et heure
    @Override
    public Cours getByJourEtHeure(Date date, Time heureDebut, Time heureFin) {
        return coursRepository.findByJourAndHeureDebutAndHeureFin(date, heureDebut, heureFin);
    }
}
