package com.miashs.emploi_du_temps.Controller;

import com.miashs.emploi_du_temps.model.Matiere;
import com.miashs.emploi_du_temps.request.MatiereRequest;
import com.miashs.emploi_du_temps.response.ApiResponse;
import com.miashs.emploi_du_temps.service.matiere.MatiereService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("${api.prefix}/matieres")
public class MatiereController {
    private final MatiereService matiereService;


    @PostMapping("/add")
    public ResponseEntity<ApiResponse> addMatiere(@RequestBody MatiereRequest matiereRequest) {
        try {
            Matiere theMatiere = matiereService.addMatiere(matiereRequest);
            return ResponseEntity.ok(new ApiResponse("Matiere ajoutée avec succès", theMatiere));
        } catch (Exception e) {
            return ResponseEntity.status(INTERNAL_SERVER_ERROR)
                    .body(new ApiResponse("Erreur lors de l'ajout de la matiere", e.getMessage()));
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ApiResponse> updateMatiere(@RequestBody MatiereRequest matiereRequest,@PathVariable Long id) {
        try {
            Matiere theMatiere = matiereService.updateMatiere(matiereRequest, id);
            return ResponseEntity.ok(new ApiResponse("Matiere modifiée avec succès", theMatiere));
        } catch (Exception e) {
            return ResponseEntity.status(NOT_FOUND)
                   .body(new ApiResponse("Erreur lors de la modification de la matiere", e.getMessage()));
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ApiResponse> deleteMatiere(@PathVariable Long id) {
        try {
            matiereService.deleteMatiere(id);
            return ResponseEntity.ok(new ApiResponse("Matiere supprimée avec succès", null));
        } catch (Exception e) {
            return ResponseEntity.status(NOT_FOUND)
                   .body(new ApiResponse("Erreur lors de la suppression de la matiere", e.getMessage()));
        }
    }

    @GetMapping("/all")
    public ResponseEntity<ApiResponse> getAllMatieres() {
        try {
            List<Matiere> matieres = matiereService.getAllMatieres();
            return ResponseEntity.ok(new ApiResponse("Liste des matieres", matieres));
        } catch (Exception e) {
            return ResponseEntity.status(INTERNAL_SERVER_ERROR)
                   .body(new ApiResponse("Erreur lors de la récupération de la liste des matieres", e.getMessage()));
        }
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<ApiResponse> getMatiereById(@PathVariable Long id) {
        try {
            Matiere matiere = matiereService.getMatiereById(id);
            return ResponseEntity.ok(new ApiResponse("Matiere trouvée", matiere));
        } catch (Exception e) {
            return ResponseEntity.status(NOT_FOUND)
                   .body(new ApiResponse("Erreur lors de la récupération de la matiere", e.getMessage()));
        }
    }

    @GetMapping("/nom/{nom}")
    public ResponseEntity<ApiResponse> getMatiereByNom(@PathVariable String nom) {
        try {
            Matiere matiere = matiereService.getMatiereByNom(nom);
            return ResponseEntity.ok(new ApiResponse("Matiere trouvée", matiere));
        } catch (Exception e) {
            return ResponseEntity.status(NOT_FOUND)
                   .body(new ApiResponse("Erreur lors de la récupération de la matiere", e.getMessage()));
        }
    }

    @GetMapping("/matieres-by-formation")
    public ResponseEntity<ApiResponse> getMatieresByFormation(@RequestParam String nomFormation) {
        try {
            List<Matiere> matieres = matiereService.getMatieresByFormation(nomFormation);
            return ResponseEntity.ok(new ApiResponse("Liste des matieres pour la formation", matieres));
        } catch (Exception e) {
            return ResponseEntity.status(NOT_FOUND)
                   .body(new ApiResponse("Erreur lors de la récupération de la liste des matieres pour la formation", e.getMessage()));
        }
    }

    @GetMapping("/matieres-by-code")
    public ResponseEntity<ApiResponse> getMatieresByCode(@RequestParam String code) {
        try {
            Matiere matieres = matiereService.getMatiereByCode(code);
            return ResponseEntity.ok(new ApiResponse("Matiere trouvée", matieres));
        } catch (Exception e) {
            return ResponseEntity.status(NOT_FOUND)
                   .body(new ApiResponse("Erreur lors de la récupération de la matiere", e.getMessage()));
        }
    }

}
