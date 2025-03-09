package com.miashs.emploi_du_temps.service.notification;

import com.miashs.emploi_du_temps.model.Notification;
import com.miashs.emploi_du_temps.request.NotificationRequest;

import java.util.List;

public interface INotificationService {
    Notification addNotification(NotificationRequest notificationRequest);
    List<Notification> getNotificationEnseignant (Long id);
    List<Notification> getAllNotification();
    void updateNotification(Long id);
}
