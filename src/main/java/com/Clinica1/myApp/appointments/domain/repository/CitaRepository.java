package com.Clinica1.myApp.appointments.domain.repository;

import com.Clinica1.myApp.SharedKernel.ICRUD;
import com.Clinica1.myApp.SharedKernel.IDEntidad;
import com.Clinica1.myApp.appointments.domain.model.aggregates.Cita;
import com.Clinica1.myApp.appointments.domain.model.valueobjects.Canal;
import com.Clinica1.myApp.appointments.domain.model.valueobjects.Estado;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public interface CitaRepository extends ICRUD<Cita> {
    //List<Cita> findbyEstado(Estado cita_Estado);
    //List<Cita> findbyCanal(Canal cita_canal);
    List<Cita> findbyNombrepac(String nombre_pac_cita);//lista de citas por nombre de paciente
    //List<Cita> findbyDates(LocalDateTime fec_search_cita);
    List<Cita> findbyDoctor(String nombre_doc_cita);
    List<Cita> findbyEspecialidad(String nom_espe);
    List<Cita> findByDoctorId(IDEntidad doctorId);
}
