package com.Clinica1.myApp.IAMusuario.interfaces.rest.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TokenResponse {
//para refreshtoken y validartoken
    private String tokenacceso;
    private String emp_id;
    private long sgparaexpiracion;
    private List<String> funciones;
    //no quiero poner roles o success aun
    private String message;
    /*private String token; // luego cambiarlo por un JWT real
    private String username;
    private String rol;*/

}
