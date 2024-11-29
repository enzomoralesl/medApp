package br.com.enzomoralesl.medapp.adapter.input.controllers.doctor.model;

import java.util.UUID;


public record DoctorResponse(UUID id, String name, String specialty, String crm) {
}
