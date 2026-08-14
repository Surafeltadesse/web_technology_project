package com.hilcoe.web_technology_project.dto.response;

import com.hilcoe.web_technology_project.entity.NotificationType;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class NotificationResponse {
    private Long id;
    private String recipientEmail;
    private NotificationType type;
    private String subject;
    private String body;
    private String status;
    private LocalDateTime sentAt;
    private LocalDateTime createdAt;
}