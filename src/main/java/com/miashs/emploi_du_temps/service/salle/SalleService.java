package com.miashs.emploi_du_temps.service.salle;

import com.miashs.emploi_du_temps.Exception.ResourceNotFoundException;
import com.miashs.emploi_du_temps.model.Departement;
import com.miashs.emploi_du_temps.model.Salle;
import com.miashs.emploi_du_temps.repository.DepartementRepository;
import com.miashs.emploi_du_temps.repository.SalleRepository;
import com.miashs.emploi_du_temps.request.SalleRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SalleService implements ISalleService{
    private final SalleRepository salleRepository;
    private final DepartementRepository departementRepository;

    @Override
    public Salle addSalle(SalleRequest request) {
        Salle salle = new Salle();
        salle.setNom(request.getNom());
        salle.setCapacite(request.getCapacite());
        salle.setTypeSalle(request.getTypeSalle());
        salle.setDepartement(request.getDepartement());

        // Vérifiez si le département est valide
        if (request.getDepartement() != null && request.getDepartement().getId() != 0) {
            Departement departement = departementRepository.findById(request.getDepartement().getId())
                    .orElseThrow(() -> new ResourceNotFoundException("Département non trouvé"));
            salle.setDepartement(departement);
        }
        return salleRepository.save(salle);

    }

    @Override
    public Salle updateSalle(SalleRequest request, Long id) {
        Optional<Salle> salleExistant = salleRepository.findById(id);
        if (salleExistant.isPresent()) {
            Salle salle = salleExistant.get();
            salle.setNom(request.getNom());
            salle.setCapacite(request.getCapacite());
            salle.setTypeSalle(request.getTypeSalle());
            salle.setDepartement(request.getDepartement());

            return salleRepository.save(salle);
        }
        else {
            throw new ResourceNotFoundException("Salle non trouvée avec l'id : " + id);
        }
    }



    @Override
    public void deleteSalle(Long id) {
        salleRepository.deleteById(id);
    }

    @Override
    public Salle getSalleById(Long id) {
        return salleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Salle non trouvée avec l'id : " + id));
    }

    @Override
    public List<Salle> getAllSalles() {
        return salleRepository.findAll();
    }
    @Override
    public List<Salle> getSalleByDepartement(String nomDepartement) {
        return salleRepository.findByDepartementNom(nomDepartement);
    }

    @Override
    public List<Salle> getSalleByNom(String nom) {
        return salleRepository.findByNom(nom);
    }

    @Override
    public List<Salle> getSalleByType(String type) {
        return salleRepository.findByTypeSalle(type);
    }
}