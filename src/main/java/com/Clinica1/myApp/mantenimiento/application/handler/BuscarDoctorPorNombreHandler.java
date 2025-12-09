package com.Clinica1.myApp.mantenimiento.application.handler;

import com.Clinica1.myApp.mantenimiento.application.assembler.DoctorAssembler;
import com.Clinica1.myApp.mantenimiento.application.dto.DoctorDto;
import com.Clinica1.myApp.mantenimiento.application.dto.DoctorListadoDto;
import com.Clinica1.myApp.mantenimiento.application.query.BuscarDoctorPorNombreQuery;
import com.Clinica1.myApp.mantenimiento.application.query.ListarDoctorPorNombreQuery;
import com.Clinica1.myApp.mantenimiento.domain.model.valueobjects.Especialidad;
import com.Clinica1.myApp.mantenimiento.domain.repository.DoctorRepository;
import com.Clinica1.myApp.mantenimiento.domain.repository.EmpleadoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class BuscarDoctorPorNombreHandler {

    private final DoctorRepository doctorRepository;
    private final EmpleadoRepository empleadoRepository;

    public List<DoctorListadoDto> handle(ListarDoctorPorNombreQuery query) {

        return empleadoRepository.findByNombre(query.getNombre())
                .stream()
                .map(empleado ->
                        doctorRepository.findByIdEmpleado(empleado.getId_emp())
                                .map(doctor -> new DoctorListadoDto(
                                        doctor.getIdDoctor().obtenerid(),
                                        empleado.getId_emp().obtenerid(),
                                        empleado.getNombre() + " " + empleado.getApellido(),
                                        doctor.getCmp(),
                                        doctor.getConsultorio(),
                                        doctor.getEspecialidades()
                                                .stream()
                                                .map(Especialidad::nom_espe)
                                                .toList()
                                ))
                                .orElse(null)
                )
                .filter(java.util.Objects::nonNull)
                .toList();
    }
}