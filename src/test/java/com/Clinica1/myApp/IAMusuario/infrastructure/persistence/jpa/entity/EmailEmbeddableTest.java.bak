package com.Clinica1.myApp.IAMusuario.infrastructure.persistence.jpa.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmailEmbeddableTest {

    @Test
    void constructor_y_getter_funcionanCorrectamente() {
        EmailEmbeddable email = new EmailEmbeddable("test@example.com");

        assertEquals("test@example.com", email.getEmail_valor());
    }

    @Test
    void equals_retornaTrue_paraEmailsIguales() {
        EmailEmbeddable e1 = new EmailEmbeddable("a@b.com");
        EmailEmbeddable e2 = new EmailEmbeddable("a@b.com");

        assertEquals(e1, e2);
    }

    @Test
    void equals_retornaFalse_paraEmailsDiferentes() {
        EmailEmbeddable e1 = new EmailEmbeddable("a@b.com");
        EmailEmbeddable e2 = new EmailEmbeddable("c@d.com");

        assertNotEquals(e1, e2);
    }

    @Test
    void hashCode_esIgual_paraEmailsIguales() {
        EmailEmbeddable e1 = new EmailEmbeddable("x@y.com");
        EmailEmbeddable e2 = new EmailEmbeddable("x@y.com");

        assertEquals(e1.hashCode(), e2.hashCode());
    }

    @Test
    void toString_retornaValorCorrecto() {
        EmailEmbeddable email = new EmailEmbeddable("correo@dominio.com");

        assertEquals("correo@dominio.com", email.toString());
    }
}
