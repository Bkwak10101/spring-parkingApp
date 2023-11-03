package com.github.bkwak.springparkingapp.controller;

import com.github.bkwak.springparkingapp.model.User;
import com.github.bkwak.springparkingapp.service.AuthService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api")
public class AuthController {
    @Autowired
    private AuthService authService;

    @CrossOrigin
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User user) {
        boolean isAuthenticated = authService.authenticate(user.getEmail(), user.getPassword());

        if (isAuthenticated) {
            // TODO: Return JSON Web Token
            log.info("Login successful");
            return ResponseEntity.ok("Login successful");
        } else {
            log.info("Login Error");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Login Error");
        }
    }
}