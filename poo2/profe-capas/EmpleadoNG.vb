Imports CAPA_ACCESO_DATOS

Public Class EmpleadoNG
    Dim obj As New EmpleadoDA

    Public Function CategoriaListar() As DataSet
        Return obj.CategoriaListar()
    End Function

    Public Function ProveedorListar() As DataSet
        Return obj.ProveedorListar()
    End Function

    Public Function ProductoListar() As DataSet
        Return obj.ProductoListar
    End Function

    Public Sub ProductoInsertar(prod As String, pre As Double,
                               idcat As Integer, idprov As Integer, stock As Integer)
        obj.ProductoInsertar(prod, pre, idcat, idprov, stock)
    End Sub

    Public Sub ProductoActualizar(idpro As Integer, prod As String, pre As Double,
                              idcat As Integer, idprov As Integer, stock As Integer)
        obj.ProductoActualizar(idpro, prod, pre, idcat, idprov, stock)
    End Sub
End Class
