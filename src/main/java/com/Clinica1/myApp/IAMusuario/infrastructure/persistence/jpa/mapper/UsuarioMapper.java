package com.Clinica1.myApp.IAMusuario.infrastructure.persistence.jpa.mapper;

import com.Clinica1.myApp.IAMusuario.infrastructure.persistence.jpa.entity.*;
import com.Clinica1.myApp.IAMusuario.infrastructure.persistence.jpa.entity.UsuarioWebEntity;
import com.Clinica1.myApp.SharedKernel.Empleado;
import com.Clinica1.myApp.IAMusuario.domain.model.aggregates.Rol;
import com.Clinica1.myApp.IAMusuario.domain.model.valueobjects.ContraHash;
import com.Clinica1.myApp.SharedKernel.Email;
import com.Clinica1.myApp.IAMusuario.domain.model.valueobjects.Funcion;
import com.Clinica1.myApp.SharedKernel.IDEntidad;
import com.Clinica1.myApp.SharedKernel.UsuarioWeb;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class UsuarioMapper {
    private EmailMapper ema_map_iam;

    public UsuarioMapper(EmailMapper ema_map_iam) {
        this.ema_map_iam = ema_map_iam;
    }

    /* ===================== USUARIO =====================

        public UsuarioWebEntity toEntity(UsuarioWeb usuarioWeb) {
            if (usuarioWeb == null)
                return null;

            UsuarioWebEntity entity = new UsuarioWebEntity();

            //entity.setIdEmp(usuarioWeb.getId_usu().obtenerid());
            entity.setIdEmp(usuarioWeb.getId_emp());
            //entity.setUsername(usuarioWeb.getUsername());
            entity
            entity.setPass(usuarioWeb.getPasshash().getValor_contra_hash());

            EmpleadoEntity empleadoEntity = toEmpleadoEntity(usuarioWeb.getEmp());
            entity.setEmpleado(empleadoEntity);

            return entity;
        }

        public UsuarioWeb toDomain(UsuarioWebEntity entity) {
            if (entity == null)
                return null;

            Empleado empleado = toEmpleadoDomain(entity.getEmpleado());

            return new UsuarioWeb(
                    IDEntidad.astring(entity.getIdEmp()),
                    entity.getUsername(),
                    ContraHash.deHash(entity.getPass()),
                    empleado);
        }*/
    public UsuarioWeb ToDomain(UsuarioWebEntity usu_ent){
        Email usuweb_email= ema_map_iam.ToDomain(usu_ent.getCorreo_usuweb());
        return new UsuarioWeb(IDEntidad.astring(usu_ent.getId_usuweb()), usuweb_email, usu_ent.getPasshash(),
                IDEntidad.astring(usu_ent.getId_emp()), IDEntidad.astring(usu_ent.getId_cli()));

    }

    public UsuarioWebEntity ToEntity(UsuarioWeb usu_web){
        EmailEmbeddable usuwebwnt_emaemb= ema_map_iam.ToEmbeddable(usu_web.getCorreo());
        return UsuarioWebEntity.builder().id_usuweb(usu_web.getId_usu().obtenerid())
                .correo_usuweb(usuwebwnt_emaemb)
                .passhash(usu_web.getPasshash())
                .id_emp(usu_web.getId_emp().obtenerid())
                .id_cli(usu_web.getId_cli().obtenerid())
                .build();
    }


}
