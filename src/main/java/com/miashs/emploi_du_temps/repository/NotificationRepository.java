package com.miashs.emploi_du_temps.repository;

import com.miashs.emploi_du_temps.model.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
    List<Notification> getNotificationByEnseignant_idOrderByDateEnvoieDesc(Long id);
    List<Notification> findAllByOrderByDateEnvoieDesc();

}
