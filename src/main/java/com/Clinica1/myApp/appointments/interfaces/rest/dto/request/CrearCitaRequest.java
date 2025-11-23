package com.Clinica1.myApp.appointments.interfaces.rest.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
//dto q llegan en cuerpo de peticiones
public class CrearCitaRequest {
    private String motivo_cita;
     //vo
    //private Estado estado_cita;
    //private Canal canal_cita
    /*
    private IDEntidad id_cita;
    private String motivo_cita;
    private Estado estado_cita;
    private Canal canal_cita;
    private LocalDateTime inicio_cita; //cambiar a date y hora typeshi, luego cambiar a VO
    private LocalDateTime fin_cita;//luego cambiar a VO

    //referencias a paciente y doctor
    private IDEntidad pac_id;
    private IDEntidad doc_id;

    //otros, cambios 221125
    private Pac_info_cita inst_pac; //nombres, dni
    private Doc_info_cita inst_doctor; //nombre, especialidad, consultorio por ahora
    private Especialidad espe_cita;
    * */
}
