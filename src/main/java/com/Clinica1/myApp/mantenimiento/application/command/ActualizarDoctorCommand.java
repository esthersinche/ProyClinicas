package com.Clinica1.myApp.mantenimiento.application.command;

import com.Clinica1.myApp.SharedKernel.IDEntidad;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ActualizarDoctorCommand {
    private String idDoctor;
    private String cmp;
    private String consultorio;
    private List<String> especialidades;
}
