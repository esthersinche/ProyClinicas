package com.Clinica1.myApp.mantenimiento.application.assembler;

import com.Clinica1.myApp.mantenimiento.application.dto.EmpleadoDto;
import com.Clinica1.myApp.mantenimiento.domain.model.aggregates.Empleado;
import org.springframework.stereotype.Component;

@Component
public class EmpleadoAssembler {

    public EmpleadoDto toDto(Empleado empleado) {
        if (empleado == null) return null;

        return new EmpleadoDto(
                empleado.getId_emp().obtenerid(),
                empleado.getNombre(),
                empleado.getApellido(),
                empleado.getTelefono(),
                empleado.getEmail().email_valor(),
                empleado.getRolemp().name()
        );
    }
}