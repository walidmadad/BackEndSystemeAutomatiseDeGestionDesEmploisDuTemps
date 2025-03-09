package com.miashs.emploi_du_temps.service.notification;

import com.miashs.emploi_du_temps.Exception.ResourceNotFoundException;
import com.miashs.emploi_du_temps.model.Notification;
import com.miashs.emploi_du_temps.repository.NotificationRepository;
import com.miashs.emploi_du_temps.request.NotificationRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class NotificationService implements INotificationService {

    private final NotificationRepository notificationRepository;

    @Override
    public Notification addNotification(NotificationRequest notificationRequest) {
        Notification notification = new Notification();
        notification.setTitre(notificationRequest.getTitre());
        notification.setMessage(notificationRequest.getMessage());
        notification.setDateEnvoie(notificationRequest.getDateEnvoie());
        notification.setVue(notificationRequest.getVue() != null ? notificationRequest.getVue() : false);
        notification.setSender(notificationRequest.getSender());
        notification.setEnseignant(notificationRequest.getEnseignant());
        return notificationRepository.save(notification);
    }

    @Override
    public List<Notification> getNotificationEnseignant(Long id) {
        return notificationRepository.getNotificationByEnseignant_idOrderByDateEnvoieDesc(id);
    }

    @Override
    public List<Notification> getAllNotification() {
        return notificationRepository.findAllByOrderByDateEnvoieDesc();
    }

    @Override
    public void updateNotification(Long id){
        Optional<Notification> notificationOptional = notificationRepository.findById(id);
        if (notificationOptional.isPresent()) {
            Notification notification = notificationOptional.get();
            notification.setVue(true);
            notificationRepository.save(notification);
        }
        else {
            throw new ResourceNotFoundException("Notification non trouvé avec ID : " + id);
        }
    }

}
