package com.indium.AuthService.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDto {
    private String email;
    private String password;

}
