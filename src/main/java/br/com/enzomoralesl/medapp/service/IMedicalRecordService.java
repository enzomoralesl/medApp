package br.com.enzomoralesl.medapp.service;

import br.com.enzomoralesl.medapp.controller.medicalrecord.model.MedicalRecordRequest;
import br.com.enzomoralesl.medapp.controller.medicalrecord.model.MedicalRecordResponse;

import java.util.Map;


public interface IMedicalRecordService {
    MedicalRecordResponse save(MedicalRecordRequest request);
    MedicalRecordResponse fetch(Map<String, String> requestMap);

}
