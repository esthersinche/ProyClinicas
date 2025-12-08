package com.Clinica1.myApp.IAMusuario.application.command;

import com.Clinica1.myApp.IAMusuario.application.dto.EmailDto;
import com.Clinica1.myApp.SharedKernel.Email;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LoginCommand {
    private EmailDto email_emp;
    private String contra;


}
