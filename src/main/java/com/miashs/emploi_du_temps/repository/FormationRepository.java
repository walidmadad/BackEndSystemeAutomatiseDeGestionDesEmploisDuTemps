package com.miashs.emploi_du_temps.repository;

import com.miashs.emploi_du_temps.modele.Formation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FormationRepository extends JpaRepository<Formation,Long> {
    Formation findByName(String nom);
    List<Formation> findByNiveau(String niveau);
    List<Formation> findByDepartement(String nomDepartement);
    List<Formation> findByDepartementAndNiveau(String nomDepartement, String niveau);
}
