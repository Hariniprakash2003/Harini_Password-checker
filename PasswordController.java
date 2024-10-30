package com.example.passwordchecker;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/password")
public class PasswordController {
    private final PasswordService passwordService;

    public PasswordController() {
        this.passwordService = new PasswordService();
    }

    @PostMapping("/validate")
    public ResponseEntity<String> validatePassword(@RequestBody String password) {
        try {
            if (passwordService.isPasswordStrong(password)) {
                return ResponseEntity.ok("Password is strong!");
            }
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Password is weak: " + e.getMessage());
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Password validation failed.");
    }
}
