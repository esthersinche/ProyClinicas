package com.Clinica1.myApp.adquisicion.domain.model;

import com.Clinica1.myApp.SharedKernel.IDEntidad;
import org.springframework.format.annotation.DateTimeFormat;

public class Pago {
    private IDEntidad id_cli;
    private float monto_pago;
    private DateTimeFormat fecha_pago;
    private String metodo_pago;

}
