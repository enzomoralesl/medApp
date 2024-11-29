package br.com.enzomoralesl.medapp.application.services;

import br.com.enzomoralesl.medapp.adapter.input.controllers.doctor.model.DoctorRequest;
import br.com.enzomoralesl.medapp.adapter.input.controllers.doctor.model.DoctorResponse;
import br.com.enzomoralesl.medapp.adapter.output.repository.entities.JpaDoctorEntity;
import br.com.enzomoralesl.medapp.application.usecases.ICreateDoctorUseCases;
import br.com.enzomoralesl.medapp.domain.doctor.IDoctorRepository;
import br.com.enzomoralesl.medapp.utils.IDoctorMapper;

public class CreateDoctorUseCases implements ICreateDoctorUseCases {

    IDoctorRepository doctorRepository;
    IDoctorMapper mapper;

    public CreateDoctorUseCases(IDoctorRepository doctorRepository, IDoctorMapper mapper) {
        this.doctorRepository = doctorRepository;
        this.mapper = mapper;
    }

    @Override
    public DoctorResponse save(DoctorRequest request) {
        JpaDoctorEntity doctorEntity = mapper.toJpaDoctorEntity(request);
        doctorRepository.save(doctorEntity);
        return new DoctorResponse(doctorEntity.getId(), doctorEntity.getName(), doctorEntity.getSpecialty(), doctorEntity.getCrm());
    }
}
