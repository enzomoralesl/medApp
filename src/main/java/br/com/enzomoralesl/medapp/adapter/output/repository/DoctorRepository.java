package br.com.enzomoralesl.medapp.adapter.output.repository;

import br.com.enzomoralesl.medapp.adapter.output.repository.entities.JpaDoctorEntity;
import br.com.enzomoralesl.medapp.domain.doctor.DoctorDTO;
import br.com.enzomoralesl.medapp.domain.doctor.IDoctorRepository;
import br.com.enzomoralesl.medapp.infrastructure.config.exception.ResourceNotFoundException;

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
    public DoctorDTO fetch(Map<String, String> request) throws ResourceNotFoundException {
        JpaDoctorEntity doctorEntity = this.jpaDoctorRepository.findByCrm(request.get("crm"));
        if(doctorEntity == null) {
            throw new ResourceNotFoundException("Doutor não encontrado na base de dados");
        }

        return new DoctorDTO(doctorEntity.getId(), doctorEntity.getName(), doctorEntity.getSpecialty(), doctorEntity.getCrm());
    }
}
