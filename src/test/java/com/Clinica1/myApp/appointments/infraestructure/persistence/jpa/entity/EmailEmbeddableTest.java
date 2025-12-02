package com.Clinica1.myApp.appointments.infraestructure.persistence.jpa.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmailEmbeddableTest {

    @Test
    void builder_ok() {
        EmailEmbeddable email = EmailEmbeddable.builder()
                .email_valor("test@example.com")
                .build();

        assertEquals("test@example.com", email.getEmail_valor());
    }

    @Test
    void noArgs_ok() {
        EmailEmbeddable email = new EmailEmbeddable();
        assertNotNull(email);
    }

    @Test
    void allArgs_ok() {
        EmailEmbeddable email = new EmailEmbeddable("user@correo.com");
        assertEquals("user@correo.com", email.getEmail_valor());
    }
}
