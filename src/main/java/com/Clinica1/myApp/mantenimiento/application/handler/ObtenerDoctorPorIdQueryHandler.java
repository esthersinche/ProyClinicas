package com.Clinica1.myApp.mantenimiento.application.handler;

import com.Clinica1.myApp.SharedKernel.IDEntidad;
import com.Clinica1.myApp.mantenimiento.application.assembler.DoctorAssembler;
import com.Clinica1.myApp.mantenimiento.application.dto.DoctorDto;
import com.Clinica1.myApp.mantenimiento.application.query.ObtenerDoctorPorIdQuery;
import com.Clinica1.myApp.mantenimiento.domain.repository.DoctorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ObtenerDoctorPorIdQueryHandler {

    private final DoctorRepository doctorRepository;
    private final DoctorAssembler assembler;

    public DoctorDto handle(ObtenerDoctorPorIdQuery query) {
        return doctorRepository.findById(IDEntidad.astring(query.getIdDoctor()))
                .map(assembler::toDto)
                .orElse(null);
    }
}