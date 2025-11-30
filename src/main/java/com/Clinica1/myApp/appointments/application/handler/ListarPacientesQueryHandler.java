package com.Clinica1.myApp.appointments.application.handler;


import com.Clinica1.myApp.appointments.application.dto.PacienteInfoDto;
import com.Clinica1.myApp.appointments.domain.model.aggregates.Paciente;
import com.Clinica1.myApp.appointments.domain.repository.PacienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ListarPacientesQueryHandler {

    private final PacienteRepository pacienteRepository;

    public List<PacienteInfoDto> handle() {

        List<Paciente> pacientes = pacienteRepository.findall();

        return pacientes.stream()
                .map(p -> new PacienteInfoDto(
                        p.getNombre_com_pac(),
                        p.getDni_pac()
                ))
                .collect(Collectors.toList());
    }
}