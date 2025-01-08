package com.miashs.emploi_du_temps.repository;

import com.miashs.emploi_du_temps.model.Niveau;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NiveauRepository extends JpaRepository<Niveau, Long> {
    Niveau findByNom(String nom);
}
