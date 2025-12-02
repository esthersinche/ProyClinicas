package com.Clinica1.myApp.IAMusuario.application.handler;

import com.Clinica1.myApp.IAMusuario.application.command.LoginCommand;
import com.Clinica1.myApp.IAMusuario.application.dto.SesionDto;
import com.Clinica1.myApp.IAMusuario.application.dto.TokenDto;
import com.Clinica1.myApp.IAMusuario.application.exception.InvalidCredentialsException;
import com.Clinica1.myApp.IAMusuario.application.services.*;
import com.Clinica1.myApp.SharedKernel.Empleado;
import com.Clinica1.myApp.SharedKernel.IDEntidad;
import com.Clinica1.myApp.SharedKernel.UsuarioWeb;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.*;

@Service
@RequiredArgsConstructor
public class LoginCommandHandler implements LoginService {
    private final UsuarioWebRepositoryService usuweb_repo_serv;
    private final EmpleadoRepositoryService emp_repo_serv;
    private final ContraService con_serv;
    private final TokenProvider tok_prov;
    private final SesionRepositoryService ses_repo_serv;

    //validaciones
    private void validar(LoginCommand log_com_val){
        if (log_com_val.getEmail_emp() == null || log_com_val.getEmail_emp().isBlank()){
            throw new InvalidCredentialsException("Credenciales invalidas");
        }

        if (log_com_val.getContra() == null || log_com_val.getContra().isBlank()){
            throw new InvalidCredentialsException("Credenciales invalidas");
        }

    }
    @Override
    @Transactional
    public TokenDto login(LoginCommand log_com){
        validar(log_com);

        //buscar usuarioweb(1)/empleado por email
        Optional<Empleado> fantasmitaemp= emp_repo_serv.findbyEmail(log_com.getEmail_emp());

        Empleado emp= fantasmitaemp.orElseThrow(() ->
                new InvalidCredentialsException("Credenciales invalidas"));

        //ver lo de la contraseña
        String hashguardado= emp.getPasshash_emp();
        if (!con_serv.matches(log_com.getContra(), hashguardado)){
            throw new InvalidCredentialsException("Credenciales invalidas");
        }

        //roles
        List<String> roles= new ArrayList<>();
        if (emp.getRolemp() != null){
            roles.add(emp.getRolemp().name());
        }

        //ver si es usuarioweb yay or nay para claims
        Map<String, Object> claims= new HashMap<>();
        Optional<UsuarioWeb> usuweb= usuweb_repo_serv.findById_Emp(emp.getId_emp().obtenerid());
        if (usuweb.isPresent()){
            UsuarioWeb usuweb2= usuweb.get();
            if (usuweb2.getId_cli() != null){
                claims.put("id_cli", usuweb2.getId_cli().obtenerid());
            }
        }

        //obtener token
        TokenDto token_dto= tok_prov.generartokendeacceso(emp);

        //persistencia my beloathed
        if (ses_repo_serv != null){
            Instant ahoracausa= Instant.now();
            Instant expirarcausa= ahoracausa.plusSeconds(token_dto.getExpiracion());
            SesionDto ses_dto= new SesionDto(IDEntidad.generar().obtenerid(), emp.getId_emp().obtenerid(),
                    ahoracausa, expirarcausa);
        }

        return token_dto;
    }
}
