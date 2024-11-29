package br.com.enzomoralesl.medapp.adapter.output.repository;

import br.com.enzomoralesl.medapp.adapter.output.repository.entities.JpaDoctorEntity;
import br.com.enzomoralesl.medapp.domain.doctor.IDoctorRepository;

public class DoctorRepository implements IDoctorRepository {
    public IJPADoctorRepository jpaDoctorRepository;

    public DoctorRepository(IJPADoctorRepository jpaDoctorRepository) {
        this.jpaDoctorRepository = jpaDoctorRepository;
    }


    @Override
    public void save(JpaDoctorEntity doctorEntity) {
         this.jpaDoctorRepository.save(doctorEntity);
    }
}
