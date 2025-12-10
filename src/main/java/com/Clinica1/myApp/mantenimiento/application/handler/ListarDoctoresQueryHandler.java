package com.Clinica1.myApp.mantenimiento.application.handler;

import com.Clinica1.myApp.mantenimiento.application.assembler.DoctorAssembler;
import com.Clinica1.myApp.mantenimiento.application.dto.DoctorDto;
import com.Clinica1.myApp.mantenimiento.application.dto.DoctorListadoDto;
import com.Clinica1.myApp.mantenimiento.application.query.ListarDoctoresQuery;
import com.Clinica1.myApp.mantenimiento.domain.model.valueobjects.Especialidad;
import com.Clinica1.myApp.mantenimiento.domain.repository.DoctorRepository;
import com.Clinica1.myApp.mantenimiento.domain.repository.EmpleadoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
@RequiredArgsConstructor
public class ListarDoctoresQueryHandler {

    private final DoctorRepository doctorRepository;
    private final EmpleadoRepository empleadoRepository;

    public List<DoctorListadoDto> handle() {
        return doctorRepository.findall()
                .stream()
                .map(doctor -> {
                    var emp = empleadoRepository
                            .findById(doctor.getIdEmpleado())
                            .orElse(null);

                    return new DoctorListadoDto(
                            doctor.getIdDoctor().obtenerid(),
                            doctor.getIdEmpleado().obtenerid(),
                            emp != null ? emp.getNombre() + " " + emp.getApellido() : "",
                            doctor.getCmp(),
                            doctor.getConsultorio(),
                            doctor.getEspecialidades()
                                    .stream()
                                    .map(Especialidad::nom_espe)
                                    .toList()
                    );
                })
                .toList();
    }
}