package com.miashs.emploi_du_temps.service.notification;

import com.miashs.emploi_du_temps.Exception.ResourceNotFoundException;
import com.miashs.emploi_du_temps.modele.Enseignant;
import com.miashs.emploi_du_temps.modele.Notification;
import com.miashs.emploi_du_temps.repository.NotificationRepository;
import com.miashs.emploi_du_temps.request.NotificationRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class NotificationService implements INotificationService  {
    NotificationRepository notificationRepository;

    @Override
    public Notification addNotification(NotificationRequest notificationRequest) {
        Notification notification = new Notification();
        notification.setTitre(notificationRequest.getTitre());
        notification.setMessage(notificationRequest.getMessage());
        notification.setDateEnvoie(notificationRequest.getDateEnvoie());
        notification.setEnseignant(notificationRequest.getEnseignant());

        return notificationRepository.save(notification);
    }

    @Override
    public Notification updateNotification(NotificationRequest notificationRequest, Long id) {
        Optional<Notification> notificationExistant = notificationRepository.findById(id);
        if (notificationExistant.isPresent()) {
            Notification notification = notificationExistant.get();
            notification.setTitre(notificationRequest.getTitre());
            notification.setMessage(notificationRequest.getMessage());
            notification.setDateEnvoie(notificationRequest.getDateEnvoie());
            notification.setEnseignant(notificationRequest.getEnseignant());

            return notificationRepository.save(notification);
        }else {
            throw new ResourceNotFoundException("Notification not found");
        }
    }

    @Override
    public void deleteNotification(Long id) {
        notificationRepository.deleteById(id);
    }

    @Override
    public Notification getNotificationById(Long id) {
        return notificationRepository.findById(id)
               .orElseThrow(() -> new ResourceNotFoundException("Notification not found"));
    }

    @Override
    public List<Notification> getAllNotifications() {
        return notificationRepository.findAll();
    }

    @Override
    public List<Notification> getNotificationsByEnseignant(Enseignant enseignant) {
        return notificationRepository.findByEnseignant(enseignant);
    }

    @Override
    public List<Notification> getNotificationsByDate(Date dateEnvoie) {
        return notificationRepository.findByDate(dateEnvoie);
    }

}
