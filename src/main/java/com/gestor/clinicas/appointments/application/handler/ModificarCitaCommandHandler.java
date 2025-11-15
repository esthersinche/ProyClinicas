package com.gestor.clinicas.appointments.application.handler;

import com.gestor.clinicas.appointments.application.command.ModificarCitaCommand;
import com.gestor.clinicas.appointments.application.dto.CitaDto;
import com.gestor.clinicas.appointments.application.exception.FechaInvalidaException;

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
