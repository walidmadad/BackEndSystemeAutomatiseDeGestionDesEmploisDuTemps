package com.miashs.emploi_du_temps.repository;

import com.miashs.emploi_du_temps.model.Departement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartementRepository extends JpaRepository<Departement, Long> {

    Departement findByNom(String nom);
}