package com.miashs.emploi_du_temps.repository;

import com.miashs.emploi_du_temps.model.Cours;
import com.miashs.emploi_du_temps.model.Departement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CoursRepository extends JpaRepository<Cours, Long> {

    List<Cours> findByMatiere_Id (Long matiere_id);
    List<Cours> findByEnseignant_Id (Long enseignant_id);
    List<Cours> findByMatiere_IdAndTypedecours (Long matiere_id,String TypeDeCours);
    List<Cours> findByEnseignant_IdAndTypedecours (Long enseignant_id,String TypeDeCours);

}
