package com.Clinica1.myApp.IAMusuario.interfaces.rest.mapper;

import com.Clinica1.myApp.IAMusuario.application.command.LoginCommand;
import com.Clinica1.myApp.IAMusuario.application.dto.EmailDto;
import com.Clinica1.myApp.IAMusuario.interfaces.rest.dto.request.LoginRequest;
import com.Clinica1.myApp.SharedKernel.Empleado;
import com.Clinica1.myApp.IAMusuario.domain.model.aggregates.Rol;
import com.Clinica1.myApp.IAMusuario.domain.model.valueobjects.ContraHash;
import com.Clinica1.myApp.SharedKernel.Email;
import com.Clinica1.myApp.IAMusuario.domain.model.valueobjects.Funcion;
import com.Clinica1.myApp.SharedKernel.UsuarioWeb;
import org.springframework.stereotype.Component;

import java.util.HashSet;

@Component
public class LoginMapper {

    public LoginCommand ToCommand(LoginRequest login_req){
        EmailDto em_dto= EmailDto.builder()
                .email_emp(login_req.getEmail())
                .build();

        return LoginCommand.builder()
                .email_emp(em_dto)
                .contra(login_req.getPassword())
                .build();
    }



    /*public UsuarioWeb toUsuario(CrearUsuarioRequest request) {
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
        ContraHash contraHash = ContraHash.deHash(request.getPassword());

        // UsuarioWeb: también usamos el factory method
        return UsuarioWeb.crearusu(
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
    }*/


}
