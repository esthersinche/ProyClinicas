package com.Clinica1.myApp.IAMusuario.infrastructure.persistence.jpa.mapper;

import com.Clinica1.myApp.IAMusuario.infrastructure.persistence.jpa.entity.EmailEmbeddable;
import com.Clinica1.myApp.SharedKernel.Email;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmailMapperTest {

    private final EmailMapper mapper = new EmailMapper();

    @Test
    void ToDomain_convierteCorrectamente() {
        EmailEmbeddable emb = new EmailEmbeddable("correo@test.com");

        Email email = mapper.ToDomain(emb);

        assertNotNull(email);
        assertEquals("correo@test.com", email.email_valor());
    }

    @Test
    void ToEmbeddable_convierteCorrectamente() {
        Email email = new Email("usuario@mail.com");

        EmailEmbeddable emb = mapper.ToEmbeddable(email);

        assertNotNull(emb);
        assertEquals("usuario@mail.com", emb.getEmail_valor());
    }

    @Test
    void conversionBidireccional_mantieneElValor() {
        Email original = new Email("ciclo@mail.com");

        EmailEmbeddable emb = mapper.ToEmbeddable(original);
        Email resultado = mapper.ToDomain(emb);

        assertEquals(original.email_valor(), resultado.email_valor());
    }
}
