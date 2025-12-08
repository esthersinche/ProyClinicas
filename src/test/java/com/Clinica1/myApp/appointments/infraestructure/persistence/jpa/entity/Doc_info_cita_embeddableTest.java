package com.Clinica1.myApp.appointments.infraestructure.persistence.jpa.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Doc_info_cita_embeddableTest {

    @Test
    void builder_ok() {
        Doc_info_cita_embeddable info = Doc_info_cita_embeddable.builder()
                .nombre_doc("Juan Perez")
                .espe_doc("Cardiología")
                .consult_doc("C201")
                .cmp_doc("CMP12345")
                .build();

        assertEquals("Juan Perez", info.getNombre_doc());
        assertEquals("Cardiología", info.getEspe_doc());
        assertEquals("C201", info.getConsult_doc());
        assertEquals("CMP12345", info.getCmp_doc());
    }

    @Test
    void noArgs_ok() {
        Doc_info_cita_embeddable info = new Doc_info_cita_embeddable();
        assertNotNull(info);
    }

    @Test
    void allArgs_ok() {
        Doc_info_cita_embeddable info = new Doc_info_cita_embeddable(
                "Ana Santos",
                "Dermatología",
                "B115",
                "CMP67890");

        assertEquals("Ana Santos", info.getNombre_doc());
        assertEquals("Dermatología", info.getEspe_doc());
        assertEquals("B115", info.getConsult_doc());
        assertEquals("CMP67890", info.getCmp_doc());
    }
}
