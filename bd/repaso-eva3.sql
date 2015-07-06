--# procedimiento con parametros de entrada
create procedure usp_actualizar_categorias
@nom varchar(15),
@des text,
@id int
as
update compras.categorias set NombreCategoria=@nom,
Descripcion=@des where IdCategoria=@id
if(@@Error=0)
begin
print 'Se actualizo la categoria satisfactoriamente'
end
else
begin
print 'Se produjeron errores al actualizar'
end
GO
--ejecutar
exec usp_actualizar_categorias 'Golosina','todo tipo de dulces',9
Select * from Compras.categorias

--# procedimiento almacenado con parametros de salida (output)
create procedure usp_total_productos
@c int output
as
begin
select @c=count(*) from compras.productos
end
--ejecutar
declare @can int
exec usp_total_productos @c = @can output
print 'total productos' +str(@can)
go

--# procedemos variables para el cursor
create procedure usp_listar_cursor_categorias
as
begin
--declaramos variables para el cursor
declare @id int, @nom varchar(15), @des varchar(100)
--creamos el cursor
declare cListarCategorias cursor for
select IdCategoria, NombreCategoria, Descripcion
from compras.categorias
open cListarCategorias
fetch cListarCategorias into @id, @nom, @des
while (@@FETCH_STATUS=0)
begin
print cast(@id as varchar)+space(5)+' '+@nom+' '+@des
fetch cListarCategorias into @id,@nom,@des
end
close cListarCategorias
deallocate cListarCategorias
end
--ejecutar
execute usp_listar_cursor_categorias

--# procedimientos almacenados con cursores y parametros
create procedure usp_Buscar_Cursor_Clientes
@codclie varchar(5)
As
Begin
declare @id varchar(5), @nom varchar(40), @dir varchar(60), @pais varchar(40)
declare cBuscarClientes cursor for
select c.IdCliente, c.NomCliente, c.DirCliente, p.NombrePais
from ventas.clientes c inner join ventas.paises p
on c.idPais=p.Idpais
where c.IdCliente=@codclie
open cBuscarClientes
fetch cBuscarClientes into @id,@nom,@dir,@pais
while(@@FETCH_STATUS=0)
begin
print @id+' '+@nom+' '+@dir+' '+@pais
fetch cBuscarClientes into @id, @nom, @dir, @pais
end
close cBuscarClientes
deallocate cBuscarClientes
end
--ejecutar
exec usp_Buscar_Cursor_Clientes 'ANTON'

/* función de tabla -- no see */
create function fListarPreg3() Returns Table
as
Return(
select YEAR(f.fecha_emision) as fecha, c.razon_social, f.idfactura, sum(d.precio*d.cantidad) as total
from tb_factura f join tb_cliente c
on f.idcliente = c.idcliente
join tb_detfactura d
on d.idfactura = f.idfactura
group by f.idfactura,c.razon_social,fecha_emision
)
go
--ejecutar
select * from dbo.fListarPreg3()
