package com.Clinica1.myApp.IAMusuario.domain.exception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CredencialesInvalidasExceptionTest {

    @Test
    void constructor_guardaMensajeCorrectamente() {
        String mensaje = "Credenciales incorrectas";
        CredencialesInvalidasException ex = new CredencialesInvalidasException(mensaje);

        assertEquals(mensaje, ex.getMessage());
    }

    @Test
    void esRuntimeException() {
        CredencialesInvalidasException ex = new CredencialesInvalidasException("Error");

        assertTrue(ex instanceof RuntimeException);
    }
}
