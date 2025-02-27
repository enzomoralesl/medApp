package br.com.enzomoralesl.medapp.DTOs;


import br.com.enzomoralesl.medapp.repository.entities.JpaDoctorEntity;

import java.util.UUID;

public class DoctorDTO {
    private UUID id;
    private String name;
    private String specialty;
    private String crm;

    public DoctorDTO(UUID id, String name, String specialty, String crm) {
        this.id = id;
        this.name = name;
        this.specialty = specialty;
        this.crm = crm;
    }
    public DoctorDTO() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }


    public JpaDoctorEntity toDoctorEntity() {
        return new JpaDoctorEntity(this.id, this.name, this.specialty, this.crm);
    }
}
