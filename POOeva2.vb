'****************************
'	CAPA DATOS 
'****************************
'********************************** CAPA DATOS/Connexion.vb **********************************'
Imports System.Data.SqlClient
Imports System.Configuration.ConfigurationManager
Public Class Connexion
    Public Function getConecta() As SqlConnection
        Dim cn As New SqlConnection(ConnectionStrings("cn").ConnectionString)
        Return cn
    End Function
End Class
'********************************** CAPA DATOS/ProductoDAO.vb **********************************'
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
'****************************
'	CAPA ENTIDAD
'****************************
'********************************** ENTIDAD/ProductoCE.vb **********************************'
Public Class ProductoCE
    Private _codigo As String
    Public Property codigo() As String
        Get
            Return _codigo
        End Get
        Set(ByVal value As String)
            _codigo = value
        End Set
    End Property
'****************************
'	CAPA PRESENTACIÓN
'****************************
'********************************** PRESENTACIÓN/frmRegistrarProducto.vb **********************************'
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
'********************************** PRESENTACIÓN/frmListadoProductos.vb **********************************'
Imports CapasNegocio
Public Class frmListadoProductos
    Dim objNeg As New ProductoCN
    Private Sub frmListadoProductos_Load(sender As Object, e As EventArgs) Handles MyBase.Load
        dgProductos.DataSource = objNeg.listadoProducto.Tables("Productos")
    End Sub
End Class
'****************************
'	CAPA NEGOCIOS
'****************************
'********************************** CAPA NEGOCIO/ProductoCN.vb **********************************'
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
