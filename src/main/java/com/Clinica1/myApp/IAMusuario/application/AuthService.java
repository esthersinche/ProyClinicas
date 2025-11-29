package com.Clinica1.myApp.IAMusuario.application;


import com.Clinica1.myApp.SharedKernel.Usuario;
import com.Clinica1.myApp.IAMusuario.domain.repository.UsuarioRepository;
import com.Clinica1.myApp.IAMusuario.interfaces.rest.dto.request.LoginRequest;
import com.Clinica1.myApp.IAMusuario.interfaces.rest.dto.response.TokenResponse;
import com.Clinica1.myApp.IAMusuario.domain.exception.CredencialesInvalidasException;
import org.springframework.stereotype.Service;


@Service
public class AuthService {

    private final UsuarioRepository usuarioRepository;

    //inyeccion
    public AuthService(UsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
    }


    public TokenResponse login(LoginRequest command) {
        Usuario usu = usuarioRepository.findbyUsername(command.username())
                .orElseThrow(() -> new CredencialesInvalidasException("Usuario no encontrado"));


        if (!usu.getPasshash().getValor_contra_hash().equals(command.password())) {
            throw new CredencialesInvalidasException("Contraseña inválida");
        }


        return new TokenDto("token-ejemplo", 3600);
    }


}