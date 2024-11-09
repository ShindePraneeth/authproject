package com.indium.AuthService.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class RegisterUserDto {
    private String email;
    private String password;
    private String name;
}
