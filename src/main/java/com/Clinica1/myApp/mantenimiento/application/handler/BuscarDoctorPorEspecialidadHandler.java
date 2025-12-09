package com.Clinica1.myApp.mantenimiento.application.handler;

import com.Clinica1.myApp.mantenimiento.application.assembler.DoctorAssembler;
import com.Clinica1.myApp.mantenimiento.application.dto.DoctorDto;
import com.Clinica1.myApp.mantenimiento.application.query.BuscarDoctorPorEspecialidadQuery;
import com.Clinica1.myApp.mantenimiento.domain.repository.DoctorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class BuscarDoctorPorEspecialidadHandler {

    private final DoctorRepository doctorRepository;
    private final DoctorAssembler assembler;

    public List<DoctorDto> handle(BuscarDoctorPorEspecialidadQuery query) {
        return doctorRepository.findByEspecialidad(query.especialidad())
                .stream()
                .map(assembler::toDto)
                .toList();
    }
}