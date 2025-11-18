package com.Clinica1.myApp.appointments.domain.repository;

import com.Clinica1.myApp.appointments.domain.model.aggregates.Cita;
import com.Clinica1.myApp.appointments.domain.model.valueobjects.Canal;
import com.Clinica1.myApp.appointments.domain.model.valueobjects.Estado;

import java.time.LocalDateTime;
import java.util.List;

public interface CitaRepository extends ICRUD<Cita>{
    List<Cita> findbyEstado(Estado cita_Estado);
    List<Cita> findbyCanal(Canal cita_canal);
    List<Cita> findbyNombrepac(String nombre_pac_cita);//lista de citas por nombre de paciente
    List<Cita> findbyDates(LocalDateTime fec_search_cita);
    List<Cita> findbyDoctor(String nombre_doc_cita);

}
