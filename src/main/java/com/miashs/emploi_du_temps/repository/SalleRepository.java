package com.miashs.emploi_du_temps.repository;

import com.miashs.emploi_du_temps.modele.Salle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SalleRepository extends JpaRepository<Salle, Long> {
    List<Salle> findByNom(String nom);
    List<Salle> findByDepartementNom(String departement);
    List<Salle> findByTypeSalle(String typeSalle);
}