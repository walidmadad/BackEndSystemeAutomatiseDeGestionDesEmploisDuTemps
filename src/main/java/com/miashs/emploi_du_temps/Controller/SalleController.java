package com.miashs.emploi_du_temps.Controller;

import com.miashs.emploi_du_temps.modele.Salle;
import com.miashs.emploi_du_temps.request.SalleRequest;
import com.miashs.emploi_du_temps.response.ApiResponse;
import com.miashs.emploi_du_temps.service.salle.SalleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@RequiredArgsConstructor
@RestController
@RequestMapping("${api.prefix}/salles")
public class SalleController {
    private final SalleService salleService;

    @PostMapping("/add")
    public ResponseEntity<ApiResponse> addSalle(@RequestBody SalleRequest salleRequest){
        try {
            Salle theSalle = salleService.addSalle(salleRequest);
            return ResponseEntity.ok(new ApiResponse("Salle ajoutée avec succès", theSalle));
        } catch (Exception e) {
            return ResponseEntity.status(INTERNAL_SERVER_ERROR).body(new ApiResponse("Erreur lors de l'ajout de la salle", INTERNAL_SERVER_ERROR));
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ApiResponse> updateSalle(@RequestBody SalleRequest salleRequest, @PathVariable Long id){
        try {
            Salle theSalle = salleService.updateSalle(salleRequest, id);
            return ResponseEntity.ok(new ApiResponse("Salle modifiée avec succès", theSalle));
        } catch (Exception e) {
            return ResponseEntity.status(NOT_FOUND).body(new ApiResponse("Erreur lors de la modification de la salle", null));
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ApiResponse> deleteSalle(@PathVariable Long id){
        try {
            salleService.deleteSalle(id);
            return ResponseEntity.ok(new ApiResponse("Salle supprimée avec succès", null));
        } catch (Exception e) {
            return ResponseEntity.status(NOT_FOUND).body(new ApiResponse("Erreur lors de la suppression de la salle", null));
        }
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<ApiResponse> getSalleById(@PathVariable Long id){
        try {
            Salle theSalle = salleService.getSalleById(id);
            return ResponseEntity.ok(new ApiResponse("Salle trouvée", theSalle));
        } catch (Exception e) {
            return ResponseEntity.status(NOT_FOUND).body(new ApiResponse("Erreur lors de la recherche de la salle", null));
        }
    }

    @GetMapping("/all")
    public ResponseEntity<ApiResponse> getAllSalles(){
        try {
            List<Salle> salles = salleService.getAllSalles();
            return ResponseEntity.ok(new ApiResponse("success", salles));
        } catch (Exception e) {
            return ResponseEntity.status(INTERNAL_SERVER_ERROR).body(new ApiResponse("Erreur lors de la récupération des salles", INTERNAL_SERVER_ERROR));
        }
    }

    @GetMapping("/nom/{nom}")
    public ResponseEntity<ApiResponse> getSalleByNom(@PathVariable String nom){
        try {
            List<Salle> salles = salleService.getSalleByNom(nom);
            return ResponseEntity.ok(new ApiResponse("Salle trouvée", salles));
        } catch (Exception e) {
            return ResponseEntity.status(NOT_FOUND).body(new ApiResponse("Erreur lors de la recherche de la salle", null));
        }
    }

    @GetMapping("/salles-by-type")
    public ResponseEntity<ApiResponse> getSallesByType(@RequestParam String type){
        try {
            List<Salle> salles = salleService.getSalleByType(type);
            return ResponseEntity.ok(new ApiResponse("Salles trouvées", salles));
        } catch (Exception e) {
            return ResponseEntity.status(NOT_FOUND).body(new ApiResponse("Erreur lors de la recherche des salles par type", null));
        }
    }

    @GetMapping("/salles-by-departement")
    public ResponseEntity<ApiResponse> getSallesByDepartement(@RequestParam String departement){
        try {
            List<Salle> salles = salleService.getSalleByDepartement(departement);
            return ResponseEntity.ok(new ApiResponse("Salles trouvées", salles));
        } catch (Exception e) {
            return ResponseEntity.status(NOT_FOUND).body(new ApiResponse("Erreur lors de la recherche des salles par département", null));
        }
    }
}
