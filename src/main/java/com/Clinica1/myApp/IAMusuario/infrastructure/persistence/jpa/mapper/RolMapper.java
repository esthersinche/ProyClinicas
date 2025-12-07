package com.Clinica1.myApp.IAMusuario.infrastructure.persistence.jpa.mapper;

import com.Clinica1.myApp.IAMusuario.domain.model.aggregates.Rol;
import com.Clinica1.myApp.IAMusuario.domain.model.valueobjects.Funcion;
import com.Clinica1.myApp.IAMusuario.infrastructure.persistence.jpa.entity.FuncionEmbeddable;
import com.Clinica1.myApp.IAMusuario.infrastructure.persistence.jpa.entity.RolEntity;
import com.Clinica1.myApp.SharedKernel.IDEntidad;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.stream.Collectors;

public class RolMapper {
    private FuncionMapper fun_map;



    public Rol ToDomain(RolEntity rol_ent){
        /*HashSet<Funcion> funciones = rol_ent.getFunciones()
                .stream()
                .map(fun_map::ToDomain)
                .collect(Collectors.toCollection(HashSet::new));
        return new Rol(IDEntidad.astring(rol_ent.getId()), rol_ent.getNombreRol(), funciones);*/
        HashSet<Funcion> funciones= rol_ent.getFunciones()
                .stream()
                .map(fun_map::ToDomain)
                .collect(Collectors.toCollection(HashSet::new));
        return new Rol(IDEntidad.astring(rol_ent.getId()), rol_ent.getNombreRol(), funciones);




    }

    public RolEntity ToEntity(Rol rol){
        HashSet<FuncionEmbeddable> funcionesmeb= rol.getFunciones()
                .stream()
                .map(fun_map::ToEmbeddable)
                .collect(Collectors.toCollection(HashSet::new));
        return RolEntity.builder().id(rol.getId_rol().obtenerid())
                .nombreRol(rol.getNombrerol())
                .funciones(funcionesmeb)
                .build();

    }
    /* ===================== ROL =====================
    private Rol ToDomain(RolEntity rol_ent) {
        if (rol_ent == null)
            return null;



        return new Rol();
    }

    private RolEntity toRolEntity(Rol rol) {
        if (rol == null)
            return null;

        RolEntity entity = new RolEntity();
        entity.setId(rol.getId_rol().obtenerid());
        entity.setNombreRol(rol.getNombrerol());

        Set<String> funciones = rol.getFunciones()
                .stream()
                .map(Funcion::getNombre_fun)
                .collect(Collectors.toSet());

        entity.setFunciones(funciones);
        return entity;
    }*/


}
