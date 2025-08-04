package com.example.EcomBackend.controller;

import com.example.EcomBackend.dto.SigninRequest;
import com.example.EcomBackend.dto.SignupRequest;
import com.example.EcomBackend.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/auth")
@RestController
@CrossOrigin(origins = "*")
public class AuthController {
    @Autowired
    public AuthService authService;

    @PostMapping("/signup")
   public String signup(@RequestBody SignupRequest request){
       return authService.register(request);
   }
    @PostMapping("/signin")
    public String signup(@RequestBody SigninRequest request){
        return authService.login(request);
    }



}
