package com.Clinica1.myApp.appointments.application.handler;

import com.Clinica1.myApp.SharedKernel.IDEntidad;
import com.Clinica1.myApp.appointments.application.command.CancelarCitaCommand;
import com.Clinica1.myApp.appointments.application.exception.CitaNoEncontradaException;
import com.Clinica1.myApp.appointments.domain.model.aggregates.Cita;
import com.Clinica1.myApp.appointments.domain.model.valueobjects.Estado;
import com.Clinica1.myApp.appointments.domain.repository.CitaRepository;

import java.util.UUID;

public class CancelarCitaCommandHandler {

    private final CitaRepository citaRepository;

    public CancelarCitaCommandHandler(CitaRepository citaRepository) {
        this.citaRepository = citaRepository;
    }

    public void handle(CancelarCitaCommand command)
            throws CitaNoEncontradaException {

        IDEntidad id = command.getCitaId();

        Cita cita = citaRepository.findById(id);
        if (cita == null)
            throw new CitaNoEncontradaException("Cita no encontrada: " + command.getCitaId());

        if (cita.getEstado_cita() == Estado.Desercion)
            throw new CitaNoEncontradaException("La cita ya está cancelada");

        citaRepository.delete(id);
    }
}