package br.com.enzomoralesl.medapp.application.usecases;

import br.com.enzomoralesl.medapp.adapter.input.controllers.doctor.model.DoctorRequest;
import br.com.enzomoralesl.medapp.adapter.input.controllers.doctor.model.DoctorResponse;


public interface ICreateDoctorUseCases {
    DoctorResponse save(DoctorRequest request);
}
