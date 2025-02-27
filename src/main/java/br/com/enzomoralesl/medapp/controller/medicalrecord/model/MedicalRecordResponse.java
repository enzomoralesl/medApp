package br.com.enzomoralesl.medapp.controller.medicalrecord.model;

import java.util.UUID;

public record MedicalRecordResponse(
        UUID id,
        String teste,
        UUID id_patient
) {
}