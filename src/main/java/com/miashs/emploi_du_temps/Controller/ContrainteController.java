package com.miashs.emploi_du_temps.Controller;


import com.miashs.emploi_du_temps.model.Contrainte;
import com.miashs.emploi_du_temps.model.Enseignant;
import com.miashs.emploi_du_temps.request.ContrainteRequest;
import com.miashs.emploi_du_temps.response.ApiResponse;
import com.miashs.emploi_du_temps.service.contrainte.ContrainteService;
import com.miashs.emploi_du_temps.service.utilisateur.UtilisateurService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@RequiredArgsConstructor
@RestController
@RequestMapping("${api.prefix}/contraintes")
public class ContrainteController {

    private final ContrainteService contrainteService;
    private final UtilisateurService utilisateurService;
    @PostMapping("/add")
    public ResponseEntity<ApiResponse> addContrainte (@RequestBody ContrainteRequest contrainteRequest)
    {
        try{
            Contrainte contrainte = contrainteService.addContrainte(contrainteRequest);
            return ResponseEntity.ok( new ApiResponse("Le contrainte est bien enregistré",contrainte));
        } catch (Exception e)
        {
            return ResponseEntity.status(INTERNAL_SERVER_ERROR).body(new ApiResponse(e.getMessage(), INTERNAL_SERVER_ERROR));
        }

    }

    @GetMapping("/all")
    public ResponseEntity<ApiResponse> getAllContrainte ()
    {
        try{
            List<Contrainte> contrainte = contrainteService.getAllContrainte();
            return ResponseEntity.ok( new ApiResponse("Voici la liste de tous les contraintes",contrainte));
        } catch (Exception e)
        {
            return ResponseEntity.status(INTERNAL_SERVER_ERROR).body(new ApiResponse(e.getMessage(), INTERNAL_SERVER_ERROR));
        }

    }


    @GetMapping("/enseignant/{id}")

    public ResponseEntity<ApiResponse> getContrainteByEnseignantId ( @PathVariable Long id)
    {
        try{
            List<Contrainte> contrainte = contrainteService.getContraintebyEnseignant(id);
            Enseignant enseignant = utilisateurService.getEnseignantById(id);
            return ResponseEntity.ok( new ApiResponse("Voici la liste de tous les contraintes de Enseigant "+enseignant.getNom()+" "+enseignant.getPrenom()+" :",contrainte));
        } catch (Exception e)
        {
            return ResponseEntity.status(INTERNAL_SERVER_ERROR).body(new ApiResponse(e.getMessage(), INTERNAL_SERVER_ERROR));
        }


    }

}
