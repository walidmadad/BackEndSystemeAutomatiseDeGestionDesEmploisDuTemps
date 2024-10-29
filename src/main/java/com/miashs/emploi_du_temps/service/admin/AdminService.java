package com.miashs.emploi_du_temps.service.admin;

import com.miashs.emploi_du_temps.Exception.ResourceNotFoundException;
import com.miashs.emploi_du_temps.model.Admin;
import com.miashs.emploi_du_temps.repository.AdminRepository;
import com.miashs.emploi_du_temps.request.AdminRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AdminService implements IAdminService{
    private final AdminRepository adminRepository;

    @Override
    public Admin addAdmin(AdminRequest adminRequest) {
        Admin admin = new Admin();
        admin.setNom(adminRequest.getNom());
        admin.setPrenom(adminRequest.getPrenom());
        admin.setEmail(adminRequest.getEmail());
        admin.setMotDePasse(adminRequest.getMotDePasse());
        admin.setDepartement(adminRequest.getDepartement());

        return adminRepository.save(admin);
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
    public void deleteAdmin(Long id) {
        adminRepository.deleteById(id);
    }

    @Override
    public List<Admin> getAllAdmins() {
        return adminRepository.findAll();
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

    @Override
    public Boolean verifyConnexionAdmin(String email, String motDePasse){
        Admin admin = adminRepository.findByEmail(email);
        if (admin != null) {
            return motDePasse.equals(admin.getMotDePasse());
        }
        return false;
    }
}
