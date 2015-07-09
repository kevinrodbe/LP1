Imports CapasNegocio
Public Class frmListadoProductos
    Dim objNeg As New ProductoCN
    Private Sub frmListadoProductos_Load(sender As Object, e As EventArgs) Handles MyBase.Load
        dgProductos.DataSource = objNeg.listadoProducto.Tables("Productos")
    End Sub
End Class