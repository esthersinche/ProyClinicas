package com.Clinica1.myApp.mantenimiento.application.handler;

import com.Clinica1.myApp.IAMusuario.application.services.ContraService;
import com.Clinica1.myApp.mantenimiento.application.command.AuthValidateCommand;
import com.Clinica1.myApp.mantenimiento.application.dto.EmpleadoMinimalDto;
import com.Clinica1.myApp.mantenimiento.domain.model.aggregates.Empleado;
import com.Clinica1.myApp.mantenimiento.domain.repository.EmpleadoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AuthValidateCommandHandler {
    private final EmpleadoRepository empleadoRepository;
    private final ContraService contraService;

    public EmpleadoMinimalDto handle(AuthValidateCommand command) {

        Empleado emp = empleadoRepository
                .findByEmail(command.getEmail());

        if (emp == null)
            return null;

        if (!contraService.matches(command.getPassword(), emp.getPasshash_emp()))
            return null;

        return new EmpleadoMinimalDto(
                emp.getId_emp().obtenerid(),
                emp.getNombre(),
                emp.getApellido(),
                emp.getRolemp().name()
        );
    }
}