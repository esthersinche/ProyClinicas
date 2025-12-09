package com.Clinica1.myApp.mantenimiento.application.handler;

import com.Clinica1.myApp.SharedKernel.IDEntidad;
import com.Clinica1.myApp.mantenimiento.application.command.EliminarDoctorCommand;
import com.Clinica1.myApp.mantenimiento.domain.repository.DoctorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EliminarDoctorCommandHandler {

    private final DoctorRepository doctorRepository;

    public void handle(EliminarDoctorCommand command) {
        doctorRepository.delete(IDEntidad.astring(command.getIdDoctor()));
    }
}