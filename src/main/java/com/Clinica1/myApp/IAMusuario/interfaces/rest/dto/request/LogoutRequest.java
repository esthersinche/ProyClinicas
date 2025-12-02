package com.Clinica1.myApp.IAMusuario.interfaces.rest.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LogoutRequest {
    private String id_ses;
    //mapear a command en appli LogoutCommand
    //responde con 204/401
}
