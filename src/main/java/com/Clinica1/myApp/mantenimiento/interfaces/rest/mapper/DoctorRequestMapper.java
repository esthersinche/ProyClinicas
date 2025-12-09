package com.Clinica1.myApp.mantenimiento.interfaces.rest.mapper;

import com.Clinica1.myApp.mantenimiento.application.command.ActualizarDoctorCommand;
import com.Clinica1.myApp.mantenimiento.application.command.CrearDoctorCommand;
import com.Clinica1.myApp.mantenimiento.interfaces.rest.dto.request.ActualizarDoctorRequest;
import com.Clinica1.myApp.mantenimiento.interfaces.rest.dto.request.CrearDoctorRequest;
import org.springframework.stereotype.Component;

@Component
public class DoctorRequestMapper {

    public CrearDoctorCommand toCommand(CrearDoctorRequest request) {
        return new CrearDoctorCommand(
                request.getIdEmpleado(),
                request.getCmp(),
                request.getConsultorio(),
                request.getEspecialidades()
        );
    }

    public ActualizarDoctorCommand toCommand(String id, ActualizarDoctorRequest request) {
        return ActualizarDoctorCommand.builder()
                .idDoctor(id)
                .cmp(request.getCmp())
                .consultorio(request.getConsultorio())
                .especialidades(request.getEspecialidades())
                .build();
    }
}