CREATE SEQUENCE funcionarios_id_seq;

CREATE TABLE funcionarios
(
    id BIGINT NOT NULL DEFAULT NEXTVAL('funcionarios_id_seq'),
    nome character varying(255) NOT NULL,
    email character varying(255),
    senha character varying(255) NOT NULL,
    telefone character varying(20) NOT NULL,
    cargo character varying(255),
    salario character varying(15) NOT NULL,
    cpf character varying(15),
    endereco character varying(255),
    data_registro timestamp,
    data_update timestamp,
    CONSTRAINT funcionarios_pkey PRIMARY KEY (id),
    CONSTRAINT funcionarios_cpf_key UNIQUE (cpf)
);


ALTER SEQUENCE funcionarios_id_seq
    START WITH 1
    INCREMENT BY 1
    MINVALUE 1
    MAXVALUE 999999999 
;
