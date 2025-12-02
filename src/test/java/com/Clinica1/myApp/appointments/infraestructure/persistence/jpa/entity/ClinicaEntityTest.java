package com.Clinica1.myApp.appointments.infraestructure.persistence.jpa.entity;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ClinicaEntityTest {

    @Test
    void builder_ok() {
        DireccionEmbeddable dir = new DireccionEmbeddable("Av. Lima", "123", "Chorrillos", "Lima");
        ClinicaEntity clinica = ClinicaEntity.builder()
                .id_cli("CL1")
                .nom_clin("Clinica Sur")
                .dir_clin(dir)
                .doctorescli(List.of())
                .pacientescli(List.of())
                .build();

        assertEquals("CL1", clinica.getId_cli());
        assertEquals("Clinica Sur", clinica.getNom_clin());
        assertEquals(dir, clinica.getDir_clin());
        assertTrue(clinica.getDoctorescli().isEmpty());
        assertTrue(clinica.getPacientescli().isEmpty());
    }

    @Test
    void noArgs_ok() {
        ClinicaEntity clinica = new ClinicaEntity();
        assertNotNull(clinica);
    }

    @Test
    void allArgs_ok() {
        DireccionEmbeddable dir = new DireccionEmbeddable("Av. Lima", "123", "Chorrillos", "Lima");

        ClinicaEntity clinica = new ClinicaEntity(
                "CL2",
                "Centro Medico",
                dir,
                List.of(),
                List.of());

        assertEquals("CL2", clinica.getId_cli());
        assertEquals("Centro Medico", clinica.getNom_clin());
        assertEquals(dir, clinica.getDir_clin());
    }
}
