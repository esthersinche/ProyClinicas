package com.Clinica1.myApp.IAMusuario.infrastructure.persistence.jpa.mapper;

import com.Clinica1.myApp.IAMusuario.infrastructure.persistence.jpa.entity.EmailEmbeddable;
import com.Clinica1.myApp.SharedKernel.Email;
import com.Clinica1.myApp.SharedKernel.IDEntidad;
import com.Clinica1.myApp.SharedKernel.UsuarioWeb;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UsuarioMapperTest {

    private UsuarioMapper mapper;

    @BeforeEach
    void setUp() {
        mapper = new UsuarioMapper(new EmailMapper());
    }

    @Test
    void ToEntity_convierteCorrectamente() {
        IDEntidad id = IDEntidad.generar();
        IDEntidad idEmp = IDEntidad.generar();
        IDEntidad idCli = IDEntidad.generar();

        UsuarioWeb usuario = new UsuarioWeb(
                id,
                Email.of("test@example.com"),
                "HASH123",
                idEmp,
                idCli);

        UsuarioWebEntity entity = mapper.ToEntity(usuario);

        assertNotNull(entity);
        assertEquals(id.obtenerid(), entity.getId_usuweb());
        assertEquals("test@example.com", entity.getCorreo_usuweb().getEmail_valor());
        assertEquals("HASH123", entity.getPasshash());
        assertEquals(idEmp.obtenerid(), entity.getId_emp());
        assertEquals(idCli.obtenerid(), entity.getId_cli());
    }

    @Test
    void ToDomain_convierteCorrectamente() {
        IDEntidad id = IDEntidad.generar();
        IDEntidad idEmp = IDEntidad.generar();
        IDEntidad idCli = IDEntidad.generar();

        UsuarioWebEntity entity = UsuarioWebEntity.builder()
                .id_usuweb(id.obtenerid())
                .correo_usuweb(new EmailEmbeddable("test@example.com"))
                .passhash("HASH123")
                .id_emp(idEmp.obtenerid())
                .id_cli(idCli.obtenerid())
                .build();

        UsuarioWeb usuario = mapper.ToDomain(entity);

        assertNotNull(usuario);
        assertEquals(id.obtenerid(), usuario.getId_usu().obtenerid());
        assertEquals("test@example.com", usuario.getCorreo().email_valor());
        assertEquals("HASH123", usuario.getPasshash());
        assertEquals(idEmp.obtenerid(), usuario.getId_emp().obtenerid());
        assertEquals(idCli.obtenerid(), usuario.getId_cli().obtenerid());
    }

    @Test
    void conversionBidireccional_mantieneValores() {
        IDEntidad id = IDEntidad.generar();
        IDEntidad idEmp = IDEntidad.generar();
        IDEntidad idCli = IDEntidad.generar();

        UsuarioWeb original = new UsuarioWeb(
                id,
                Email.of("test@example.com"),
                "HASH123",
                idEmp,
                idCli);

        UsuarioWebEntity entity = mapper.ToEntity(original);
        UsuarioWeb convertido = mapper.ToDomain(entity);

        assertEquals(original.getId_usu().obtenerid(), convertido.getId_usu().obtenerid());
        assertEquals(original.getCorreo().email_valor(), convertido.getCorreo().email_valor());
        assertEquals(original.getPasshash(), convertido.getPasshash());
        assertEquals(original.getId_emp().obtenerid(), convertido.getId_emp().obtenerid());
        assertEquals(original.getId_cli().obtenerid(), convertido.getId_cli().obtenerid());
    }
}
