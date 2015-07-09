Imports System.Data
Imports System.Data.SqlClient
Imports System.Configuration.ConfigurationManager

Public Class EmpleadoDA
    Dim cn As New SqlConnection(ConnectionStrings("cno").ConnectionString)
    Dim da As New SqlDataAdapter
    Dim cmd As New SqlCommand
    Dim ds As New DataSet

    Public Function CategoriaListar() As DataSet
        da = New SqlDataAdapter("usp_CategoriaListar", cn)
        da.SelectCommand.CommandType = CommandType.StoredProcedure
        ds = New DataSet
        da.Fill(ds)
        Return ds
    End Function

    Public Function ProveedorListar() As DataSet
        da = New SqlDataAdapter("usp_ProveedorListar", cn)
        da.SelectCommand.CommandType = CommandType.StoredProcedure
        ds = New DataSet
        da.Fill(ds)
        Return ds
    End Function

    Public Function ProductoListar() As DataSet
        da = New SqlDataAdapter("usp_ListaProductos", cn)
        da.SelectCommand.CommandType = CommandType.StoredProcedure
        ds = New DataSet
        da.Fill(ds)
        Return ds
    End Function

    Public Sub ProductoInsertar(prod As String, pre As Double,
                               idcat As Integer, idprov As Integer, stock As Integer)
        cn.Open()
        cmd = New SqlCommand
        cmd.Connection = cn
        cmd.CommandType = CommandType.StoredProcedure
        cmd.CommandText = "usp_ProductoInsertar"
        With cmd.Parameters
            .AddWithValue("@NomProducto", prod)
            .AddWithValue("@Precio", pre)
            .AddWithValue("@IdProveedor", idprov)
            .AddWithValue("@IdCategoria", idcat)
            .AddWithValue("@Stock", stock)
        End With
        Try
            cmd.ExecuteNonQuery()
        Catch ex As Exception
        Finally
            cn.Close()
        End Try
    End Sub

    Public Sub ProductoActualizar(idpro As Integer, prod As String, pre As Double,
                               idcat As Integer, idprov As Integer, stock As Integer)
        cn.Open()
        cmd = New SqlCommand
        cmd.Connection = cn
        cmd.CommandType = CommandType.StoredProcedure
        cmd.CommandText = "usp_ProductoActualizar"
        With cmd.Parameters
            .AddWithValue("@IdProducto", idpro)
            .AddWithValue("@NomProducto", prod)
            .AddWithValue("@Precio", pre)
            .AddWithValue("@IdProveedor", idprov)
            .AddWithValue("@IdCategoria", idcat)
            .AddWithValue("@Stock", stock)
        End With
        Try
            cmd.ExecuteNonQuery()
        Catch ex As Exception
        Finally
            cn.Close()
        End Try
    End Sub
End Class
