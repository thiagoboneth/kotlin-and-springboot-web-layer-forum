create table curso(
    id bigint not null auto_increment,
    nome varchar(255) not null,
    categoria varchar(255) not null,
    primary key (id)
);

insert into curso(nome, categoria) values('Kotlin', 'Programação');