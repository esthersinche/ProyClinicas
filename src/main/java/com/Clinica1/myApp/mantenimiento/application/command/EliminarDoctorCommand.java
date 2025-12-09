package com.Clinica1.myApp.mantenimiento.application.command;

import com.Clinica1.myApp.SharedKernel.IDEntidad;
import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class EliminarDoctorCommand {
    private String idDoctor;
}
