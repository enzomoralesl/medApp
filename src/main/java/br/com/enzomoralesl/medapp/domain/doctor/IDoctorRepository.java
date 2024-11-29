package br.com.enzomoralesl.medapp.domain.doctor;

import br.com.enzomoralesl.medapp.adapter.output.repository.entities.JpaDoctorEntity;

public interface IDoctorRepository {
    void save (JpaDoctorEntity doctorDto);
}
