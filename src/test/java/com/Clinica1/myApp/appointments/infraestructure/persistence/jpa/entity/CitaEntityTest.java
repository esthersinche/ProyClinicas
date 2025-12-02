package com.Clinica1.myApp.appointments.infraestructure.persistence.jpa.entity;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class CitaEntityTest {

    @Test
    void builder_ok() {
        LocalDateTime ini = LocalDateTime.now();
        LocalDateTime fin = ini.plusHours(1);

        CitaEntity cita = CitaEntity.builder()
                .id_cita("C1")
                .motivo_cita("Consulta general")
                .estado_cita("ACTIVO")
                .canal_cita("ONLINE")
                .inicio_cita(ini)
                .fin_cita(fin)
                .pac_id("P1")
                .doc_id("D1")
                .build();

        assertEquals("C1", cita.getId_cita());
        assertEquals("Consulta general", cita.getMotivo_cita());
        assertEquals("ACTIVO", cita.getEstado_cita());
        assertEquals("ONLINE", cita.getCanal_cita());
        assertEquals("P1", cita.getPac_id());
        assertEquals("D1", cita.getDoc_id());
        assertEquals(ini, cita.getInicio_cita());
        assertEquals(fin, cita.getFin_cita());
    }

    @Test
    void noArgs_ok() {
        CitaEntity cita = new CitaEntity();
        assertNotNull(cita);
    }

    @Test
    void allArgs_ok() {
        LocalDateTime ini = LocalDateTime.now();
        LocalDateTime fin = ini.plusHours(1);

        CitaEntity cita = new CitaEntity(
                "ID1",
                "Motivo",
                "PENDIENTE",
                "PRESENCIAL",
                ini,
                fin,
                "PAC123",
                "DOC456",
                null,
                null,
                null);

        assertEquals("ID1", cita.getId_cita());
        assertEquals("PENDIENTE", cita.getEstado_cita());
        assertEquals("PRESENCIAL", cita.getCanal_cita());
    }
}
