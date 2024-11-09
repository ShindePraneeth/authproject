package com.indium.AuthService.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class AuthenticationResponse {
    Boolean isAuthenticated;
    String message;

    public AuthenticationResponse(boolean isAuthenticated, String errorMessage) {
        this.isAuthenticated = isAuthenticated;
        this.message = errorMessage;
    }
}
