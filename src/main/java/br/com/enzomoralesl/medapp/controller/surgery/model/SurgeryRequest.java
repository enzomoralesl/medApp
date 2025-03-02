package br.com.enzomoralesl.medapp.controller.surgery.model;

import br.com.enzomoralesl.medapp.DTOs.medicalrecords.SurgeryType;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;

public record SurgeryRequest(
        @NotNull @JsonProperty("email") String patientEmail,
        @NotNull String date,
        @NotNull String doctorName,
        @NotNull String doctorCRM,
        @NotNull String description,
        @NotNull SurgeryType type
) {
}
