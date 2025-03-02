-- Enable the uuid-ossp extension
SET search_path TO public;
DROP EXTENSION IF EXISTS "uuid-ossp";

CREATE EXTENSION "uuid-ossp" SCHEMA public;

DROP TABLE IF EXISTS tb_surgery;
DROP TABLE IF EXISTS tb_doctor;
DROP TABLE IF EXISTS tb_medical_record;
DROP TABLE IF EXISTS tb_patient;

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

-- Insert data into tb_patient
INSERT INTO tb_patient (id, email, name, cpf, password, phone, birth_date)
VALUES
    (uuid_generate_v4(), 'john1000.doee@example.com', 'John doee', '12345678901', 'password', '1234567890', '1990-01-01'),
    (uuid_generate_v4(), 'enzo.moralesl@example.com', 'Enzo Morales', '12312312345', 'password', '1234567891', '1992-02-02');

-- Insert data into tb_medical_record
INSERT INTO tb_medical_record (id, patient_id)
VALUES
    (uuid_generate_v4(), (SELECT id FROM tb_patient WHERE email = 'john1000.doee@example.com')),
    (uuid_generate_v4(), (SELECT id FROM tb_patient WHERE email = 'enzo.moralesl@example.com'));

-- Insert data into tb_doctor
INSERT INTO tb_doctor (id, name, specialty, crm)
VALUES
    (uuid_generate_v4(), 'Dr. Smith', 'Cardiology', 'DESCUBRAA');

-- Insert data into tb_surgery
INSERT INTO tb_surgery (id, date, doctor_name, doctorcrm, description, type, medical_record_id)
VALUES
    (uuid_generate_v4(), '2025-03-01', 'Dr. Smith', 'DESCUBRAA', 'Heart surgery', 'COMPLEX', (SELECT id FROM tb_medical_record WHERE patient_id = (SELECT id FROM tb_patient WHERE email = 'john1000.doee@example.com'))),
    (uuid_generate_v4(), '2025-04-01', 'Dr. Smith', 'DESCUBRAA', 'Knee surgery', 'COMPLEX', (SELECT id FROM tb_medical_record WHERE patient_id = (SELECT id FROM tb_patient WHERE email = 'enzo.moralesl@example.com')));