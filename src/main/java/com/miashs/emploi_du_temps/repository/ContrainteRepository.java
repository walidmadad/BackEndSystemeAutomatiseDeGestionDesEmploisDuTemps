package com.miashs.emploi_du_temps.repository;

import com.miashs.emploi_du_temps.model.Contrainte;
import com.miashs.emploi_du_temps.model.Cours;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContrainteRepository extends JpaRepository<Contrainte, Long> {

    List<Contrainte> findByEnseignant_id(Long enseignant_id);

}
