package com.miashs.emploi_du_temps.Controller;

import com.miashs.emploi_du_temps.model.Departement;
import com.miashs.emploi_du_temps.request.DepartementRequest;
import com.miashs.emploi_du_temps.response.ApiResponse;
import com.miashs.emploi_du_temps.service.departement.DepartementService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@RequiredArgsConstructor
@RestController
@RequestMapping("${api.prefix}/departements")
public class DepartementController {
    private final DepartementService departementService;

    @PostMapping("/add")
    public ResponseEntity<ApiResponse> addDepartement(@RequestBody DepartementRequest departement) {
        try {
            Departement theDepartement = departementService.addDepartement(departement);
            return ResponseEntity.ok(new ApiResponse("Département ajouté avec succès", theDepartement));
        } catch (Exception e) {
            return ResponseEntity.status(INTERNAL_SERVER_ERROR).body(new ApiResponse("Erreur lors de l'ajout du département", INTERNAL_SERVER_ERROR));
        }

    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ApiResponse> updateDepartement(@PathVariable Long id, @RequestBody DepartementRequest departement) {
        try {
            Departement theDepartement = departementService.updateDepartement(departement, id);
            return ResponseEntity.ok(new ApiResponse("Département modifié avec succès", theDepartement));
        } catch (Exception e) {
            return ResponseEntity.status(NOT_FOUND).body(new ApiResponse("Erreur lors de la modification du département", null));
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ApiResponse> deleteDepartement(@PathVariable Long id) {
        try {
            departementService.deleteDepartement(id);
            return ResponseEntity.ok(new ApiResponse("Département supprimé avec succès", null));
        } catch (Exception e) {
            return ResponseEntity.status(NOT_FOUND).body(new ApiResponse("Erreur lors de la suppression du département", null));
        }
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<ApiResponse> getDepartementById(@PathVariable Long id) {
        try {
            Departement departement = departementService.getDepartementById(id);
            return ResponseEntity.ok(new ApiResponse("success", departement));
        } catch (Exception e) {
            return ResponseEntity.status(NOT_FOUND).body(new ApiResponse("Erreur lors de la récupération du département", null));
        }
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<ApiResponse> getDepartementByName(@PathVariable String name) {
        try {
            Departement departement = departementService.getDepartementByNom(name);
            return ResponseEntity.ok(new ApiResponse("success", departement));
        } catch (Exception e) {
            return ResponseEntity.status(NOT_FOUND).body(new ApiResponse("Erreur lors de la récupération du département", null));
        }
    }

    @GetMapping("/all")
    public ResponseEntity<ApiResponse> getAllDepartements() {
        try {
            List<Departement> departements = departementService.getAllDepartements();
            return ResponseEntity.ok(new ApiResponse("success", departements));
        } catch (Exception e) {
            return ResponseEntity.status(INTERNAL_SERVER_ERROR).body(new ApiResponse("Erreur lors de la récupération des départements", INTERNAL_SERVER_ERROR));
        }
    }

}
