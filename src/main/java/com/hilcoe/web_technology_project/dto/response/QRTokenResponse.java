package com.hilcoe.web_technology_project.dto.response;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class QRTokenResponse {
    private Long id;
    private String token;
    private String qrImagePath;
    private LocalDateTime issuedAt;
    private LocalDateTime expiresAt;
    private Boolean isUsed;
    private Long invitationId;
}
