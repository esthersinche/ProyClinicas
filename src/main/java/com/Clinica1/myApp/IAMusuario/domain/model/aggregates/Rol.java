package com.Clinica1.myApp.IAMusuario.domain.model.aggregates;

import com.Clinica1.myApp.SharedKernel.IDEntidad;

import java.util.HashSet;

public final class Rol {
    private IDEntidad id_rol;
    private String nombrerol;
    private HashSet<String> funciones;//evita los duplicados y es mas facil de hacer operaciones
    //debido al hash


    public Rol(IDEntidad id_rol, String nombrerol, HashSet<String> funciones) {
        this.id_rol = id_rol;
        this.nombrerol = nombrerol;
        this.funciones = funciones;
    }

    public boolean estapermitido(){
        return true;
    }


}
