package com.Clinica1.myApp.IAMusuario.infrastructure.persistence.jpa.adapter;

import com.Clinica1.myApp.IAMusuario.domain.repository.EmpleadoRepository;
import com.Clinica1.myApp.IAMusuario.infrastructure.persistence.jpa.entity.EmpleadoEntity;
import com.Clinica1.myApp.IAMusuario.infrastructure.persistence.jpa.mapper.EmpleadoMapper;
import com.Clinica1.myApp.IAMusuario.infrastructure.persistence.jpa.repository.JPAEmpleadoRepository;
import com.Clinica1.myApp.SharedKernel.Email;
import com.Clinica1.myApp.mantenimiento.domain.model.aggregates.Empleado;
import com.Clinica1.myApp.SharedKernel.IDEntidad;
import com.Clinica1.myApp.SharedKernel.Roles;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class EmpleadoRepositoryAdapter implements EmpleadoRepository {

    private final JPAEmpleadoRepository emp_repo;
    private final EmpleadoMapper emp_map;

    public EmpleadoRepositoryAdapter(JPAEmpleadoRepository emp_repo, EmpleadoMapper emp_map) {
        this.emp_repo = emp_repo;
        this.emp_map = emp_map;
    }
    //metodos especificos
    @Override
    public Optional<Empleado> findbyEmail(Email email_emp){
        return emp_repo.findbyEmail(email_emp.email_valor())
                .map(emp_map::ToDomain);
    }

    @Override
    public Optional<Empleado> findbyNamecompleto(String nom_emp, String ape_emp){
        return emp_repo.findbyNamecompleto(nom_emp, ape_emp)
                .map(emp_map::ToDomain);
    }

    @Override
    public List<Empleado> findbyRol(Roles nom_rol_emp){
        return emp_repo.findbyRol(nom_rol_emp)
                .stream()
                .map(emp_map::ToDomain)
                .collect(Collectors.toList());
    }
    //ICRUD

    @Override
    public Empleado insert(Empleado emp) {

        EmpleadoEntity emp_ent= emp_map.ToEntity(emp);
        EmpleadoEntity emp_ent_saved= emp_repo.save(emp_ent);
        return emp_map.ToDomain(emp_ent_saved);

    }

    @Override
    public Empleado update(Empleado emp2) {

        EmpleadoEntity emp_ent2= emp_map.ToEntity(emp2);
        EmpleadoEntity emp_ent_saved2= emp_repo.save(emp_ent2);
        return emp_map.ToDomain(emp_ent_saved2);

    }

    @Override
    public Optional<Empleado> findById(IDEntidad id) {
        /*return jpaUsuarioRepository.findById(id.toString())
                .map(usuarioMapper::toDomain);*/
        return emp_repo.findById(id.obtenerid())
                .map(emp_map::ToDomain);


    }

    @Override
    public List<Empleado> findall() {
        /*
        return jpaUsuarioRepository.findAll()
                .stream()
                .map(usuarioMapper::toDomain)
                .collect(Collectors.toList());*/
        return emp_repo.findAll()
                .stream()
                .map(emp_map::ToDomain)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(IDEntidad id) {
        emp_repo.deleteById(id.toString());
    }


}
