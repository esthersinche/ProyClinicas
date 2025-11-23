package com.Clinica1.myApp.IAMusuario.interfaces.rest.dto.response;

public class TokenResponse {

    private String token; // luego cambiarlo por un JWT real
    private String username;
    private String rol;

    public TokenResponse() {
    }

    public TokenResponse(String token, String username, String rol) {
        this.token = token;
        this.username = username;
        this.rol = rol;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
}
