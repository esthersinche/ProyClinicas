package com.Clinica1.myApp.IAMusuario.application.handler;

import com.Clinica1.myApp.IAMusuario.application.command.PermisosEmpleadosCommand;
import com.Clinica1.myApp.IAMusuario.application.exception.UserNotFoundException;
import com.Clinica1.myApp.IAMusuario.domain.model.valueobjects.Funcion;
import com.Clinica1.myApp.IAMusuario.domain.repository.EmpleadoRepository;
import com.Clinica1.myApp.IAMusuario.domain.repository.RolRepository;
import com.Clinica1.myApp.mantenimiento.domain.model.aggregates.Empleado;
import com.Clinica1.myApp.SharedKernel.Roles;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PermisosEmpleadosCommandHandler{
    private final EmpleadoRepository emp_repo;
    private final RolRepository rol_repo;

    public List<String> obtenerFunciones(PermisosEmpleadosCommand peremp_com){

        //busca al empleado por el id
        Optional<Empleado> fantasmitaemp= emp_repo.findById(peremp_com.getId_emp());
        Empleado emp= fantasmitaemp.orElseThrow(() ->
                new UserNotFoundException("Empleado no encontrado"));

        //roles
        Roles rol_emp= emp.getRolemp();

        Set<Funcion> funcionesemp= rol_repo.findFuncionesByNombre(rol_emp);

        //mapear
        List<String> funcionesempstring= funcionesemp.stream()
                .map(Funcion::getNombre_fun)
                .distinct()
                .sorted()
                .collect(Collectors.toList());

        return funcionesempstring;


    }
}
