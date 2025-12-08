package com.Clinica1.myApp.appointments.domain.model.valueobjects;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Doc_info_citaTest {

    @Test
    void deberiaCrearCorrectamente() {
        Doc_info_cita d = new Doc_info_cita(
                "Dr. Juan Pérez",
                "Cardiología",
                "Consultorio 12",
                "CMP12345");

        assertEquals("Dr. Juan Pérez", d.nombreCompleto());
        assertEquals("Cardiología", d.especialidad());
        assertEquals("Consultorio 12", d.consultorio());
        assertEquals("CMP12345", d.cmp());
    }

    @Test
    void deberiaCrearConFactory() {
        Doc_info_cita d = Doc_info_cita.of(
                "Dr. María López",
                "Pediatría",
                "Consultorio 3",
                "CMP67890");

        assertEquals("Dr. María López", d.nombreCompleto());
        assertEquals("Pediatría", d.especialidad());
        assertEquals("Consultorio 3", d.consultorio());
        assertEquals("CMP67890", d.cmp());
    }

    @Test
    void deberiaFallarSiNombreEsNuloOVacio() {
        assertThrows(IllegalArgumentException.class, () -> new Doc_info_cita(null, "Cardiología", "C1", "CMP123"));

        assertThrows(IllegalArgumentException.class, () -> new Doc_info_cita("  ", "Cardiología", "C1", "CMP123"));
    }

    @Test
    void deberiaFallarSiEspecialidadEsNuloOVacio() {
        assertThrows(IllegalArgumentException.class, () -> new Doc_info_cita("Dr. Juan", null, "C2", "CMP456"));

        assertThrows(IllegalArgumentException.class, () -> new Doc_info_cita("Dr. Juan", "   ", "C2", "CMP456"));
    }

    @Test
    void deberiaFallarSiConsultorioEsNuloOVacio() {
        assertThrows(IllegalArgumentException.class, () -> new Doc_info_cita("Dr. Juan", "Dermatología", null, "CMP789"));

        assertThrows(IllegalArgumentException.class, () -> new Doc_info_cita("Dr. Juan", "Dermatología", "", "CMP789"));
    }
}
