package com.Clinica1.myApp.IAMusuario.domain.model.aggregates;

import com.Clinica1.myApp.IAMusuario.domain.model.valueobjects.ContraHash;
import com.Clinica1.myApp.SharedKernel.IDEntidad;

public class Usuario {
    private IDEntidad id_usu;
    private String username;
    private ContraHash passhash;
    private Empleado emp;

}
