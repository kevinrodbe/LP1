--ejemplo 2
create trigger tr_transacciones_paises
on ventas.paises
for insert, update, delete
as
print 'se ejecutò el trigger para la tabla pais'

--probando trigger
delete from ventas.paises
where idpais='021'
go
insert into ventas.paises values('011','ecuador')
go	
update ventas.paises set NombrePais='bolivia'
where Idpais='011'
go
--ejemplo 3
alter trigger rrhh.tr_cargos
on rrhh.cargos
for insert, update, delete
as
print 'se ejecutò el trigger para la tabla cargos'
go
--borrar trigger
drop trigger rrhh.tr_cargos
--probar

--
go
create trigger ventas.tr_aud_clientes
on ventas.clientes
for insert
as
begin
insert into aud_clientes(codcliente,nomcliente,fecha_creacion)
select idcliente,nomcliente,getdate() from inserted
end
--probando
insert into ventas.clientes values('dpmar','duran perez maria','jr. azangaro ·454','001','12345678')
go
select * from aud_clientes
go

--ejercicio
/*
crear un disparador que cada vez que se elimine un producto, se agrege de forma automatica a una nueva tabla tipo auditoria
con los campos id, codprod, nombre, precio, stock, fecha_creaciony hora creacion
*/
create table aud_tbcategoria(
idcategoria int identity(1,1) primary key,
codcate int not null,
nombre int not null,
servidor varchar(15) not null,
usuario varchar(25) not null,
fecha_creacion date,
hora_creacion time
)
go
drop table aud_tbcategoria
--creacion trigger
alter trigger Compras.tr_delete_categorias
on Compras.categorias
for insert
as
begin
insert into aud_tbcategoria(codcate,nombre,servidor,usuario,fecha_creacion,hora_creacion)
select idcategoria, nombrecategoria, @@SERVERNAME,current_user, getdate(),GETDATE() from inserted
end
--probando
insert into compras.categorias values(13,'Zapatos','todo tipo')
delete from Compras.categorias where IdCategoria=13
go
select * from aud_tbcategoria