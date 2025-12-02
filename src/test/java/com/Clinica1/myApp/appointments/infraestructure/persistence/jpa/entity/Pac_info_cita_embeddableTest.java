package com.Clinica1.myApp.appointments.infraestructure.persistence.jpa.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Pac_info_cita_embeddableTest {

    @Test
    void builder_ok() {
        Pac_info_cita_embeddable info = Pac_info_cita_embeddable.builder()
                .nomb_com_pac("Luis Ramos")
                .dni_pac("12345678")
                .build();

        assertEquals("Luis Ramos", info.getNomb_com_pac());
        assertEquals("12345678", info.getDni_pac());
    }

    @Test
    void noArgs_ok() {
        Pac_info_cita_embeddable info = new Pac_info_cita_embeddable();
        assertNotNull(info);
    }

    @Test
    void allArgs_ok() {
        Pac_info_cita_embeddable info = new Pac_info_cita_embeddable(
                "Ana Torres",
                "87654321");

        assertEquals("Ana Torres", info.getNomb_com_pac());
        assertEquals("87654321", info.getDni_pac());
    }
}
