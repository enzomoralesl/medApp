package br.com.enzomoralesl.medapp.service;

import br.com.enzomoralesl.medapp.controller.patient.model.PatientRequest;
import br.com.enzomoralesl.medapp.controller.patient.model.PatientResponse;

import java.util.Map;


public interface IPatientService {
    PatientResponse save(PatientRequest request);

    PatientResponse fetch(Map<String, String> request);
}
