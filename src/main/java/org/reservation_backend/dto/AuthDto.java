package org.reservation_backend.dto;


import jakarta.validation.constraints.NotBlank;

public class AuthDto {
    @NotBlank(message = "L'identifiant est obligatoire")
    private String username;
    @NotBlank(message = "Le mot de passe est obligatoire")
    private String password;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

