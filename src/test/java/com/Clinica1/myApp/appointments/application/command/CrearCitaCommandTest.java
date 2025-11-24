package com.Clinica1.myApp.appointments.application.command;

import com.Clinica1.myApp.SharedKernel.IDEntidad;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class CrearCitaCommandTest {

    @Test
    void deberiaCrearCommandConConstructor() {
        LocalDateTime inicio = LocalDateTime.now();
        LocalDateTime fin = inicio.plusHours(1);

        IDEntidad pacienteId = IDEntidad.astring("PAC001");
        IDEntidad doctorId = IDEntidad.astring("DOC001");
        IDEntidad clinicaId = IDEntidad.astring("CLIN001");

        CrearCitaCommand cmd = new CrearCitaCommand(
                "Dolor de cabeza",
                "Presencial",
                inicio,
                fin,
                pacienteId,
                doctorId,
                clinicaId,
                "Neurología"
        );

        assertEquals("Dolor de cabeza", cmd.getMotivo());
        assertEquals("Presencial", cmd.getCanal());
        assertEquals(inicio, cmd.getInicio());
        assertEquals(fin, cmd.getFin());
        assertEquals("PAC001", cmd.getPacienteId().obtenerid());
        assertEquals("DOC001", cmd.getDoctorId().obtenerid());
        assertEquals("CLIN001", cmd.getClinicaId().obtenerid());
        assertEquals("Neurología", cmd.getEspecialidad());
    }

    @Test
    void deberiaCrearCommandConBuilder() {
        LocalDateTime inicio = LocalDateTime.now();
        LocalDateTime fin = inicio.plusHours(2);

        CrearCitaCommand cmd = CrearCitaCommand.builder()
                .motivo("Control")
                .canal("Virtual")
                .inicio(inicio)
                .fin(fin)
                .pacienteId(IDEntidad.astring("P001"))
                .doctorId(IDEntidad.astring("D001"))
                .clinicaId(IDEntidad.astring("C001"))
                .especialidad("Dermatología")
                .build();

        assertEquals("Control", cmd.getMotivo());
        assertEquals("Virtual", cmd.getCanal());
        assertEquals(inicio, cmd.getInicio());
        assertEquals(fin, cmd.getFin());
        assertEquals("P001", cmd.getPacienteId().obtenerid());
        assertEquals("D001", cmd.getDoctorId().obtenerid());
        assertEquals("C001", cmd.getClinicaId().obtenerid());
        assertEquals("Dermatología", cmd.getEspecialidad());
    }
}
