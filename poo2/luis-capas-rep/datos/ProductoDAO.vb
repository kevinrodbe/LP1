Imports System.Data.SqlClient
Imports CapaEntidad
Public Class ProductoDAO
    Dim objCon As New Connexion 'Declaracion As es un objeto , New es uno nuevo objeto
    Dim cn As New SqlConnection
    Dim objPro As New ProductoCE
    '1. Listado de Productos 
    Public Function listadoProducto() As DataSet
        cn = objCon.getConecta
        Using da As New SqlDataAdapter("SP_LISTAPRODUCTOS", cn)
            Dim ds As New DataSet
            da.Fill(ds, "Productos")
            Return ds
        End Using
    End Function
    '2. Listado Categorias
    Public Function listadoCategorias() As DataSet
        cn = objCon.getConecta
        Using da As New SqlDataAdapter("SP_LISTACATEGORIAS", cn)
            Dim ds As New DataSet
            da.Fill(ds, "Categorias")
            Return ds
        End Using
    End Function
    '3. Listado Proveedores
    Public Function listadoProveedores() As DataSet
        Using da As New SqlDataAdapter("SP_LISTAPROVEEDORES", cn)
            Dim ds As New DataSet
            da.Fill(ds, "Proveedores")
            Return ds
        End Using
    End Function
    '4. Generacion del codigo de Producto
    Public Function generaCodigo() As Integer
        cn = objCon.getConecta
        cn.Open()
        Using da As New SqlDataAdapter()
            Using cmd As New SqlCommand("SP_ULTIMOCODIGO", cn)
                cmd.CommandType = CommandType.StoredProcedure
                Return cmd.ExecuteScalar + 1
            End Using
        End Using
    End Function
    '5. Registro Producto
    Public Sub registraProducto(ByVal objPro As ProductoCE)
        cn = objCon.getConecta
        cn.Open()
        Using cmd As New SqlCommand("SP_INSERTAPRODUCTO", cn)
            cmd.CommandType = CommandType.StoredProcedure
            cmd.Parameters.Add("@COD", SqlDbType.Int).Value = objPro.codigo
            cmd.Parameters.Add("@NOM", SqlDbType.VarChar).Value = objPro.descripcion
            cmd.Parameters.Add("@PRO", SqlDbType.Int).Value = objPro.codProv
            cmd.Parameters.Add("@CAT", SqlDbType.Int).Value = objPro.codCat
            cmd.Parameters.Add("@CAN", SqlDbType.VarChar).Value = objPro.cantxuni
            cmd.Parameters.Add("@PRE", SqlDbType.Money).Value = objPro.precio
            cmd.Parameters.Add("@EXI", SqlDbType.Int).Value = objPro.uExistencia
            cmd.Parameters.Add("@PED", SqlDbType.Int).Value = objPro.uPedidos
            cmd.ExecuteNonQuery()
        End Using
    End Sub

End Class
