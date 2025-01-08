package com.miashs.emploi_du_temps.repository;

import com.miashs.emploi_du_temps.model.Matiere;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MatiereRepository extends JpaRepository<Matiere, Long> {
    Matiere findByNom(String nom);
    List<Matiere> findByFormationNom(String formation);
    Matiere findByCode(String code);
}
