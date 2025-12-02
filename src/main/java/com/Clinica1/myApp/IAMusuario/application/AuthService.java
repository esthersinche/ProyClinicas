package com.Clinica1.myApp.IAMusuario.application;


import com.Clinica1.myApp.IAMusuario.application.dto.TokenDto;
import com.Clinica1.myApp.IAMusuario.application.services.ContraService;
import com.Clinica1.myApp.IAMusuario.domain.repository.EmpleadoRepository;
import com.Clinica1.myApp.IAMusuario.domain.repository.UsuarioRepository;
import com.Clinica1.myApp.IAMusuario.interfaces.rest.dto.request.LoginRequest;
import com.Clinica1.myApp.IAMusuario.interfaces.rest.dto.response.TokenResponse;
import com.Clinica1.myApp.IAMusuario.domain.exception.CredencialesInvalidasException;
import com.Clinica1.myApp.SharedKernel.UsuarioWeb;
import org.springframework.stereotype.Service;


@Service
public class AuthService {

    private final UsuarioRepository usuweb_repo;
    private final EmpleadoRepository emp_repo;
    private final ContraService con_serv;
    private final TokenProvider tok_prov;

    //inyeccion
    public AuthService(UsuarioRepository usuweb_repo, EmpleadoRepository emp_repo, ContraService con_serv, TokenProvider tok_prov) {
        this.usuweb_repo = usuweb_repo;
        this.emp_repo = emp_repo;
        this.con_serv = con_serv;
        this.tok_prov = tok_prov;
    }

    public TokenResponse loging(LoginRequest comm){

    }
    /*public TokenResponse login(LoginRequest command) {
        UsuarioWeb usu= usuarioRepository.findbyUsername(command.username())
                .orElseThrow(() -> new CredencialesInvalidasException("UsuarioWeb no encontrado"));

        if (!usu.getPasshash().getValor_contra_hash().equals(command.password())) {
            throw new CredencialesInvalidasException("Contraseña inválida");
        }


        return new TokenDto("token-ejemplo", 3600);
    }*/




}