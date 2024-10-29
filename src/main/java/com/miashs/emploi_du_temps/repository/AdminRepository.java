package com.miashs.emploi_du_temps.repository;

import com.miashs.emploi_du_temps.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AdminRepository extends JpaRepository<Admin, Long> {
    Admin findByNomAndPrenom(String nom, String prenom);
    Admin findByEmail(String email);
    List<Admin> findByNom(String nom);
    List<Admin> findByPrenom(String prenom);
    List<Admin> findByDepartementNom(String departement);
}
