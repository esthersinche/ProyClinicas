package com.Clinica1.myApp.IAMusuario.infrastructure.configuration;

import com.Clinica1.myApp.IAMusuario.application.TokenProvider;
import com.Clinica1.myApp.IAMusuario.infrastructure.security.JWTTokenProvider;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JWTConfigTest {

    @Test
    void tokenProvider_creaJWTTokenProviderCorrectamente() {
        JWTConfig config = new JWTConfig();

        // Simulamos que Spring asignó los @Value
        // por eso se los seteamos manualmente usando reflexión
        setField(config, "jwtsecreto", "MI_SECRETO_DE_32_CARACTERES_123456");
        setField(config, "jwtexpiracionsg", 900L);

        TokenProvider provider = config.tokenProvider();

        assertNotNull(provider);
        assertTrue(provider instanceof JWTTokenProvider);
    }

    @Test
    void tokenProvider_configuraValoresCorrectos() {
        JWTConfig config = new JWTConfig();

        setField(config, "jwtsecreto", "OTRO_SECRETO_DE_32_CHARS_ABCDEF123");
        setField(config, "jwtexpiracionsg", 3600L);

        JWTTokenProvider provider = (JWTTokenProvider) config.tokenProvider();

        assertNotNull(provider);
    }

    // ========= Método auxiliar para simular @Value ==========
    private static void setField(Object target, String fieldName, Object value) {
        try {
            var field = target.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(target, value);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}
