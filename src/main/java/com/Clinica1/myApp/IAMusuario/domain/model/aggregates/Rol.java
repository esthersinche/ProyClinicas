package com.Clinica1.myApp.IAMusuario.domain.model.aggregates;

import com.Clinica1.myApp.IAMusuario.domain.model.valueobjects.Funcion;
import com.Clinica1.myApp.SharedKernel.IDEntidad;

import java.util.HashSet;

public final class Rol {
    private IDEntidad id_rol;
    private String nombrerol;
    private HashSet<Funcion> funciones;//evita los duplicados y es mas facil de hacer operaciones
    //debido al hash


    public Rol(IDEntidad id_rol, String nombrerol, HashSet<Funcion> funciones) {
        this.id_rol = id_rol;
        this.nombrerol = nombrerol;
        this.funciones = new HashSet<>(funciones);
    }

    public boolean estapermitido(Funcion funcion){
        return funciones.contains(funcion);
    }

    //para llamar a funcion permite mas facil
    public boolean estapermitidio(String nombre_fun){
        return funciones.contains(Funcion.of(nombre_fun));
    }


}
