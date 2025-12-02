package com.Clinica1.myApp.appointments.interfaces.rest.dto.request;

import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class CrearPacienteRequestTest {

    @Test
    void getterSetter_ok() {
        CrearPacienteRequest req = new CrearPacienteRequest();

        req.setNombre("Ana Lopez");
        req.setNacionalidad("Peruana");
        req.setDni("12345678");
        req.setTel("987654321");
        req.setEmail("ana@mail.com");
        Date fecha = new Date();
        req.setFec_nac(fecha);
        req.setSexo("Femenino");

        assertEquals("Ana Lopez", req.getNombre());
        assertEquals("Peruana", req.getNacionalidad());
        assertEquals("12345678", req.getDni());
        assertEquals("987654321", req.getTel());
        assertEquals("ana@mail.com", req.getEmail());
        assertEquals(fecha, req.getFec_nac());
        assertEquals("Femenino", req.getSexo());
    }
}
