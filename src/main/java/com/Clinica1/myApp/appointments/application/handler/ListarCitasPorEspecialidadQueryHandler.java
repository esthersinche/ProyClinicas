package com.Clinica1.myApp.appointments.application.handler;

import com.Clinica1.myApp.appointments.application.query.ListarCitasPorEspecialidadQuery;
import com.Clinica1.myApp.appointments.application.dto.CitaDto;
import com.Clinica1.myApp.appointments.application.assembler.CitaAssembler;
import com.Clinica1.myApp.appointments.domain.model.aggregates.Cita;
import com.Clinica1.myApp.appointments.domain.repository.CitaRepository;

import java.util.List;
import java.util.stream.Collectors;

public class ListarCitasPorEspecialidadQueryHandler {
    
    private final CitaRepository citaRepository;
    private final CitaAssembler citaAssembler;

    public ListarCitasPorEspecialidadQueryHandler(CitaRepository citaRepository, CitaAssembler citaAssembler) {
        this.citaRepository = citaRepository;
        this.citaAssembler = citaAssembler;
    }

    public List<CitaDto> handle(ListarCitasPorEspecialidadQuery query) {
        List<Cita> todasLasCitas = citaRepository.findall();
        
        return todasLasCitas.stream()
            .filter(cita -> cita.getEspe_cita() != null && 
                           cita.getEspe_cita().nom_espe().equals(query.getEspecialidad()))
            .map(citaAssembler::toDto)
            .collect(Collectors.toList());
    }
}
