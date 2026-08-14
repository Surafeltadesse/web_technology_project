package com.hilcoe.web_technology_project.repository;

import com.hilcoe.web_technology_project.entity.Guest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GuestRepository extends JpaRepository<Guest, Long> {
    Optional<Guest> findByEmail(String email);
    Boolean existsByEmail(String email);
    Optional<Guest> findByUserId(Long userId);
}