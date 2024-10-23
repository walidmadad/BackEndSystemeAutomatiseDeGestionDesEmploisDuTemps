package com.miashs.emploi_du_temps.Controller;

import com.miashs.emploi_du_temps.model.Enseignant;
import com.miashs.emploi_du_temps.request.EnseignantRequest;
import com.miashs.emploi_du_temps.response.ApiResponse;
import com.miashs.emploi_du_temps.service.enseignant.EnseignantService;
import lombok.RequiredArgsConstructor;
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

}
