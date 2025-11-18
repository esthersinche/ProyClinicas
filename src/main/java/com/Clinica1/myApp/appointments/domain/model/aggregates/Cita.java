package com.Clinica1.myApp.appointments.domain.model.aggregates;

import com.Clinica1.myApp.SharedKernel.IDEntidad;
import com.Clinica1.myApp.appointments.domain.model.valueobjects.Direccion;
import com.Clinica1.myApp.appointments.domain.model.valueobjects.Especialidad;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

public class Cita {
    private IDEntidad id_cita;
    private String motivo_cita;
    private String estado_cita;
    private String canal_cita;
    private LocalDateTime inicio_cita; //cambiar a date y hora typeshi
    private String fin_cita;

    //otros
    private Paciente inst_pac; //nombres, dni
    private Doctor inst_doctor; //nombre, especialidad, consultorio por ahora
    private Especialidad espe_cita;// por si acaso
    private Clinica inst_clin; //nombre
    private Direccion dir_clin_cita;

}
