package com.Clinica1.myApp.mantenimiento.application.handler;

import com.Clinica1.myApp.mantenimiento.application.assembler.DoctorAssembler;
import com.Clinica1.myApp.mantenimiento.application.dto.DoctorDto;
import com.Clinica1.myApp.mantenimiento.application.query.BuscarDoctorPorNombreQuery;
import com.Clinica1.myApp.mantenimiento.domain.repository.DoctorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class BuscarDoctorPorNombreQueryHandler {

    private final DoctorRepository doctorRepository;
    private final DoctorAssembler doctorAssembler;

    public List<DoctorDto> handle(BuscarDoctorPorNombreQuery query) {
        return doctorRepository.findByNombre(query.getTexto())
                .stream()
                .map(doctorAssembler::toDto)
                .toList();
    }
}