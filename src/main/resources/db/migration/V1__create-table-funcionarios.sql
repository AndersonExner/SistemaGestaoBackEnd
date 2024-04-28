CREATE TABLE funcionarios(
    id BIGINT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    email VARCHAR(255) NULL,
    telefone INT NOT NULL,
    cargo VARCHAR(255) NOT NULL,
    salario FLOAT NOT NULL,
    cpf INT UNIQUE,
    rg INT NULL UNIQUE,
    endereco VARCHAR(255) NULL,
    data_registro TIMESTAMP NULL,
    data_update TIMESTAMP NULL
);

