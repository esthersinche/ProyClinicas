package com.Clinica1.myApp.mantenimiento.application.handler;

import com.Clinica1.myApp.mantenimiento.application.assembler.DoctorAssembler;
import com.Clinica1.myApp.mantenimiento.application.dto.DoctorDto;
import com.Clinica1.myApp.mantenimiento.application.query.ListarDoctoresQuery;
import com.Clinica1.myApp.mantenimiento.domain.repository.DoctorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class ListarDoctoresQueryHandler {

    private final DoctorRepository doctorRepository;
    private final DoctorAssembler assembler;

    public List<DoctorDto> handle(ListarDoctoresQuery query) {
        return doctorRepository.findall().stream()
                .map(assembler::toDto)
                .toList();
    }
}
