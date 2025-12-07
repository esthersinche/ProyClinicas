package com.Clinica1.myApp.IAMusuario.interfaces.rest.mapper;

import com.Clinica1.myApp.IAMusuario.application.command.LogoutCommand;
import com.Clinica1.myApp.IAMusuario.interfaces.rest.dto.request.LogoutRequest;
import com.Clinica1.myApp.SharedKernel.IDEntidad;
import org.springframework.stereotype.Component;

@Component
public class LogoutMapper {

    public LogoutCommand ToCommand(LogoutRequest logout_req){
        return LogoutCommand.builder()
                .id_ses(IDEntidad.astring(logout_req.getId_ses()))
                .build();
    }
}
