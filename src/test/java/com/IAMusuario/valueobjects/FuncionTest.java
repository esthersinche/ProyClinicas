package com.IAMusuario.valueobjects;

import com.Clinica1.myApp.IAMusuario.domain.model.valueobjects.Funcion;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FuncionTest {

    @Test
    void testCreacionCorrecta() {
        Funcion f = Funcion.of("Administrador");

        assertNotNull(f);
        assertEquals("Administrador", f.getNombre_fun());
    }

    @Test
    void testCreacionConNullDebeFallar() {
        assertThrows(NullPointerException.class, () -> Funcion.of(null));
    }

    @Test
    void testEqualsEsCaseInsensitive() {
        Funcion f1 = Funcion.of("Administrador");
        Funcion f2 = Funcion.of("administrador");

        assertEquals(f1, f2);  // Deben ser iguales ignorando mayúsc/minús
    }

    @Test
    void testHashCodeEsCaseInsensitive() {
        Funcion f1 = Funcion.of("ADMIN");
        Funcion f2 = Funcion.of("admin");

        assertEquals(f1.hashCode(), f2.hashCode());
    }

    @Test
    void testToString() {
        Funcion f = Funcion.of("Supervisor");

        assertEquals("Funcion: Supervisor", f.toString());
    }
}
