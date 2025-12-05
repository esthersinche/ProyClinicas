package com.Clinica1.myApp.IAMusuario.application.assembler;

import com.Clinica1.myApp.IAMusuario.application.dto.EmailDto;
import com.Clinica1.myApp.IAMusuario.application.exception.InvalidCredentialsException;
import com.Clinica1.myApp.SharedKernel.Email;
import org.springframework.stereotype.Component;

@Component
public class EmailAssembler {

    public EmailDto ToDto(Email email_ent){
        if (email_ent == null){
            throw new NullPointerException("Email no puede ser nulo");
        }
        if (!email_ent.email_valor().matches("^[a-zA-Z0-9._%+-]+@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,}$")){
            throw new InvalidCredentialsException("Email no es válido");
        }

        return EmailDto.builder()
                .email_emp(email_ent.email_valor())
                .build();
    }

    public Email ToDomain(EmailDto em_dto){
        if (em_dto == null){
            throw new NullPointerException("Email no puede ser nulo");
        }
        if (!em_dto.getEmail_emp().matches("^[a-zA-Z0-9._%+-]+@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,}$")){
            throw new InvalidCredentialsException("Email no es válido");
        }

        return new Email(em_dto.getEmail_emp());
    }
}
