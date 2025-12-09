package com.Clinica1.myApp.mantenimiento.application.handler;

import com.Clinica1.myApp.mantenimiento.application.assembler.EmpleadoAssembler;
import com.Clinica1.myApp.mantenimiento.application.dto.EmpleadoDto;
import com.Clinica1.myApp.mantenimiento.domain.repository.EmpleadoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ListarEmpleadosQueryHandler {
    private final EmpleadoRepository empleadoRepository;
    private final EmpleadoAssembler empleadoAssembler;

    public List<EmpleadoDto> handle() {
        return empleadoRepository.findall()
                .stream()
                .map(empleadoAssembler::toDto)
                .toList();
    }
}
