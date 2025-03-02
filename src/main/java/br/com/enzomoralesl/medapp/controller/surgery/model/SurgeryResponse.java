package br.com.enzomoralesl.medapp.controller.surgery.model;

import br.com.enzomoralesl.medapp.DTOs.medicalrecords.SurgeryType;

import java.util.UUID;

public record SurgeryResponse(
        UUID id,
        String date,
        String doctorName,
        String doctorCRM,
        String description,
        SurgeryType type
) {
}
