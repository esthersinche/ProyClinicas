package com.Clinica1.myApp.IAMusuario.application.command;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
@Builder
public class LoginCommand {
    private final String email_emp;
    private final String contra;
}
