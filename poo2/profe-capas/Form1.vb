Imports CAPA_ACCESO_DATOS
Imports CAPA_NEGOCIO

Public Class Form1
    Dim objNeg As New EmpleadoNG

    Private Sub Form1_Load(sender As Object, e As EventArgs) Handles MyBase.Load
        dgProductos.DataSource = objNeg.ProductoListar.Tables(0)
    End Sub
End Class
