package com.miashs.emploi_du_temps.repository;

import com.miashs.emploi_du_temps.modele.Enseignant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EnseignantRepository extends JpaRepository<Enseignant, Long> {
    List<Enseignant> findEnseignantByNom(String nom);
    List<Enseignant> findEnseignantByPrenom(String prenom);
    Enseignant findEnseignantByNomEtPrenom(String nom, String prenom);
    List<Enseignant> findEnseignantsByMatiere(String matiere);
}
