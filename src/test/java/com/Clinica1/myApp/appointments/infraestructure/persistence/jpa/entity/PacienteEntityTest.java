package com.Clinica1.myApp.appointments.infraestructure.persistence.jpa.entity;

import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class PacienteEntityTest {

    @Test
    void builder_ok() {
        EmailEmbeddable email = new EmailEmbeddable("user@mail.com");
        Date fecha = new Date();

        PacienteEntity pac = PacienteEntity.builder()
                .id_pac("PAC1")
                .nombre_com_pac("Luis Torres")
                .nacionalidad_pac("Peruana")
                .dni_pac("12345678")
                .tel_pac("987654321")
                .email_pac(email)
                .fec_nac_pac(fecha)
                .sexo_pac("Masculino")
                .build();

        assertEquals("PAC1", pac.getId_pac());
        assertEquals("Luis Torres", pac.getNombre_com_pac());
        assertEquals("Peruana", pac.getNacionalidad_pac());
        assertEquals("12345678", pac.getDni_pac());
        assertEquals("987654321", pac.getTel_pac());
        assertEquals(email, pac.getEmail_pac());
        assertEquals(fecha, pac.getFec_nac_pac());
        assertEquals("Masculino", pac.getSexo_pac());
    }

    @Test
    void noArgs_ok() {
        PacienteEntity pac = new PacienteEntity();
        assertNotNull(pac);
    }

    @Test
    void allArgs_ok() {
        EmailEmbeddable email = new EmailEmbeddable("test@mail.com");
        Date fecha = new Date();

        PacienteEntity pac = new PacienteEntity(
                "ID2",
                "Ana Ramos",
                "Peruana",
                "87654321",
                "912345678",
                email,
                fecha,
                "Femenino");

        assertEquals("ID2", pac.getId_pac());
        assertEquals("Ana Ramos", pac.getNombre_com_pac());
        assertEquals("Femenino", pac.getSexo_pac());
    }
}
