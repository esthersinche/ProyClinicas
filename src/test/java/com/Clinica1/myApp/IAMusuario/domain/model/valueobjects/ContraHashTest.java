package com.Clinica1.myApp.IAMusuario.domain.model.valueobjects;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContraHashTest {

    @Test
    void crearContraHash_ok() {
        String hashValue = "HASH123";
        ContraHash hash = ContraHash.deHash(hashValue);

        assertNotNull(hash);
        assertEquals(hashValue, hash.getValor_contra_hash());
    }

    @Test
    void contraHash_igual_mismoValor() {
        ContraHash h1 = ContraHash.deHash("ABC123");
        ContraHash h2 = ContraHash.deHash("ABC123");

        assertEquals(h1, h2);
        assertEquals(h1.hashCode(), h2.hashCode());
    }

    @Test
    void contraHash_diferente_valorDistinto() {
        ContraHash h1 = ContraHash.deHash("AAA");
        ContraHash h2 = ContraHash.deHash("BBB");

        assertNotEquals(h1, h2);
    }
}
