Imports CapasNegocio
Public Class Form1
    Dim objNeg As New ProductoCN
    Private Sub Form1_Load(sender As Object, e As EventArgs) Handles MyBase.Load
        Dim rpt As New rptProductos
        rpt.SetDataSource(objNeg.listadoProducto.Tables("Productos"))
        crvProductos.ReportSource = rpt
    End Sub
   
End Class