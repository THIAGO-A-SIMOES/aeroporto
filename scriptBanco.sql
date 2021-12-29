use aeroporto;

create table situacoes(
idSituacao integer not null primary key auto_increment,
descricao varchar(50) not null
)auto_increment = 1;

create table companiaAerea(
idCompAerea integer not null primary key auto_increment,
descricao varchar(60) not null,
situacao integer not null,
FOREIGN KEY (situacao) REFERENCES situacoes(idSituacao)
);

create table users(
iduser integer not null primary key unique auto_increment,
user varchar(15) not null unique,
password varchar(16) not null,
nameuser varchar(32) not null,
compAerea integer not null,
situacao integer not null,
perfil integer not null, -- 1(Administrador), 2(Comumm), 3(Supervisor)
FOREIGN KEY (compAerea) REFERENCES companiaAerea(idCompAerea),
FOREIGN KEY (situacao) REFERENCES situacoes(idSituacao)
)auto_increment = 1;


insert into situacoes(descricao) values ('Ativado'),('Desativado');
insert into companiaAerea(descricao, situacao) values('Administradores',2);
insert into users(user, password, nameuser, compAerea, situacao, perfil) values ('admin','admin123','Administrador',1,1,1);



select * from users;

