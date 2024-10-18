package com.miashs.emploi_du_temps.service.Enseignant;

import com.miashs.emploi_du_temps.Exception.ResourceNotFoundException;
import com.miashs.emploi_du_temps.modele.Enseignant;
import com.miashs.emploi_du_temps.repository.EnseignantRepository;
import com.miashs.emploi_du_temps.request.EnseignantRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EnseignantService implements IEnseignantService{
    private final EnseignantRepository enseignantRepository;

    @Override
    public Enseignant addEnseignant(EnseignantRequest request) {
        Enseignant enseignant = new Enseignant();
        enseignant.setNom(request.getNom());
        enseignant.setPrenom(request.getPrenom());
        enseignant.setEmail(request.getEmail());
        enseignant.setMdp(request.getMdp());
        enseignant.setDate_joining(request.getDate_joining());

        return enseignantRepository.save(enseignant);
    }

    @Override
    public Enseignant updateEnseignant(EnseignantRequest enseignantRequest, Long id) {
        Optional<Enseignant> enseignantExistant = enseignantRepository.findById(id);
        if (enseignantExistant.isPresent()) {
            Enseignant enseignant = enseignantExistant.get();
            enseignant.setNom(enseignantRequest.getNom());
            enseignant.setPrenom(enseignantRequest.getPrenom());
            enseignant.setEmail(enseignantRequest.getEmail());
            enseignant.setMdp(enseignantRequest.getMdp());
            enseignant.setDate_joining(enseignantRequest.getDate_joining());

            return enseignantRepository.save(enseignant);
        }else {
            throw new ResourceNotFoundException("Enseignant Not Found");
        }
    }

    @Override
    public void deleteEnseignant(Long id) {
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
    public Enseignant getEnseignantByNomAndPrenom(String nom, String prenom) {
        return enseignantRepository.findEnseignantByNomAndPrenom(nom, prenom);
    }

    public List<Enseignant> getEnseignantsByMatiere(String matiere) {
        return enseignantRepository.findEnseignantsByMatiere(matiere);
    }
}
