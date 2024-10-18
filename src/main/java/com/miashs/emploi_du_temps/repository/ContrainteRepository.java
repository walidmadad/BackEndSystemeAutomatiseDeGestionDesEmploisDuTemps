package com.miashs.emploi_du_temps.repository;

import com.miashs.emploi_du_temps.modele.Contrainte;
import com.miashs.emploi_du_temps.modele.Enseignant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContrainteRepository extends JpaRepository<Contrainte, Long> {
    List<Contrainte> findByType(String type);
    List<Contrainte> findByEnseignant(Enseignant enseignant);
}
