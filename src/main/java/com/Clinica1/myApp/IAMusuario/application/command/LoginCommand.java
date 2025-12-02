package com.Clinica1.myApp.IAMusuario.application.command;

import com.Clinica1.myApp.SharedKernel.Email;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
@Builder
public class LoginCommand {
    private String email_emp;
    private String contra;


}
