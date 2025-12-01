package com.Clinica1.myApp.appointments.interfaces.rest.dto.request;
import lombok.Data;

import java.util.Date;

@Data
public class CrearPacienteRequest {
    private String nombre;
    private String nacionalidad;
    private String dni;
    private String tel;
    private String email;
    private Date fec_nac;
    private String sexo;
}