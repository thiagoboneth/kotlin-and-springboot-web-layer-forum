create table usuario(
    id bigint not null auto_increment,
    nome varchar(255) not null,
    email varchar(255) not null,
    primary key (id)
);

insert into usuario(nome, email) values('Rafael', 'rafa@email.com');