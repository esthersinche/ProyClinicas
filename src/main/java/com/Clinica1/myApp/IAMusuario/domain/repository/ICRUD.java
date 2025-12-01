package com.Clinica1.myApp.IAMusuario.domain.repository;

import com.Clinica1.myApp.SharedKernel.IDEntidad;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ICRUD<T> {
    //plantilla
    T insert(T tall);//guarda
    T update(T tall);// actualiza
    Optional<T> FindById(IDEntidad id);//los encuentra
    List<T> getall();//obtiene todos
    void delete(IDEntidad ID);//delete

}
