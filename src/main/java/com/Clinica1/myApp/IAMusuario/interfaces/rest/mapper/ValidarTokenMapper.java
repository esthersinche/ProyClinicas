package com.Clinica1.myApp.IAMusuario.interfaces.rest.mapper;

import com.Clinica1.myApp.IAMusuario.application.command.ValidarTokenCommand;
import com.Clinica1.myApp.IAMusuario.interfaces.rest.dto.request.ValidarTokenRequest;
import org.springframework.stereotype.Component;

@Component
public class ValidarTokenMapper {

    public ValidarTokenCommand ToCommand(ValidarTokenRequest valtok_req){
        return ValidarTokenCommand.builder()
                .token(valtok_req.getToken())
                .build();
    }
}
