package com.Clinica1.myApp.IAMusuario.application.dto;

public class TokenDto {
    private final String accesstoken;
    private final String refreshtoken;
    private final long expiracion;

    public TokenDto(String accesstoken, String refreshtoken, long expiracion) {
        this.accesstoken = accesstoken;
        this.refreshtoken = refreshtoken;
        this.expiracion = expiracion;
    }

    public String getAccesstoken() {
        return accesstoken;
    }

    public String getRefreshtoken() {
        return refreshtoken;
    }

    public long getExpiracion() {
        return expiracion;
    }
}
