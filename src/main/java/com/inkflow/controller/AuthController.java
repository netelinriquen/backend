package com.inkflow.controller;

import com.inkflow.dto.LoginRequest;
import com.inkflow.dto.LoginResponse;
import com.inkflow.dto.RegisterRequest;
import com.inkflow.model.Usuario;
import com.inkflow.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = {"https://inkflow.vercel.app", "http://localhost:5173", "http://localhost:3000"})
public class AuthController {
    
    @Autowired
    private AuthService authService;
    
    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@Valid @RequestBody LoginRequest request) {
        try {
            LoginResponse response = authService.login(request.getEmail(), request.getSenha());
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.badRequest()
                .body(new LoginResponse(false, null, null, e.getMessage()));
        }
    }
    
    @PostMapping("/register")
    public ResponseEntity<?> register(@Valid @RequestBody RegisterRequest request) {
        try {
            Usuario usuario = authService.register(request.getNome(), request.getEmail(), request.getSenha());
            return ResponseEntity.ok().body(new RegisterResponse(true, "Usuário criado com sucesso!"));
        } catch (Exception e) {
            return ResponseEntity.badRequest()
                .body(new RegisterResponse(false, e.getMessage()));
        }
    }
    
    // Inner class for response
    public static class RegisterResponse {
        private boolean success;
        private String message;
        
        public RegisterResponse(boolean success, String message) {
            this.success = success;
            this.message = message;
        }
        
        public boolean isSuccess() { return success; }
        public String getMessage() { return message; }
    }
}