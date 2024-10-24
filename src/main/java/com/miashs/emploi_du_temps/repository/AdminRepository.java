package com.miashs.emploi_du_temps.repository;

import com.miashs.emploi_du_temps.model.Enseignant;

import java.util.List;

public interface AdminRepository {
    Enseignant findByNomAndPrenom(String nom, String prenom);
    Enseignant findByEmail(String email);
    List<Enseignant> findByNom(String nom);
    List<Enseignant> findByPrenom(String prenom);
    List<Enseignant> findByDepartementNom(String departement);
}
