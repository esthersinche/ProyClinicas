package com.Clinica1.myApp.appointments.application.handler;

import com.Clinica1.myApp.appointments.application.assembler.PacienteAssembler;
import com.Clinica1.myApp.appointments.application.dto.PacienteDto;
import com.Clinica1.myApp.appointments.application.query.ObtenerPacientePorDniQuery;
import com.Clinica1.myApp.appointments.domain.model.aggregates.Paciente;
import com.Clinica1.myApp.appointments.domain.repository.PacienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ObtenerPacientePorDniQueryHandler {

    private final PacienteRepository pacienteRepository;
    private final PacienteAssembler assembler;

    public PacienteDto handle(ObtenerPacientePorDniQuery query) {

        Paciente paciente = pacienteRepository.findbyDNI(query.getDni());

        if (paciente == null) return null;

        return assembler.toDto(paciente);
    }
}