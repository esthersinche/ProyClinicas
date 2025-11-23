package com.IAMusuario.valueobjects;

import com.Clinica1.myApp.IAMusuario.domain.model.valueobjects.ContraHash;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContraHashTest {

    @Test
    void factoryDebeCrearInstanciaCorrectamente() {
        ContraHash hash = ContraHash.hasheandocB("abc123");

        assertNotNull(hash);
        assertEquals("abc123", hash.getValor_contra_hash());
    }

    @Test
    void equalsDebeSerTrueCuandoElValorEsIgual() {
        ContraHash h1 = ContraHash.hasheandocB("clave");
        ContraHash h2 = ContraHash.hasheandocB("clave");

        assertEquals(h1, h2, "Dos ContraHash con el mismo valor deben ser iguales");
    }

    @Test
    void equalsDebeSerFalseCuandoElValorEsDiferente() {
        ContraHash h1 = ContraHash.hasheandocB("pass1");
        ContraHash h2 = ContraHash.hasheandocB("pass2");

        assertNotEquals(h1, h2, "ContraHash con valores distintos no deben ser iguales");
    }

    @Test
    void hashCodeDebeSerIgualParaValoresIguales() {
        ContraHash h1 = ContraHash.hasheandocB("123");
        ContraHash h2 = ContraHash.hasheandocB("123");

        assertEquals(h1.hashCode(), h2.hashCode());
    }

    @Test
    void hashCodeDebeSerDiferenteParaValoresDistintos() {
        ContraHash h1 = ContraHash.hasheandocB("AAA");
        ContraHash h2 = ContraHash.hasheandocB("BBB");

        assertNotEquals(h1.hashCode(), h2.hashCode());
    }

    @Test
    void equalsDebeRetornarFalseSiObjetoEsNull() {
        ContraHash h1 = ContraHash.hasheandocB("abc");

        assertNotEquals(null, h1);
    }

    @Test
    void equalsDebeRetornarFalseParaClasesDistintas() {
        ContraHash h1 = ContraHash.hasheandocB("abc");

        assertNotEquals("abc", h1);
    }
}
