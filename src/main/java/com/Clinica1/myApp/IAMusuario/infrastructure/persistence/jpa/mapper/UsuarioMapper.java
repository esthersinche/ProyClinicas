package com.Clinica1.myApp.IAMusuario.infrastructure.persistence.jpa.mapper;

import com.Clinica1.myApp.IAMusuario.infrastructure.persistence.jpa.entity.EmpleadoEntity;
import com.Clinica1.myApp.IAMusuario.infrastructure.persistence.jpa.entity.RolEntity;
import com.Clinica1.myApp.IAMusuario.infrastructure.persistence.jpa.entity.UsuarioEntity;
import com.Clinica1.myApp.SharedKernel.Empleado;
import com.Clinica1.myApp.IAMusuario.domain.model.aggregates.Rol;
import com.Clinica1.myApp.SharedKernel.Usuario;
import com.Clinica1.myApp.IAMusuario.domain.model.valueobjects.ContraHash;
import com.Clinica1.myApp.IAMusuario.domain.model.valueobjects.Email;
import com.Clinica1.myApp.IAMusuario.domain.model.valueobjects.Funcion;
import com.Clinica1.myApp.SharedKernel.IDEntidad;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class UsuarioMapper {

    /* ===================== USUARIO ===================== */

    public UsuarioEntity toEntity(Usuario usuario) {
        if (usuario == null)
            return null;

        UsuarioEntity entity = new UsuarioEntity();

        entity.setIdEmp(usuario.getId_usu().obtenerid());
        entity.setUsername(usuario.getUsername());
        entity.setPass(usuario.getPasshash().getValor_contra_hash());

        EmpleadoEntity empleadoEntity = toEmpleadoEntity(usuario.getEmp());
        entity.setEmpleado(empleadoEntity);

        return entity;
    }

    public Usuario toDomain(UsuarioEntity entity) {
        if (entity == null)
            return null;

        Empleado empleado = toEmpleadoDomain(entity.getEmpleado());

        return new Usuario(
                IDEntidad.astring(entity.getIdEmp()),
                entity.getUsername(),
                ContraHash.hasheandocB(entity.getPass()),
                empleado);
    }

    /* ===================== EMPLEADO ===================== */

    private EmpleadoEntity toEmpleadoEntity(Empleado empleado) {
        if (empleado == null)
            return null;

        EmpleadoEntity entity = new EmpleadoEntity();
        entity.setIdEmp(empleado.getId_emp().obtenerid());
        entity.setNombresEmp(empleado.getNombre());
        entity.setApellidosEmp(empleado.getApellido());
        entity.setTelefonoEmp(empleado.getTelefono());
        entity.setEmailEmp(empleado.getEmail().email_valor());
        entity.setRol(toRolEntity(empleado.getRolemp()));

        return entity;
    }

    private Empleado toEmpleadoDomain(EmpleadoEntity entity) {
        if (entity == null)
            return null;

        Rol rol = toRolDomain(entity.getRol());

        return new Empleado(
                IDEntidad.astring(entity.getIdEmp()),
                entity.getNombresEmp(),
                entity.getApellidosEmp(),
                entity.getTelefonoEmp(),
                Email.of(entity.getEmailEmp()),
                rol);
    }

    /* ===================== ROL ===================== */

    private RolEntity toRolEntity(Rol rol) {
        if (rol == null)
            return null;

        RolEntity entity = new RolEntity();
        entity.setId(rol.getId_rol().obtenerid());
        entity.setNombreRol(rol.getNombrerol());

        Set<String> funciones = rol.getFunciones()
                .stream()
                .map(Funcion::getNombre_fun)
                .collect(Collectors.toSet());

        entity.setFunciones(funciones);
        return entity;
    }

    private Rol toRolDomain(RolEntity entity) {
        if (entity == null)
            return null;

        HashSet<Funcion> funciones = entity.getFunciones()
                .stream()
                .map(Funcion::of)
                .collect(Collectors.toCollection(HashSet::new));

        return new Rol(
                IDEntidad.astring(entity.getId()),
                entity.getNombreRol(),
                funciones);
    }
}
