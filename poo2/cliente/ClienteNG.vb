Imports CAPA_ACCESO_DATOS

Public Class ClienteNG
    Dim objNeg As New ClienteDA

    Public Function PaisListar() As DataSet
        Return objNeg.PaisListar()
    End Function

    Public Function ClienteListar() As DataSet
        Return objNeg.ClienteListar()
    End Function

    Public Sub ClienteInsertar(cod As String, nom As String, dir As String,
                               idpais As String, fono As String)
        objNeg.ClienteInsertar(cod, nom, dir, idpais, fono)
    End Sub

    Public Sub ClienteActualizar(cod As String, nom As String, dir As String,
                               idpais As String, fono As String)
        objNeg.ClienteActualizar(cod, nom, dir, idpais, fono)
    End Sub
End Class
