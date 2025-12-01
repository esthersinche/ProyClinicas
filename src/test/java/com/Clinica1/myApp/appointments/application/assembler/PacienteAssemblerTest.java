package com.Clinica1.myApp.appointments.application.assembler;

import com.Clinica1.myApp.SharedKernel.IDEntidad;
import com.Clinica1.myApp.appointments.application.dto.PacienteDto;
import com.Clinica1.myApp.appointments.domain.model.aggregates.Paciente;
import com.Clinica1.myApp.appointments.domain.model.valueobjects.Email;

import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class PacienteAssemblerTest {

    private final PacienteAssembler assembler = new PacienteAssembler();

    @Test
    void deberiaConvertirPacienteA_PacienteDto_Correctamente() {
        // ---- Datos del paciente ----
        IDEntidad id = IDEntidad.generar();
        Date fechaNacimiento = new Date();

        Paciente paciente = new Paciente(
                id,
                "Juan Pérez",
                "Peruano",
                "87654321",
                "999888777",
                Email.of("juan@example.com"),
                fechaNacimiento,
                "M");

        // ---- Ejecutar assembler ----
        PacienteDto dto = assembler.toDto(paciente);

        // ---- Validaciones ----
        assertNotNull(dto);
        assertEquals(id, dto.getId());
        assertEquals("Juan Pérez", dto.getNombre());
        assertEquals("Peruano", dto.getNacionalidad());
        assertEquals("87654321", dto.getDni());
        assertEquals("999888777", dto.getTel());
        assertEquals("juan@example.com", dto.getEmail());
        assertEquals(fechaNacimiento, dto.getFec_nac());
        assertEquals("M", dto.getSexo());
    }

    @Test
    void deberiaConvertirPacienteDtoA_EntidadPaciente_Correctamente() {
        // ---- Datos ----
        IDEntidad id = IDEntidad.generar();
        Date fechaNacimiento = new Date();

        PacienteDto dto = new PacienteDto(
                id,
                "María López",
                "Chilena",
                "12345678",
                "987654321",
                "maria@example.com",
                fechaNacimiento,
                "F");

        // ---- Ejecutar conversión ----
        Paciente entidad = assembler.toEntity(dto);

        // ---- Validaciones ----
        assertNotNull(entidad);
        assertEquals(id, entidad.getId_pac());
        assertEquals("María López", entidad.getNombre_com_pac());
        assertEquals("Chilena", entidad.getNacionalidad_pac());
        assertEquals("12345678", entidad.getDni_pac());
        assertEquals("987654321", entidad.getTel_pac());
        assertEquals("maria@example.com", entidad.getEmail_pac().email_valor());
        assertEquals(fechaNacimiento, entidad.getFec_nac_pac());
        assertEquals("F", entidad.getSexo_pac());
    }

    @Test
    void deberiaRetornarNullSiPacienteEsNull() {
        assertNull(assembler.toDto(null));
    }

}
