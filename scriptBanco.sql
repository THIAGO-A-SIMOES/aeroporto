create database aeroporto;

use aeroporto;

create table companiaAerea(
idCompAerea integer not null primary key auto_increment,
descricao varchar(60) not null,
situacao integer not null,
FOREIGN KEY (situacao) REFERENCES situacoes(idSituacao)
);

create table situacoes(
idSituacao integer not null primary key auto_increment,
descricao varchar(30) not null
);


create table users(
iduser integer not null primary key unique auto_increment,
user varchar(15) not null unique,
password varchar(16) not null,
nameuser varchar(32) not null,
compAerea integer not null,
situacao integer not null,
perfil integer not null, -- 1(Administrador), 2(Comum), 3(Supervisor)
FOREIGN KEY (compAerea) REFERENCES companiaAerea(idCompAerea),
FOREIGN KEY (situacao) REFERENCES situacoes(idSituacao)
)auto_increment = 1;


insert into situacoes(descricao) values ('Ativado'),('Desativado');
insert into companiaAerea(descricao, situacao) values('Dubai Airlane',1);
insert into users(user, password, nameuser, compAerea, situacao, perfil) values ('admin','admin123','Administrador',1,1,1);



select * from companiaaerea order by idCompAerea;

select * from users order by iduser;

select * from situacoes;


select u.idUser as CodigoUsuario, u.nameuser as NomeUsuario, u.user as Usuario, ca.descricao as CompaniaAerea, 
case when u.perfil = 1 then 'Administrador' when u.perfil = 2 then 'Comum' when u.perfil = 3 then 'Supervisor' end as PerfilUsuario,
case when u.situacao = 1 then 'Ativado' when u.situacao = 0 then 'Desativado' end as Situacao  from users u, companiaAerea ca where ca.idCompAerea = u.compAerea;

select * from situacoes;




/*"  select u.idUser as CodigoUsuario, u.nameuser as NomeUsuario, u.user as Usuario, ca.descricao as CompaniaAerea,                                                                     " +
                     "  case when u.perfil = 1 then 'Administrador' when u.perfil = 2 then 'Comum' when u.perfil = 3 then 'Supervisor' end as PerfilUsuario,                                               " +
                     "  case when u.situacao = 1 then 'Ativado' when u.situacao = 0 then 'Desativado' end as Situacao  from users u, companiaAerea ca where ca.idCompAerea = u.compAerea and idUser = ?    ";*/

