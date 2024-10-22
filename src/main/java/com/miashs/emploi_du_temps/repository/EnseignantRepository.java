package com.miashs.emploi_du_temps.repository;

import com.miashs.emploi_du_temps.model.Enseignant;
import com.miashs.emploi_du_temps.model.Formation;
import com.miashs.emploi_du_temps.model.Matiere;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EnseignantRepository extends JpaRepository<Enseignant,Long> {



 Enseignant findByNom (String nom);
 Enseignant findByEmail(String email);

}
