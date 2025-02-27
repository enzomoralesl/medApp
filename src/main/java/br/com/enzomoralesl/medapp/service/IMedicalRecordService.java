package br.com.enzomoralesl.medapp.service;

import br.com.enzomoralesl.medapp.controller.medicalrecord.model.MedicalRecordRequest;
import br.com.enzomoralesl.medapp.controller.medicalrecord.model.MedicalRecordResponse;


public interface IMedicalRecordService {
    MedicalRecordResponse save(MedicalRecordRequest request);

}
