package com.Clinica1.myApp.mantenimiento.infraestructure.persistence.adapter;

import com.Clinica1.myApp.SharedKernel.IDEntidad;
import com.Clinica1.myApp.mantenimiento.domain.model.aggregates.Administrador;
import com.Clinica1.myApp.mantenimiento.domain.repository.AdministradorRepository;
import com.Clinica1.myApp.mantenimiento.infraestructure.persistence.jpa.entity.AdministradorEntity;
import com.Clinica1.myApp.mantenimiento.infraestructure.persistence.jpa.repository.JPAAdministradorRepository;
import com.Clinica1.myApp.mantenimiento.infraestructure.persistence.mapper.AdministradorMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class AdministradorRepositoryAdapter implements AdministradorRepository {
    private final JPAAdministradorRepository admin_repo;
    private final AdministradorMapper admin_map;

    //metodos especificos
    @Override
    public Administrador findByIdEmp(IDEntidad id_emp){
        return admin_repo.findByIdEmp(id_emp.obtenerid())
                .map(admin_map::ToDomain)
                .orElse(null);
    }
    //ICRUD
    @Override
    public Administrador insert(Administrador admin){
        AdministradorEntity admin_ent= admin_map.ToEntity(admin);
        AdministradorEntity admin_saved= admin_repo.save(admin_ent);

        return admin_map.ToDomain(admin_saved);
    }

    @Override
    public Administrador update(Administrador admin2){
        AdministradorEntity admin_ent2= admin_map.ToEntity(admin2);
        AdministradorEntity admin_saved2= admin_repo.save(admin_ent2);

        return admin_map.ToDomain(admin_saved2);
    }

    @Override
    public Optional<Administrador> findById(IDEntidad id_admin){
        return admin_repo.findById(id_admin.obtenerid())
                .map(admin_map::ToDomain);
    }

    @Override
    public List<Administrador> findall(){
        return admin_repo.findAll()
                .stream().map(admin_map::ToDomain)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(IDEntidad id_admin){
        admin_repo.deleteById(id_admin.obtenerid());
    }


}
