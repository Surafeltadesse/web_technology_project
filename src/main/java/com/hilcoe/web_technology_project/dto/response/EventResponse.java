package com.hilcoe.web_technology_project.dto.response;

import com.hilcoe.web_technology_project.entity.EventStatus;
import com.hilcoe.web_technology_project.entity.EventType;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class EventResponse {
    private Long id;
    private String title;
    private String description;
    private EventType eventType;
    private EventStatus status;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private LocalDateTime createdAt;
    private UserResponse organizer;
    private VenueResponse venue;
    private long confirmedGuestCount;
}
