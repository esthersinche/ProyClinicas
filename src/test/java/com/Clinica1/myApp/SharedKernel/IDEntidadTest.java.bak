package com.Clinica1.myApp.SharedKernel;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IDEntidadTest {

    @Test
    void deberiaGenerarUnIdValido() {
        IDEntidad id = IDEntidad.generar();

        assertNotNull(id);
        assertNotNull(id.obtenerid());
        assertFalse(id.obtenerid().isBlank());
    }

    @Test
    void deberiaCrearIdDesdeString() {
        String valor = "1234-abc";
        IDEntidad id = IDEntidad.astring(valor);

        assertEquals(valor, id.obtenerid());
    }

    @Test
    void idsConElMismoValorSonIguales() {
        String valor = "id-001";

        IDEntidad id1 = IDEntidad.astring(valor);
        IDEntidad id2 = IDEntidad.astring(valor);

        assertEquals(id1, id2);
        assertEquals(id1.hashCode(), id2.hashCode());
    }

    @Test
    void idsConValoresDiferentesNoSonIguales() {
        IDEntidad id1 = IDEntidad.astring("ID-A");
        IDEntidad id2 = IDEntidad.astring("ID-B");

        assertNotEquals(id1, id2);
    }

    @Test
    void equalsDebeRetornarFalseSiComparadoConNull() {
        IDEntidad id = IDEntidad.generar();
        assertNotEquals(id, null);
    }

    @Test
    void equalsDebeRetornarFalseSiComparadoConOtroTipo() {
        IDEntidad id = IDEntidad.generar();
        assertNotEquals(id, "string");
    }

    @Test
    void equalsDebeRetornarTrueParaElMismoObjeto() {
        IDEntidad id = IDEntidad.generar();
        assertEquals(id, id); // misma referencia
    }
}
