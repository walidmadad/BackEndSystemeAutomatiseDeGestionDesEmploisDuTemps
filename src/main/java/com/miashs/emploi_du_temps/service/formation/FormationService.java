package com.miashs.emploi_du_temps.service.formation;

import com.miashs.emploi_du_temps.Exception.ResourceNotFoundException;
import com.miashs.emploi_du_temps.model.Departement;
import com.miashs.emploi_du_temps.model.Formation;
import com.miashs.emploi_du_temps.model.Niveau;
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
    private final NiveauRepository niveauRepository;
    private final DepartementRepository departementRepository;

    @Override
    public Formation addFormation(FormationRequest request) {
        Formation formation = new Formation();
        formation.setNom(request.getNom());
        formation.setDepartement(request.getDepartement());
        formation.setNiveau(request.getNiveau());

        // Vérifiez si département est valide
        if(request.getDepartement()!= null && request.getDepartement().getId() != 0){
            Departement departement = departementRepository.findById(request.getDepartement().getId())
                    .orElseThrow(() -> new ResourceNotFoundException("Département non trouvé"));
            formation.setDepartement(departement);
        }

        // Vérifiez si Niveau est valide
        if(request.getNiveau()!= null && request.getNiveau().getId()!= 0){
            Niveau niveau = niveauRepository.findById(request.getNiveau().getId())
                   .orElseThrow(() -> new ResourceNotFoundException("Niveau non trouvé"));
            formation.setNiveau(niveau);
        }

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
    public List<Formation> getFormationByNom(String nom) {
        return formationRepository.findByNom(nom);
    }

    @Override
    public List<Formation> getAllFormations() {
        return formationRepository.findAll();
    }

    @Override
    public List<Formation> getFormationsByNiveau(String niveau) {
        return formationRepository.findByNiveauNom(niveau);
    }

    @Override
    public List<Formation> getFormationsByDepartement(String departement) {
        return formationRepository.findByDepartementNom(departement);
    }

    @Override
    public List<Formation> getFormationsByDepartementAndNiveau(String departement, String niveau) {
        return formationRepository.findByDepartementNomAndNiveauNom(departement, niveau);
    }
}