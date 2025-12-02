package com.Clinica1.myApp.IAMusuario.infrastructure.configuration;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.jupiter.api.Assertions.*;

class ConfigSecurityTest {

    @Test
    void contraEncoder_devuelveBCryptPasswordEncoder() {
        ConfigSecurity config = new ConfigSecurity();

        PasswordEncoder encoder = config.contraEncoder();

        assertNotNull(encoder);
        assertTrue(encoder instanceof BCryptPasswordEncoder);
    }

    @Test
    void contraEncoder_hasheaYVerificaCorrectamente() {
        ConfigSecurity config = new ConfigSecurity();
        PasswordEncoder encoder = config.contraEncoder();

        String password = "123456";
        String hash = encoder.encode(password);

        assertNotNull(hash);
        assertTrue(encoder.matches(password, hash));
    }

    @Test
    void contraEncoder_hashesSiempreDiferentes() {
        ConfigSecurity config = new ConfigSecurity();
        PasswordEncoder encoder = config.contraEncoder();

        String password = "abc123";

        String hash1 = encoder.encode(password);
        String hash2 = encoder.encode(password);

        assertNotEquals(hash1, hash2);
    }
}
