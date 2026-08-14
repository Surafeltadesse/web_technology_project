package com.hilcoe.web_technology_project.dto.request;

import com.hilcoe.web_technology_project.entity.InvitationStatus;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class RsvpRequest {
    @NotNull(message = "Status is required")
    private InvitationStatus status;
}
