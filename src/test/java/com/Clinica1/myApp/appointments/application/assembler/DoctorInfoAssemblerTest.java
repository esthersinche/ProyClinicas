package com.Clinica1.myApp.appointments.application.assembler;

import com.Clinica1.myApp.SharedKernel.IDEntidad;
import com.Clinica1.myApp.appointments.domain.model.aggregates.Doctor;
import com.Clinica1.myApp.appointments.domain.model.valueobjects.Doc_info_cita;
import com.Clinica1.myApp.appointments.domain.model.valueobjects.Especialidad;
import com.Clinica1.myApp.appointments.domain.model.valueobjects.NombreCompleto;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DoctorInfoAssemblerTest {

    @Test
    void deberiaCrearDocInfoCitaDesdeDoctorYEspecialidad() {

        // Arrange
        Doctor doctor = Doctor.creardoc(
                IDEntidad.generar(),
                NombreCompleto.of("Ana", "Torres"),
                "CMP99999",
                "Consultorio-5",
                List.of(Especialidad.of("Pediatría"))
        );

        Especialidad especialidad = Especialidad.of("Pediatría");

        // Act
        Doc_info_cita result = DoctorInfoAssembler.fromDoctor(doctor, especialidad);

        // Assert
        assertNotNull(result);
        assertEquals("Ana Torres", result.nombreCompleto());
        assertEquals("Pediatría", result.especialidad());
        assertEquals("Consultorio-5", result.consultorio());
        assertEquals("CMP99999", result.cmp());
    }

    @Test
    void deberiaRespetarEspecialidadRecibidaAunqueElDoctorTengaVarias() {
        Doctor doctor = Doctor.creardoc(
                IDEntidad.generar(),
                NombreCompleto.of("Luis", "Ramírez"),
                "CMP11111",
                "Consultorio-2",
                List.of(
                        Especialidad.of("Trauma"),
                        Especialidad.of("Cardiología")
                )
        );

        Especialidad seleccionada = Especialidad.of("Cardiología");

        Doc_info_cita result = DoctorInfoAssembler.fromDoctor(doctor, seleccionada);

        assertEquals("Cardiología", result.especialidad());
    }
}