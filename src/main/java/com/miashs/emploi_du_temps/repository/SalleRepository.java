package com.miashs.emploi_du_temps.repository;

import com.miashs.emploi_du_temps.modele.Salle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SalleRepository extends JpaRepository<Salle, Long> {
    List<Salle> findByName(String nom);
    List<Salle> findByDepartement(String nomDepartement);
}