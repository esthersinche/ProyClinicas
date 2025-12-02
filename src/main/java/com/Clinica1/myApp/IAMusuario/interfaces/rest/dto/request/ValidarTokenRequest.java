package com.Clinica1.myApp.IAMusuario.interfaces.rest.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
//opcional por si algo pide en el frontend validacion de token
public class ValidarTokenRequest {
    @NotBlank(message = "token is a must")
    private String token;
}
