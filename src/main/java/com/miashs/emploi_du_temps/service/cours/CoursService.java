package com.miashs.emploi_du_temps.service.cours;

import com.miashs.emploi_du_temps.Exception.ResourceNotFoundException;
import com.miashs.emploi_du_temps.model.Cours;
import com.miashs.emploi_du_temps.model.Enseignant;
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

        return coursRepository.save(cours);
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
