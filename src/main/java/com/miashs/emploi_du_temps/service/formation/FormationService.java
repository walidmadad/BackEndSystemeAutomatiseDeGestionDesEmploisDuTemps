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

    @Override
    public Formation addFormation(FormationRequest request) {
        Formation formation = new Formation();
        formation.setNom(request.getNom());
        formation.setDepartement(request.getDepartement());
        formation.setNiveau(request.getNiveau());

        return formationRepository.save(formation);
    }


    @Override
    public Formation updateFormation(FormationRequest request, Long id){
        Optional<Formation> formationExistant = formationRepository.findById(id);
        if (formationExistant.isPresent()){
            Formation formation = formationExistant.get();
            formation.setNom(request.getNom());
            formation.setDepartement(request.getDepartement());
            formation.setNiveau(request.getNiveau());

            return formationRepository.save(formation);
        }else {
            throw new ResourceNotFoundException("Formation non trouvée avec l'id : " + id);
        }
    }


    @Override
    public void deleteFormation(Long id) {
        formationRepository.deleteById(id);
    }

    @Override
    public Formation getFormationById(Long id) {
        return formationRepository.findById(id)
               .orElseThrow(()-> new ResourceNotFoundException("Formation non trouvée avec l'id : " + id));
    }

    @Override
    public Formation getFormationByNom(String nom) {
        return formationRepository.findByNom(nom);
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
