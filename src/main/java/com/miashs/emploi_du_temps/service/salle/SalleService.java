package com.miashs.emploi_du_temps.service.salle;

import com.miashs.emploi_du_temps.Exception.ResourceNotFoundException;
import com.miashs.emploi_du_temps.modele.Departement;
import com.miashs.emploi_du_temps.modele.Salle;
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
    public Salle ajouterSalle(SalleRequest request) {
        Departement departement = Optional.ofNullable(departementRepository.findByName(request.getDepartement().getNom()))
                .orElseGet(() -> {
                    Departement newDepartement = new Departement(request.getDepartement().getNom());
                    return departementRepository.save(newDepartement);
                });
        request.setDepartement(departement);
        return salleRepository.save(createSalle(request, departement));
    }

    private Salle createSalle(SalleRequest request, Departement departement) {
        return new Salle(
                request.getNom(),
                request.getCapacite(),
                request.getTypeSalle(),
                departement
        );
    }

    @Override
    public Salle modifierSalle(SalleRequest request, Long id) {
        return salleRepository.findById(id)
                .map(salleExistante -> modifierSalleExistante(salleExistante, request))
                .map(salleRepository ::save)
                .orElseThrow(() -> new ResourceNotFoundException("Salle non trouvée avec l'id : " + id));
    }

    private Salle modifierSalleExistante(Salle salle, SalleRequest request) {
        salle.setNom(request.getNom());
        salle.setCapacite(request.getCapacite());
        salle.setTypeSalle(request.getTypeSalle());
        salle.setDepartement(request.getDepartement());

        Departement departement = departementRepository.findByName(request.getDepartement().getNom());
        salle.setDepartement(departement);
        return salle;
    }

    @Override
    public void SupprimerSalle(Long id) {
        salleRepository.findById(id)
               .ifPresentOrElse(salleRepository :: delete, () -> {
                   throw new ResourceNotFoundException("Salle non trouvée avec l'id : " + id);
               });
    }

    @Override
    public Salle getSalleById(Long id) {
        return salleRepository.findById(id)
               .orElseThrow(() -> new ResourceNotFoundException("Salle non trouvée avec l'id : " + id));
    }

    @Override
    public List<Salle> getAllSalle() {
        return salleRepository.findAll();
    }
    @Override
    public List<Salle> getByDepartement(String nomDepartement) {
        return salleRepository.findByDepartement(nomDepartement);
    }

    @Override
    public List<Salle> getByName(String nom) {
        return salleRepository.findByName(nom);
    }

}
