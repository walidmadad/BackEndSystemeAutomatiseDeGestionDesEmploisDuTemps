package com.miashs.emploi_du_temps.service.matiere;

import com.miashs.emploi_du_temps.Exception.ResourceNotFoundException;
import com.miashs.emploi_du_temps.modele.Formation;
import com.miashs.emploi_du_temps.modele.Matiere;
import com.miashs.emploi_du_temps.modele.Niveau;
import com.miashs.emploi_du_temps.repository.FormationRepository;
import com.miashs.emploi_du_temps.repository.MatiereRepository;
import com.miashs.emploi_du_temps.request.MatiereRequest;
import com.miashs.emploi_du_temps.service.formation.FormationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MatiereService implements IMatiereService{
    private final MatiereRepository matiereRepository;


    @Override
    public Matiere addMatiere(MatiereRequest request) {
        Matiere matiere = new Matiere();
        matiere.setNom(request.getNom());
        matiere.setCode(request.getCode());
        matiere.setFormation(request.getFormation());

        return matiereRepository.save(matiere);
    }

    @Override
    public Matiere updateMatiere(MatiereRequest request, Long id) {
        Optional<Matiere> matiereExistant = matiereRepository.findById(id);
        if (matiereExistant.isPresent()) {
            Matiere matiere = matiereExistant.get();
            matiere.setNom(request.getNom());
            matiere.setCode(request.getCode());
            matiere.setFormation(request.getFormation());

            return matiereRepository.save(matiere);
        }else {
            throw new ResourceNotFoundException("Matière non trouvée avec l'id : " + id);
        }
    }

    @Override
    public void deleteMatiere(Long id) {
        matiereRepository.findById(id).
                ifPresentOrElse(matiereRepository :: delete, () -> {
            throw new RuntimeException("Matière Not Found");
        });

    }

    @Override
    public Matiere getMatiereById(Long id) {
        return matiereRepository.findById(id)
               .orElseThrow(() -> new ResourceNotFoundException("Matière non trouvée avec l'id : " + id));
    }

    @Override
    public List<Matiere> getAllMatieres() {
        return matiereRepository.findAll();
    }

    @Override
    public List<Matiere> getMatieresByFormation(String nomFormation) {
        return matiereRepository.findMatieresByFormation(nomFormation);
    }

    @Override
    public List<Matiere> getMatieresByEnseignant(String nomEnseignant) {
        return matiereRepository.findMatieresByEnseignant(nomEnseignant);
    }

    @Override
    public Matiere getMatieresByNom(String nomMatiere) {
        return matiereRepository.findByNom(nomMatiere);
    }
}
