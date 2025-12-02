package com.Clinica1.myApp.mantenimiento.domain.model.aggregates;

import com.Clinica1.myApp.SharedKernel.Email;
import com.Clinica1.myApp.SharedKernel.Empleado;
import com.Clinica1.myApp.SharedKernel.IDEntidad;
import com.Clinica1.myApp.SharedKernel.Roles;

import com.Clinica1.myApp.mantenimiento.domain.model.valueobjects.Nombrecompleto;
import com.Clinica1.myApp.mantenimiento.domain.model.valueobjects.Especialidad;
import com.Clinica1.myApp.mantenimiento.domain.model.valueobjects.Nombrecompleto;
import lombok.Getter;

import java.util.List;
import java.util.Objects;

@Getter
public class Doctor {
    private IDEntidad idDoctor;
    private IDEntidad idEmpleado; // Solo referencia por ID
    private Nombrecompleto nombreCompleto; // Duplicado para lectura
    private String cmp;
    private String consultorio;
    private List<Especialidad> especialidades;

    protected Doctor() {}

    private Doctor(IDEntidad idDoctor,
                   IDEntidad idEmpleado,
                   Nombrecompleto nombreCompleto,
                   String cmp,
                   String consultorio,
                   List<Especialidad> especialidades) {
        this.idDoctor = idDoctor;
        this.idEmpleado = idEmpleado;
        this.nombreCompleto = nombreCompleto;
        this.cmp = cmp;
        this.consultorio = consultorio;
        this.especialidades = especialidades;
    }

    // ----- FACTORY -----
    public static Doctor crear(
            IDEntidad idEmpleado,
            String nombre,
            String apellido,
            String cmp,
            String consultorio,
            List<Especialidad> especialidades
    ) {
        if (idEmpleado == null) {
            throw new IllegalArgumentException("El ID del empleado es obligatorio");
        }

        return new Doctor(
                IDEntidad.generar(),
                idEmpleado,
                new Nombrecompleto(nombre, apellido),
                cmp,
                consultorio,
                especialidades
        );
    }

    // ----- COMPORTAMIENTO -----
    public void actualizarDatos(String cmp, String consultorio, List<Especialidad> especialidades) {
        if (cmp == null || cmp.isBlank()) {
            throw new IllegalArgumentException("El CMP no puede estar vacío");
        }
        if (consultorio == null || consultorio.isBlank()) {
            throw new IllegalArgumentException("El consultorio no puede estar vacío");
        }
        if (especialidades == null || especialidades.isEmpty()) {
            throw new IllegalArgumentException("Debe tener al menos una especialidad");
        }

        this.cmp = cmp;
        this.consultorio = consultorio;
        this.especialidades = especialidades;
    }
    private Empleado empleado;
    public void actualizarCredenciales(String nuevaPassword) {
        if (this.empleado == null) {
            throw new IllegalStateException("El empleado asociado no existe");
        }
        this.empleado.asignarCredenciales(nuevaPassword);
    }

    public void actualizarNombre(String nombre, String apellido) {
        this.nombreCompleto = new Nombrecompleto(nombre, apellido);
    }



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
