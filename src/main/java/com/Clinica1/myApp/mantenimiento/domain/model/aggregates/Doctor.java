package com.Clinica1.myApp.mantenimiento.domain.model.aggregates;

import com.Clinica1.myApp.SharedKernel.Email;
import com.Clinica1.myApp.SharedKernel.Empleado;
import com.Clinica1.myApp.SharedKernel.IDEntidad;
import com.Clinica1.myApp.SharedKernel.Roles;

import com.Clinica1.myApp.mantenimiento.domain.model.valueobjects.Especialidad;
import com.Clinica1.myApp.mantenimiento.domain.model.valueobjects.Nombrecompleto;
import lombok.Getter;

import java.util.List;
import java.util.Objects;

@Getter
public class Doctor {
    private IDEntidad idDoctor;
    private Empleado empleado;
    private String cmp;
    private String consultorio;
    private List<Especialidad> especialidades;

    protected Doctor() {}

    private Doctor(IDEntidad idDoctor,
                   Empleado empleado,
                   String cmp,
                   String consultorio,
                   List<Especialidad> especialidades) {

        this.idDoctor = idDoctor;
        this.empleado = empleado;
        this.cmp = cmp;
        this.consultorio = consultorio;
        this.especialidades = especialidades;
    }

    // ----- FACTORY -----
    public static Doctor crear(
            String nombre,
            String apellido,
            String telefono,
            Email email,
            String password,
            String cmp,
            String consultorio,
            List<Especialidad> especialidades
    ) {

        Empleado emp = Empleado.crearemp(
                nombre,
                apellido,
                telefono,
                email,
                password,
                Roles.Rol_Doctor
        );

        return new Doctor(
                IDEntidad.generar(),
                emp,
                cmp,
                consultorio,
                especialidades
        );
    }

    // ----- COMPORTAMIENTO -----
    public void actualizarDatos( String cmp, String consultorio, List<Especialidad> especialidades) {
        this.cmp = cmp;
        this.consultorio = consultorio;
        this.especialidades = especialidades;
    }
    public void actualizarCredenciales(String nuevaContrasena) {
        this.empleado.asignarCredenciales(nuevaContrasena);
    }

    // Igualdad por idDoctor
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Doctor)) return false;
        Doctor doctor = (Doctor) o;
        return Objects.equals(idDoctor, doctor.idDoctor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idDoctor);
    }
}
