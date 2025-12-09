package com.Clinica1.myApp.IAMusuario.application.assembler;
import com.Clinica1.myApp.IAMusuario.domain.model.aggregates.EmpleadoIAM;
import com.Clinica1.myApp.IAMusuario.infrastructure.integration.EmpleadoMinDto;
import com.Clinica1.myApp.SharedKernel.IDEntidad;
import com.Clinica1.myApp.SharedKernel.Roles;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Builder
public class EmpleadoAssembler {
    public EmpleadoMinDto ToDto(EmpleadoIAM emp){
        return EmpleadoMinDto.builder()
                .id_empiam(emp.getId_empiam().obtenerid())
                .nom_empiam(emp.getNom_empiam())
                .ape_empiam(emp.getApe_empiam())
                .rol_empiam(emp.getRol_empiam().name())
                .build();
    }

    public EmpleadoIAM ToDomain(EmpleadoMinDto neverever_dto){
        return new EmpleadoIAM(IDEntidad.astring(neverever_dto.getId_empiam()), neverever_dto.getNom_empiam(),
                neverever_dto.getApe_empiam(), null, null,
                Roles.valueOf(neverever_dto.getRol_empiam()));
    }
    /*private final EmailAssembler em_assem;

    public EmpleadoDto ToDto(Empleado emp){
        if (emp == null){
            throw new NullPointerException("Empleado no puede ser nulo");
        }

        EmailDto em_dto= em_assem.ToDto(emp.getEmail());
        return EmpleadoDto.builder()
                .id_emp(emp.getId_emp().obtenerid())
                .nom_emp(emp.getNombre())
                .ape_emp(emp.getApellido())
                .tel_emp(emp.getTelefono())
                .email_emp(em_dto)
                .passhash_emp(emp.getPasshash_emp())
                .rol_emp(emp.getRolemp().name())

                .build();

    }

    public Empleado ToDomain(EmpleadoDto emp_dto){
        if (emp_dto == null){
            throw new NullPointerException("Empleado no puede ser nulo");
        }
        Email em_emp= em_assem.ToDomain(emp_dto.getEmail_emp());
        return new Empleado(IDEntidad.astring(emp_dto.getId_emp()), emp_dto.getNom_emp(), emp_dto.getApe_emp(),
                emp_dto.getTel_emp(), em_emp, emp_dto.getPasshash_emp(), Roles.valueOf(emp_dto.getRol_emp()));
    }*/

}
