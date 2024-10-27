package com.miashs.emploi_du_temps.Controller;

import com.miashs.emploi_du_temps.model.Enseignant;
import com.miashs.emploi_du_temps.request.EnseignantRequest;
import com.miashs.emploi_du_temps.response.ApiResponse;
import com.miashs.emploi_du_temps.service.enseignant.EnseignantService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestController
@RequiredArgsConstructor
@RequestMapping("${api.prefix}/enseignants")
public class EnseignantController {

    private final EnseignantService enseignantService;

    @PostMapping("/add")
    public ResponseEntity<ApiResponse> addEnseignant(@RequestBody EnseignantRequest enseignantRequest) {


        try {
            Enseignant enseignant = enseignantService.addEnseignant(enseignantRequest);
            return ResponseEntity.ok(new ApiResponse("ajout de l'eseignant a ete fait", enseignant));
        } catch (Exception e) {
            return ResponseEntity.status(NOT_FOUND).body(new ApiResponse("Erreur lors de l'ajout de l'enseignant ", null));
        }
    }
    @GetMapping("/all")
    public ResponseEntity<ApiResponse> getAllEnseignant () {
        try {
            List<Enseignant> enseignants = enseignantService.getAllEnseignant();
            return ResponseEntity.ok(new ApiResponse("Formations trouvées", enseignants));
        } catch (Exception e) {
            return ResponseEntity.status(INTERNAL_SERVER_ERROR).body(new ApiResponse("Erreur lors de la récupération de toutes les enseigants", INTERNAL_SERVER_ERROR));
        }
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<ApiResponse> updateEnseignant(@RequestBody EnseignantRequest enseignantRequest, @PathVariable Long id)
    {
        try {
            Enseignant enseignant = enseignantService.updateEnseignant(enseignantRequest,id);
            return ResponseEntity.ok(new ApiResponse("enseignant a été bien enrégistrer",enseignant));
        }catch (Exception e) {
            return ResponseEntity.status(NOT_FOUND).body(new ApiResponse("Erreur lors de modifier l'enseignant", null));
        }
    }
    @PostMapping("/verify")
    public ResponseEntity<ApiResponse> verifierConnexionEnseignant(@RequestParam String email, @RequestParam String motDePasse) {
        Boolean isVerified = enseignantService.verifierConnexionEnseignant(email, motDePasse);
        if (isVerified) {
            return ResponseEntity.ok(new ApiResponse("Vérification réussie", true));
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(new ApiResponse("Identifiants invalides", false));
        }
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ApiResponse> deleteEnseignant (@PathVariable long id)
    {
        try
        {
            enseignantService.deleteEnseignant(id);
            return ResponseEntity.ok(new ApiResponse("enseignant avec ID "+id+" a été bien enrégistrer", null));
        } catch (Exception e)
        {
            return ResponseEntity.status(NOT_FOUND).body(new ApiResponse("Erreur lors de supprimer l'enseignant", null));

        }
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<ApiResponse> getEnseignantById(@PathVariable Long id){
        try {
            Enseignant enseignant = enseignantService.getEnseignantById(id);
            return ResponseEntity.ok(new ApiResponse("Enseignant trouvé", enseignant));
        } catch (Exception e) {
            return ResponseEntity.status(NOT_FOUND).body(new ApiResponse("Erreur lors de la recherche de l'enseignant", null));
        }
    }

    @GetMapping("/nom/{nom}")
    public ResponseEntity<ApiResponse> getEnseignantByNom(@PathVariable String nom) {
        try {
            List<Enseignant> enseignants = enseignantService.getEnseignantByNom(nom);
            return ResponseEntity.ok(new ApiResponse("Enseignants trouvés", enseignants));
        } catch (Exception e) {
            return ResponseEntity.status(NOT_FOUND).body(new ApiResponse("Erreur lors de la recherche de l'enseignant", null));
        }
    }
    @GetMapping("/prenom/{prenom}")
    public ResponseEntity<ApiResponse> getEnseignantByPrenom(@PathVariable String prenom) {
        try {
            List<Enseignant> enseignants = enseignantService.getEnseignantByPrenom(prenom);
            return ResponseEntity.ok(new ApiResponse("Enseignants trouvés", enseignants));
        } catch (Exception e) {
            return ResponseEntity.status(NOT_FOUND).body(new ApiResponse("Erreur lors de la recherche de l'enseignant", null));
        }
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<ApiResponse> getEnseignantByEmail(@PathVariable String email) {
        try {
            Enseignant enseignant = enseignantService.getEnseignantByEmail(email);
            return ResponseEntity.ok(new ApiResponse("Enseignant trouvé", enseignant));
        } catch (Exception e) {
            return ResponseEntity.status(NOT_FOUND).body(new ApiResponse("Erreur lors de la recherche de l'enseignant", null));
        }
    }

    @GetMapping("/get-by-nom-and-prenom")
    public ResponseEntity<ApiResponse> getEnseignantByNomAndPrenom(@RequestParam String nom, @RequestParam String prenom) {
        try {
            List<Enseignant> enseignants = enseignantService.getEnseignantByNomAndPrenom(nom, prenom);
            return ResponseEntity.ok(new ApiResponse("Enseignants trouvés", enseignants));
        } catch (Exception e) {
            return ResponseEntity.status(NOT_FOUND).body(new ApiResponse("Erreur lors de la recherche de l'enseignant", null));
        }
    }

}