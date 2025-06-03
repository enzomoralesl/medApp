package br.com.enzomoralesl.medapp.controller.patient.model;

import java.util.UUID;

public record PatientResponse(
        UUID id,
        String email,
        String name,
        String cpf,
        String password,
        String phone,
        String birthDate
) {
}