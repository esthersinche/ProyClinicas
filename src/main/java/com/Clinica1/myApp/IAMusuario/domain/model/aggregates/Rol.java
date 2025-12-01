package com.Clinica1.myApp.IAMusuario.domain.model.aggregates;

import com.Clinica1.myApp.IAMusuario.domain.model.valueobjects.Funcion;
import com.Clinica1.myApp.SharedKernel.IDEntidad;
import com.Clinica1.myApp.SharedKernel.Roles;

import java.util.HashSet;
import java.util.Objects;

public final class Rol {
    private IDEntidad id_rol;
    private Roles nombrerol;
    private HashSet<Funcion> funciones;//evita los duplicados y es mas facil de hacer operaciones
    //debido al hash

    public Rol() {
    }

    public Rol(IDEntidad id_rol, Roles nombrerol, HashSet<Funcion> funciones) {
        this.id_rol = id_rol;
        this.nombrerol = nombrerol;
        this.funciones = funciones;
    }

    public static Rol crearrol(Roles nombrerol, HashSet<Funcion> funciones){
        return new Rol(IDEntidad.generar(), nombrerol, funciones);
    }
    //para dcotor solamente, borrar dsps
    //por ahora
    public static final Rol doctor= creardoctor();
    public static Rol creardoctor(){
        HashSet<Funcion> funciones= new HashSet<>();
        funciones.add(Funcion.of("Atender_paciente"));
        funciones.add(Funcion.of("buscar_paciente"));

        return new Rol(IDEntidad.generar(), Roles.Rol_Doctor, funciones);
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

    public IDEntidad getId_rol() {
        return id_rol;
    }

    public Roles getNombrerol() {
        return nombrerol;
    }

    public HashSet<Funcion> getFunciones() {
        return funciones;
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
