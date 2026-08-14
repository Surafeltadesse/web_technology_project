package com.hilcoe.web_technology_project.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ScanRequest {
    @NotBlank(message = "QR token is required")
    private String token;

    private String gateName;
}
