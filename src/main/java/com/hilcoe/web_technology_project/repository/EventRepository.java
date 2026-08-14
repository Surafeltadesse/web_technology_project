package com.hilcoe.web_technology_project.repository;

import com.hilcoe.web_technology_project.entity.Event;
import com.hilcoe.web_technology_project.entity.EventStatus;
import com.hilcoe.web_technology_project.entity.EventType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
    List<Event> findByOrganizerId(Long organizerId);
    List<Event> findByStatus(EventStatus status);
    List<Event> findByEventType(EventType eventType);
    List<Event> findByOrganizerIdAndStatus(Long organizerId, EventStatus status);

    @Query("SELECT COUNT(i) FROM Invitation i WHERE i.event.id = :eventId AND i.status = 'CONFIRMED'")
    Long countConfirmedGuests(@Param("eventId") Long eventId);
}
