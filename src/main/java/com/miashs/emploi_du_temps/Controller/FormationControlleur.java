package com.miashs.emploi_du_temps.Controller;

import com.miashs.emploi_du_temps.modele.Formation;
import com.miashs.emploi_du_temps.request.FormationRequest;
import com.miashs.emploi_du_temps.response.ApiResponse;
import com.miashs.emploi_du_temps.service.formation.FormationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("${api.prefix}/formations")
public class FormationControlleur {
    private final FormationService formationService;

    @PostMapping("/add")
    public ResponseEntity<ApiResponse> addFormation(@RequestBody FormationRequest formationRequest) {
        try {
            Formation formation = formationService.addFormation(formationRequest);
            return ResponseEntity.ok(new ApiResponse("Ajout de formation réussi", formation));
        } catch (Exception e) {
            return ResponseEntity.status(NOT_FOUND).body(new ApiResponse("Erreur lors de l'ajout de formation", null));
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ApiResponse> updateFormation(@RequestBody FormationRequest formationRequest,@PathVariable Long id) {
        try {
            Formation formation = formationService.updateFormation(formationRequest, id);
            return ResponseEntity.ok(new ApiResponse("Formation modifiée avec succès", formation));
        } catch (Exception e) {
            return ResponseEntity.status(NOT_FOUND).body(new ApiResponse("Erreur lors de la modification de formation", null));
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ApiResponse> deleteFormation(@PathVariable Long id) {
        try {
            formationService.deleteFormation(id);
            return ResponseEntity.ok(new ApiResponse("Formation supprimée avec succès", null));
        } catch (Exception e) {
            return ResponseEntity.status(NOT_FOUND).body(new ApiResponse("Erreur lors de la suppression de formation", null));
        }
    }

    @GetMapping("/all")
    public ResponseEntity<ApiResponse> getAllFormations() {
        try {
            List<Formation> formations = formationService.getAllFormations();
            return ResponseEntity.ok(new ApiResponse("Formations trouvées", formations));
        } catch (Exception e) {
            return ResponseEntity.status(INTERNAL_SERVER_ERROR).body(new ApiResponse("Erreur lors de la récupération de toutes les formations", INTERNAL_SERVER_ERROR));
        }
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<ApiResponse> getFormationById(@PathVariable Long id) {
        try {
            Formation formation = formationService.getFormationById(id);
            return ResponseEntity.ok(new ApiResponse("Formation trouvée", formation));
        } catch (Exception e) {
            return ResponseEntity.status(NOT_FOUND).body(new ApiResponse("Erreur lors de la recherche de formation", null));
        }
    }

    @GetMapping("/nom/{nom}")
    public ResponseEntity<ApiResponse> getFormationByNom(@PathVariable String nom) {
        try {
            List<Formation> formation = formationService.getFormationByNom(nom);
            return ResponseEntity.ok(new ApiResponse("Formation trouvée", formation));
        } catch (Exception e) {
            return ResponseEntity.status(NOT_FOUND).body(new ApiResponse("Erreur lors de la recherche de formation", null));
        }
    }

    @GetMapping("/formations-by-departement")
    public ResponseEntity<ApiResponse> getFormationsByDepartement(@RequestParam String departement) {
        try {
            List<Formation> formations = formationService.getFormationsByDepartement(departement);
            return ResponseEntity.ok(new ApiResponse("Formations trouvée", formations));
        } catch (Exception e) {
            return ResponseEntity.status(NOT_FOUND).body(new ApiResponse("Erreur lors de la recherche de formations par département", null));
        }
    }

    @GetMapping("/formations-by-niveau")
    public ResponseEntity<ApiResponse> getFormationsByNiveau(@RequestParam String niveau) {
        try {
            List<Formation> formations = formationService.getFormationsByNiveau(niveau);
            return ResponseEntity.ok(new ApiResponse("Formations trouvée", formations));
        } catch (Exception e) {
            return ResponseEntity.status(NOT_FOUND).body(new ApiResponse("Erreur lors de la recherche de formations par licence", null));
        }
    }

    @GetMapping("/formations-by-departement-and-niveau")
    public ResponseEntity<ApiResponse> getFormationsByDepartementAndNiveau(@RequestParam String departement, @RequestParam String niveau) {
        try {
            List<Formation> formations = formationService.getFormationsByDepartementAndNiveau(departement, niveau);
            return ResponseEntity.ok(new ApiResponse("Formations trouvée", formations));
        } catch (Exception e) {
            return ResponseEntity.status(NOT_FOUND).body(new ApiResponse("Erreur lors de la recherche de formations par département et licence", null));
        }
    }
}
