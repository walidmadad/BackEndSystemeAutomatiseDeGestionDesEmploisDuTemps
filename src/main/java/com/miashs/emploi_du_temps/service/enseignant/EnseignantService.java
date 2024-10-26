package com.miashs.emploi_du_temps.service.enseignant;

import com.miashs.emploi_du_temps.Exception.ResourceNotFoundException;
import com.miashs.emploi_du_temps.model.Enseignant;
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
    public Enseignant addEnseignant(EnseignantRequest enseignantRequest) {
        Enseignant enseignant = new Enseignant();
        enseignant.setNom(enseignantRequest.getNom());
        enseignant.setPrenom(enseignantRequest.getPrenom());
        enseignant.setEmail(enseignantRequest.getEmail());
        enseignant.setMotDePasse(enseignantRequest.getMotDePasse());
        enseignant.setDateEntree(enseignantRequest.getDateEntree());

        return enseignantRepository.save(enseignant);
    }

    @Override
    public Enseignant updateEnseignant(EnseignantRequest enseignantRequest, Long id) {

        Optional<Enseignant> enseignantExistant = enseignantRepository.findById(id);
        if(enseignantExistant.isPresent())
        {
            Enseignant enseignant = enseignantExistant.get();
            enseignant.setNom(enseignantRequest.getNom());
            enseignant.setPrenom(enseignantRequest.getPrenom());
            enseignant.setEmail(enseignantRequest.getEmail());
            enseignant.setMotDePasse(enseignantRequest.getMotDePasse());
            enseignant.setDateEntree(enseignantRequest.getDateEntree());
            return enseignantRepository.save(enseignant);
        } else { throw new ResourceNotFoundException("Formation non trouvé avec ID : "+id);
        }


    }

    @Override
    public void deleteEnseignant(Long id) {
        Optional<Enseignant> enseignantExistant = enseignantRepository.findById(id);
        if(enseignantExistant.isPresent())
        {
            enseignantRepository.deleteById(id);
        } else {
            throw new ResourceNotFoundException("Formation non trouvé avec ID : " + id);
        }
    }


    @Override
    public List<Enseignant> getAllEnseignant() {
        return enseignantRepository.findAll();
    }

    @Override
    public Enseignant getEnseignantById(Long id) {
        return enseignantRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Enseignant non trouvé avec ID : " + id));
    }

    @Override
    public List<Enseignant> getEnseignantByNom(String nom) {
        return enseignantRepository.findByNom(nom);
    }

    @Override
    public List<Enseignant> getEnseignantByPrenom(String prenom) {
        return enseignantRepository.findByPrenom(prenom);
    }

    @Override
    public Enseignant getEnseignantByEmail(String email) {
        return enseignantRepository.findByEmail(email);
    }

    @Override
    public Boolean verifierConnexionEnseignant(String email, String motDePasse) {
        Enseignant enseignant = enseignantRepository.findByEmail(email);
        if (enseignant != null) {
            return motDePasse.equals(enseignant.getMotDePasse());
        }
        return false;
    }

    @Override
    public List<Enseignant> getEnseignantByNomAndPrenom(String nom, String prenom) {
        return enseignantRepository.findByNomAndPrenom(nom, prenom);
    }
}