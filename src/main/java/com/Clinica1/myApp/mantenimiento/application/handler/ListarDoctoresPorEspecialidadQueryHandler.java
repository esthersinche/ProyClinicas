package com.Clinica1.myApp.mantenimiento.application.handler;

import com.Clinica1.myApp.mantenimiento.application.assembler.DoctorAssembler;
import com.Clinica1.myApp.mantenimiento.application.dto.DoctorDto;
import com.Clinica1.myApp.mantenimiento.application.query.ListarDoctorPorEspecialidadQuery;
import com.Clinica1.myApp.mantenimiento.domain.repository.DoctorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ListarDoctoresPorEspecialidadQueryHandler {

    private final DoctorRepository doctorRepository;
    private final DoctorAssembler assembler = new DoctorAssembler();

    public List<DoctorDto> handle(ListarDoctorPorEspecialidadQuery query) {

        return doctorRepository.findByEspecialidad(query.getEspecialidad())
                .stream()
                .map(assembler::toDto)
                .toList();
    }
}