package com.Clinica1.myApp.IAMusuario.domain.model.aggregates;

import com.Clinica1.myApp.SharedKernel.IDEntidad;
import org.junit.jupiter.api.Test;

import java.time.Instant;

import static org.junit.jupiter.api.Assertions.*;

class SesionTest {

    @Test
    void crearSesion_ok() {
        IDEntidad usuarioId = IDEntidad.generar();
        Instant inicio = Instant.now();
        Instant fin = inicio.plusSeconds(3600);

        Sesion sesion = Sesion.crearsesion(usuarioId, inicio, fin);

        assertNotNull(sesion.getToken_id());
        assertEquals(usuarioId, sesion.getUsuweb_id());
        assertEquals(inicio, sesion.getComienzo());
        assertEquals(fin, sesion.getExpiracion());
    }

    @Test
    void sesiones_iguales_mismoToken() {
        IDEntidad token = IDEntidad.generar();
        IDEntidad usu = IDEntidad.generar();
        Instant t1 = Instant.now();
        Instant t2 = t1.plusSeconds(300);

        Sesion s1 = new Sesion(token, usu, t1, t2);
        Sesion s2 = new Sesion(token, usu, t1, t2);

        assertEquals(s1, s2);
        assertEquals(s1.hashCode(), s2.hashCode());
    }

    @Test
    void sesiones_distintas_tokenDiferente() {
        IDEntidad usu = IDEntidad.generar();
        Instant t1 = Instant.now();
        Instant t2 = t1.plusSeconds(300);

        Sesion s1 = new Sesion(IDEntidad.generar(), usu, t1, t2);
        Sesion s2 = new Sesion(IDEntidad.generar(), usu, t1, t2);

        assertNotEquals(s1, s2);
    }
}
