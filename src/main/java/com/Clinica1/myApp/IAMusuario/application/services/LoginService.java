package com.Clinica1.myApp.IAMusuario.application.services;

import com.Clinica1.myApp.IAMusuario.application.command.LoginCommand;
import com.Clinica1.myApp.IAMusuario.application.dto.TokenDto;
import com.Clinica1.myApp.IAMusuario.application.exception.InvalidCredentialsException;

public interface LoginService {
    TokenDto login(LoginCommand log_com) throws InvalidCredentialsException;

}
