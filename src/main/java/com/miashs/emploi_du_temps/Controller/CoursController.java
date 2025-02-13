package com.miashs.emploi_du_temps.Controller;

import com.miashs.emploi_du_temps.model.Cours;
import com.miashs.emploi_du_temps.request.CoursRequest;
import com.miashs.emploi_du_temps.response.ApiResponse;
import com.miashs.emploi_du_temps.service.cours.CoursService;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.core.ApplicationPushBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;


@RequiredArgsConstructor
@RestController
@RequestMapping("${api.prefix}/cours")
public class CoursController {
    private final CoursService coursService;



    @PostMapping("/add")
    public ResponseEntity<ApiResponse> addCours (@RequestBody CoursRequest coursRequest)
    {
        try
        {
            Cours cours = coursService.addCours(coursRequest);
            return ResponseEntity.ok( new ApiResponse("Le cours est bien enregistré",cours));
        } catch (Exception e) {
            return ResponseEntity.status(INTERNAL_SERVER_ERROR).body(new ApiResponse(e.getMessage(), INTERNAL_SERVER_ERROR));
        }
    }

    @GetMapping("/all")
    public ResponseEntity<ApiResponse> getAllCours ()
    {
            try {
                List <Cours> cours = coursService.getAllCours();
                return ResponseEntity.ok(new ApiResponse("success", cours));

            } catch (Exception e) {
                return ResponseEntity.status(INTERNAL_SERVER_ERROR).body(new ApiResponse("Erreur lors de la récupération des cours", INTERNAL_SERVER_ERROR));
            }
    }

    @GetMapping("/coursByEnseignant")
    public ResponseEntity<ApiResponse> getCoursByEnseignant (@PathVariable Long enseignant_id)
    {
        try {
            List <Cours> cours = coursService.getCoursByEnseignant(enseignant_id);
            return ResponseEntity.ok(new ApiResponse("success", cours));

        } catch (Exception e) {
            return ResponseEntity.status(INTERNAL_SERVER_ERROR).body(new ApiResponse("Erreur lors de la récupération des cours", INTERNAL_SERVER_ERROR));
        }
    }
}
