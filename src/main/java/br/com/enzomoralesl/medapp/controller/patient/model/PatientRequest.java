package br.com.enzomoralesl.medapp.controller.patient.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record PatientRequest(
        @NotNull @NotBlank String email,
        @NotNull @NotBlank String name,
//        MedicalRecordDTO medicalRecord,
        @NotNull @NotBlank String cpf,
        @NotNull @NotBlank String password,
        @NotNull @NotBlank String phone,
        @NotNull @NotBlank String birthDate
        ) {
}
