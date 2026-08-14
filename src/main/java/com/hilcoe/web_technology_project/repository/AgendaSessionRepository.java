package com.hilcoe.web_technology_project.repository;

import com.hilcoe.web_technology_project.entity.AgendaSession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AgendaSessionRepository extends JpaRepository<AgendaSession, Long> {
    List<AgendaSession> findByEventIdOrderByStartTimeAsc(Long eventId);
    void  deleteByEventId(Long eventId);
}