package com.Clinica1.myApp.IAMusuario.application.handler;

import com.Clinica1.myApp.IAMusuario.application.command.PermisosEmpleadosCommand;
import com.Clinica1.myApp.IAMusuario.application.dto.FuncionesDto;
import com.Clinica1.myApp.IAMusuario.application.exception.UserNotFoundException;
import com.Clinica1.myApp.IAMusuario.application.services.EmpleadoRepositoryService;
import com.Clinica1.myApp.IAMusuario.application.services.PermisosEmpleadoService;
import com.Clinica1.myApp.IAMusuario.application.services.RolRepositoryService;
import com.Clinica1.myApp.SharedKernel.Empleado;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PermisosEmpleadosCommandHandler implements PermisosEmpleadoService {
    private final EmpleadoRepositoryService emp_repo_serv;
    private final RolRepositoryService rol_repo_serv;

    @Override
    public FuncionesDto obtenerFunciones(PermisosEmpleadosCommand peremp_com){

        Optional<Empleado> fantasmitaemp= emp_repo_serv.findById(peremp_com.getId_emp().obtenerid());
        Empleado emp= fantasmitaemp.orElseThrow(() ->
                new UserNotFoundException("Empleado no encontrado"));

        //roles..
        
    }
}
