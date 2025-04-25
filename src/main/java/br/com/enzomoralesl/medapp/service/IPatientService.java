package br.com.enzomoralesl.medapp.service;

import br.com.enzomoralesl.medapp.controller.patient.model.PatientRequest;
import br.com.enzomoralesl.medapp.controller.patient.model.PatientResponse;

import java.util.List;


public interface IPatientService {
    PatientResponse save(PatientRequest request);
    PatientResponse fetch(String request);
    PatientResponse update(String email, PatientRequest request);
    void delete(String email);
    List<PatientResponse> fetchAll();
}
