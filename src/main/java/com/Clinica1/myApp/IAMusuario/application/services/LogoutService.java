package com.Clinica1.myApp.IAMusuario.application.services;

import com.Clinica1.myApp.IAMusuario.application.command.LogoutCommand;

public interface LogoutService {
    void logout(LogoutCommand logout_com);
}
