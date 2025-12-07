package com.Clinica1.myApp.IAMusuario.interfaces.rest.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LogoutRequest {
    @NotBlank
    private String id_ses;
    //mapear a command en appli LogoutCommand
    //responde con 204/401
}
