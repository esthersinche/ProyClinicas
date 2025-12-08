package com.Clinica1.myApp.IAMusuario.infrastructure.persistence.jpa.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UsuarioWebEntityTest {

    @Test
    void constructorYGetters_funcionanCorrectamente() {

        EmailEmbeddable email = new EmailEmbeddable("correo@test.com");

        UsuarioWebEntity usuario = new UsuarioWebEntity(
                "USER123",
                email,
                "HASHEDPASS",
                "EMP001",
                "CLI900");

        assertEquals("USER123", usuario.getId_usuweb());
        assertEquals(email, usuario.getCorreo_usuweb());
        assertEquals("HASHEDPASS", usuario.getPasshash());
        assertEquals("EMP001", usuario.getId_emp());
        assertEquals("CLI900", usuario.getId_cli());
    }

    @Test
    void builder_creaInstanciaCorrecta() {

        EmailEmbeddable email = new EmailEmbeddable("mail@site.com");

        UsuarioWebEntity usuario = UsuarioWebEntity.builder()
                .id_usuweb("USER777")
                .correo_usuweb(email)
                .passhash("PASS123HASH")
                .id_emp("EMP789")
                .id_cli("CLI123")
                .build();

        assertEquals("USER777", usuario.getId_usuweb());
        assertEquals(email, usuario.getCorreo_usuweb());
        assertEquals("PASS123HASH", usuario.getPasshash());
        assertEquals("EMP789", usuario.getId_emp());
        assertEquals("CLI123", usuario.getId_cli());
    }

    @Test
    void getters_noDevuelvenValoresNulosCuandoAsignados() {

        EmailEmbeddable email = new EmailEmbeddable("test@mail.com");

        UsuarioWebEntity usuario = new UsuarioWebEntity(
                "A1",
                email,
                "HASHED",
                "EMPX",
                "CLIX");

        assertNotNull(usuario.getId_usuweb());
        assertNotNull(usuario.getCorreo_usuweb());
        assertNotNull(usuario.getPasshash());
        assertNotNull(usuario.getId_emp());
        assertNotNull(usuario.getId_cli());
    }
}
