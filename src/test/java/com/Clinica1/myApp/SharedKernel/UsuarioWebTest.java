package com.Clinica1.myApp.SharedKernel;

import com.Clinica1.myApp.adquisicion.domain.model.UsuarioWeb;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UsuarioWebTest {

    @Test
    void deberiaCrearUsuarioConConstructor() {
        IDEntidad idUsu = IDEntidad.generar();
        IDEntidad idEmp = IDEntidad.generar();
        IDEntidad idCli = IDEntidad.generar();
        Email correo = Email.of("usuario@test.com");

        UsuarioWeb usuario = new UsuarioWeb(idUsu, correo, "hash123", idEmp, idCli);

        assertEquals(idUsu, usuario.getId_usu());
        assertEquals(correo, usuario.getCorreo());
        assertEquals("hash123", usuario.getPasshash());
        assertEquals(idEmp, usuario.getId_emp());
        assertEquals(idCli, usuario.getId_cli());
    }

    @Test
    void deberiaCrearUsuarioConFactoryMethod() {
        IDEntidad idEmp = IDEntidad.generar();
        IDEntidad idCli = IDEntidad.generar();
        Email correo = Email.of("factory@test.com");

        UsuarioWeb usuario = UsuarioWeb.crearusu(correo, "passHash", idEmp, idCli);

        assertNotNull(usuario.getId_usu());
        assertEquals(correo, usuario.getCorreo());
        assertEquals("passHash", usuario.getPasshash());
        assertEquals(idEmp, usuario.getId_emp());
        assertEquals(idCli, usuario.getId_cli());
    }

    @Test
    void usuariosConMismoIdSonIguales() {
        IDEntidad id = IDEntidad.generar();
        IDEntidad idEmp = IDEntidad.generar();
        IDEntidad idCli = IDEntidad.generar();
        Email correo = Email.of("a@test.com");

        UsuarioWeb u1 = new UsuarioWeb(id, correo, "h1", idEmp, idCli);
        UsuarioWeb u2 = new UsuarioWeb(id, correo, "h1", idEmp, idCli);

        assertEquals(u1, u2);
        assertEquals(u1.hashCode(), u2.hashCode());
    }

    @Test
    void usuariosConIdsDiferentesNoSonIguales() {
        Email correo = Email.of("b@test.com");

        UsuarioWeb u1 = new UsuarioWeb(IDEntidad.generar(), correo, "x", IDEntidad.generar(), IDEntidad.generar());
        UsuarioWeb u2 = new UsuarioWeb(IDEntidad.generar(), correo, "x", IDEntidad.generar(), IDEntidad.generar());

        assertNotEquals(u1, u2);
    }
}
