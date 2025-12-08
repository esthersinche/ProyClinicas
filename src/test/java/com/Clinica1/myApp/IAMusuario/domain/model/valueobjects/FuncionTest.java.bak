package com.Clinica1.myApp.IAMusuario.domain.model.valueobjects;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FuncionTest {

    @Test
    void crearFuncion_ok() {
        Funcion f = Funcion.of("Buscar_Paciente");

        assertNotNull(f);
        assertEquals("Buscar_Paciente", f.getNombre_fun());
    }

    @Test
    void crearFuncion_error_null() {
        assertThrows(NullPointerException.class, () -> Funcion.of(null));
    }

    @Test
    void igualdad_ignoraMayusculas() {
        Funcion f1 = Funcion.of("ATENDER_PACIENTE");
        Funcion f2 = Funcion.of("atender_paciente");

        assertEquals(f1, f2);
        assertEquals(f1.hashCode(), f2.hashCode());
    }

    @Test
    void desigualdad_valoresDistintos() {
        Funcion f1 = Funcion.of("AAA");
        Funcion f2 = Funcion.of("BBB");

        assertNotEquals(f1, f2);
    }

    @Test
    void toString_devuelveNombre() {
        Funcion f = Funcion.of("Registrar_Cita");

        assertEquals("Registrar_Cita", f.toString());
    }
}
