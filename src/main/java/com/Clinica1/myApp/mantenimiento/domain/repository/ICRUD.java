package com.Clinica1.myApp.mantenimiento.domain.repository;

import com.Clinica1.myApp.SharedKernel.IDEntidad;

import java.util.List;

public interface ICRUD<T>{
    T insert(T tall);
    T update(T tall);
    T findById(IDEntidad id_all);
    List<T> findall();
    void delete(IDEntidad id_someone);
}
