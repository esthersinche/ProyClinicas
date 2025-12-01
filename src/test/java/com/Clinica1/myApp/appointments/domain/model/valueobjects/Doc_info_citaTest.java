package com.Clinica1.myApp.appointments.domain.model.valueobjects;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Doc_info_citaTest {

    @Test
    void deberiaCrearCorrectamente() {
        Doc_info_cita d = new Doc_info_cita(
                "Dr. Juan Pérez",
                "Cardiología",
                "Consultorio 12");

        assertEquals("Dr. Juan Pérez", d.nombre_doc());
        assertEquals("Cardiología", d.espe_doc());
        assertEquals("Consultorio 12", d.consult_doc());
    }

    @Test
    void deberiaCrearConFactory() {
        Doc_info_cita d = Doc_info_cita.of(
                "Dr. María López",
                "Pediatría",
                "Consultorio 3");

        assertEquals("Dr. María López", d.nombre_doc());
        assertEquals("Pediatría", d.espe_doc());
        assertEquals("Consultorio 3", d.consult_doc());
    }

    @Test
    void deberiaFallarSiNombreEsNuloOVacio() {
        assertThrows(IllegalArgumentException.class, () -> new Doc_info_cita(null, "Cardiología", "C1"));

        assertThrows(IllegalArgumentException.class, () -> new Doc_info_cita("  ", "Cardiología", "C1"));
    }

    @Test
    void deberiaFallarSiEspecialidadEsNuloOVacio() {
        assertThrows(IllegalArgumentException.class, () -> new Doc_info_cita("Dr. Juan", null, "C2"));

        assertThrows(IllegalArgumentException.class, () -> new Doc_info_cita("Dr. Juan", "   ", "C2"));
    }

    @Test
    void deberiaFallarSiConsultorioEsNuloOVacio() {
        assertThrows(IllegalArgumentException.class, () -> new Doc_info_cita("Dr. Juan", "Dermatología", null));

        assertThrows(IllegalArgumentException.class, () -> new Doc_info_cita("Dr. Juan", "Dermatología", ""));
    }
}
