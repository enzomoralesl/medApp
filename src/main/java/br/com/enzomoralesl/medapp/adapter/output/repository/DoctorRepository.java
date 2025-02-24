package br.com.enzomoralesl.medapp.adapter.output.repository;

import br.com.enzomoralesl.medapp.adapter.output.repository.entities.JpaDoctorEntity;
import br.com.enzomoralesl.medapp.domain.doctor.DoctorDTO;
import br.com.enzomoralesl.medapp.domain.doctor.IDoctorRepository;

import java.util.Map;

public class DoctorRepository implements IDoctorRepository {
    public IJPADoctorRepository jpaDoctorRepository;

    public DoctorRepository(IJPADoctorRepository jpaDoctorRepository) {
        this.jpaDoctorRepository = jpaDoctorRepository;
    }


    @Override
    public void save(DoctorDTO doctor) {
        JpaDoctorEntity doctorEntity = doctor.toDoctorEntity();
         this.jpaDoctorRepository.save(doctorEntity);
        doctor.setId(doctorEntity.getId());
    }

    @Override
    public DoctorDTO fetch(Map<String, String> request) {
        JpaDoctorEntity doctorEntity = this.jpaDoctorRepository.findByCrm(request.get("crm"));
        return new DoctorDTO(doctorEntity.getId(), doctorEntity.getName(), doctorEntity.getSpecialty(), doctorEntity.getCrm());
    }
}
