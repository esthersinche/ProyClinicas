package com.Clinica1.myApp.IAMusuario.domain.interfaces.rest.mapper;

import com.Clinica1.myApp.IAMusuario.domain.interfaces.rest.dto.request.CrearUsuarioRequest;
import com.Clinica1.myApp.IAMusuario.domain.model.aggregates.Empleado;
import com.Clinica1.myApp.IAMusuario.domain.model.aggregates.Rol;
import com.Clinica1.myApp.IAMusuario.domain.model.aggregates.Usuario;
import com.Clinica1.myApp.IAMusuario.domain.model.valueobjects.ContraHash;
import com.Clinica1.myApp.IAMusuario.domain.model.valueobjects.Email;
import com.Clinica1.myApp.IAMusuario.domain.model.valueobjects.Funcion;
import org.springframework.stereotype.Component;

import java.util.HashSet;

@Component
public class UsuarioRequestMapper {

    public Usuario toUsuario(CrearUsuarioRequest request) {
        // Email VO
        Email email = Email.of(request.getEmail());

        // Rol de dominio (por ahora sin funciones, salvo casos especiales)
        Rol rol = mapRolFromString(request.getRol());

        // Empleado: usamos el factory method del aggregate
        Empleado empleado = Empleado.crearemp(
                request.getNombres(),
                request.getApellidos(),
                request.getTelefono(),
                email,
                rol);

        // Contraseña: VO ContraHash (aquí todavía no estamos aplicando BCrypt, solo
        // envolvemos)
        ContraHash contraHash = ContraHash.hasheandocB(request.getPassword());

        // Usuario: también usamos el factory method
        return Usuario.crearusu(
                request.getUsername(),
                contraHash,
                empleado);
    }

    private Rol mapRolFromString(String rolNombre) {
        if (rolNombre == null) {
            return Rol.crearrol("SIN_ROL", new HashSet<>());
        }

        // Si es Doctor, usamos el estático que ya definieron
        if (rolNombre.equalsIgnoreCase("Doctor")) {
            return Rol.doctor;
        }

        // Para otros roles creamos uno nuevo sin funciones (se puede mejorar después)
        return Rol.crearrol(rolNombre, new HashSet<Funcion>());
    }
}
