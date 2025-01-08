package com.miashs.emploi_du_temps.Controller;


import com.miashs.emploi_du_temps.model.Admin;
import com.miashs.emploi_du_temps.model.Enseignant;
import com.miashs.emploi_du_temps.model.Utilisateur;
import com.miashs.emploi_du_temps.request.AdminRequest;
import com.miashs.emploi_du_temps.request.EnseignantRequest;
import com.miashs.emploi_du_temps.request.UtilisateurRequest;
import com.miashs.emploi_du_temps.response.ApiResponse;
import com.miashs.emploi_du_temps.service.utilisateur.UtilisateurService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestController
@RequiredArgsConstructor
@RequestMapping("${api.prefix}/utilisateurs")
public class UtilisateurController {
    private final UtilisateurService utilisateurService;

    // ** ADMINS **
    @PostMapping("/admin/add")
    public ResponseEntity<ApiResponse> addAdmin(@RequestBody AdminRequest adminRequest) {
        try {
            boolean estAdmin = utilisateurService.addAdmin(adminRequest);
            if(estAdmin) {
                return ResponseEntity.ok(new ApiResponse("ajout de l'eseignant a ete fait", true));
            }else {
                return ResponseEntity.ok(new ApiResponse("Erreur lors de l'ajout de l'admin ", true));
            }
        } catch (Exception e) {
            return ResponseEntity.status(NOT_FOUND).body(new ApiResponse("Erreur lors de l'ajout de l'admin ", null));
        }
    }

    @PutMapping("admin/update/{id}")
    public ResponseEntity<ApiResponse> updateAdmin(@RequestBody AdminRequest adminRequest, @PathVariable Long id)
    {
        try {
            Admin admin = utilisateurService.updateAdmin(adminRequest,id);
            return ResponseEntity.ok(new ApiResponse("admin a été bien enrégistrer",admin));
        }catch (Exception e) {
            return ResponseEntity.status(NOT_FOUND).body(new ApiResponse("Erreur lors de modifier l'admin", null));
        }
    }

    @GetMapping("admin/id/{id}")
    public ResponseEntity<ApiResponse> getAdminById(@PathVariable Long id){
        try {
            Admin admin = utilisateurService.getAdminById(id);
            return ResponseEntity.ok(new ApiResponse("admin trouvé", admin));
        } catch (Exception e) {
            return ResponseEntity.status(NOT_FOUND).body(new ApiResponse("Erreur lors de la recherche de l'admin", null));
        }
    }

    @GetMapping("admin/nom/{nom}")
    public ResponseEntity<ApiResponse> getAdminByNom(@PathVariable String nom) {
        try {
            List<Admin> admins = utilisateurService.getAdminsByNom(nom);
            return ResponseEntity.ok(new ApiResponse("admins trouvés", admins));
        } catch (Exception e) {
            return ResponseEntity.status(NOT_FOUND).body(new ApiResponse("Erreur lors de la recherche de l'admin", null));
        }
    }
    @GetMapping("admin/prenom/{prenom}")
    public ResponseEntity<ApiResponse> getAdminByPrenom(@PathVariable String prenom) {
        try {
            List<Admin> admins = utilisateurService.getAdminsByPrenom(prenom);
            return ResponseEntity.ok(new ApiResponse("admins trouvés", admins));
        } catch (Exception e) {
            return ResponseEntity.status(NOT_FOUND).body(new ApiResponse("Erreur lors de la recherche de l'admin", null));
        }
    }

    @GetMapping("admin/email/{email}")
    public ResponseEntity<ApiResponse> getAdminByEmail(@PathVariable String email) {
        try {
            Admin admin = utilisateurService.getAdminByEmail(email);
            return ResponseEntity.ok(new ApiResponse("admin trouvé", admin));
        } catch (Exception e) {
            return ResponseEntity.status(NOT_FOUND).body(new ApiResponse("Erreur lors de la recherche de l'admin", null));
        }
    }

    @GetMapping("admin/get-by-nom-and-prenom")
    public ResponseEntity<ApiResponse> getAdminByNomAndPrenom(@RequestParam String nom, @RequestParam String prenom) {
        try {
            Admin admin = utilisateurService.getAdminByNomAndPrenom(nom, prenom);
            return ResponseEntity.ok(new ApiResponse("admins trouvés", admin));
        } catch (Exception e) {
            return ResponseEntity.status(NOT_FOUND).body(new ApiResponse("Erreur lors de la recherche de l'admin", null));
        }
    }

    // ** ENSEIGNANTS **
    @PostMapping("enseignant/add")
    public ResponseEntity<ApiResponse> addEnseignant(@RequestBody EnseignantRequest enseignantRequest) {
        try {
            boolean estAjouter = utilisateurService.addEnseignant(enseignantRequest);
            if(estAjouter) {
                return ResponseEntity.ok(new ApiResponse("ajout de l'enseignant a ete fait", true));
            }else{
                return ResponseEntity.ok(new ApiResponse("Erreur lors de l'ajout de l'enseignant", false));
            }
        } catch (Exception e) {
            return ResponseEntity.status(NOT_FOUND).body(new ApiResponse("Erreur lors de l'ajout de l'enseignant ", null));
        }
    }
    @PutMapping("enseignant/update/{id}")
    public ResponseEntity<ApiResponse> updateEnseignant(@RequestBody EnseignantRequest enseignantRequest, @PathVariable Long id)
    {
        try {
            Enseignant enseignant = utilisateurService.updateEnseignant(enseignantRequest,id);
            return ResponseEntity.ok(new ApiResponse("enseignant a été bien enrégistrer",enseignant));
        }catch (Exception e) {
            return ResponseEntity.status(NOT_FOUND).body(new ApiResponse("Erreur lors de modifier l'enseignant", null));
        }
    }

    @GetMapping("enseignant/id/{id}")
    public ResponseEntity<ApiResponse> getEnseignantById(@PathVariable Long id){
        try {
            Enseignant enseignant = utilisateurService.getEnseignantById(id);
            return ResponseEntity.ok(new ApiResponse("Enseignant trouvé", enseignant));
        } catch (Exception e) {
            return ResponseEntity.status(NOT_FOUND).body(new ApiResponse("Erreur lors de la recherche de l'enseignant", null));
        }
    }

    @GetMapping("enseignant/nom/{nom}")
    public ResponseEntity<ApiResponse> getEnseignantByNom(@PathVariable String nom) {
        try {
            List<Enseignant> enseignants = utilisateurService.getEnseignantByNom(nom);
            return ResponseEntity.ok(new ApiResponse("Enseignants trouvés", enseignants));
        } catch (Exception e) {
            return ResponseEntity.status(NOT_FOUND).body(new ApiResponse("Erreur lors de la recherche de l'enseignant", null));
        }
    }
    @GetMapping("enseignant/prenom/{prenom}")
    public ResponseEntity<ApiResponse> getEnseignantByPrenom(@PathVariable String prenom) {
        try {
            List<Enseignant> enseignants = utilisateurService.getEnseignantByPrenom(prenom);
            return ResponseEntity.ok(new ApiResponse("Enseignants trouvés", enseignants));
        } catch (Exception e) {
            return ResponseEntity.status(NOT_FOUND).body(new ApiResponse("Erreur lors de la recherche de l'enseignant", null));
        }
    }

    @GetMapping("enseignant/email/{email}")
    public ResponseEntity<ApiResponse> getEnseignantByEmail(@PathVariable String email) {
        try {
            Enseignant enseignant = utilisateurService.getEnseignantByEmail(email);
            return ResponseEntity.ok(new ApiResponse("Enseignant trouvé", enseignant));
        } catch (Exception e) {
            return ResponseEntity.status(NOT_FOUND).body(new ApiResponse("Erreur lors de la recherche de l'enseignant", null));
        }
    }

    @GetMapping("enseignant/get-by-nom-and-prenom")
    public ResponseEntity<ApiResponse> getEnseignantByNomAndPrenom(@RequestParam String nom, @RequestParam String prenom) {
        try {
            List<Enseignant> enseignants = utilisateurService.getEnseignantByNomAndPrenom(nom, prenom);
            return ResponseEntity.ok(new ApiResponse("Enseignants trouvés", enseignants));
        } catch (Exception e) {
            return ResponseEntity.status(NOT_FOUND).body(new ApiResponse("Erreur lors de la recherche de l'enseignant", null));
        }
    }


    // ** UTILISATEUR **
    @GetMapping("/verify")
    public ResponseEntity<ApiResponse> verifierConnexionEnseignants(@RequestParam String email, @RequestParam String motDePasse, @RequestParam String userType){
        boolean isVerified = utilisateurService.verifyConnexionUtilisateur(email, motDePasse, userType);
        if (isVerified) {
            Utilisateur utilisateur = utilisateurService.getUtilisateurByEmail(email);
            return ResponseEntity.ok(new ApiResponse("Vérification réussie", utilisateur));
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(new ApiResponse("Identifiants invalides", false));
        }
    }
    @GetMapping("/all")
    public ResponseEntity<ApiResponse> getAllUtilisateurs () {
        try {
            List<Utilisateur> utilisateur = utilisateurService.getAllUtilisateurs();
            return ResponseEntity.ok(new ApiResponse("Utilisateurs trouvées", utilisateur));
        } catch (Exception e) {
            return ResponseEntity.status(INTERNAL_SERVER_ERROR).body(new ApiResponse("Erreur lors de la récupération de toutes les utilisateurs", INTERNAL_SERVER_ERROR));
        }
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ApiResponse> deleteUtilisateur (@PathVariable long id)
    {
        try {
            utilisateurService.deleteUtilisateur(id);
            return ResponseEntity.ok(new ApiResponse("Utilisateur avec ID "+id+" a été bien supprimer", null));
        } catch (Exception e) {
            return ResponseEntity.status(NOT_FOUND).body(new ApiResponse("Erreur lors de supprimer l'utilisateur", null));
        }
    }

}
