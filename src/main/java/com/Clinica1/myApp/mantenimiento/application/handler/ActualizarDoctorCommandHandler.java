package com.Clinica1.myApp.mantenimiento.application.handler;
import com.Clinica1.myApp.SharedKernel.IDEntidad;
import com.Clinica1.myApp.mantenimiento.application.command.ActualizarDoctorCommand;
import com.Clinica1.myApp.mantenimiento.domain.model.valueobjects.Especialidad;
import com.Clinica1.myApp.mantenimiento.domain.repository.DoctorRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ActualizarDoctorCommandHandler {

    private final DoctorRepository doctorRepository;

    public void handle(ActualizarDoctorCommand command) {

        IDEntidad idDoctor = IDEntidad.astring(command.getIdDoctor());

        var doctor = doctorRepository.findById(idDoctor)
                .orElseThrow(() -> new IllegalArgumentException("Doctor no encontrado"));

        doctor.actualizarDatosProfesionales(
                command.getCmp(),
                command.getConsultorio(),
                command.getEspecialidades()
                        .stream()
                        .map(Especialidad::of)
                        .toList()
        );

        doctorRepository.update(doctor);
    }
}