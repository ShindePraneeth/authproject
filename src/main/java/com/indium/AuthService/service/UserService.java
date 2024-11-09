package com.indium.AuthService.service;

import com.indium.AuthService.dto.AuthenticationResponse;
import com.indium.AuthService.dto.RegisterUserDto;
import com.indium.AuthService.dto.UserDto;
import com.indium.AuthService.entity.User;
import com.indium.AuthService.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User register(RegisterUserDto user) {
        User userData = User.builder().name(user.getName()).password(user.getPassword()).email(user.getEmail()).isAdmin(false).balance(new BigDecimal(100)).build();
        userData = userRepository.save(userData);
        return userData;
    }

    public AuthenticationResponse authenticate(UserDto user) {
        Optional<User> userData = userRepository.findByEmailAndPassword(user.getEmail(), user.getPassword());
        if (userData.isPresent()) {
            return AuthenticationResponse.builder().isAuthenticated(true).message("Authentication success").build();
        }
        return AuthenticationResponse.builder().isAuthenticated(false).message("Authentication failed").build();
    }
}
