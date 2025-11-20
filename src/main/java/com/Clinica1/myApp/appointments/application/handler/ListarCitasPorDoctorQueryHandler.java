package com.Clinica1.myApp.appointments.application.handler;

import com.Clinica1.myApp.appointments.application.query.ListarCitasPorDoctorQuery;
import com.Clinica1.myApp.appointments.application.dto.CitaDto;
import com.Clinica1.myApp.appointments.application.assembler.CitaAssembler;
import com.Clinica1.myApp.appointments.domain.model.aggregates.Cita;
import com.Clinica1.myApp.appointments.domain.repository.CitaRepository;

import java.util.List;
import java.util.stream.Collectors;

public class ListarCitasPorDoctorQueryHandler {
    
    private final CitaRepository citaRepository;
    private final CitaAssembler citaAssembler;

    public ListarCitasPorDoctorQueryHandler(CitaRepository citaRepository, CitaAssembler citaAssembler) {
        this.citaRepository = citaRepository;
        this.citaAssembler = citaAssembler;
    }

    public List<CitaDto> handle(ListarCitasPorDoctorQuery query) {
        List<Cita> citas = citaRepository.findbyDoctor(query.getDoctorId().toString());
        
        return citas.stream()
            .map(citaAssembler::toDto)
            .collect(Collectors.toList());
    }
}
