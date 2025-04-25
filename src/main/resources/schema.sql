DROP SCHEMA public CASCADE;
CREATE SCHEMA public;

-- Create tb_patient table
CREATE TABLE IF NOT EXISTS tb_patient (
                                          id UUID PRIMARY KEY,
                                          email VARCHAR(255) UNIQUE NOT NULL,
                                          name VARCHAR(255) NOT NULL,
                                          cpf VARCHAR(11) UNIQUE NOT NULL,
                                          password VARCHAR(255) NOT NULL,
                                          phone VARCHAR(50),
                                          birth_date VARCHAR(15)
);


-- Create tb_doctor table
CREATE TABLE IF NOT EXISTS tb_doctor (
                                         id UUID PRIMARY KEY,
                                         name VARCHAR(255) NOT NULL,
                                         specialty VARCHAR(255) NOT NULL,
                                         crm VARCHAR(20) UNIQUE NOT NULL
);