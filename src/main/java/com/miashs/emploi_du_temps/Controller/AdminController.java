package com.miashs.emploi_du_temps.Controller;

import com.miashs.emploi_du_temps.model.Admin;
import com.miashs.emploi_du_temps.request.AdminRequest;
import com.miashs.emploi_du_temps.response.ApiResponse;
import com.miashs.emploi_du_temps.service.admin.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestController
@RequiredArgsConstructor
@RequestMapping("${api.prefix}/admins")
public class AdminController {
    private final AdminService adminService;


    @PostMapping("/add")
    public ResponseEntity<ApiResponse> addAdmin(@RequestBody AdminRequest adminRequest) {


        try {
            Admin admin = adminService.addAdmin(adminRequest);
            return ResponseEntity.ok(new ApiResponse("ajout de l'eseignant a ete fait", admin));
        } catch (Exception e) {
            return ResponseEntity.status(NOT_FOUND).body(new ApiResponse("Erreur lors de l'ajout de l'admin ", null));
        }
    }
    @GetMapping("/all")
    public ResponseEntity<ApiResponse> getAllAdmin () {
        try {
            List<Admin> admins = adminService.getAllAdmins();
            return ResponseEntity.ok(new ApiResponse("Formations trouvées", admins));
        } catch (Exception e) {
            return ResponseEntity.status(INTERNAL_SERVER_ERROR).body(new ApiResponse("Erreur lors de la récupération de toutes les enseigants", INTERNAL_SERVER_ERROR));
        }
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<ApiResponse> updateAdmin(@RequestBody AdminRequest adminRequest, @PathVariable Long id)
    {
        try {
            Admin admin = adminService.updateAdmin(adminRequest,id);
            return ResponseEntity.ok(new ApiResponse("admin a été bien enrégistrer",admin));
        }catch (Exception e) {
            return ResponseEntity.status(NOT_FOUND).body(new ApiResponse("Erreur lors de modifier l'admin", null));
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ApiResponse> deleteAdmin (@PathVariable long id)
    {
        try
        {
            adminService.deleteAdmin(id);
            return ResponseEntity.ok(new ApiResponse("admin avec ID "+id+" a été bien enrégistrer", null));
        } catch (Exception e)
        {
            return ResponseEntity.status(NOT_FOUND).body(new ApiResponse("Erreur lors de supprimer l'admin", null));

        }
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<ApiResponse> getAdminById(@PathVariable Long id){
        try {
            Admin admin = adminService.getAdminById(id);
            return ResponseEntity.ok(new ApiResponse("admin trouvé", admin));
        } catch (Exception e) {
            return ResponseEntity.status(NOT_FOUND).body(new ApiResponse("Erreur lors de la recherche de l'admin", null));
        }
    }

    @GetMapping("/nom/{nom}")
    public ResponseEntity<ApiResponse> getAdminByNom(@PathVariable String nom) {
        try {
            List<Admin> admins = adminService.getAdminsByNom(nom);
            return ResponseEntity.ok(new ApiResponse("admins trouvés", admins));
        } catch (Exception e) {
            return ResponseEntity.status(NOT_FOUND).body(new ApiResponse("Erreur lors de la recherche de l'admin", null));
        }
    }
    @GetMapping("/prenom/{prenom}")
    public ResponseEntity<ApiResponse> getAdminByPrenom(@PathVariable String prenom) {
        try {
            List<Admin> admins = adminService.getAdminsByPrenom(prenom);
            return ResponseEntity.ok(new ApiResponse("admins trouvés", admins));
        } catch (Exception e) {
            return ResponseEntity.status(NOT_FOUND).body(new ApiResponse("Erreur lors de la recherche de l'admin", null));
        }
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<ApiResponse> getAdminByEmail(@PathVariable String email) {
        try {
            Admin admin = adminService.getAdminByEmail(email);
            return ResponseEntity.ok(new ApiResponse("admin trouvé", admin));
        } catch (Exception e) {
            return ResponseEntity.status(NOT_FOUND).body(new ApiResponse("Erreur lors de la recherche de l'admin", null));
        }
    }

    @GetMapping("/get-by-nom-and-prenom")
    public ResponseEntity<ApiResponse> getAdminByNomAndPrenom(@RequestParam String nom, @RequestParam String prenom) {
        try {
            Admin admin = adminService.getAdminByNomAndPrenom(nom, prenom);
            return ResponseEntity.ok(new ApiResponse("admins trouvés", admin));
        } catch (Exception e) {
            return ResponseEntity.status(NOT_FOUND).body(new ApiResponse("Erreur lors de la recherche de l'admin", null));
        }
    }

    @GetMapping("/verify")
    public ResponseEntity<ApiResponse> verifierConnexionAdmin(@RequestParam String email, @RequestParam String motDePasse) {
        Boolean isVerified = adminService.verifyConnexionAdmin(email, motDePasse);
        if (isVerified) {
            return ResponseEntity.ok(new ApiResponse("Vérification réussie", true));
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(new ApiResponse("Identifiants invalides", false));
        }
    }
}
