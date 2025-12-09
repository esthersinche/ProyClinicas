package com.Clinica1.myApp.mantenimiento.interfaces.rest.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthValidateRequest {
    private String email;
    private String password;
}