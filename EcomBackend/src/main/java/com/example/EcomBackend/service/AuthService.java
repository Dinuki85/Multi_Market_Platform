package com.example.EcomBackend.service;

import com.example.EcomBackend.dto.SigninRequest;
import com.example.EcomBackend.dto.SignupRequest;
import com.example.EcomBackend.model.User;
import com.example.EcomBackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class AuthService {
    @Autowired
    private UserRepository userRepository;

    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public String register(SignupRequest request){
        if(userRepository.existsByEmail(request.email)){
            return "Email Already Exists";
        }
        User user = new User();
        user.setName(request.name);
        user.setEmail(request.email);
        user.setPassword(passwordEncoder.encode(request.password));
        user.setRole(request.role);
        userRepository.save(user);
        return "User registered Successfully as "+ request.role;

    }

    public Map<String, String> login(SigninRequest request) {
        // Finding the user by email
        User user = userRepository.findByEmail(request.email).orElse(null);

        // If the user doesn't exist or password doesn't match
        if (user == null || !passwordEncoder.matches(request.password, user.getPassword())) {
            return null;  // Login failed
        }

        // Creating the Map to return
        Map<String, String> loginResult = new HashMap<>();
        loginResult.put("role", user.getRole().toString());
        loginResult.put("email", user.getEmail());

        // Returning the Map
        return loginResult;
    }

}
