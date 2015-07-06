Declare @vc_IdProducto int, @vc_nomproducto varchar(40)
Declare @vc_PrecioUnitario money
Declare CA_Producto cursor for Select	IdProducto,
										NomProducto,
										PrecioUnidad
								From [Compras].[productos]
								For Update
Open CA_Producto
Fetch CA_Producto Into @vc_IdProducto,@vc_nomproducto,
						@vc_PrecioUnitario
While @@FETCH_STATUS=0
	Begin
		Update [Compras].[productos]
		Set PrecioUnidad = @vc_PrecioUnitario - 10
		Where Current Of CA_Producto
		Fetch CA_Producto Into @vc_IdProducto,@vc_nomproducto,
						@vc_PrecioUnitario
	End
Close CA_Producto
Deallocate CA_Producto


Update [Compras].[productos]
		Set PrecioUnidad = PrecioUnidad - 10

--Modifique el cursor anterior para actualizar los precios 
--de la siguiente manera:
--Incrementar 10 solo si es suministrado por el proveedor 5, 10, 15 y 20
--Incrementar 5 solo si es suministrado por el proveedor 2, 4, 6 y 8
Declare @vc_IdProducto int, @vc_nomproducto varchar(40)
Declare @vc_PrecioUnitario money, @vc_idproveedor int
Declare @v_valor money
Declare CA_Producto cursor for Select	IdProducto,
										NomProducto,
										precioUnidad,
										IdProveedor
								From [Compras].[productos]
								For Update
Open CA_Producto
Fetch CA_Producto Into @vc_IdProducto,@vc_nomproducto,
						@vc_PrecioUnitario,@vc_idproveedor
While @@FETCH_STATUS=0
	Begin
		Set @v_valor = 0
		If @vc_idproveedor in (5,10,15,20)
			BEGIN
				Set @v_valor=10
			END
		If @vc_idproveedor in (2,4,6,8)
			BEGIN
				Set @v_valor=5
			END
		
		
		Update [Compras].[productos]
		Set PrecioUnidad = @vc_PrecioUnitario + @v_valor
		Where Current Of CA_Producto
		Fetch CA_Producto Into @vc_IdProducto,@vc_nomproducto,
						@vc_PrecioUnitario,@vc_idproveedor
	End
Close CA_Producto
Deallocate CA_Producto


/******** PROCEDIMIENTOS ALMACENADOS *************/
CREATE PROCEDURE USP_VERPEDIDOS
AS
BEGIN
	SELECT *
	FROM VENTAS.pedidoscabe
END
------EJECUTAR EL PROCEDIMIENTO-------------
EXECUTE USP_VERPEDIDOS


-----MODIFICAR EL PROCEDIMIENTO ANTERIOR PARA DEFINIR 
-----UN PAR�METRO ANHO Y VISUALIZAR LOS PEDIDOS DE DICHO ANHO
ALTER PROCEDURE USP_VERPEDIDOS
@P_ANHO SMALLINT
AS
BEGIN
	SELECT *
	FROM VENTAS.pedidoscabe
	WHERE YEAR(FechaPedido) = @P_ANHO
END
------EJECUTAR EL PROCEDIMIENTO MODIFICADO
EXECUTE USP_VERPEDIDOS 1990


----MODIFICAR LE PROCEDIMIENTO ANTERIOR PARA VALIDAR LA EXSITENCIA DE
----PEDIDOS DE DICHO ANHOS SOLICITADO, DE NO EXISTIR, MOSTRAR UN MENSAJE
ALTER PROCEDURE USP_VERPEDIDOS
@P_ANHO SMALLINT
AS
BEGIN
	IF NOT EXISTS (SELECT *	FROM VENTAS.pedidoscabe	
					WHERE YEAR(FechaPedido) = @P_ANHO)
		BEGIN
			PRINT '�NO EXISTE PEDIDOS GENERADOS EN ESE ANHO!!!!'
			RETURN
		END
	SELECT *
	FROM VENTAS.pedidoscabe
	WHERE YEAR(FechaPedido) = @P_ANHO
END
------EJECUTAR EL PROCEDIMIENTO MODIFICADO
EXECUTE USP_VERPEDIDOS 1996


-----CREAR UN PROCEDIMIENTO QUE MUESTRE MENSAJES-----
CREATE PROCEDURE USP_VERMENSAJE
AS
BEGIN
	PRINT '�NO EXISTE PEDIDOS GENERADOS EN ESE ANHO!!!!'
END


----MODIFICAR EL PEN�LTIMO PROCEDIMIENTO PARA INVOCAR AL 
----PROCEDIMIENTO RECIENTEMENTE CREADO
ALTER PROCEDURE USP_VERPEDIDOS
@P_ANHO SMALLINT
AS
BEGIN
	IF NOT EXISTS (SELECT *	FROM VENTAS.pedidoscabe	
					WHERE YEAR(FechaPedido) = @P_ANHO)
		BEGIN
			EXECUTE USP_VERMENSAJE
			RETURN
		END
	SELECT *
	FROM VENTAS.pedidoscabe
	WHERE YEAR(FechaPedido) = @P_ANHO
END
------EJECUTAR EL PROCEDIMIENTO MODIFICADO
EXECUTE USP_VERPEDIDOS 1995