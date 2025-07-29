create table topicos(
    id bigint not null auto_increment
    titulo varchar(100) not null unique,
    mensaje varchar(100) not null,
    fecha-de-creacion varchar(6) not null,
    status varchar(100) not null,
    autor varchar(100) not null unique,
    curso varchar(100) not null,

    primary key(id)
);