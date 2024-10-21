package com.miashs.emploi_du_temps.service.matiere;

import com.miashs.emploi_du_temps.Exception.ResourceNotFoundException;
import com.miashs.emploi_du_temps.model.Formation;
import com.miashs.emploi_du_temps.model.Matiere;
import com.miashs.emploi_du_temps.repository.FormationRepository;
import com.miashs.emploi_du_temps.repository.MatiereRepository;
import com.miashs.emploi_du_temps.request.MatiereRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class MatiereService implements IMatiereService{
    private final MatiereRepository matiereRepository;
    private final FormationRepository formationRepository;

    @Override
    public Matiere addMatiere(MatiereRequest matiereRequest) {
        Matiere matiere = new Matiere();
        matiere.setNom(matiereRequest.getNom());
        matiere.setCode(matiereRequest.getCode());
        matiere.setFormation(matiereRequest.getFormation());

        if(matiereRequest.getFormation() != null && matiereRequest.getFormation().getId() != 0){
            Formation formation = formationRepository.findById(matiereRequest.getFormation().getId())
                   .orElseThrow(() -> new ResourceNotFoundException("Formation non trouvée"));
            matiere.setFormation(formation);
        }
        return matiereRepository.save(matiere);
    }

    @Override
    public Matiere updateMatiere(MatiereRequest matiereRequest, Long id) {
        Optional<Matiere> matiereExistant = matiereRepository.findById(id);
        if (matiereExistant.isPresent()) {
            Matiere matiere = matiereExistant.get();
            matiere.setNom(matiereRequest.getNom());
            matiere.setCode(matiereRequest.getCode());
            matiere.setFormation(matiereRequest.getFormation());

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
        return matiereRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Matière non trouvée avec l'id : " + id));
    }

    @Override
    public List<Matiere> getAllMatieres() {
        return matiereRepository.findAll();
    }

    @Override
    public Matiere getMatiereByNom(String nomMatiere) {
        return matiereRepository.findByNom(nomMatiere);

    }

    @Override
    public List<Matiere> getMatieresByFormation(String nomFormation) {
        return matiereRepository.findByFormationNom(nomFormation);
    }

    @Override
    public Matiere getMatiereByCode(String codeMatiere) {
        return matiereRepository.findByCode(codeMatiere);
    }

    @Override
    public List<Matiere> getMatieresByEnseignant(String nomEnseignant) {
        return List.of();
    }
}
