Imports CapaDatos
Imports CapaEntidad
Public Class ProductoCN
    Dim objDao As New ProductoDAO
    Public Function listadoProducto() As DataSet
        Return objDao.listadoProducto
    End Function
    Public Function listadoCategorias() As DataSet
        Return objDao.listadoCategorias
    End Function
    Public Function listadoProveedores() As DataSet
        Return objDao.listadoProveedores
    End Function
    Public Function generaCodigo() As Integer
        Return objDao.generaCodigo
    End Function
    Public Sub registraProducto(ByVal objPro As ProductoCE)
        objDao.registraProducto(objPro)
    End Sub

End Class
