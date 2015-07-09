Imports CapasNegocio
Imports CapaEntidad
Public Class frmRegistraProducto
    Dim objCN As New ProductoCN
    Dim objPro As New ProductoCE
    Private Sub frmRegistraProducto_Load(sender As Object, e As EventArgs) Handles MyBase.Load
        Call generaCodigo()
        Call llenaProducto()
        Call llenaProveedores()
        Call llenaCategoria()
    End Sub
    Sub generaCodigo()
        lblCodigo.Text = objCN.generaCodigo
    End Sub
    Sub llenaProducto()
        dgProductos.DataSource = objCN.listadoProducto.Tables("Productos")
    End Sub
    Sub llenaProveedores()
        cboProveedor.DataSource = objCN.listadoProveedores.Tables("Proveedores")
        cboProveedor.DisplayMember = "NomProveedor"
        cboProveedor.ValueMember = "IdProveedor"
    End Sub
    Sub llenaCategoria()
        cboCategoria.DataSource = objCN.listadoCategorias.Tables("Categorias")
        cboCategoria.DisplayMember = "NombreCategoria"
        cboCategoria.ValueMember = "idCategoria"
    End Sub

    Private Sub btnRegistrar_Click(sender As Object, e As EventArgs) Handles btnRegistrar.Click
        objPro.codigo = lblCodigo.Text
        objPro.descripcion = txtDescrp.Text
        objPro.codProv = cboProveedor.SelectedValue
        objPro.codCat = cboCategoria.SelectedValue
        objPro.cantxuni = txtCantidad.Text
        objPro.precio = txtPrecio.Text
        objPro.uExistencia = txtExistencia.Text
        objPro.uPedidos = txtPedidos.Text
        objCN.registraProducto(objPro)
        Call llenaProducto()
        Call generaCodigo()
    End Sub

    Private Sub dgProductos_DoubleClick(sender As Object, e As EventArgs) Handles dgProductos.DoubleClick
        lblCodigo.Text = dgProductos.CurrentRow.Cells(0).Value
        txtDescrp.Text = dgProductos.CurrentRow.Cells(1).Value
        cboProveedor.SelectedValue = dgProductos.CurrentRow.Cells(2).Value
        cboCategoria.SelectedValue = dgProductos.CurrentRow.Cells(3).Value
        txtCantidad.Text = dgProductos.CurrentRow.Cells(4).Value
        txtPrecio.Text = dgProductos.CurrentRow.Cells(5).Value
        txtExistencia.Text = dgProductos.CurrentRow.Cells(6).Value
        txtPedidos.Text = dgProductos.CurrentRow.Cells(7).Value
    End Sub
End Class