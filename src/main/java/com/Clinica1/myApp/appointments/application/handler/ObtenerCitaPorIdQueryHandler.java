package com.Clinica1.myApp.appointments.application.handler;

import com.Clinica1.myApp.appointments.application.query.ObtenerCitaPorIdQuery;
import com.Clinica1.myApp.appointments.application.dto.CitaDto;
import com.Clinica1.myApp.appointments.application.assembler.CitaAssembler;
import com.Clinica1.myApp.appointments.application.exception.CitaNoEncontradaException;
import com.Clinica1.myApp.appointments.domain.model.aggregates.Cita;
import com.Clinica1.myApp.appointments.domain.repository.CitaRepository;

public class ObtenerCitaPorIdQueryHandler {
    
    private final CitaRepository citaRepository;
    private final CitaAssembler citaAssembler;

    public ObtenerCitaPorIdQueryHandler(CitaRepository citaRepository, CitaAssembler citaAssembler) {
        this.citaRepository = citaRepository;
        this.citaAssembler = citaAssembler;
    }

    public CitaDto handle(ObtenerCitaPorIdQuery query) throws CitaNoEncontradaException {
        Cita cita = citaRepository.findById(query.getCitaId());

        if (cita == null) {
            throw new CitaNoEncontradaException(query.getCitaId());
        }
        
        return citaAssembler.toDto(cita);
    }
}
