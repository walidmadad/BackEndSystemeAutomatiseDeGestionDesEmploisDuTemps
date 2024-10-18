package com.miashs.emploi_du_temps.service.Enseignant;

import com.miashs.emploi_du_temps.Exception.AlreadyExistsException;
import com.miashs.emploi_du_temps.modele.Enseignant;
import com.miashs.emploi_du_temps.repository.EnseignantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EnseignantService implements IEnseignantService{
    private final EnseignantRepository enseignantRepository;

    @Override
    public Enseignant ajouterEnseignant(Enseignant enseignant) {
        return Optional.of(enseignant)
                .filter(e -> enseignantRepository.existsById(e.getId()))
                .map(enseignantRepository::save)
                .orElseThrow(() -> new AlreadyExistsException("Enseignant déjà existant : " + enseignant.getId()));
    }

    @Override
    public Enseignant modifierEnseignant(Enseignant enseignant, Long id) {
        return Optional.ofNullable(getEnseignantById(id)).map(oldEnseignant -> {
            oldEnseignant.setNom(enseignant.getNom());
            return enseignantRepository.save(oldEnseignant);
        }).orElseThrow(() -> new RuntimeException("Enseignant Not Found"));
    }

    @Override
    public void supprimerEnseignant(Long id) {
        enseignantRepository.findById(id).
                ifPresentOrElse(enseignantRepository::delete, () -> {
            throw new RuntimeException("Enseignant Not Found");
        });
    }

    @Override
    public List<Enseignant> getAllEnseignants() {
        return enseignantRepository.findAll();
    }

    @Override
    public Enseignant getEnseignantById(Long id) {
        return enseignantRepository.findById(id)
               .orElseThrow(() -> new RuntimeException("Enseignant Not Found"));
    }

    @Override
    public List<Enseignant> getEnseignantByNom(String nom) {
        return enseignantRepository.findEnseignantByNom(nom);
    }

    @Override
    public List<Enseignant> getEnseignantByPrenom(String prenom) {
        return enseignantRepository.findEnseignantByPrenom(prenom);
    }

    @Override
    public Enseignant getEnseignantByNomEtPrenom(String nom, String prenom) {
        return enseignantRepository.findEnseignantByNomEtPrenom(nom, prenom);
    }

    public List<Enseignant> getEnseignantsByMatiere(String matiere) {
        return enseignantRepository.findEnseignantsByMatiere(matiere);
    }
}
