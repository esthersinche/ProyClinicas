package com.Clinica1.myApp.appointments.application.handler;

import com.Clinica1.myApp.appointments.application.command.CrearCitaCommand;
import com.Clinica1.myApp.appointments.application.dto.CitaDto;
import com.Clinica1.myApp.appointments.application.exception.FechaInvalidaException;

public class CrearCitaCommandHandler {
    
    // TODO: Inyectar dependencias necesarias (repositories, domain service, etc.)
    // private final ICitaRepository citaRepository;
    // private final IDoctorRepository doctorRepository;
    // private final IPacienteRepository pacienteRepository;
    // private final CitaDomainService citaDomainService;
    // private final CitaAssembler citaAssembler;

    public CrearCitaCommandHandler() {
    }

    public CitaDto handle(CrearCitaCommand command) throws FechaInvalidaException {
        // TODO: Implementar
        throw new UnsupportedOperationException("Pendiente de implementación");
    }
}
