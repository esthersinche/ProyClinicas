package com.Clinica1.myApp.IAMusuario.application;


import com.Clinica1.myApp.IAMusuario.application.dto.TokenDto;
import com.Clinica1.myApp.IAMusuario.application.services.ContraService;
import com.Clinica1.myApp.IAMusuario.domain.repository.UsuarioRepository;
import com.Clinica1.myApp.IAMusuario.interfaces.rest.dto.request.LoginRequest;
import com.Clinica1.myApp.IAMusuario.interfaces.rest.dto.response.TokenResponse;
import com.Clinica1.myApp.IAMusuario.domain.exception.CredencialesInvalidasException;
import com.Clinica1.myApp.SharedKernel.UsuarioWeb;
import org.springframework.stereotype.Service;


@Service
public class AuthService {

    private final UsuarioRepository usuarioRepository;
    private final ContraService con_serv;

    //inyeccion


    public AuthService(UsuarioRepository usuarioRepository, ContraService con_serv) {
        this.usuarioRepository = usuarioRepository;
        this.con_serv = con_serv;
    }

    public TokenResponse login(LoginRequest command) {
        UsuarioWeb usu= usuarioRepository.findbyUsername(command.username())
                .orElseThrow(() -> new CredencialesInvalidasException("UsuarioWeb no encontrado"));

        if (!usu.getPasshash().getValor_contra_hash().equals(command.password())) {
            throw new CredencialesInvalidasException("Contraseña inválida");
        }


        return new TokenDto("token-ejemplo", 3600);
    }


}