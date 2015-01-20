create database consorcio;
use consorcio;
create table tb_empleado
 (
cod_emp int primary key auto_increment,
nom_emp varchar(25),
ape_emp varchar(25),
costo_hora numeric(8,2),
dni_emp int,
fec_ing_emp date,
cod_dis int
);
create table tb_distrito
 (
cod_dis int primary key auto_increment,
nom_dis varchar(30)
);
alter table tb_empleado add constraint fk1 foreign key(cod_dis) references tb_distrito(cod_dis);
insert into tb_distrito values(1,'Comas');
insert into tb_distrito values(2,'Callao');
insert into tb_distrito values(3,'Lince');
delimiter //

CREATE PROCEDURE spDistrito(xnom VARCHAR(30))

BEGIN
    
insert into tb_distrito(nom_dis) values(xnom);

END
//