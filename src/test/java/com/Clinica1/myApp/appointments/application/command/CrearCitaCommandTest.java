package com.Clinica1.myApp.appointments.application.command;

import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.*;

class CrearCitaCommandTest {

    @Test
    void deberiaCrearCommandConDatosValidos() {
        LocalDateTime inicio = LocalDateTime.now().plusDays(1);
        LocalDateTime fin = inicio.plusHours(1);
        
        CrearCitaCommand command = new CrearCitaCommand(
            "Consulta general",
            "Presencial",
            inicio,
            fin,
            1L,
            2L,
            3L,
            "Cardiología"
        );
        
        assertNotNull(command);
        assertEquals("Consulta general", command.getMotivo());
        assertEquals("Presencial", command.getCanal());
        assertEquals(inicio, command.getInicio());
        assertEquals(fin, command.getFin());
        assertEquals(1L, command.getPacienteId());
        assertEquals(2L, command.getDoctorId());
        assertEquals(3L, command.getClinicaId());
        assertEquals("Cardiología", command.getEspecialidad());
    }

    @Test
    void deberiaPermitirCanalVirtual() {
        LocalDateTime inicio = LocalDateTime.now().plusDays(1);
        LocalDateTime fin = inicio.plusHours(1);
        
        CrearCitaCommand command = new CrearCitaCommand(
            "Consulta virtual",
            "Virtual",
            inicio,
            fin,
            1L,
            2L,
            3L,
            "Medicina General"
        );
        
        assertEquals("Virtual", command.getCanal());
    }
}
