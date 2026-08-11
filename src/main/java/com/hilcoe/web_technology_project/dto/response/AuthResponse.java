package com.hilcoe.web_technology_project.dto.response;

import com.hilcoe.web_technology_project.entity.Role;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AuthResponse {
    private String token;
    private String type;
    private Long userId;
    private String name;
    private String email;
    private Role role;
}
