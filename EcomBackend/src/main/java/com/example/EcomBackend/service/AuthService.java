package com.example.EcomBackend.service;

import com.example.EcomBackend.dto.SigninRequest;
import com.example.EcomBackend.dto.SignupRequest;
import com.example.EcomBackend.model.User;
import com.example.EcomBackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

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

    public String login(SigninRequest request){
        User user = userRepository.findByEmail(request.email).orElse(null);
        if(user == null || !passwordEncoder.matches(request.password, user.getPassword())){
            return "Invalid email or password";
        }
        return "Login Successfull .Role: "+user.getRole();

    }


}
