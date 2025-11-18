package com.Clinica1.myApp.IAMusuario.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ICRUD<T> {
    //plantilla
    T insert(T tall);//guarda
    T update(T tall);// actualiza
    T FindById(UUID id);//los encuentra
    List<T> getall();//obtiene todos
    void delete(UUID ID);//delete

}
