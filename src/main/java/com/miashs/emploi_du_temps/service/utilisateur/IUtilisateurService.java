package com.miashs.emploi_du_temps.service.utilisateur;

import com.miashs.emploi_du_temps.model.Admin;
import com.miashs.emploi_du_temps.model.Enseignant;
import com.miashs.emploi_du_temps.model.Utilisateur;
import com.miashs.emploi_du_temps.request.AdminRequest;
import com.miashs.emploi_du_temps.request.EnseignantRequest;
import com.miashs.emploi_du_temps.request.UtilisateurRequest;

import java.util.List;

public interface IUtilisateurService {

    // ADMIN
    boolean addAdmin(AdminRequest adminRequest);
    Admin updateAdmin(AdminRequest adminRequest, Long id);
    Admin getAdminById(Long id);
    Admin getAdminByNomAndPrenom(String nom, String prenom);
    Admin getAdminByEmail(String email);
    List<Admin> getAdminsByNom(String nom);
    List<Admin> getAdminsByPrenom(String prenom);
    List<Admin> getAdminsByDepartement(String departement);

    // ENSEIGNANT

    boolean addEnseignant(EnseignantRequest enseignantRequest);
    Enseignant updateEnseignant(EnseignantRequest enseignantRequest, Long id);
    Enseignant getEnseignantById(Long id);
    List<Enseignant> getEnseignantByNom(String nom);
    List<Enseignant> getEnseignantByPrenom(String prenom);
    Enseignant getEnseignantByEmail(String email);
    List<Enseignant> getEnseignantByNomAndPrenom(String nom, String prenom);

    // UTILISATEUR
    Boolean verifyConnexionUtilisateur(String email, String motDePasse, String type);
    Utilisateur getUtilisateurByEmail(String email);
    List<Utilisateur> getAllUtilisateurs();
    void deleteUtilisateur(Long id);
}
