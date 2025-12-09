package com.Clinica1.myApp.mantenimiento.application.query;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BuscarDoctorPorCMPQuery {
    private final String cmp;
}