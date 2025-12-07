package com.Clinica1.myApp.IAMusuario.interfaces.rest.mapper;

import com.Clinica1.myApp.IAMusuario.application.command.PermisosEmpleadosCommand;
import com.Clinica1.myApp.IAMusuario.interfaces.rest.dto.request.PermisosEmpleadosRequest;
import com.Clinica1.myApp.SharedKernel.IDEntidad;
import org.springframework.stereotype.Component;

@Component
public class PermisosEmpleadoMapper {

    public PermisosEmpleadosCommand ToCommand(PermisosEmpleadosRequest peremp_req){
        return PermisosEmpleadosCommand.builder()
                .id_emp(IDEntidad.astring(peremp_req.getId_emp()))
                .build();
    }
}
