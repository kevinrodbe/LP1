Imports CAPA_NEGOCIO

Public Class frmClientes
    Dim objNeg As New ClienteNG

    Sub PaisListar()
        cboPais.DataSource = objNeg.PaisListar.Tables(0)
        cboPais.DisplayMember = "NombrePais"
        cboPais.ValueMember = "IdPais"
    End Sub

    Private Sub frmClientes_Load(sender As Object, e As EventArgs) Handles MyBase.Load
        PaisListar()
        dgClientes.DataSource = objNeg.ClienteListar.Tables(0)
        dgClientes.AutoSizeColumnsMode = DataGridViewAutoSizeColumnsMode.AllCells
    End Sub

    Private Sub btnNuevo_Click(sender As Object, e As EventArgs) Handles btnNuevo.Click
        For Each objeto As Object In Me.Controls
            If TypeOf objeto Is TextBox Then objeto.Text = String.Empty
        Next
        cboPais.SelectedIndex = -1
        txtCodigo.Focus()
    End Sub

    Private Sub btnGrabar_Click(sender As Object, e As EventArgs) Handles btnGrabar.Click
        Try
            objNeg.ClienteInsertar(txtCodigo.Text.ToUpper, txtCliente.Text,
                                 txtDireccion.Text.ToUpper, cboPais.SelectedValue.ToString,
                                 txtTelefono.Text)
            dgClientes.DataSource = objNeg.ClienteListar.Tables(0)
            MessageBox.Show("Cliente Registrado satisfactoriamente...", "AVISO")
        Catch ex As Exception
            MessageBox.Show(ex.Message + "ERROR....")
        End Try
    End Sub

    Private Sub btnActualizar_Click(sender As Object, e As EventArgs) Handles btnActualizar.Click
        Try
            objNeg.ClienteActualizar(txtCodigo.Text.ToUpper, txtCliente.Text,
                                 txtDireccion.Text.ToUpper, cboPais.SelectedValue.ToString,
                                 txtTelefono.Text)
            dgClientes.DataSource = objNeg.ClienteListar.Tables(0)
            MessageBox.Show("Cliente Actualizado satisfactoriamente...", "AVISO")
        Catch ex As Exception
            MessageBox.Show(ex.Message + "ERROR....")
        End Try
    End Sub

    Private Sub dgClientes_SelectionChanged(sender As Object, e As EventArgs) Handles dgClientes.SelectionChanged
        Try
            txtCodigo.Text = dgClientes.Rows(dgClientes.CurrentRow.Index).Cells(0).Value()
            txtCliente.Text = dgClientes.Rows(dgClientes.CurrentRow.Index).Cells(1).Value()
            txtDireccion.Text = dgClientes.Rows(dgClientes.CurrentRow.Index).Cells(2).Value()
            cboPais.Text = dgClientes.Rows(dgClientes.CurrentRow.Index).Cells(3).Value()
            txtTelefono.Text = dgClientes.Rows(dgClientes.CurrentRow.Index).Cells(4).Value()
        Catch ex As Exception
            MessageBox.Show("Debe seleccionar una fila...", "AVISO")
        End Try
    End Sub

    Private Sub btnReporte_Click(sender As Object, e As EventArgs) Handles btnReporte.Click
        My.Forms.frmReporte.ShowDialog()
    End Sub
End Class