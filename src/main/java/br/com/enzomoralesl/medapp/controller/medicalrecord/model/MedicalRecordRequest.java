package br.com.enzomoralesl.medapp.controller.medicalrecord.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record MedicalRecordRequest(
        @NotNull @NotBlank String emailPatient,
        String teste
) {
}
