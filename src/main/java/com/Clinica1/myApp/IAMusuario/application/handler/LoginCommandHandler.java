package com.Clinica1.myApp.IAMusuario.application.handler;

import com.Clinica1.myApp.IAMusuario.application.assembler.EmailAssembler;
import com.Clinica1.myApp.IAMusuario.application.assembler.EmpleadoAssembler;
import com.Clinica1.myApp.IAMusuario.application.assembler.SesionAssembler;
import com.Clinica1.myApp.IAMusuario.application.command.LoginCommand;
import com.Clinica1.myApp.IAMusuario.application.dto.SesionDto;
import com.Clinica1.myApp.IAMusuario.application.dto.TokenDto;
import com.Clinica1.myApp.IAMusuario.application.exception.InvalidCredentialsException;
import com.Clinica1.myApp.IAMusuario.application.services.*;
import com.Clinica1.myApp.IAMusuario.domain.model.aggregates.EmpleadoIAM;
import com.Clinica1.myApp.IAMusuario.domain.model.aggregates.Sesion;
import com.Clinica1.myApp.IAMusuario.domain.model.valueobjects.Funcion;
import com.Clinica1.myApp.IAMusuario.domain.repository.EmpleadoRepository;
import com.Clinica1.myApp.IAMusuario.domain.repository.RolRepository;
import com.Clinica1.myApp.IAMusuario.domain.repository.SesionRepository;
import com.Clinica1.myApp.mantenimiento.domain.model.aggregates.Empleado;
import com.Clinica1.myApp.SharedKernel.IDEntidad;
import com.Clinica1.myApp.SharedKernel.Roles;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LoginCommandHandler{
    private final EmpleadoRepository emp_repo;
    private final TokenProvider tok_prov;
    private final SesionRepository ses_repo;
    private final SesionAssembler ses_assem;
    private final RolRepository rol_repo;

    //validaciones
    private void validar(LoginCommand log_com_val){
        if (log_com_val.getEmail_emp() == null || log_com_val.getEmail_emp().getEmail_emp().isBlank()){
            throw new InvalidCredentialsException("Credenciales invalidas");
        }

        if (log_com_val.getContra() == null || log_com_val.getContra().isBlank()){
            throw new InvalidCredentialsException("Credenciales invalidas");
        }

    }
    @Transactional
    public TokenDto handle(LoginCommand log_com){
        validar(log_com);


        //buscar usuarioweb(1)/empleado por email
        Optional<EmpleadoIAM> fantasmitaemp= emp_repo.validaryobtenerporemail(log_com.getEmail_emp().getEmail_emp(),
                log_com.getContra());

        EmpleadoIAM emp= fantasmitaemp.orElseThrow(() ->
                new InvalidCredentialsException("Credenciales invalidas"));

        /*//ver lo de la contraseña
        String hashguardado= emp.getPasshash_emp();
        if (!con_serv.matches(log_com.getContra(), hashguardado)){
            throw new InvalidCredentialsException("Credenciales invalidas");
        }*/


        //rol
        Roles rolemp_ses= emp.getRol_empiam();


        //obtener token
        TokenDto token_dto= tok_prov.generartokendeacceso(emp);

        //funciones
        Set<Funcion> funciones= rol_repo.findFuncionesByNombre(rolemp_ses);
        List<String> funcioneslistaemp= funciones.stream().map(Funcion::getNombre_fun)
                .collect(Collectors.toList());

        //builder
        TokenDto tok_dto_zoetrope= TokenDto.builder()
                .accesstoken(token_dto.getAccesstoken())
                .id_emp(token_dto.getId_emp())
                .expiracion(token_dto.getExpiracion())
                .funciones(funcioneslistaemp)
                .build();


        //persistencia my beloathed, por si se necesita persistir en el futuro
        if (ses_repo != null){
            Instant ahoracausa= Instant.now();
            Instant expirarcausa= ahoracausa.plusSeconds(token_dto.getExpiracion());
            SesionDto ses_dto= new SesionDto(IDEntidad.generar().obtenerid(), emp.getId_empiam().obtenerid(),
                    ahoracausa, expirarcausa);
            Sesion ses_saved= ses_assem.ToDomain(ses_dto);
            ses_repo.insert(ses_saved);
        }

        //final dto


        return tok_dto_zoetrope;
    }
}
