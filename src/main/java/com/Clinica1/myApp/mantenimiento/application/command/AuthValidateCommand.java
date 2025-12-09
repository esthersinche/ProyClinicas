package com.Clinica1.myApp.mantenimiento.application.command;

public class AuthValidateCommand {
    private final String email;
    private final String password;

    public AuthValidateCommand(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
