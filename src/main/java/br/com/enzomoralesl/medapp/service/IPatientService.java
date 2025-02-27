package br.com.enzomoralesl.medapp.service;

import br.com.enzomoralesl.medapp.controller.patient.model.PatientRequest;
import br.com.enzomoralesl.medapp.controller.patient.model.PatientResponse;
import br.com.enzomoralesl.medapp.infrastructure.exception.ResourceNotFoundException;

import java.util.Map;


public interface IPatientService {
    PatientResponse save(PatientRequest request);

    PatientResponse fetch(Map<String, String> request) throws ResourceNotFoundException;
}
