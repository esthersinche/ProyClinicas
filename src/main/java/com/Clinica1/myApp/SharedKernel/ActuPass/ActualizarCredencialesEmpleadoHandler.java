package com.Clinica1.myApp.SharedKernel.ActuPass;

public class ActualizarCredencialesEmpleadoHandler {
    private final EmpleadoRepository empleadoRepository;

    public Empleado handle(ActualizarCredencialesEmpleadoCommand command) {

        Empleado emp = empleadoRepository.findById(command.getIdEmpleado());

        if (emp == null)
            throw new DomainException("Empleado no encontrado");

        emp.asignarCredenciales(command.getNuevaPassword());

        return empleadoRepository.update(emp);
    }
}
