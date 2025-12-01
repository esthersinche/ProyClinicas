package com.Clinica1.myApp.IAMusuario.mapper;

import com.Clinica1.myApp.IAMusuario.infrastructure.persistence.jpa.entity.EmpleadoEntity;
import com.Clinica1.myApp.IAMusuario.infrastructure.persistence.jpa.entity.RolEntity;
import com.Clinica1.myApp.IAMusuario.infrastructure.persistence.jpa.entity.UsuarioEntity;
import com.Clinica1.myApp.IAMusuario.infrastructure.persistence.jpa.mapper.UsuarioMapper;
import com.Clinica1.myApp.SharedKernel.Empleado;
import com.Clinica1.myApp.IAMusuario.domain.model.aggregates.Rol;
import com.Clinica1.myApp.IAMusuario.domain.model.valueobjects.ContraHash;
import com.Clinica1.myApp.SharedKernel.Email;
import com.Clinica1.myApp.IAMusuario.domain.model.valueobjects.Funcion;
import com.Clinica1.myApp.SharedKernel.IDEntidad;

import com.Clinica1.myApp.SharedKernel.UsuarioWeb;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class UsuarioWebMapperTest {

    private UsuarioMapper mapper;

    @BeforeEach
    void setUp() {
        mapper = new UsuarioMapper();
    }

    @Test
    void testToEntity() {
        HashSet<Funcion> funciones = new HashSet<>();
        funciones.add(Funcion.of("CREAR"));
        funciones.add(Funcion.of("ELIMINAR"));

        Rol rol = new Rol(
                IDEntidad.generar(),
                "Administrador",
                funciones);

        Empleado empleado = new Empleado(
                IDEntidad.generar(),
                "Luis",
                "Ramos",
                "999888777",
                Email.of("luis@test.com"),
                rol);

        UsuarioWeb usuarioWeb = new UsuarioWeb(
                IDEntidad.generar(),
                "user123",
                ContraHash.deHash("123456"),
                empleado);

        UsuarioEntity entity = mapper.toEntity(usuarioWeb);

        assertNotNull(entity);
        assertEquals(usuarioWeb.getId_usu().obtenerid(), entity.getIdEmp());
        assertEquals("user123", entity.getUsername());
        assertEquals(usuarioWeb.getPasshash().getValor_contra_hash(), entity.getPass());

        assertNotNull(entity.getEmpleado());
        assertEquals(empleado.getNombre(), entity.getEmpleado().getNombresEmp());
        assertEquals("luis@test.com", entity.getEmpleado().getEmailEmp());

        RolEntity rolEntity = entity.getEmpleado().getRol();
        assertNotNull(rolEntity);
        assertEquals("Administrador", rolEntity.getNombreRol());
        assertTrue(rolEntity.getFunciones().contains("CREAR"));
        assertTrue(rolEntity.getFunciones().contains("ELIMINAR"));
    }

    @Test
    void testToDomain() {

        RolEntity rolEntity = new RolEntity();
        rolEntity.setId(IDEntidad.generar().obtenerid());
        rolEntity.setNombreRol("Doctor");

        Set<String> funciones = new HashSet<>();
        funciones.add("ATENDER");
        funciones.add("RECETAR");

        rolEntity.setFunciones(funciones);

        EmpleadoEntity empEntity = new EmpleadoEntity();
        empEntity.setIdEmp("EMP001");
        empEntity.setNombresEmp("Carlos");
        empEntity.setApellidosEmp("Perez");
        empEntity.setTelefonoEmp("111222333");
        empEntity.setEmailEmp("carlos@mail.com");
        empEntity.setRol(rolEntity);

        UsuarioEntity usuarioEntity = new UsuarioEntity();
        usuarioEntity.setIdEmp("EMP001");
        usuarioEntity.setUsername("carlosUser");
        usuarioEntity.setPass("HASHED123");
        usuarioEntity.setEmpleado(empEntity);

        UsuarioWeb domain = mapper.toDomain(usuarioEntity);

        assertNotNull(domain);
        assertEquals("EMP001", domain.getId_usu().obtenerid());
        assertEquals("carlosUser", domain.getUsername());
        assertEquals("HASHED123", domain.getPasshash().getValor_contra_hash());

        Empleado emp = domain.getEmp();
        assertNotNull(emp);
        assertEquals("Carlos", emp.getNombre());
        assertEquals("Perez", emp.getApellido());
        assertEquals("111222333", emp.getTelefono());
        assertEquals("carlos@mail.com", emp.getEmail().email_valor());

        Rol rol = emp.getRolemp();
        assertNotNull(rol);
        assertEquals("Doctor", rol.getNombrerol());
        assertEquals(2, rol.getFunciones().size());
        assertTrue(
                rol.getFunciones().stream()
                        .anyMatch(f -> f.getNombre_fun().equals("ATENDER")));
    }

    @Test
    void testToEntityNull() {
        assertNull(mapper.toEntity(null));
    }

    @Test
    void testToDomainNull() {
        assertNull(mapper.toDomain(null));
    }
}
