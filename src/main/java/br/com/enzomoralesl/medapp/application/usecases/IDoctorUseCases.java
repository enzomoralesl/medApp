package br.com.enzomoralesl.medapp.application.usecases;

import br.com.enzomoralesl.medapp.adapter.input.controllers.doctor.model.DoctorRequest;
import br.com.enzomoralesl.medapp.adapter.input.controllers.doctor.model.DoctorResponse;
import br.com.enzomoralesl.medapp.infrastructure.config.exception.ResourceNotFoundException;

import java.util.Map;


public interface IDoctorUseCases {
    DoctorResponse save(DoctorRequest request);

    DoctorResponse fetch(Map<String, String> request) throws ResourceNotFoundException;
}
