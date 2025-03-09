package com.miashs.emploi_du_temps.Controller;

import com.miashs.emploi_du_temps.model.Enseignant;
import com.miashs.emploi_du_temps.model.Notification;
import com.miashs.emploi_du_temps.response.ApiResponse;
import com.miashs.emploi_du_temps.service.notification.NotificationService;
import com.miashs.emploi_du_temps.service.utilisateur.UtilisateurService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@RestController
@RequiredArgsConstructor
@RequestMapping("${api.prefix}/notifications")
public class NotificationController {
    private final NotificationService notificationService;
    private final UtilisateurService utilisateurService;
    @GetMapping("/notification/{id}")
    public ResponseEntity<ApiResponse> getNotificationByEnseignantId(@PathVariable Long id) {
        try{
            List<Notification> notifications = notificationService.getNotificationEnseignant(id);
            Enseignant enseignant = utilisateurService.getEnseignantById(id);
            return ResponseEntity.ok( new ApiResponse("Voici la liste de tous les Notifications de Enseigant "+enseignant.getNom()+" "+enseignant.getPrenom()+" :",notifications));
        } catch (Exception e)
        {
            return ResponseEntity.status(INTERNAL_SERVER_ERROR).body(new ApiResponse(e.getMessage(), INTERNAL_SERVER_ERROR));
        }
    }

    @GetMapping("/notification/all")
    public ResponseEntity<ApiResponse> getAllNotification() {
        try {
            List<Notification> notifications = notificationService.getAllNotification();
            return ResponseEntity.ok(new ApiResponse("Voici la liste de tous les notifications", notifications));
        }catch (Exception e){
            return ResponseEntity.status(INTERNAL_SERVER_ERROR).body(new ApiResponse(e.getMessage(), INTERNAL_SERVER_ERROR));
        }
    }

    @PutMapping("notification/update/{id}")
    public ResponseEntity<ApiResponse> updateNotification(@PathVariable Long id) {
        try{
            notificationService.updateNotification(id);
            return ResponseEntity.ok(new ApiResponse("Notification a été modifier", null));
        }catch (Exception e){
            return ResponseEntity.status(INTERNAL_SERVER_ERROR).body(new ApiResponse(e.getMessage(), INTERNAL_SERVER_ERROR));
        }
    }
}
