package com.hilcoe.web_technology_project.repository;


import com.hilcoe.web_technology_project.entity.Agenda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AgendaRepository extends JpaRepository<Agenda, Long> {
    List<Agenda> findByEventIdOrderByStartTimeAsc(Long eventId);
    void deleteByEventId(Long eventId);
}
