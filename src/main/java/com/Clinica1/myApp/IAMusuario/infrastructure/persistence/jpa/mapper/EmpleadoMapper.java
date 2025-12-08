package com.Clinica1.myApp.IAMusuario.infrastructure.persistence.jpa.mapper;

import com.Clinica1.myApp.IAMusuario.domain.model.aggregates.Rol;
import com.Clinica1.myApp.IAMusuario.infrastructure.persistence.jpa.entity.EmailEmbeddable;
import com.Clinica1.myApp.IAMusuario.infrastructure.persistence.jpa.entity.EmpleadoEntity;
import com.Clinica1.myApp.SharedKernel.Email;
import com.Clinica1.myApp.SharedKernel.Empleado;
import com.Clinica1.myApp.SharedKernel.IDEntidad;

public class EmpleadoMapper {

    private EmailMapper ema_map_iam;
    private RolMapper rol_map;

    public EmpleadoMapper(EmailMapper ema_map_iam, RolMapper rol_map) {
        this.ema_map_iam = ema_map_iam;
        this.rol_map = rol_map;
    }

    /* ===================== EMPLEADO =====================

            private EmpleadoEntity toEmpleadoEntity(Empleado empleado) {
                if (empleado == null)
                    return null;

                EmpleadoEntity entity = new EmpleadoEntity();
                entity.setIdEmp(empleado.getId_emp().obtenerid());
                entity.setNombresEmp(empleado.getNombre());
                entity.setApellidosEmp(empleado.getApellido());
                entity.setTelefonoEmp(empleado.getTelefono());
                entity.setEmailEmp(empleado.getEmail().email_valor());
                entity.setRol(toRolEntity(empleado.getRolemp()));

                return entity;
            }

            private Empleado toEmpleadoDomain(EmpleadoEntity entity) {
                if (entity == null)
                    return null;

                Rol rol = toRolDomain(entity.getRol());

                return new Empleado(
                        IDEntidad.astring(entity.getIdEmp()),
                        entity.getNombresEmp(),
                        entity.getApellidosEmp(),
                        entity.getTelefonoEmp(),
                        Email.of(entity.getEmailEmp()),
                        rol);
            }*/
    public Empleado ToDomain(EmpleadoEntity emp_ent){
        Email empent_email= ema_map_iam.ToDomain(emp_ent.getEmail_emp());
        return new Empleado(IDEntidad.astring(emp_ent.getId_Emp()), emp_ent.getNombresEmp(), emp_ent.getApellidosEmp(),
                emp_ent.getTelefonoEmp(), empent_email, emp_ent.getPasshash_emp(),emp_ent.getRol_emp(),
                IDEntidad.astring(emp_ent.getId_clinica()));
    }

    public EmpleadoEntity ToEntity(Empleado emp){
        EmailEmbeddable emp_emailemb= ema_map_iam.ToEmbeddable(emp.getEmail());
        return EmpleadoEntity.builder().id_Emp(emp.getId_emp().obtenerid())
                .nombresEmp(emp.getNombre())
                .apellidosEmp(emp.getApellido())
                .telefonoEmp(emp.getTelefono())
                .email_emp(emp_emailemb)
                .passhash_emp(emp.getPasshash_emp())
                .rol_emp(emp.getRolemp())
                .id_clinica(emp.getId_clinica().obtenerid())
                .build();
    }
}
