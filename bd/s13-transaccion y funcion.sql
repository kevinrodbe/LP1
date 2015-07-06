--Transacción implícita
Update Compras.productos
Set PrecioUnidad=50
Where IdProducto=10
go

--Transacción Explícita (Confirmando Transacción)
Begin Tran 
Update Compras.productos
Set PrecioUnidad=40
Where IdProducto=10;
Commit Tran;

--Transacción Explícita (Anulando Transacción)
Begin Tran 
Update Compras.productos
Set PrecioUnidad=40
Where IdProducto=10;
Rollback Tran;

/*Crear un SP que permita realizar la actualización de los precios de producto,
confirmando solo si el nuevo precio tiene una diferencia de 5, ya sea incrementando o
reduciendo*/
Alter Procedure Usp_040714001
@p_idProducto smallint,
@p_nuevoPrecio money
As
Begin
	Declare @vc_IdProducto smallint, @vc_Precio Money 
	Declare C_Producto Cursor For Select IdProducto, PrecioUnidad from Compras.productos
									where IdProducto = @p_idProducto
									for Update
	Open  C_producto
	Fetch C_Producto Into @vc_IdProducto,@vc_Precio
	Begin Tran
		Update Compras.productos
		Set PrecioUnidad = @p_nuevoPrecio
		Where current of C_Producto
		;
		
		If (@p_nuevoPrecio - @vc_Precio)=5 or (- @vc_Precio - @p_nuevoPrecio )=5
			Commit Tran
		Else 
		
			Rollback Tran
	Close C_Producto
	Deallocate C_Producto
End
----Ejecutando el Procedimiemto
Execute Usp_040714001 '1','20'

/* Transacción para registrar nuevo cliente*/
ALTER PROCEDURE  usp_InsertaCliente
@id varchar(5), @nombre varchar(50), @direccion varchar(100), @idpais char(3),  @fono varchar(15)
AS
Begin
--Inicio de la Transaccion
	BEGIN TRAN Tran_newcliente
		Begin Try
	  		Insert Into Ventas.clientes Values(@id, @nombre, @direccion, @idpais, @fono)
			IF @@ERROR = 0
			BEGIN
				COMMIT TRAN Tran_newcliente;   
				print 'Pedido Registrado'
			END
		End Try
		Begin Catch
				Print 'Se produjo un error '
				ROLLBACK TRAN Tran_newcliente
		End Catch
End
---Ejecutar el Procedimiento
Execute usp_InsertaCliente 'AORE','Andy Z','Av Izaguirre 777','001','33222'


/********* FUNCIONES ESCALARES *************/
CREATE FUNCTION DBO.FN_CALCULAR_EDAD
(@P_FECHANAC DATE) RETURNS TINYINT
AS
BEGIN
	DECLARE @V_EDAD TINYINT
	SET @V_EDAD = DATEDIFF(YY,@P_FECHANAC,GETDATE())
	RETURN @V_EDAD
END

/***APLICANDO LA FUNCION ESCALAR DE FORMA SIMPLE**/
PRINT DBO.FN_CALCULAR_EDAD('09/6/1989')

/***APLICANDO LA FUNCION ESCALAR DENTRO DE UNA CONSULTA**/
SELECT NomEmpleado,
		FecNac,
		dbo.FN_CALCULAR_EDAD(FECNAC) As Edad,
		FecContrata,
		dbo.FN_CALCULAR_EDAD(FecContrata) As TiempoServicio
FROM RRHH.empleados

/***OTRA EJEMPLO DE función ESCALAR****/
CREATE FUNCTION DBO.FN_CALCULARTOTAL
(@P_ID_PEDIDO SMALLINT) RETURNS MONEY
AS
BEGIN
	DECLARE @V_TOTAL MONEY
	SET @V_TOTAL= (SELECT SUM((Cantidad*PrecioUnidad) -((Cantidad*PrecioUnidad)*Descuento))
					FROM Ventas.pedidosdeta
					WHERE IdPedido= @P_ID_PEDIDO
				  )
	RETURN @V_TOTAL

END
---UTILIZANDO LA FUNCIÓN ESCALAR DENTRO DE UNA CONSULTA
SELECT	IdPedido,
		FechaPedido,
		FechaEntrega,
		FechaEnvio,
		IdCliente,
		IdEmpleado,
		DBO.FN_CALCULARTOTAL(IdPedido) AS TOTALPEDIDO
FROM Ventas.pedidoscabe
-------
CREATE FUNCTION DBO.OBTCLIENTE
(@P_IDCLIENTE VARCHAR(50)) RETURNS VARCHAR(MAX)
AS
BEGIN
	DECLARE @V_NOMBRECLIENTE VARCHAR(MAX)
	SET @V_NOMBRECLIENTE= (SELECT NomCliente FROM Ventas.clientes
							WHERE IdCliente=@P_IDCLIENTE)
	RETURN @V_NOMBRECLIENTE
END
------------
SELECT	IdPedido,
		FechaPedido,
		FechaEntrega,
		FechaEnvio,
		DBO.OBTCLIENTE(IdCliente) AS NOMBRECLIENTE,
		IdEmpleado,
		DBO.FN_CALCULARTOTAL(IdPedido) AS TOTALPEDIDO
FROM Ventas.pedidoscabe

/*** fucnción de tabla en linea***/
Create Function DBO.fn_consultaCliente 
() Returns Table
As
  Return	(Select C.NomCliente As Nombre,
			C.DirCliente As Direccion,
			P.NombrePais As Pais
			from Ventas.clientes C Join Ventas.paises P
			On C.idpais = P.Idpais)
---Utilzando la función de tabla en linea
Select * from DBO.fn_consultaCliente()

---
Select * from DBO.fn_consultaCliente()
Where Pais='Peru'