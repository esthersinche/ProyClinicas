package com.Clinica1.myApp.appointments.domain.model.valueobjects;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmailTest {

    @Test
    void deberiaCrearEmailCorrectamente() {
        Email email = new Email("usuario@example.com");

        assertEquals("usuario@example.com", email.email_valor());
    }

    @Test
    void deberiaCrearEmailConFactory() {
        Email email = Email.of("test@mail.com");

        assertEquals("test@mail.com", email.email_valor());
    }

    @Test
    void deberiaFallarSiEmailEsNulo() {
        assertThrows(IllegalArgumentException.class, () -> new Email(null));
    }

    @Test
    void deberiaFallarSiEmailEsVacio() {
        assertThrows(IllegalArgumentException.class, () -> new Email("  "));
    }

    @Test
    void deberiaFallarSiEmailTieneFormatoIncorrecto() {
        assertThrows(IllegalArgumentException.class, () -> new Email("correo-sin-arroba.com"));

        assertThrows(IllegalArgumentException.class, () -> new Email("invalido@"));

        assertThrows(IllegalArgumentException.class, () -> new Email("@sinusuario.com"));
    }

    @Test
    void deberiaAceptarEmailValido() {
        assertDoesNotThrow(() -> new Email("valido123.test@mail-domain.pe"));
    }
}
