package com.hilcoe.web_technology_project.service;

import com.hilcoe.web_technology_project.dto.request.LoginRequest;
import com.hilcoe.web_technology_project.dto.request.RegisterRequest;
import com.hilcoe.web_technology_project.dto.response.AuthResponse;
import com.hilcoe.web_technology_project.entity.Role;
import com.hilcoe.web_technology_project.entity.User;
import com.hilcoe.web_technology_project.exception.DuplicateResourceException;
import com.hilcoe.web_technology_project.repository.UserRepository;
import com.hilcoe.web_technology_project.security.jwt.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;
    private final AuthenticationManager authenticationManager;

    public AuthResponse register(RegisterRequest request) {
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new DuplicateResourceException("Email already registered: " + request.getEmail());
        }
        Role role = request.getRole() != null ? request.getRole() : Role.GUEST;
        User user = User.builder()
                .name(request.getName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(role)
                .phone(request.getPhone())
                .build();
        userRepository.save(user);
        String token = jwtUtil.generateToken(user, user.getRole().name());
        return buildAuthResponse(user, token);
    }

    public AuthResponse login(LoginRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
        User user = userRepository.findByEmail(request.getEmail()).orElseThrow();
        String token = jwtUtil.generateToken(user, user.getRole().name());
        return buildAuthResponse(user, token);
    }

    private AuthResponse buildAuthResponse(User user, String token) {
        return AuthResponse.builder()
                .token(token).type("Bearer")
                .userId(user.getId()).name(user.getName())
                .email(user.getEmail()).role(user.getRole())
                .build();
    }
}
