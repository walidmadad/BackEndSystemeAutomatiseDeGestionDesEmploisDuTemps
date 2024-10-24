package com.miashs.emploi_du_temps.service.admin;

import com.miashs.emploi_du_temps.model.Admin;
import com.miashs.emploi_du_temps.model.Departement;
import com.miashs.emploi_du_temps.request.AdminRequest;

import java.util.List;

public interface IAdminService {
    Admin addAdmin(AdminRequest adminRequest);
    Admin updateAdmin(AdminRequest adminRequest, Long id);
    void deleteAdmin(Long id);

    List<Admin> getAllAdmins();
    Admin getAdminById(Long id);
    Admin getAdminByNomAndPrenom(String nom, String prenom);
    Admin getAdminByEmail(String email);
    List<Admin> getAdminsByNom(String nom);
    List<Admin> getAdminsByPrenom(String prenom);
    List<Admin> getAdminsByDepartement(String departement);
}
