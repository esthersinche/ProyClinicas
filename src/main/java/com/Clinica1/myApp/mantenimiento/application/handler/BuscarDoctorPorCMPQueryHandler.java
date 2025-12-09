package com.Clinica1.myApp.mantenimiento.application.handler;
import com.Clinica1.myApp.mantenimiento.application.dto.DoctorDto;
import com.Clinica1.myApp.mantenimiento.application.assembler.DoctorAssembler;
import com.Clinica1.myApp.mantenimiento.application.exception.DomainException;
import com.Clinica1.myApp.mantenimiento.application.query.BuscarDoctorPorCMPQuery;
import com.Clinica1.myApp.mantenimiento.domain.model.aggregates.Doctor;
import com.Clinica1.myApp.mantenimiento.domain.repository.DoctorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BuscarDoctorPorCMPQueryHandler {

    private final DoctorRepository doctorRepository;
    private final DoctorAssembler assembler = new DoctorAssembler();

    public DoctorDto handle(BuscarDoctorPorCMPQuery query) {
        return assembler.toDto(
                doctorRepository.findByCmp(query.getCmp())
        );
    }
}