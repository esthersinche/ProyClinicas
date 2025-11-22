package com.Clinica1.myApp.appointments.infraestructure.persistence.jpa.mapper;

import com.Clinica1.myApp.appointments.domain.model.valueobjects.Email;
import com.Clinica1.myApp.appointments.infraestructure.persistence.jpa.entity.EmailEmbeddable;
import org.springframework.stereotype.Component;

@Component
public class EmailMapper {
    public Email ToDomain(EmailEmbeddable emailemb){
        return new Email(
                emailemb.getEmail_valor()
        );
    }

    public EmailEmbeddable ToEmbeddable(Email email){
        return EmailEmbeddable.builder().email_valor(email.email_valor()).build();
    }
}
