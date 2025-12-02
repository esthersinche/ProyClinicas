package com.Clinica1.myApp.IAMusuario.interfaces.rest.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TokenResponse {
//para refreshtoken y validartoken
    private String tokenacceso;
    private String tipotoken;
    private long sgparaexpiracion;
    private String emp_id;
    private String nomcom_emp;
    //no quiero poner roles o success aun
    private String message;
    /*private String token; // luego cambiarlo por un JWT real
    private String username;
    private String rol;*/

}
