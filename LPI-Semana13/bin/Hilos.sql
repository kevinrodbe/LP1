Create database hilos;
use hilos;
create table tb_cliente
(
	cod_cli int primary key auto_increment,
	nom_cli varchar(30),
	ape_cli varchar(30),
	tiempo_sesion varchar(10)
);
insert into tb_cliente values(1,'Ana','Soto','01:30:30');
insert into tb_cliente values(2,'Maria','Rivera','00:30:30');
insert into tb_cliente values(3,'Alicia','Acuña','00:03:30');
insert into tb_cliente values(4,'Gloria','Palacios','00:01:30');
