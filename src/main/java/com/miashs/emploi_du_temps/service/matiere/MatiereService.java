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
    private final FormationRepository formationRepository;

    @Override
    public Matiere ajouterMatiere(MatiereRequest request) {
        Formation formation = Optional.ofNullable(formationRepository.findByName(request.getFormation().getNom()))
                .orElseGet(() -> {
                    Formation newFormation = new Formation(request.getFormation().getNom(), request.getFormation().getDepartement(), request.getFormation().getNiveau());
                    return formationRepository.save(newFormation);
                });
        return matiereRepository.save(creerMatiere(request, formation));
    }
    public Matiere creerMatiere(MatiereRequest request, Formation formation) {
        return new Matiere(
                request.getNom(),
                request.getCode(),
                formation
        );
    }

    @Override
    public Matiere modifierMatiere(MatiereRequest request, Long id) {
        return matiereRepository.findById(id)
                .map(matiereExistante -> modifierMatiereExitante(matiereExistante, request))
                .map(matiereRepository :: save)
                .orElseThrow(() -> new ResourceNotFoundException("Matière non trouvée avec l'id : " + id));
    }
    public Matiere modifierMatiereExitante(Matiere matiere, MatiereRequest matiereRequest) {
        matiere.setNom(matiereRequest.getNom());
        matiere.setCode(matiereRequest.getCode());
        matiere.setFormation(matiereRequest.getFormation());

        Formation formation = formationRepository.findByName(matiereRequest.getFormation().getNom());
        matiere.setFormation(formation);
        return matiere;
    }

    @Override
    public void supprimerMatiere(Long id) {
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
}
