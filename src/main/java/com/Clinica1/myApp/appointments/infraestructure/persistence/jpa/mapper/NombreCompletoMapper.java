package com.Clinica1.myApp.appointments.infraestructure.persistence.jpa.mapper;

import com.Clinica1.myApp.appointments.domain.model.valueobjects.NombreCompleto;
import com.Clinica1.myApp.appointments.infraestructure.persistence.jpa.entity.NombreCompletoEmbeddable;
import org.springframework.stereotype.Component;

@Component
public class NombreCompletoMapper {
    /*public Email ToDomain(EmailEmbeddable emailemb){
        return new Email(
                emailemb.getEmail_valor()
        );
    }

    public EmailEmbeddable ToEmbeddable(Email email){
        return EmailEmbeddable.builder().email_valor(email.email_valor()).build();
    }*/

    public NombreCompleto ToDomain(NombreCompletoEmbeddable nom_com_emb){
        return new NombreCompleto(nom_com_emb.getNombre(), nom_com_emb.getApellido());
    }

    public NombreCompletoEmbeddable ToEmbeddable(NombreCompleto nom_com){
        return NombreCompletoEmbeddable.builder()
                .nombre(nom_com.nombre())
                .apellido(nom_com.apellido())
                .build();
    }
}
