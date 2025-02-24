package br.com.enzomoralesl.medapp.application.services;

import br.com.enzomoralesl.medapp.adapter.input.controllers.doctor.model.DoctorRequest;
import br.com.enzomoralesl.medapp.adapter.input.controllers.doctor.model.DoctorResponse;
import br.com.enzomoralesl.medapp.application.usecases.IDoctorUseCases;
import br.com.enzomoralesl.medapp.domain.doctor.DoctorDTO;
import br.com.enzomoralesl.medapp.domain.doctor.IDoctorRepository;
import br.com.enzomoralesl.medapp.infrastructure.config.exception.ResourceNotFoundException;
import br.com.enzomoralesl.medapp.utils.IDoctorMapper;

import java.util.Map;

public class DoctorUseCases implements IDoctorUseCases {

    IDoctorRepository doctorRepository;
    IDoctorMapper mapper;

    public DoctorUseCases(IDoctorRepository doctorRepository, IDoctorMapper mapper) {
        this.doctorRepository = doctorRepository;
        this.mapper = mapper;
    }

    @Override
    public DoctorResponse save(DoctorRequest request) {
        DoctorDTO doctor = mapper.toDoctorDto(request);
        doctorRepository.save(doctor);
        return new DoctorResponse(doctor.getId(), doctor.getName(), doctor.getSpecialty(), doctor.getCrm());
    }

    @Override
    public DoctorResponse fetch(Map<String, String> request) throws ResourceNotFoundException {
        DoctorDTO doctorDTO = doctorRepository.fetch(request);
        return new DoctorResponse(doctorDTO.getId(), doctorDTO.getName(), doctorDTO.getSpecialty(), doctorDTO.getCrm());
    }
}
