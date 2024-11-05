package com.miashs.emploi_du_temps.service.cours;

import com.miashs.emploi_du_temps.Exception.ResourceNotFoundException;
import com.miashs.emploi_du_temps.model.Cours;
import com.miashs.emploi_du_temps.model.Matiere;
import com.miashs.emploi_du_temps.repository.CoursRepository;
import com.miashs.emploi_du_temps.request.CoursRequest;
import com.miashs.emploi_du_temps.service.matiere.MatiereService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CoursService implements ICoursService {

    private final CoursRepository coursRepository;
    private final MatiereService matiereService;
    @Override
    public Cours addCours(CoursRequest coursRequest) {
        Cours cours = new Cours();
        cours.setEnseignant(coursRequest.getEnseignant());
        cours.setMatiere(coursRequest.getMatiere());
        cours.setTypedecours(coursRequest.getTypeDeCours());
        Matiere matiere = matiereService.getMatiereById(coursRequest.getMatiere().getId());
        cours.setFormation(matiere.getFormation());
        return coursRepository.save(cours);
    }

    @Override
    public Cours updateCours(CoursRequest coursRequest, Long id) {
        Optional<Cours> coursExiste = coursRepository.findById(id);
        if(coursExiste.isPresent())
        {
            Cours cours = coursExiste.get();
            cours.setEnseignant(coursRequest.getEnseignant());
            cours.setMatiere(coursRequest.getMatiere());
            cours.setTypedecours(coursRequest.getTypeDeCours());
            return coursRepository.save(cours);
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
        return List.of();
    }

    @Override
    public List<Cours> getCoursByMatiere(Long matiere_id) {
        return List.of();
    }

    @Override
    public List<Cours> getCoursByMatiereAndType(Long matiere_id, String type) {
        return List.of();
    }

    @Override
    public List<Cours> getCoursByEnseignantAndType(Long enseigant_id, String type) {
        return List.of();
    }
    @Override
    public List<Cours> getAllCours()
    {
        return  coursRepository.findAll();
    }

}
