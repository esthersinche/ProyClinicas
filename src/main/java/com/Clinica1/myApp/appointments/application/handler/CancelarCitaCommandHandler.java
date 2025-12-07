package com.Clinica1.myApp.appointments.application.handler;

import com.Clinica1.myApp.appointments.application.command.CancelarCitaCommand;
import com.Clinica1.myApp.appointments.application.exception.CitaNoEncontradaException;
import com.Clinica1.myApp.appointments.domain.model.aggregates.Cita;
import com.Clinica1.myApp.appointments.domain.repository.CitaRepository;


public class CancelarCitaCommandHandler {

    private final CitaRepository citaRepository;

    public CancelarCitaCommandHandler(CitaRepository citaRepository) {
        this.citaRepository = citaRepository;
    }

    public void handle(CancelarCitaCommand command)
            throws CitaNoEncontradaException {
        Cita cita = citaRepository.findById(command.getCitaId())
                .orElseThrow(() ->
                        new CitaNoEncontradaException(
                                "Cita no encontrada: " + command.getCitaId()
                        )
                );

        cita.cancelar();

        citaRepository.update(cita);
    }
}