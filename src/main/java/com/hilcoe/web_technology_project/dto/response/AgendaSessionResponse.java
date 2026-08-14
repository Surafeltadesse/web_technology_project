package com.hilcoe.web_technology_project.dto.response;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class AgendaSessionResponse {
    private Long id;
    private String sessionTitle;
    private String speaker;
    private String location;
    private String description;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private Long eventId;
}