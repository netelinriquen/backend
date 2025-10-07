package com.inkflow.dto;

import com.inkflow.model.Usuario;

public class LoginResponse {
    
    private boolean success;
    private Usuario user;
    private String token;
    private String message;
    
    // Constructors
    public LoginResponse() {}
    
    public LoginResponse(boolean success, Usuario user, String token, String message) {
        this.success = success;
        this.user = user;
        this.token = token;
        this.message = message;
    }
    
    // Getters and Setters
    public boolean isSuccess() { return success; }
    public void setSuccess(boolean success) { this.success = success; }
    
    public Usuario getUser() { return user; }
    public void setUser(Usuario user) { this.user = user; }
    
    public String getToken() { return token; }
    public void setToken(String token) { this.token = token; }
    
    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }
}