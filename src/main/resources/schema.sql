DROP SCHEMA public CASCADE;
CREATE SCHEMA public;

-- Create tb_patient table
CREATE TABLE IF NOT EXISTS tb_patient (
                                          id UUID PRIMARY KEY,
                                          email VARCHAR(255) UNIQUE NOT NULL,
                                          name VARCHAR(255) NOT NULL,
                                          cpf VARCHAR(11) UNIQUE NOT NULL,
                                          password VARCHAR(255) NOT NULL,
                                          phone VARCHAR(15),
                                          birth_date DATE
);

-- Create tb_medical_record table
CREATE TABLE IF NOT EXISTS tb_medical_record (
                                                 id UUID PRIMARY KEY,
                                                 patient_id UUID REFERENCES tb_patient(id)
);

-- Create tb_doctor table
CREATE TABLE IF NOT EXISTS tb_doctor (
                                         id UUID PRIMARY KEY,
                                         name VARCHAR(255) NOT NULL,
                                         specialty VARCHAR(255) NOT NULL,
                                         crm VARCHAR(20) UNIQUE NOT NULL
);

-- Create tb_surgery table
CREATE TABLE IF NOT EXISTS tb_surgery (
                                          id UUID PRIMARY KEY,
                                          date DATE NOT NULL,
                                          doctor_name VARCHAR(255) NOT NULL,
                                          doctorcrm VARCHAR(20) NOT NULL,
                                          description TEXT,
                                          type VARCHAR(50),
                                          medical_record_id UUID REFERENCES tb_medical_record(id)
);