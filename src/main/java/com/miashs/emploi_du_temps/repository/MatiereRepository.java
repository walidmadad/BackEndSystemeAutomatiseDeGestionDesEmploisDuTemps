package com.miashs.emploi_du_temps.repository;

import com.miashs.emploi_du_temps.modele.Matiere;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MatiereRepository extends JpaRepository<Matiere, Long> {

    List<Matiere> findMatieresByFormation(String nomFormation);
    List<Matiere> findMatieresByEnseignant(String nomEnseignant);

}
