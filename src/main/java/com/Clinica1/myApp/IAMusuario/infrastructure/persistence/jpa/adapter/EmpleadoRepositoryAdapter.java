package com.Clinica1.myApp.IAMusuario.infrastructure.persistence.jpa.adapter;

import com.Clinica1.myApp.IAMusuario.domain.model.aggregates.EmpleadoIAM;
import com.Clinica1.myApp.IAMusuario.domain.repository.EmpleadoRepository;
import com.Clinica1.myApp.IAMusuario.infrastructure.integration.EmpleadoMinDto;
import com.Clinica1.myApp.IAMusuario.infrastructure.integration.MantenimientoAPICliente;
import com.Clinica1.myApp.IAMusuario.infrastructure.persistence.jpa.mapper.EmpleadoIAMMapper;
import com.Clinica1.myApp.SharedKernel.Email;
import com.Clinica1.myApp.SharedKernel.IDEntidad;
import com.Clinica1.myApp.SharedKernel.Roles;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Component
public class EmpleadoRepositoryAdapter implements EmpleadoRepository {

    private final MantenimientoAPICliente mant_api_cli;
    private final EmpleadoIAMMapper emp_iam_map;

    public EmpleadoRepositoryAdapter(MantenimientoAPICliente mant_api_cli, EmpleadoIAMMapper emp_iam_map) {
        this.mant_api_cli = mant_api_cli;
        this.emp_iam_map = emp_iam_map;
    }

    //metodo para autenticacion del bc mantenimiento
    public Optional<EmpleadoIAM> validaryobtenerporemail(String email_empiam, String passhash_empiam){
        EmpleadoMinDto emp_min_dto= mant_api_cli.validar(email_empiam, passhash_empiam);
        EmpleadoIAM empiam_saved= emp_iam_map.ToDomain(emp_min_dto);
        return Optional.of(empiam_saved);
    }

    //metodos especificos
    @Override
    public Optional<EmpleadoIAM> findbyEmail(Email email_emp){
        /*return emp_repo.findbyEmail(email_emp.email_valor())
                .map(emp_map::ToDomain);*/
        return Optional.empty();

    }

    @Override
    public Optional<EmpleadoIAM> findbyNamecompleto(String nom_emp, String ape_emp){
        /*return emp_repo.findbyNamecompleto(nom_emp, ape_emp)
                .map(emp_map::ToDomain);*/
        return Optional.empty();

    }

    @Override
    public List<EmpleadoIAM> findbyRol(Roles nom_rol_emp){
        /*return emp_repo.findbyRol(nom_rol_emp)
                .stream()
                .map(emp_map::ToDomain)
                .collect(Collectors.toList());*/
        return Collections.emptyList();

    }
    //ICRUD

    @Override
    public EmpleadoIAM insert(EmpleadoIAM emp_iam) {
        /*EmpleadoEntity emp_ent= emp_map.ToEntity(emp);
        EmpleadoEntity emp_ent_saved= emp_repo.save(emp_ent);
        return emp_map.ToDomain(emp_ent_saved);*/
        throw new UnsupportedOperationException("insert no es soportado p");
    }

    @Override
    public EmpleadoIAM update(EmpleadoIAM emp2) {
        /*EmpleadoEntity emp_ent2= emp_map.ToEntity(emp2);
        EmpleadoEntity emp_ent_saved2= emp_repo.save(emp_ent2);
        return emp_map.ToDomain(emp_ent_saved2);*/
        throw new UnsupportedOperationException("update no soportado, zoetrope god");
    }

    @Override
    public Optional<EmpleadoIAM> findById(IDEntidad id) {
        /*return jpaUsuarioRepository.findById(id.toString())
                .map(usuarioMapper::toDomain);
                return emp_repo.findById(id.obtenerid())
                .map(emp_map::ToDomain);*/
        EmpleadoMinDto tensei_no_yadorigi= mant_api_cli.findEmpById(id.obtenerid());
        EmpleadoIAM tensei_no_yadorigi_saved= emp_iam_map.ToDomain(tensei_no_yadorigi);
        return Optional.of(tensei_no_yadorigi_saved);
    }

    @Override
    public List<EmpleadoIAM> findall() {
        /*
        return jpaUsuarioRepository.findAll()
                .stream()
                .map(usuarioMapper::toDomain)
                .collect(Collectors.toList());
                return emp_repo.findAll()
                .stream()
                .map(emp_map::ToDomain)
                .collect(Collectors.toList());*/
        return Collections.emptyList();

    }

    @Override
    public void delete(IDEntidad id) {
        /*emp_repo.deleteById(id.toString());*/
        throw new UnsupportedOperationException("delete no es soportado, aguante ft");
    }


}
