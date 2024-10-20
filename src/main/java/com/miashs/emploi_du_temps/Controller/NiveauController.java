package com.miashs.emploi_du_temps.Controller;

import com.miashs.emploi_du_temps.modele.Niveau;
import com.miashs.emploi_du_temps.request.NiveauRequest;
import com.miashs.emploi_du_temps.response.ApiResponse;
import com.miashs.emploi_du_temps.service.niveau.NiveauService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@RequiredArgsConstructor
@RestController
@RequestMapping("${api.prefix}/niveaux")
public class NiveauController {
    private final NiveauService niveauService;

    @PostMapping("/add")
    public ResponseEntity<ApiResponse> addNiveau(@RequestBody NiveauRequest niveau) {
        try {
            Niveau theNiveau = niveauService.addNiveau(niveau);
            return ResponseEntity.ok(new ApiResponse("Niveau ajouté avec succès", theNiveau));
        } catch (Exception e) {
            return ResponseEntity.status(INTERNAL_SERVER_ERROR).body(new ApiResponse("Erreur lors de l'ajout du niveau", INTERNAL_SERVER_ERROR));
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ApiResponse> updateNiveau(@PathVariable Long id, @RequestBody NiveauRequest niveau) {
        try {
            Niveau theNiveau = niveauService.updateNiveau(niveau, id);
            return ResponseEntity.ok(new ApiResponse("Niveau modifié avec succès", theNiveau));
        } catch (Exception e) {
            return ResponseEntity.status(NOT_FOUND).body(new ApiResponse("Erreur lors de la modification du niveau", null));
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ApiResponse> deleteNiveau(@PathVariable Long id) {
        try {
            niveauService.deleteNiveau(id);
            return ResponseEntity.ok(new ApiResponse("Niveau supprimé avec succès", null));
        } catch (Exception e) {
            return ResponseEntity.status(NOT_FOUND).body(new ApiResponse("Erreur lors de la suppression du niveau", null));
        }
    }

    @GetMapping("/all")
    public ResponseEntity<ApiResponse> getAllNiveaux() {
        try {
            List<Niveau> result = niveauService.getAllNiveaux();
            return ResponseEntity.ok(new ApiResponse("success", result));
        } catch (Exception e) {
            return ResponseEntity.status(INTERNAL_SERVER_ERROR).body(new ApiResponse("Erreur lors de la récupération des niveaux", INTERNAL_SERVER_ERROR));
        }
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<ApiResponse> getNiveauById(@PathVariable Long id) {
        try {
            Niveau niveau = niveauService.getNiveauById(id);
            return ResponseEntity.ok(new ApiResponse("success", niveau));
        } catch (Exception e) {
            return ResponseEntity.status(NOT_FOUND).body(new ApiResponse("Erreur lors de la récupération du niveau", null));
        }
    }

    @GetMapping("/nom/{nom}")
    public ResponseEntity<ApiResponse> getNiveauByNom(@PathVariable String nom) {
        try {
            Niveau niveau = niveauService.getNiveauByNom(nom);
            return ResponseEntity.ok(new ApiResponse("success", niveau));
        } catch (Exception e) {
            return ResponseEntity.status(NOT_FOUND).body(new ApiResponse("Erreur lors de la récupération du niveau", null));
        }
    }

}
