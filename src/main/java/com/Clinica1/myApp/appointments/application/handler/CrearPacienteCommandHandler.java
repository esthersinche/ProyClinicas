package com.Clinica1.myApp.appointments.application.handler;

import com.Clinica1.myApp.SharedKernel.IDEntidad;
import com.Clinica1.myApp.appointments.application.command.CrearPacienteCommand;
import com.Clinica1.myApp.appointments.domain.model.valueobjects.Email;
import com.Clinica1.myApp.appointments.domain.model.aggregates.Paciente;
import com.Clinica1.myApp.appointments.domain.repository.PacienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CrearPacienteCommandHandler {
    private final PacienteRepository pacienteRepository;
    @Transactional
    public IDEntidad handle(CrearPacienteCommand command) {

        // 1. Validaciones
        validar(command);

        // 2. Construir Value Objects del dominio
        IDEntidad id = (command.getId() != null)
                ? command.getId()
                : IDEntidad.generar();

        Email email = Email.of(command.getEmail());

        // 3. Construir el agregado Paciente
        Paciente paciente = new Paciente(
                id,
                command.getNombre(),
                command.getNacionalidad(),
                command.getDni(),
                command.getTel(),
                email,
                command.getFec_nac(),
                command.getSexo()
        );

        // 4. Persistir usando el repositorio
        pacienteRepository.insert(paciente);

        // 5. Retornar el ID del paciente creado
        return paciente.getId_pac();
    }

    private void validar(CrearPacienteCommand command) {
        if (command.getNombre() == null || command.getNombre().isBlank()) {
            throw new IllegalArgumentException("El nombre del paciente no puede estar vacío.");
        }
        if (command.getDni() == null || command.getDni().length() != 8) {
            throw new IllegalArgumentException("El DNI debe tener 8 dígitos.");
        }
        if (command.getEmail() == null) {
            throw new IllegalArgumentException("El email no puede ser nulo.");
        }
        if (command.getFec_nac() == null) {
            throw new IllegalArgumentException("La fecha de nacimiento no puede ser nula.");
        }
        if (command.getSexo() == null || command.getSexo().isBlank()) {
            throw new IllegalArgumentException("El sexo no puede estar vacío.");
        }
    }
}