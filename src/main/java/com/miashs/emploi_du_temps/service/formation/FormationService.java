package com.miashs.emploi_du_temps.service.formation;

import com.miashs.emploi_du_temps.Exception.ResourceNotFoundException;
import com.miashs.emploi_du_temps.modele.Departement;
import com.miashs.emploi_du_temps.modele.Formation;
import com.miashs.emploi_du_temps.modele.Niveau;
import com.miashs.emploi_du_temps.repository.DepartementRepository;
import com.miashs.emploi_du_temps.repository.FormationRepository;
import com.miashs.emploi_du_temps.repository.NiveauRepository;
import com.miashs.emploi_du_temps.request.FormationRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FormationService implements IFormationService{
    private final FormationRepository formationRepository;
    private final DepartementRepository departementRepository;
    private final NiveauRepository niveauRepository;

    @Override
    public Formation ajouterFormation(FormationRequest request) {
        Departement departement = Optional.ofNullable(departementRepository.findByName(request.getDepartement().getNom()))
                .orElseGet(() -> {
                    Departement newDepartement = new Departement(request.getDepartement().getNom());
                    return departementRepository.save(newDepartement);
                });
        Niveau niveau = Optional.ofNullable(niveauRepository.findByNom(request.getNiveau().getNom()))
                .orElseGet(() -> {
                    Niveau newNiveau = new Niveau(request.getNiveau().getNom());
                    return niveauRepository.save(newNiveau);
                });
        return formationRepository.save(creerFormation(request, departement, niveau));
    }
    public Formation creerFormation(FormationRequest request, Departement departement, Niveau niveau) {
        return new Formation(
                request.getNom(),
                departement,
                niveau
        );
    }


    @Override
    public Formation modifierFormation(FormationRequest request, Long id){
        return formationRepository.findById(id)
                .map(formationExistante -> modifierFormationExistante(formationExistante, request))
                .map(formationRepository :: save)
                .orElseThrow(()-> new ResourceNotFoundException("Formation non trouvée avec l'id : " + id));
    }

    private Formation modifierFormationExistante(Formation formation, FormationRequest request) {
        formation.setNom(request.getNom());
        formation.setDepartement(request.getDepartement());
        formation.setNiveau(request.getNiveau());

        Departement departement = departementRepository.findByName(request.getNom());
        formation.setDepartement(departement);

        Niveau niveau = niveauRepository.findByNom(request.getNom());
        formation.setNiveau(niveau);

        return formation;
    }


    @Override
    public void supprimerFormation(Long id) {
        formationRepository.deleteById(id);
    }

    @Override
    public Formation getFormationById(Long id) {
        return formationRepository.findById(id)
               .orElseThrow(()-> new ResourceNotFoundException("Formation non trouvée avec l'id : " + id));
    }

    @Override
    public Formation getFormationByName(String nom) {
        return formationRepository.findByName(nom);
    }

    @Override
    public List<Formation> getAllFormations() {
        return formationRepository.findAll();
    }

    @Override
    public List<Formation> getFormationsByNiveau(String niveau) {
        return formationRepository.findByNiveau(niveau);
    }

    @Override
    public List<Formation> getFormationsByDepartement(String departement) {
        return formationRepository.findByDepartement(departement);
    }

    @Override
    public List<Formation> getFormationsByDepartementAndNiveau(String departement, String niveau) {
        return formationRepository.findByDepartementAndNiveau(departement, niveau);
    }
}
