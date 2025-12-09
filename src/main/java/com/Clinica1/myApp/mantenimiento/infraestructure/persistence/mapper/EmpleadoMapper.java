package com.Clinica1.myApp.mantenimiento.infraestructure.persistence.mapper;

import com.Clinica1.myApp.SharedKernel.Email;
import com.Clinica1.myApp.mantenimiento.domain.model.aggregates.Empleado;
import com.Clinica1.myApp.SharedKernel.IDEntidad;
import com.Clinica1.myApp.SharedKernel.Roles;

import com.Clinica1.myApp.mantenimiento.infraestructure.persistence.jpa.entity.EmpleadoEntity;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;

@Component
public class EmpleadoMapper {

    public Empleado toDomain(EmpleadoEntity entity) {
        if (entity == null) return null;

        try {
            Empleado empleado = Empleado.crearemp(
                    entity.getNombre(),
                    entity.getApellido(),
                    entity.getTelefono(),
                    new Email(entity.getEmail()),
                    entity.getPassword(),
                    Roles.valueOf(entity.getRol())
                     // id_clinica temporal
            );

            // Setear el ID original
            Field field = Empleado.class.getDeclaredField("id_emp");
            field.setAccessible(true);
            field.set(empleado, IDEntidad.astring(entity.getIdEmpleado()));

            return empleado;

        } catch (Exception e) {
            throw new RuntimeException("Error al mapear EmpleadoEntity a Empleado: " + e.getMessage(), e);
        }
    }

    public EmpleadoEntity toEntity(Empleado empleado) {
        if (empleado == null) return null;

        return EmpleadoEntity.builder()
                .idEmpleado(empleado.getId_emp().obtenerid())
                .nombre(empleado.getNombre())
                .apellido(empleado.getApellido())
                .telefono(empleado.getTelefono())
                .email(empleado.getEmail().email_valor())
                .password(empleado.getPasshash_emp())
                .rol(empleado.getRolemp().name())
                .build();
    }
}