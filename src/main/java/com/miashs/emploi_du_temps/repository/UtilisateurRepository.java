package com.miashs.emploi_du_temps.repository;

import com.miashs.emploi_du_temps.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {
    Utilisateur findByEmailAndUserType(String email, String user_type);
    Utilisateur findByEmail(String email);

}
