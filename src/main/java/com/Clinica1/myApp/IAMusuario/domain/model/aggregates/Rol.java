package com.Clinica1.myApp.IAMusuario.domain.model.aggregates;

import com.Clinica1.myApp.IAMusuario.domain.model.valueobjects.Funcion;
import com.Clinica1.myApp.SharedKernel.IDEntidad;

import java.util.HashSet;
import java.util.Objects;

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
        //si es q las funciones estan dentro del set en la clase de cualquier empleado
        return funciones.contains(funcion);
    }

    //para llamar a funcion permite mas facil
    public boolean estapermitidonombre(String nombre_fun){
        //busca por nombre de funcion si esta
        //of: metodo estatico q crea instancias, en vez de usar new funcion()
        return funciones.contains(Funcion.of(nombre_fun));
    }

    //solo por id debido a q es una entidad y son identificadas nomas por su id
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Rol rol = (Rol) o;
        return Objects.equals(id_rol, rol.id_rol);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id_rol);
    }
}
