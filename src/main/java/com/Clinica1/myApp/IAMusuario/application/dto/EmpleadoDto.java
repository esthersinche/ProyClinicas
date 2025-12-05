package com.Clinica1.myApp.IAMusuario.application.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmpleadoDto {
    private String id_emp;
    private String nom_emp;
    private String ape_emp;
    private String tel_emp;
    private EmailDto email_emp;
    private String passhash_emp;
    private String rol_emp;
}
