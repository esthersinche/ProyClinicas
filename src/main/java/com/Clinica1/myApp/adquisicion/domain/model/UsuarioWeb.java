package com.Clinica1.myApp.adquisicion.domain.model;


import com.Clinica1.myApp.SharedKernel.IDEntidad;

public class UsuarioWeb {
    private IDEntidad id_usuweb;
    private IDEntidad id_emp;

    public UsuarioWeb() {
    }

    public UsuarioWeb(IDEntidad id_usuweb, IDEntidad id_emp) {
        this.id_usuweb = id_usuweb;
        this.id_emp = id_emp;
    }

    public IDEntidad getId_usuweb() {
        return id_usuweb;
    }

    public IDEntidad getId_emp() {
        return id_emp;
    }
}
