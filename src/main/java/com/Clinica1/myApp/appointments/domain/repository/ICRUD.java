package com.Clinica1.myApp.appointments.domain.repository;

import com.Clinica1.myApp.SharedKernel.IDEntidad;

import java.util.List;
import java.util.UUID;

public interface ICRUD<T>{
    T insert(T tall);
    T update(T tall);
    T findbyId(UUID id_all);
    List<T> findall();
    void delete(UUID id_someone);


}
