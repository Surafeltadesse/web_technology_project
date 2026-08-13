package com.hilcoe.web_technology_project.service;

import com.hilcoe.web_technology_project.dto.request.VenueRequest;
import com.hilcoe.web_technology_project.dto.response.VenueResponse;
import com.hilcoe.web_technology_project.entity.Venue;
import com.hilcoe.web_technology_project.exception.ResourceNotFoundException;
import com.hilcoe.web_technology_project.repository.VenueRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VenueService {
    private final VenueRepository venueRepository;

    public VenueResponse create(VenueRequest request) {
        Venue venue = Venue.builder()
                .name(request.getName()).address(request.getAddress())
                .city(request.getCity()).country(request.getCountry())
                .capacity(request.getCapacity())
                .contactPhone(request.getContactPhone())
                .contactEmail(request.getContactEmail())
                .build();
        return toResponse(venueRepository.save(venue));
    }

    public List<VenueResponse> getAll() {
        return venueRepository.findAll().stream().map(this::toResponse).toList();
    }

    public VenueResponse getById(Long id) {
        return toResponse(findById(id));
    }

    public VenueResponse update(Long id, VenueRequest request) {
        Venue venue = findById(id);
        venue.setName(request.getName()); venue.setAddress(request.getAddress());
        venue.setCity(request.getCity()); venue.setCountry(request.getCountry());
        venue.setCapacity(request.getCapacity());
        venue.setContactPhone(request.getContactPhone());
        venue.setContactEmail(request.getContactEmail());
        return toResponse(venueRepository.save(venue));
    }

    public void delete(Long id) {
        venueRepository.delete(findById(id));
    }

    public Venue findById(Long id) {
        return venueRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Venue not found: " + id));
    }

    public VenueResponse toResponse(Venue v) {
        return VenueResponse.builder()
                .id(v.getId()).name(v.getName()).address(v.getAddress())
                .city(v.getCity()).country(v.getCountry()).capacity(v.getCapacity())
                .contactPhone(v.getContactPhone()).contactEmail(v.getContactEmail())
                .build();
    }
}

