CREATE TABLE cursos(
    id BIGINT NOT NULL AUTO_INCREMENT,
    nombre varchar(100) NOT NULL UNIQUE,
    categoria VARCHAR(50) NOT NULL,

    PRIMARY KEY(id)
);