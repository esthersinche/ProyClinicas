package com.Clinica1.myApp.IAMusuario.infrastructure.persistence.jpa.mapper;

import com.Clinica1.myApp.IAMusuario.infrastructure.persistence.jpa.entity.EmailEmbeddable;
import com.Clinica1.myApp.SharedKernel.Email;
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
