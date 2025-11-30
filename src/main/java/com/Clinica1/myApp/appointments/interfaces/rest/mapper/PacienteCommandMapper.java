package com.Clinica1.myApp.appointments.interfaces.rest.mapper;

import com.Clinica1.myApp.appointments.application.command.CrearPacienteCommand;
import com.Clinica1.myApp.appointments.domain.model.aggregates.Paciente;

public interface PacienteCommandMapper {
    Paciente toDomain(CrearPacienteCommand command);
}