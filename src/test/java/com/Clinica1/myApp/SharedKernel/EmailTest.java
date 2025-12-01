package com.Clinica1.myApp.SharedKernel;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmailTest {

    @Test
    void deberiaCrearEmailCorrectamente() {
        Email email = new Email("usuario@mail.com");
        assertEquals("usuario@mail.com", email.email_valor());
        assertEquals("usuario@mail.com", email.toString());
    }

    @Test
    void deberiaCrearEmailConMetodoFactory() {
        Email email = Email.of("test@example.com");
        assertEquals("test@example.com", email.email_valor());
    }

    @Test
    void deberiaLanzarErrorSiEsNulo() {
        assertThrows(IllegalArgumentException.class, () -> new Email(null));
    }

    @Test
    void deberiaLanzarErrorSiEsVacio() {
        assertThrows(IllegalArgumentException.class, () -> new Email("   "));
    }

    @Test
    void deberiaLanzarErrorSiEsInvalido() {

        // Sin @
        assertThrows(IllegalArgumentException.class, () -> new Email("correo-invalido"));

        // Sin parte local
        assertThrows(IllegalArgumentException.class, () -> new Email("@dominio.com"));

        // Sin dominio
        assertThrows(IllegalArgumentException.class, () -> new Email("usuario@"));

        // Doble @
        assertThrows(IllegalArgumentException.class, () -> new Email("a@@b.com"));
    }

    @Test
    void deberiaAplicarEqualsYHashCodeCorrectamente() {
        Email e1 = new Email("a@b.com");
        Email e2 = new Email("a@b.com");

        assertEquals(e1, e2);
        assertEquals(e1.hashCode(), e2.hashCode());
    }
}
