package br.com.enzomoralesl.medapp.DTOs.medicalrecords;

public enum SurgeryType {
    SIMPLE("Simples"),
    EMERGENCY("Emergencia"),
    CANCER("Cancer"),
    BONES("Ossos"),
    COMPLEX("Complexa"),
    OTHER("Outro");

    SurgeryType(String tipo) {

    }

    public static SurgeryType fromString(String type) {
        try {
            return SurgeryType.valueOf(type.toUpperCase());
        } catch (IllegalArgumentException | NullPointerException e) {
            return OTHER;
        }
    }
}
