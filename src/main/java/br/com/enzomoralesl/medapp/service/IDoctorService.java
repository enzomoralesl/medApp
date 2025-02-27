package br.com.enzomoralesl.medapp.service;

import br.com.enzomoralesl.medapp.controller.doctor.model.DoctorRequest;
import br.com.enzomoralesl.medapp.controller.doctor.model.DoctorResponse;
import br.com.enzomoralesl.medapp.infrastructure.exception.ResourceNotFoundException;

import java.util.Map;


public interface IDoctorService {
    DoctorResponse save(DoctorRequest request);

    DoctorResponse fetch(Map<String, String> request) throws ResourceNotFoundException;
}
