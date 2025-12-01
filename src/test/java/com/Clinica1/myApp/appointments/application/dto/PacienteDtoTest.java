package com.Clinica1.myApp.appointments.application.dto;

import com.Clinica1.myApp.SharedKernel.IDEntidad;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class PacienteDtoTest {

    @Test
    void deberiaCrearPacienteDtoConConstructorCorrectamente() {
        IDEntidad id = IDEntidad.generar();
        String nombre = "Luis Ramos";
        String nacionalidad = "Peruana";
        String dni = "12345678";
        String tel = "987654321";
        String email = "luis@gmail.com";
        Date nacimiento = new Date();
        String sexo = "Masculino";

        PacienteDto dto = new PacienteDto(
                id,
                nombre,
                nacionalidad,
                dni,
                tel,
                email,
                nacimiento,
                sexo);

        assertNotNull(dto, "✔ El DTO no debe ser nulo");
        assertEquals(id, dto.getId(), "✔ El ID debe coincidir");
        assertEquals(nombre, dto.getNombre(), "✔ El nombre debe coincidir");
        assertEquals(nacionalidad, dto.getNacionalidad(), "✔ La nacionalidad debe coincidir");
        assertEquals(dni, dto.getDni(), "✔ El DNI debe coincidir");
        assertEquals(tel, dto.getTel(), "✔ El teléfono debe coincidir");
        assertEquals(email, dto.getEmail(), "✔ El email debe coincidir");
        assertEquals(nacimiento, dto.getFec_nac(), "✔ La fecha de nacimiento debe coincidir");
        assertEquals(sexo, dto.getSexo(), "✔ El sexo debe coincidir");
    }

    @Test
    void deberiaModificarCamposConSettersCorrectamente() {
        PacienteDto dto = new PacienteDto();

        IDEntidad id = IDEntidad.generar();
        Date nacimiento = new Date();

        dto.setId(id);
        dto.setNombre("Ana Torres");
        dto.setNacionalidad("Argentina");
        dto.setDni("87654321");
        dto.setTel("912345678");
        dto.setEmail("ana@gmail.com");
        dto.setFec_nac(nacimiento);
        dto.setSexo("Femenino");

        assertEquals(id, dto.getId(), "✔ El ID debe coincidir tras usar setter");
        assertEquals("Ana Torres", dto.getNombre(), "✔ El nombre debe coincidir tras usar setter");
        assertEquals("Argentina", dto.getNacionalidad(), "✔ La nacionalidad debe coincidir tras usar setter");
        assertEquals("87654321", dto.getDni(), "✔ El DNI debe coincidir tras usar setter");
        assertEquals("912345678", dto.getTel(), "✔ El teléfono debe coincidir tras usar setter");
        assertEquals("ana@gmail.com", dto.getEmail(), "✔ El email debe coincidir tras usar setter");
        assertEquals(nacimiento, dto.getFec_nac(), "✔ La fecha debe coincidir tras usar setter");
        assertEquals("Femenino", dto.getSexo(), "✔ El sexo debe coincidir tras usar setter");
    }
}
