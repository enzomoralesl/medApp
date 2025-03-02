package br.com.enzomoralesl.medapp.controller.medicalrecord.model;

import br.com.enzomoralesl.medapp.DTOs.medicalrecords.SurgeryDTO;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record MedicalRecordRequest(
        @NotNull @NotBlank String emailPatient,
        List<SurgeryDTO> surgeries
) {
}
