package com.miashs.emploi_du_temps.repository;

import com.miashs.emploi_du_temps.model.Enseignant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EnseignantRepository extends JpaRepository<Enseignant, Long> {
    Enseignant findByNomAndPrenom(String nom, String prenom);
    Enseignant findByEmail(String email);
    List<Enseignant> findByNom(String nom);
    List<Enseignant> findByPrenom(String prenom);
}
