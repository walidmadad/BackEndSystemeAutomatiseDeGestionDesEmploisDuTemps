package com.miashs.emploi_du_temps.repository;

import com.miashs.emploi_du_temps.model.Cours;
import com.miashs.emploi_du_temps.model.Enseignant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CoursRepository extends JpaRepository<Cours, Long> {

    List<Cours> findByEnseignantId (Long enseignant_id);

}
