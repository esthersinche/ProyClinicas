package com.Clinica1.myApp.mantenimiento.application.handler;

import com.Clinica1.myApp.mantenimiento.application.command.ActualizarCredencialesEmpleadoCommand;
import com.Clinica1.myApp.mantenimiento.domain.model.aggregates.Empleado;
import com.Clinica1.myApp.mantenimiento.application.exception.DomainException;
import com.Clinica1.myApp.mantenimiento.domain.repository.EmpleadoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ActualizarCredencialesEmpleadoHandler {
    private EmpleadoRepository empleadoRepository;

    public Empleado handle(ActualizarCredencialesEmpleadoCommand command) {

        Empleado emp = empleadoRepository.findById(command.getIdEmpleado())
                .orElseThrow(() ->
                        new DomainException(
                                "Doctor no encontrado: " + command.getIdEmpleado().obtenerid()
                        )
                );

        emp.asignarCredenciales(command.getNuevaPassword());
        return empleadoRepository.update(emp);
    }
}
