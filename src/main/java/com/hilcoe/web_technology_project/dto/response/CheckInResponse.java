package com.hilcoe.web_technology_project.dto.response;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class CheckInResponse {
    private Long id;
    private LocalDateTime checkedInAt;
    private String gateName;
    private Long scannedByStaffId;
    private Long invitationId;
    private String guestName;
    private String eventTitle;
    private boolean success;
    private String message;
}

