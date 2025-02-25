package br.com.enzomoralesl.medapp.domain.doctor;


import br.com.enzomoralesl.medapp.infrastructure.config.exception.ResourceNotFoundException;

import java.util.Map;

public interface IDoctorRepository {
    void save(DoctorDTO doctorDto);

    DoctorDTO fetch(Map<String, String> request) throws ResourceNotFoundException;
}
