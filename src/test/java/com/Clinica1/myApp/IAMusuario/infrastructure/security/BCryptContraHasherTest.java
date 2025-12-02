package com.Clinica1.myApp.IAMusuario.infrastructure.security;

import com.Clinica1.myApp.IAMusuario.application.services.ContraService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class BCryptContraHasherTest {

    private PasswordEncoder encoderMock;
    private ContraService hasher;

    @BeforeEach
    void setUp() {
        encoderMock = mock(PasswordEncoder.class);
        hasher = new BCryptContraHasher(encoderMock);
    }

    @Test
    void hash_delegaEnPasswordEncoder() {
        String password = "123456";
        String hashedMock = "$2a$10$abc123";

        when(encoderMock.encode(password)).thenReturn(hashedMock);

        String result = hasher.hash(password);

        assertEquals(hashedMock, result);
        verify(encoderMock, times(1)).encode(password);
    }

    @Test
    void matches_delegaEnPasswordEncoder() {
        String password = "mipass";
        String hash = "$2a$10$xyz987";

        when(encoderMock.matches(password, hash)).thenReturn(true);

        boolean result = hasher.matches(password, hash);

        assertTrue(result);
        verify(encoderMock, times(1)).matches(password, hash);
    }
}
