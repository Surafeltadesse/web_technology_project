package com.hilcoe.web_technology_project.controller;

import com.hilcoe.web_technology_project.dto.request.ScanRequest;
import com.hilcoe.web_technology_project.dto.response.ApiResponse;
import com.hilcoe.web_technology_project.dto.response.CheckInResponse;
import com.hilcoe.web_technology_project.dto.response.QRTokenResponse;
import com.hilcoe.web_technology_project.entity.User;
import com.hilcoe.web_technology_project.service.QRService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class QRController {
    private final QRService qrService;

    @PostMapping("/qr/generate/{invitationId}")
    @PreAuthorize("hasAnyRole('ADMIN','ORGANIZER')")
    public ResponseEntity<ApiResponse<QRTokenResponse>> generate(@PathVariable Long invitationId) {
        return ResponseEntity.ok(ApiResponse.success("QR code generated", qrService.generateQR(invitationId)));
    }

    @GetMapping("/qr/{invitationId}")
    @PreAuthorize("hasAnyRole('ADMIN','ORGANIZER','GUEST')")
    public ResponseEntity<ApiResponse<QRTokenResponse>> getByInvitation(@PathVariable Long invitationId) {
        return ResponseEntity.ok(ApiResponse.success(qrService.getByInvitation(invitationId)));
    }

    @PostMapping("/checkin/scan")
    @PreAuthorize("hasAnyRole('ADMIN','STAFF')")
    public ResponseEntity<ApiResponse<CheckInResponse>> scan(
            @Valid @RequestBody ScanRequest request,
            @AuthenticationPrincipal User currentUser) {
        return ResponseEntity.ok(ApiResponse.success(qrService.scan(request, currentUser.getId())));
    }
}
