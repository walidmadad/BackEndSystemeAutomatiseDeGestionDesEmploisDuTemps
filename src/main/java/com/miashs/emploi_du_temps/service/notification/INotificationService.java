package com.miashs.emploi_du_temps.service.notification;

import com.miashs.emploi_du_temps.modele.Enseignant;
import com.miashs.emploi_du_temps.modele.Notification;
import com.miashs.emploi_du_temps.request.NotificationRequest;

import java.util.Date;
import java.util.List;

public interface INotificationService {
    Notification addNotification(NotificationRequest notificationRequest);
    Notification updateNotification(NotificationRequest notificationRequest, Long id);
    void deleteNotification(Long id);

    Notification getNotificationById(Long id);
    List<Notification> getAllNotifications();
    List<Notification> getNotificationsByEnseignant(Enseignant enseignant);
    List<Notification> getNotificationsByDate(Date dateEnvoie);
}
