-- Crear la base de datos
CREATE DATABASE users_manager;

-- Usar la base de datos creada
USE user_manager;

-- Crear tabla "phones"
CREATE TABLE phones (
    number VARCHAR(255) NOT NULL,
    city_code VARCHAR(255),
    contry_code VARCHAR(255),
    PRIMARY KEY (number)
);

-- Crear tabla "users"
CREATE TABLE users (
    id UUID NOT NULL,
    active BOOLEAN NOT NULL,
    created TIMESTAMP(6),
    email VARCHAR(255),
    last_login TIMESTAMP(6),
    modified TIMESTAMP(6),
    name VARCHAR(255),
    password VARCHAR(255),
    token VARCHAR(255),
    PRIMARY KEY (id)
);

-- Crear tabla intermedia "users_phones" para la relación entre "users" y "phones"
CREATE TABLE users_phones (
    user_id UUID NOT NULL,
    phones_number VARCHAR(255) NOT NULL
);