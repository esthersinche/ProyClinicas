package com.Clinica1.myApp.IAMusuario.infrastructure.security;

import com.Clinica1.myApp.IAMusuario.application.exception.JWTInvalidException;
import com.Clinica1.myApp.SharedKernel.Email;
import com.Clinica1.myApp.SharedKernel.IDEntidad;
import com.Clinica1.myApp.SharedKernel.UsuarioWeb;
import io.jsonwebtoken.JwtException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class JWTTokenProviderTest {

    private JWTTokenProvider provider;

    private final String SECRET = "12345678901234567890123456789012"; // 32+ chars
    private final long EXPSECONDS = 3600;

    @BeforeEach
    void setUp() {
        provider = new JWTTokenProvider(SECRET, EXPSECONDS);
    }

    UsuarioWeb crearUsuarioMock() {
        return new UsuarioWeb(
                IDEntidad.astring("USER001"),
                new Email("test@gmail.com"),
                "hashedpass",
                IDEntidad.astring("EMP123"),
                IDEntidad.astring("CLI555"));
    }

    @Test
    void generarToken_funcionaCorrectamente() {
        UsuarioWeb usu = crearUsuarioMock();

        String token = provider.generartokendeacceso(usu);

        assertNotNull(token);
        assertFalse(token.isEmpty());
    }

    @Test
    void validarToken_valido_noLanzaExcepcion() {
        UsuarioWeb usu = crearUsuarioMock();
        String token = provider.generartokendeacceso(usu);

        assertDoesNotThrow(() -> provider.validartokendeacceso(token));
    }

    @Test
    void validarToken_invalido_lanzaJWTInvalidException() {
        String tokenCorrupto = "abc.def.ghi";

        assertThrows(JWTInvalidException.class, () -> provider.validartokendeacceso(tokenCorrupto));
    }

    @Test
    void parsear_extraeClaimsCorrectamente() {
        UsuarioWeb usu = crearUsuarioMock();

        String token = provider.generartokendeacceso(usu);
        Map<String, Object> claims = provider.parsear(token);

        assertEquals("USER001", claims.get("sub"));
        assertEquals("EMP123", claims.get("id_emp"));
        assertEquals("CLI555", claims.get("id_cli"));
    }

    @Test
    void generarIdToken_devuelveStringDiferenteCadaVez() {
        String id1 = provider.generarIdtoken();
        String id2 = provider.generarIdtoken();

        assertNotNull(id1);
        assertNotNull(id2);
        assertNotEquals(id1, id2);
    }
}
