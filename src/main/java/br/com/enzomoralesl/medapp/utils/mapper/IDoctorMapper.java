package br.com.enzomoralesl.medapp.utils.mapper;

import br.com.enzomoralesl.medapp.controller.doctor.model.DoctorRequest;
import br.com.enzomoralesl.medapp.repository.entities.JpaDoctorEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IDoctorMapper {
    JpaDoctorEntity toJpaDoctorEntity(DoctorRequest doctorRequest);
}
