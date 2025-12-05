package com.Clinica1.myApp.IAMusuario.application.handler;

import com.Clinica1.myApp.IAMusuario.application.command.PermisosEmpleadosCommand;
import com.Clinica1.myApp.IAMusuario.application.exception.UserNotFoundException;
import com.Clinica1.myApp.IAMusuario.application.services.EmpleadoRepositoryService;
import com.Clinica1.myApp.IAMusuario.application.services.RolRepositoryService;
import com.Clinica1.myApp.IAMusuario.domain.model.valueobjects.Funcion;
import com.Clinica1.myApp.SharedKernel.Empleado;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PermisosEmpleadosCommandHandler{
    private final EmpleadoRepositoryService emp_repo_serv;
    private final RolRepositoryService rol_repo_serv;

    public List<String> obtenerFunciones(PermisosEmpleadosCommand peremp_com){

        //busca al empleado por el id
        Optional<Empleado> fantasmitaemp= emp_repo_serv.findById(peremp_com.getId_emp().obtenerid());
        Empleado emp= fantasmitaemp.orElseThrow(() ->
                new UserNotFoundException("Empleado no encontrado"));

        //obtiene roles desde el empleado en string
        String rol_emp= emp.getRolemp().name();

        Set<Funcion> funcionesemp= rol_repo_serv.findFuncionesByNombreRol(rol_emp);

        //mapear
        List<String> funcionesempstring= funcionesemp.stream()
                .map(Funcion::getNombre_fun)
                .distinct()
                .sorted()
                .collect(Collectors.toList());

        return funcionesempstring;


    }
}
