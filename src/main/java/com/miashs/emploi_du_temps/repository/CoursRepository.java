package com.miashs.emploi_du_temps.repository;

import com.miashs.emploi_du_temps.modele.Cours;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Time;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface CoursRepository extends JpaRepository<Cours, Long> {
    List<Cours> findByMatiereId(Long idMatiere);
    List<Cours> findByFormationId(Long idFormation);
    Cours findByJourAndHeureDebutAndHeureFin(Date jour, Time heureDebut, Time heureFin);
}
