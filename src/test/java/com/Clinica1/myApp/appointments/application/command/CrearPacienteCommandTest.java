package com.Clinica1.myApp.appointments.application.command;

import com.Clinica1.myApp.SharedKernel.IDEntidad;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class CrearPacienteCommandTest {

    @Test
    void deberiaCrearCrearPacienteCommandCorrectamente() {
        IDEntidad id = IDEntidad.generar();
        Date fechaNac = new Date();

        CrearPacienteCommand cmd = new CrearPacienteCommand(
                id,
                "Juan Pérez",
                "Peruano",
                "87654321",
                "987654321",
                "juan@example.com",
                fechaNac,
                "M");

        assertEquals(id, cmd.getId());
        assertEquals("Juan Pérez", cmd.getNombre());
        assertEquals("Peruano", cmd.getNacionalidad());
        assertEquals("87654321", cmd.getDni());
        assertEquals("987654321", cmd.getTel());
        assertEquals("juan@example.com", cmd.getEmail());
        assertEquals(fechaNac, cmd.getFec_nac());
        assertEquals("M", cmd.getSexo());
    }

    @Test
    void deberiaCrearCrearPacienteCommandConBuilder() {
        IDEntidad id = IDEntidad.generar();
        Date fechaNac = new Date();

        CrearPacienteCommand cmd = CrearPacienteCommand.builder()
                .id(id)
                .nombre("María López")
                .nacionalidad("Chilena")
                .dni("11223344")
                .tel("912345678")
                .email("maria@example.com")
                .fec_nac(fechaNac)
                .sexo("F")
                .build();

        assertNotNull(cmd);
        assertEquals(id, cmd.getId());
        assertEquals("María López", cmd.getNombre());
        assertEquals("Chilena", cmd.getNacionalidad());
        assertEquals("11223344", cmd.getDni());
        assertEquals("912345678", cmd.getTel());
        assertEquals("maria@example.com", cmd.getEmail());
        assertEquals(fechaNac, cmd.getFec_nac());
        assertEquals("F", cmd.getSexo());
    }
}
