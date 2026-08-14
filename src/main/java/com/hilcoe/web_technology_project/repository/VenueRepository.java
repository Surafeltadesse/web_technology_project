package com.hilcoe.web_technology_project.repository;

import com.hilcoe.web_technology_project.entity.Venue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VenueRepository extends JpaRepository<Venue, Long> {
    List<Venue> findByCity(String city);
    List<Venue> findByCapacityGreaterThanEqual(Integer minCapacity);
}
