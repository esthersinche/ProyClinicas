package com.Clinica1.myApp.IAMusuario.application.services;


import com.Clinica1.myApp.IAMusuario.application.command.LoginCommand;
import com.Clinica1.myApp.IAMusuario.application.dto.TokenDto;
import com.Clinica1.myApp.IAMusuario.domain.repository.EmpleadoRepository;
import com.Clinica1.myApp.IAMusuario.domain.repository.SesionRepository;
import com.Clinica1.myApp.IAMusuario.domain.repository.UsuarioRepository;
import org.springframework.stereotype.Service;


@Service
public class AuthService {

    private final UsuarioRepository usuweb_repo;
    private final UsuarioWebRepositoryService usuweb_repo_serv;
    private final EmpleadoRepository emp_repo;
    private final ContraService con_serv;
    private final TokenProvider tok_prov;
    private final SesionRepository ses_repo;
    private final SesionRepositoryService ses_repo_serv;

    //inyeccion


    public AuthService(UsuarioRepository usuweb_repo, UsuarioWebRepositoryService usuweb_repo_serv, EmpleadoRepository emp_repo,
                       ContraService con_serv, TokenProvider tok_prov, SesionRepository ses_repo, SesionRepositoryService ses_repo_serv) {
        this.usuweb_repo = usuweb_repo;
        this.usuweb_repo_serv = usuweb_repo_serv;
        this.emp_repo = emp_repo;
        this.con_serv = con_serv;
        this.tok_prov = tok_prov;
        this.ses_repo = ses_repo;
        this.ses_repo_serv = ses_repo_serv;
    }

    public TokenDto login(LoginCommand log_com){

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