package com.Clinica1.myApp.mantenimiento.interfaces.rest.mapper;

import com.Clinica1.myApp.mantenimiento.application.dto.EmpleadoDto;
import com.Clinica1.myApp.mantenimiento.domain.model.aggregates.Empleado;
import com.Clinica1.myApp.mantenimiento.interfaces.rest.dto.response.EmpleadoResponse;
import org.springframework.stereotype.Component;

@Component
public class EmpleadoRestMapper {
    public EmpleadoResponse toResponse(EmpleadoDto dto) {
        return new EmpleadoResponse(
                dto.getId(),
                dto.getNombre() + " " + dto.getApellido(),
                dto.getTelefono(),
                dto.getEmail(),
                dto.getRol()
        );
    }
}
