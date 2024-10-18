package com.miashs.emploi_du_temps.repository;

import com.miashs.emploi_du_temps.modele.Enseignant;
import com.miashs.emploi_du_temps.modele.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
    List<Notification> findByEnseignant(Enseignant enseignant);
    List<Notification> findByDate(Date dateEnvoie);
}
