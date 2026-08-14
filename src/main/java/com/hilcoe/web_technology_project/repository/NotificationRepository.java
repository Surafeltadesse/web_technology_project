package com.hilcoe.web_technology_project.repository;

import com.hilcoe.web_technology_project.entity.Notification;
import com.hilcoe.web_technology_project.entity.NotificationType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long> {
    List<Notification> findByEventId(Long eventId);
    List<Notification> findByGuestId(Long guestId);
    List<Notification> findByRecipientEmail(String email);
    List<Notification> findByType(NotificationType type);
}
