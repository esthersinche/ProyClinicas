package com.Clinica1.myApp.IAMusuario.application.handler;

import com.Clinica1.myApp.IAMusuario.application.assembler.TokenAssembler;
import com.Clinica1.myApp.IAMusuario.application.command.ValidarTokenCommand;
import com.Clinica1.myApp.IAMusuario.application.dto.TokenDto;
import com.Clinica1.myApp.IAMusuario.application.services.TokenProvider;
import com.Clinica1.myApp.IAMusuario.domain.repository.EmpleadoRepository;
import com.Clinica1.myApp.mantenimiento.domain.model.aggregates.Empleado;
import com.Clinica1.myApp.SharedKernel.IDEntidad;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ValidarTokenCommandHandler {
    private final TokenProvider tok_prov;
    private final TokenAssembler tok_assem;
    private final EmpleadoRepository emp_repo;

    public TokenDto handle(ValidarTokenCommand valtok_com){
        //validacion
        tok_prov.validartokendeacceso(valtok_com.getToken());

        //parsear los claims, save me lucy heartfilia..
        Map<String, Object> claims_tok= tok_prov.parsear(valtok_com.getToken());
        IDEntidad emp_id= IDEntidad.astring(claims_tok.get("id_emp").toString());

        List<String> funcioneslist= (List<String>)claims_tok.get("funciones");
        long expiracion= (long)claims_tok.get("exp");

        //empleado
        Empleado emp= emp_repo.findById(emp_id)
                .orElseThrow(() -> new RuntimeException("Empleado not found"));

        return tok_assem.ToDto(emp, valtok_com.getToken(), expiracion, funcioneslist);


    }


}
