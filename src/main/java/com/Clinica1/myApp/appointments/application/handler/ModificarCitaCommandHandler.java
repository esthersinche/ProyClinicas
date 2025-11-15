package com.Clinica1.myApp.appointments.application.handler;

import com.Clinica1.myApp.appointments.application.command.ModificarCitaCommand;
import com.Clinica1.myApp.appointments.application.dto.CitaDto;
import com.Clinica1.myApp.appointments.application.exception.FechaInvalidaException;

public class ModificarCitaCommandHandler {
    
    // TODO: Inyectar dependencias necesarias
    // private final ICitaRepository citaRepository;
    // private final IDoctorRepository doctorRepository;
    // private final CitaDomainService citaDomainService;
    // private final CitaAssembler citaAssembler;

    public ModificarCitaCommandHandler() {
    }

    public CitaDto handle(ModificarCitaCommand command) throws FechaInvalidaException {
        // TODO: Implementar
        throw new UnsupportedOperationException("Pendiente de implementación");
    }
}
