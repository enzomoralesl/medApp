package br.com.enzomoralesl.medapp.service;

import br.com.enzomoralesl.medapp.controller.doctor.model.DoctorRequest;
import br.com.enzomoralesl.medapp.controller.doctor.model.DoctorResponse;
import br.com.enzomoralesl.medapp.infrastructure.exception.ResourceNotFoundException;
import br.com.enzomoralesl.medapp.repository.IJPADoctorRepository;
import br.com.enzomoralesl.medapp.repository.entities.JpaDoctorEntity;
import br.com.enzomoralesl.medapp.utils.mapper.IDoctorMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class DoctorService implements IDoctorService {

    public IJPADoctorRepository jpaDoctorRepository;
    IDoctorMapper mapper;

    public DoctorService(IJPADoctorRepository jpaDoctorRepository, @Qualifier("IDoctorMapperImpl") IDoctorMapper mapper) {
        this.jpaDoctorRepository = jpaDoctorRepository;
        this.mapper = mapper;
    }

    @Override
    public DoctorResponse save(DoctorRequest request) {
        JpaDoctorEntity doctorEntity = mapper.toJpaDoctorEntity(request);
        jpaDoctorRepository.save(doctorEntity);
        return new DoctorResponse(doctorEntity.getId(), doctorEntity.getName(), doctorEntity.getSpecialty(), doctorEntity.getCrm());
    }

    @Override
    public DoctorResponse fetch(Map<String, String> request) throws ResourceNotFoundException {
        JpaDoctorEntity doctorEntity = this.jpaDoctorRepository.findByCrm(request.get("crm"));
        if(doctorEntity == null) {
            throw new ResourceNotFoundException("Doutor não encontrado na base de dados");
        }
        return new DoctorResponse(doctorEntity.getId(), doctorEntity.getName(), doctorEntity.getSpecialty(), doctorEntity.getCrm());
    }
}
