package com.example.EcomBackend.controller;

import com.example.EcomBackend.dto.SigninRequest;
import com.example.EcomBackend.dto.SignupRequest;
import com.example.EcomBackend.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RequestMapping("/api/auth")
@RestController
@CrossOrigin(origins = "*")
public class AuthController {
    @Autowired
    public AuthService authService;

    @PostMapping("/signup")
   public ResponseEntity<Map<String,Object>> signup(@RequestBody SignupRequest request){
        String result = authService.register(request);
        boolean success = !result.toLowerCase().contains("already");
        return  ResponseEntity.status(success ? 200 : 400).body(Map.of("success",success,"message",result));
    }



    @PostMapping("/signin")
    public ResponseEntity<Map<String,Object>> signin(@RequestBody SigninRequest request){
        var loginResult = authService.login(request);
        boolean success = loginResult != null;

        return  ResponseEntity
                .status(success ? 200 : 401)
                .body(Map.of("success",success,"message",success ? "Login Successful" : "Invalid email or password", "role",loginResult.get("role"),"email",loginResult.get("email") ));
    }



}
