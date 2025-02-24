package br.com.enzomoralesl.medapp.domain.doctor;


import java.util.Map;

public interface IDoctorRepository {
    void save (DoctorDTO doctorDto);
    DoctorDTO fetch (Map<String, String> request);
}
