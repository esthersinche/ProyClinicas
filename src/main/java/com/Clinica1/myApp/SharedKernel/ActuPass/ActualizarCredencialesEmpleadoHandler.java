package com.Clinica1.myApp.SharedKernel.ActuPass;

import com.Clinica1.myApp.SharedKernel.Empleado;
import com.Clinica1.myApp.mantenimiento.application.exception.DomainException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ActualizarCredencialesEmpleadoHandler {
    private EmpleadoRepository empleadoRepository;

    public Empleado handle(ActualizarCredencialesEmpleadoCommand command) {

        Empleado emp = empleadoRepository.findById(command.getIdEmpleado());

        if (emp == null)
            throw new DomainException("Empleado no encontrado");

        emp.asignarCredenciales(command.getNuevaPassword());
        return empleadoRepository.update(emp);
    }
}
