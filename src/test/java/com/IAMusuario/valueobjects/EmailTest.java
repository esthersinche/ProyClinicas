package com.IAMusuario.valueobjects;

import com.Clinica1.myApp.SharedKernel.Email;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmailTest {

    @Test
    void crearEmailValidoDeberiaFuncionar() {
        Email email = new Email("usuario@gmail.com");

        assertNotNull(email);
        assertEquals("usuario@gmail.com", email.email_valor());
    }

    @Test
    void crearEmailConOfDeberiaFuncionar() {
        Email email = Email.of("test@example.com");

        assertNotNull(email);
        assertEquals("test@example.com", email.email_valor());
    }

    @Test
    void emailNullDebeLanzarExcepcion() {
        IllegalArgumentException ex = assertThrows(
                IllegalArgumentException.class,
                () -> new Email(null)
        );

        assertEquals("Email cannot be null or be empty", ex.getMessage());
    }

    @Test
    void emailVacioDebeLanzarExcepcion() {
        IllegalArgumentException ex = assertThrows(
                IllegalArgumentException.class,
                () -> new Email(" ")
        );

        assertEquals("Email cannot be null or be empty", ex.getMessage());
    }

    @Test
    void emailFormatoInvalidoDebeLanzarExcepcion() {
        IllegalArgumentException ex = assertThrows(
                IllegalArgumentException.class,
                () -> new Email("correo-invalido")
        );

        assertEquals("Invalid Email", ex.getMessage());
    }

    @Test
    void igualesCuandoValorEsIgual() {
        Email e1 = new Email("abc@test.com");
        Email e2 = new Email("abc@test.com");

        assertEquals(e1, e2);
        assertEquals(e1.hashCode(), e2.hashCode());
    }

    @Test
    void noIgualesCuandoValorEsDistinto() {
        Email e1 = new Email("a@test.com");
        Email e2 = new Email("b@test.com");

        assertNotEquals(e1, e2);
        assertNotEquals(e1.hashCode(), e2.hashCode());
    }

    @Test
    void equalsDebeRetornarFalseConObjetoDeOtraClase() {
        Email email = new Email("abc@test.com");

        assertNotEquals("abc@test.com", email);
    }
}

