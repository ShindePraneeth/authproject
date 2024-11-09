package com.indium.AuthService.controller;

import com.indium.AuthService.dto.AuthenticationResponse;
import com.indium.AuthService.dto.RegisterUserDto;
import com.indium.AuthService.dto.UserDto;
import com.indium.AuthService.entity.User;
import com.indium.AuthService.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<User> register(@RequestBody RegisterUserDto user) {
        try {
            User response = userService.register(user);
            return ResponseEntity.ok(response);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody UserDto user) {
        AuthenticationResponse response = userService.authenticate(user);
        if (response.getIsAuthenticated())
            return ResponseEntity.ok(response);
        String errorMessage = "Authentication failed. Please check your email and password.";
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new AuthenticationResponse(false, errorMessage));
    }
}
