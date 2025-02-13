package com.miashs.emploi_du_temps.service.utilisateur;

import com.miashs.emploi_du_temps.Exception.ResourceNotFoundException;
import com.miashs.emploi_du_temps.model.Admin;
import com.miashs.emploi_du_temps.model.Enseignant;
import com.miashs.emploi_du_temps.model.Utilisateur;
import com.miashs.emploi_du_temps.repository.AdminRepository;
import com.miashs.emploi_du_temps.repository.EnseignantRepository;
import com.miashs.emploi_du_temps.repository.UtilisateurRepository;
import com.miashs.emploi_du_temps.request.AdminRequest;
import com.miashs.emploi_du_temps.request.EnseignantRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UtilisateurService implements IUtilisateurService{
    private final EnseignantRepository enseignantRepository;
    private final AdminRepository adminRepository;
    private final UtilisateurRepository utilisateurRepository;


    // ** ADMIN **

    @Override
    public boolean addAdmin(AdminRequest adminRequest) {
        if (enseignantRepository.existsByEmail(adminRequest.getEmail())) {
            return false; // Retourner false si l'utilisateur existe déjà
        }

        Admin admin = new Admin();
        admin.setNom(adminRequest.getNom());
        admin.setPrenom(adminRequest.getPrenom());
        admin.setEmail(adminRequest.getEmail());
        admin.setMotDePasse(adminRequest.getMotDePasse());
        admin.setDepartement(adminRequest.getDepartement());
        admin.setDateNaissance(adminRequest.getDateNaissance());
        admin.setTelephone(adminRequest.getTelephone());
        adminRepository.save(admin);
        return true;
    }

    @Override
    public Admin updateAdmin(AdminRequest adminRequest, Long id) {
        Optional<Admin> adminExistant = adminRepository.findById(id);
        if(adminExistant.isPresent())
        {
            Admin admin = adminExistant.get();
            admin.setNom(adminRequest.getNom());
            admin.setPrenom(adminRequest.getPrenom());
            admin.setEmail(adminRequest.getEmail());
            admin.setMotDePasse(adminRequest.getMotDePasse());
            admin.setDepartement(adminRequest.getDepartement());
            return adminRepository.save(admin);
        } else { throw new ResourceNotFoundException("Formation non trouvé avec ID : "+id);
        }
    }

    @Override
    public Admin getAdminById(Long id) {
        return adminRepository.findById(id).
                orElseThrow(()-> new ResourceNotFoundException("Admin non trouvé"));
    }

    @Override
    public Admin getAdminByNomAndPrenom(String nom, String prenom) {
        return adminRepository.findByNomAndPrenom(nom, prenom);
    }

    @Override
    public Admin getAdminByEmail(String email) {
        return adminRepository.findByEmail(email);
    }

    @Override
    public List<Admin> getAdminsByNom(String nom) {
        return adminRepository.findByNom(nom);
    }

    @Override
    public List<Admin> getAdminsByPrenom(String prenom) {
        return adminRepository.findByPrenom(prenom);
    }

    @Override
    public List<Admin> getAdminsByDepartement(String departement) {
        return adminRepository.findByDepartementNom(departement);
    }


    // ** ENSEIGNANTS **

    @Override
    public boolean addEnseignant(EnseignantRequest enseignantRequest) {

        if (enseignantRepository.existsByEmail(enseignantRequest.getEmail())) {
            return false; // Retourner false si l'utilisateur existe déjà
        }
        Enseignant enseignant = new Enseignant();
        enseignant.setNom(enseignantRequest.getNom());
        enseignant.setPrenom(enseignantRequest.getPrenom());
        enseignant.setEmail(enseignantRequest.getEmail());
        enseignant.setMotDePasse(enseignantRequest.getMotDePasse());
        enseignant.setDateEntree(enseignantRequest.getDateEntree());
        enseignant.setDateNaissance(enseignantRequest.getDateNaissance());
        enseignant.setTelephone(enseignantRequest.getTelephone());
        enseignantRepository.save(enseignant);
        return true;

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
            enseignant.setTelephone(enseignantRequest.getTelephone());
            enseignant.setDateNaissance(enseignantRequest.getDateNaissance());
            return enseignantRepository.save(enseignant);
        } else { throw new ResourceNotFoundException("Formation non trouvé avec ID : "+id);
        }


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
    public List<Enseignant> getEnseignantByNomAndPrenom(String nom, String prenom) {
        return enseignantRepository.findByNomAndPrenom(nom, prenom);
    }

    @Override
    public List<Utilisateur> getAllUtilisateurs(){
        return utilisateurRepository.findAll();
    }

    // ** UTILISATEUR **

    @Override
    public Boolean verifyConnexionUtilisateur(String email, String motDePasse, String userType){
        Utilisateur utilisateur = utilisateurRepository.findByEmailAndUserType(email, userType);
        if (utilisateur != null) {
            return motDePasse.equals(utilisateur.getMotDePasse());
        }
        return false;
    }

    @Override
    public Utilisateur getUtilisateurByEmail(String email){
        return utilisateurRepository.findByEmail(email);
    }

    @Override
    public void deleteUtilisateur(Long id){
        Optional<Utilisateur> utilisateurExistant = utilisateurRepository.findById(id);

        if(utilisateurExistant.isPresent())
        {
            utilisateurRepository.deleteById(id);
        } else {
            throw new ResourceNotFoundException("Formation non trouvé avec ID : " + id);
        }
    }

}
