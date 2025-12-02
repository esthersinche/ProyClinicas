package com.Clinica1.myApp.appointments.infraestructure.persistence.jpa.mapper;

import com.Clinica1.myApp.appointments.domain.model.valueobjects.Email;
import com.Clinica1.myApp.appointments.infraestructure.persistence.jpa.entity.EmailEmbeddable;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmailMapperTest {

    private final EmailMapper mapper = new EmailMapper();

    @Test
    void toDomain_ok() {
        EmailEmbeddable emb = EmailEmbeddable.builder()
                .email_valor("test@example.com")
                .build();

        Email result = mapper.ToDomain(emb);

        assertNotNull(result);
        assertEquals("test@example.com", result.email_valor());
    }

    @Test
    void toEntity_ok() {
        Email email = new Email("test@example.com");

        EmailEmbeddable emb = mapper.ToEmbeddable(email);

        assertNotNull(emb);
        assertEquals("test@example.com", emb.getEmail_valor());
    }
}
