package br.com.enzomoralesl.medapp.utils;

import br.com.enzomoralesl.medapp.adapter.input.controllers.doctor.model.DoctorRequest;
import br.com.enzomoralesl.medapp.adapter.output.repository.entities.JpaDoctorEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IDoctorMapper {
    JpaDoctorEntity toJpaDoctorEntity(DoctorRequest doctorDto);
}
