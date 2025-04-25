-- Enable the uuid-ossp extension
SET search_path TO public;
DROP EXTENSION IF EXISTS "uuid-ossp";

CREATE EXTENSION "uuid-ossp" SCHEMA public;


-- Insert data into tb_patient
INSERT INTO tb_patient (id, email, name, cpf, password, phone, birth_date)
VALUES
    (uuid_generate_v4(), 'john1000.doee@example.com', 'John doee', '12345678901', 'password', '1234567890', '1990-01-01'),
    (uuid_generate_v4(), 'enzo.moralesl@example.com', 'Enzo Morales', '12312312345', 'password', '1234567891', '1992-02-02');

-- Insert data into tb_doctor
INSERT INTO tb_doctor (id, name, specialty, crm)
VALUES
    (uuid_generate_v4(), 'Dr. Smith', 'Cardiology', 'DESCUBRAA');
