create table tbComensal(
codcomensal char(5) not null,
paterno varchar(25) not null,
dni char(8) not null,
genero char(1) not null
)
go
alter table tbComensal
add constraint pk_codcomensal
primary key(codcomensal)
go
alter table tbComensal
add constraint uq_dni
unique(dni)
go
alter table tbComensal
add constraint ck_sexo
check(genero ='m' or genero='f')
go
alter table tbComensal
add constraint df_correo
default '@'
for correo
go

insert into tbComensal (codcomensal,paterno,materno,) values('c1','')