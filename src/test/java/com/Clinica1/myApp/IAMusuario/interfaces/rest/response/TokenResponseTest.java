package com.Clinica1.myApp.IAMusuario.interfaces.rest.response;

import com.Clinica1.myApp.IAMusuario.interfaces.rest.dto.response.TokenResponse;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TokenResponseTest {

    @Test
    void testCompletoTokenResponse() {

        TokenResponse empty = new TokenResponse();
        assertNull(empty.getToken());
        assertNull(empty.getUsername());
        assertNull(empty.getRol());

        TokenResponse full = new TokenResponse("TOKEN123", "usuario1", "Admin");

        assertEquals("TOKEN123", full.getToken());
        assertEquals("usuario1", full.getUsername());
        assertEquals("Admin", full.getRol());

        empty.setToken("XYZ");
        empty.setUsername("juan");
        empty.setRol("Doctor");

        assertEquals("XYZ", empty.getToken());
        assertEquals("juan", empty.getUsername());
        assertEquals("Doctor", empty.getRol());
    }
}
