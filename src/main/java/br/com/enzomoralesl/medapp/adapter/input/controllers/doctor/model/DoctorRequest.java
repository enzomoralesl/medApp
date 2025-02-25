package br.com.enzomoralesl.medapp.adapter.input.controllers.doctor.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DoctorRequest(
        @NotNull @NotBlank String name,
        @NotNull @NotBlank String specialty,
        @NotNull @NotBlank String crm) {
}
