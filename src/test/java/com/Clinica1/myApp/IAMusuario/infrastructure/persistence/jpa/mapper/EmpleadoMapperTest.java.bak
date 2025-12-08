package com.Clinica1.myApp.IAMusuario.infrastructure.persistence.jpa.mapper;

import com.Clinica1.myApp.IAMusuario.infrastructure.persistence.jpa.entity.EmailEmbeddable;
import com.Clinica1.myApp.IAMusuario.infrastructure.persistence.jpa.entity.EmpleadoEntity;
import com.Clinica1.myApp.SharedKernel.Email;
import com.Clinica1.myApp.SharedKernel.Empleado;
import com.Clinica1.myApp.SharedKernel.IDEntidad;
import com.Clinica1.myApp.SharedKernel.Roles;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class EmpleadoMapperTest {

    private EmailMapper emailMapper;
    private RolMapper rolMapper;
    private EmpleadoMapper mapper;

    @BeforeEach
    void setup() {
        emailMapper = mock(EmailMapper.class);
        rolMapper = mock(RolMapper.class);
        mapper = new EmpleadoMapper(emailMapper, rolMapper);
    }

    @Test
    void ToDomain_convierteCorrectamente() {
        EmailEmbeddable emb = new EmailEmbeddable("correo@dominio.com");
        Email email = new Email("correo@dominio.com");

        EmpleadoEntity entity = EmpleadoEntity.builder()
                .id_Emp("EMP123")
                .nombresEmp("Luis")
                .apellidosEmp("Ramos")
                .telefonoEmp("987654321")
                .email_emp(emb)
                .rol(Roles.Rol_Doctor)
                .build();

        when(emailMapper.ToDomain(emb)).thenReturn(email);

        Empleado emp = mapper.ToDomain(entity);

        assertNotNull(emp);
        assertEquals("EMP123", emp.getId_emp().obtenerid());
        assertEquals("Luis", emp.getNombre());
        assertEquals("Ramos", emp.getApellido());
        assertEquals("987654321", emp.getTelefono());
        assertEquals(email, emp.getEmail());
        assertEquals(Roles.Rol_Doctor, emp.getRolemp());
    }

    @Test
    void ToEntity_convierteCorrectamente() {
        Email email = new Email("mail@test.com");
        EmailEmbeddable emb = new EmailEmbeddable("mail@test.com");

        Empleado emp = new Empleado(
                IDEntidad.astring("EMP777"),
                "Ana",
                "Pérez",
                "900111222",
                email,
                Roles.Rol_Admin);

        when(emailMapper.ToEmbeddable(email)).thenReturn(emb);

        EmpleadoEntity entity = mapper.ToEntity(emp);

        assertNotNull(entity);
        assertEquals("EMP777", entity.getId_Emp());
        assertEquals("Ana", entity.getNombresEmp());
        assertEquals("Pérez", entity.getApellidosEmp());
        assertEquals("900111222", entity.getTelefonoEmp());
        assertEquals(emb, entity.getEmail_emp());
        assertEquals(Roles.Rol_Admin, entity.getRol());
    }

    @Test
    void conversionBidireccional_mantieneDatos() {
        Email email = new Email("dual@test.com");
        EmailEmbeddable emb = new EmailEmbeddable("dual@test.com");

        Empleado original = new Empleado(
                IDEntidad.astring("EMP999"),
                "Carlos",
                "Lopez",
                "955000111",
                email,
                Roles.Rol_Doctor);

        when(emailMapper.ToEmbeddable(email)).thenReturn(emb);
        when(emailMapper.ToDomain(emb)).thenReturn(email);

        EmpleadoEntity entity = mapper.ToEntity(original);
        Empleado resultado = mapper.ToDomain(entity);

        assertEquals(original.getNombre(), resultado.getNombre());
        assertEquals(original.getApellido(), resultado.getApellido());
        assertEquals(original.getTelefono(), resultado.getTelefono());
        assertEquals(original.getEmail(), resultado.getEmail());
        assertEquals(original.getRolemp(), resultado.getRolemp());
    }
}
