package com.Clinica1.myApp.IAMusuario.infrastructure.persistence.jpa.adapter;

import com.Clinica1.myApp.IAMusuario.domain.model.aggregates.Sesion;
import com.Clinica1.myApp.IAMusuario.domain.repository.SesionRepository;
import com.Clinica1.myApp.IAMusuario.infrastructure.persistence.jpa.repository.JPASesionRepository;
import com.Clinica1.myApp.SharedKernel.IDEntidad;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class SessionRepositoryAdapter implements SesionRepository {
    private final JPASesionRepository ses_repo;

    public SessionRepositoryAdapter(JPASesionRepository ses_repo) {
        this.ses_repo = ses_repo;
    }

    @Override
    public List<Sesion> findByUserId(IDEntidad usu_id){
        return ses_repo.findByUserId(usu_id);
    }

    //ICRUD
    /*T insert(T tall);//guarda
    T update(T tall);// actualiza
    Optional<T> FindById(UUID id);//los encuentra
    List<T> getall();//obtiene todos
    void delete(UUID ID);//delete
*/

    @Override
    public Sesion insert(Sesion ses){

    }

    @Override
    public Sesion update(Sesion ses2){
        return ses_repo.save(ses2);
    }

    @Override

}
