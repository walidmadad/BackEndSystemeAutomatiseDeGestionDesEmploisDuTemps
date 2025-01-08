package com.miashs.emploi_du_temps.repository;

import com.miashs.emploi_du_temps.model.Formation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface FormationRepository extends JpaRepository<Formation,Long> {
    List<Formation> findByNom(String nom);
    List<Formation> findByNiveauNom(String niveau);
    List<Formation> findByDepartementNom(String departement);
    List<Formation> findByDepartementNomAndNiveauNom(String departement, String niveau);
}