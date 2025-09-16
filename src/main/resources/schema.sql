DROP SCHEMA public CASCADE;
CREATE SCHEMA public;

-- Create tb_patient table
CREATE TABLE IF NOT EXISTS tb_patient (
                                          id UUID PRIMARY KEY,
                                          email VARCHAR(255) NOT NULL,
                                          name VARCHAR(255) NOT NULL,
                                          cpf VARCHAR(11) NOT NULL,
                                          password VARCHAR(255) NOT NULL,
                                          phone VARCHAR(50),
                                          birth_date VARCHAR(15),
                                          CONSTRAINT tb_patient_email_key UNIQUE (email)
);