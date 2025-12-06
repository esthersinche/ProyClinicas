package com.Clinica1.myApp.mantenimiento.application.handler;

import com.Clinica1.myApp.SharedKernel.Email;
import com.Clinica1.myApp.SharedKernel.Empleado;
import com.Clinica1.myApp.SharedKernel.Roles;
import com.Clinica1.myApp.mantenimiento.application.command.CrearDoctorCommand;
import com.Clinica1.myApp.mantenimiento.application.exception.DomainException;
import com.Clinica1.myApp.mantenimiento.domain.model.aggregates.Doctor;
import com.Clinica1.myApp.mantenimiento.domain.model.valueobjects.Especialidad;
import com.Clinica1.myApp.mantenimiento.domain.repository.DoctorRepository;
import com.Clinica1.myApp.SharedKernel.ActuPass.EmpleadoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class CrearDoctorCommandHandler {

    private final DoctorRepository doctorRepository;
    private final EmpleadoRepository empleadoRepository;

    public String handle(CrearDoctorCommand command) {

        // ----- VALIDACIONES -----
        if (command.getNombre() == null || command.getNombre().isBlank())
            throw new DomainException("El nombre no puede estar vacío");

        if (command.getApellido() == null || command.getApellido().isBlank())
            throw new DomainException("El apellido no puede estar vacío");

        if (command.getEmail() == null)
            throw new DomainException("El email es obligatorio");

        if (command.getCmp() == null || command.getCmp().isBlank())
            throw new DomainException("El CMP es obligatorio");

        // CMP duplicado
        Doctor repetido = doctorRepository.findByCmp(command.getCmp());
        if (repetido != null)
            throw new DomainException("Ya existe un doctor con el CMP " + command.getCmp());

        // ----- CREAR EMAIL -----
        Email email;
        try {
            email = Email.of(command.getEmail());
        } catch (IllegalArgumentException e) {
            throw new DomainException("Email inválido: " + e.getMessage());
        }

        // ------------------------------------------------------------------
        // PASO 1: CREAR EMPLEADO
        // ------------------------------------------------------------------
        Empleado empleado = Empleado.crearemp(
                command.getNombre(),
                command.getApellido(),
                command.getTelefono(),
                email,
                command.getPassword(),   // luego harás hashing
                Roles.Rol_Doctor            // El doctor SIEMPRE es ROl DOCTOR
        );

        empleadoRepository.insert(empleado);

        // ------------------------------------------------------------------
        // PASO 2: CREAR DOCTOR usando el id_emp recién generado
        // ------------------------------------------------------------------

        Doctor doctor = Doctor.crear(
                empleado.getId_emp(),                 // ← idEmpleado
                command.getNombre(),
                command.getApellido(),
                command.getCmp(),
                command.getConsultorio(),
                command.getEspecialidades().stream()
                        .map(Especialidad::new)
                        .collect(Collectors.toList())
        );

        doctorRepository.insert(doctor);

        return doctor.getIdDoctor().obtenerid();  // retorna el UUID del doctor
    }
}