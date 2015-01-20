/* Solo SQL */
// GUI
protected void btnRegistrarActionPerformed(ActionEvent arg0) {
	if(validar()){
		Seccion sec = new SeccionAction().buscarPorNombre(cboSeccion.getSelectedItem().toString());
		if(sec != null){
			Post obj = new Post();
			obj.setIdSeccion(sec.getIdSeccion());
			obj.setContenido(txtContenido.getText());
			obj.setFechaPublicacion(txtFechaPublicacion.getText());
			obj.setVisitasMinimas(Integer.parseInt(txtVisitas.getText()));
			int salida = new PostAction().insertaDistrito(obj);
			if(salida != -1)
				JOptionPane.showMessageDialog(this, "Se registró el Post");
			else
				JOptionPane.showMessageDialog(this, "No se registró el Post");
		}
	}
}
// Controlador
public int insertaDistrito(DistritoBean bean){
	int salida = -1;
	Connection cn = null;
	PreparedStatement pstm = null;
	try {
			cn = new ConexionDB().getConexion();
			String sql ="insert into tb_distrito values(null,?)";
			pstm = cn.prepareStatement(sql);
			pstm.setString(1, bean.getDescripcion());
			salida = pstm.executeUpdate();
	} catch (Exception e) {
		e.printStackTrace();
	}finally{
		try {
			if (pstm!= null)pstm.close();
			if (cn!= null)cn.close();
		} catch (SQLException e) {}
	}
	return salida;
}
/* Store Procedure */
public int insertaDistrito(DistritoBean bean){
	int salida = -1;
	Connection cn = null;
	CallableStatement cstmt = null;
	try {
			cn = new ConexionDB().getConexion();
			cstmt = cn.prepareCall("{call spDistrito(?)}");
			cstmt.setString(1, bean.getDescripcion());
			salida = cstmt.executeUpdate();
	} catch (Exception e) {
		try {
				cn.rollback();
		} catch (SQLException e1) {
				e1.printStackTrace();
		}
		e.printStackTrace();
	}finally{
		try {
			if (cstmt!= null)cstmt.close();
			if (cn!= null)cn.close();
		} catch (SQLException e) {}
	}
	return salida;
}
/* Llenar cbo desde bd */
cboSeccion = new JComboBox();
ArrayList<Seccion> secciones = new SeccionAction().listarTodos();
for (Seccion seccion : secciones) {
	cboSeccion.addItem(seccion.getNombre());
}
// La función de la clase SeccionAction
public ArrayList<Seccion> listarTodos(){
	ArrayList<Seccion> lista = new ArrayList<Seccion>();
	Connection conn = null;
	PreparedStatement pstm = null;
	ResultSet rs = null;
	try {
		conn = new MySqlConection().getConection();
		String sql = "SELECT * FROM seccion";
		pstm = conn.prepareStatement(sql);
		rs = pstm.executeQuery();
		Seccion obj = null;	
		while (rs.next()) {
			obj = new Seccion();
			obj.setIdSeccion(rs.getInt("idSeccion"));
			obj.setNombre(rs.getString("nombre"));
			lista.add(obj);
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	finally{
		try {
			if(rs != null) rs.close();
			if(pstm != null) pstm.close();
			if(conn != null) conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	return lista;
}
/* Buscar por Cod en la BD */
public Seccion buscarPorNombre(String nombre){
	Seccion obj = null;	
	Connection conn = null;
	PreparedStatement pstm = null;
	ResultSet rs = null;
	try {
		conn = new MySqlConection().getConection();
		String sql = "SELECT * FROM seccion WHERE nombre = ?";
		pstm = conn.prepareStatement(sql);
		pstm.setString(1, nombre);
		rs = pstm.executeQuery();
		while (rs.next()) {
			obj = new Seccion();
			obj.setIdSeccion(rs.getInt("idSeccion"));
			obj.setNombre(rs.getString("nombre"));
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	finally{
		try {
			if(rs != null) rs.close();
			if(pstm != null) pstm.close();
			if(conn != null) conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	return obj;
}
/* Ordenar datos! */
// Paquete SORT
	//Clase SortNombreEvento STRING PS
		import java.util.Comparator;
		import repaso.bean.miBean;
		public class SortNombreEvento implements Comparator<EventoBean> {
			@Override
			public int compare(EventoBean arg0, EventoBean arg1) {
				return arg0.getNombre().compareToIgnoreCase(arg1.getNombre());
			}
		}
	// Clase SortCapacidad #s PS
		import java.util.Comparator;
		import repaso.bean.miBean;
		public class SortCapacidad implements Comparator<EventoBean> {
			@Override
			public int compare(EventoBean arg0, EventoBean arg1) {
				if(arg0.getCapacidad() > arg1.getCapacidad())
					return 1;
				else if (arg0.getCapacidad() == arg1.getCapacidad())
					return 0;
				else 
					return -1;
			}
		}
// Controlador
import java.util.*;
import java.sql.*;
import repaso.bean.EventoBean;
import repaso.util.MySqlDBConexion;
	public List<EventoBean> consultarxCap(int cI, int cF){
		List<EventoBean> lista = new ArrayList<EventoBean>();
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			String sql = " SELECT e.*, l.nombre nombreLocal "
					+ " FROM evento e "
					+ " INNER JOIN local l "
					+ " ON e.idlocal = l.idlocal "
					+ " WHERE e.capacidad BETWEEN ? AND ?";
			conn = MySqlDBConexion.getConexion();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, capacidadInicio);
			pstm.setInt(2, capacidadFinal);
			rs = pstm.executeQuery();
			EventoBean bean = null;
			while (rs.next()) {
				bean = new EventoBean();
				bean.setIdEvento(rs.getInt("idEvento"));			
				lista.add(bean);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			try {
				if(rs != null) rs.close();
				if(pstm != null) pstm.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return lista;
	}
//GUI
import java.util.(List,ArrayList,Collections);
import repaso.sort.*;//Las clases que hemos creado para Ordenar
List<EventoBean> lista = new ArrayList<EventoBean>();
	// En el evento del botón CONSULTAR
		int capInicio = Integer.parseInt(txtCapacidadInicio.getText());
		int capFinal = Integer.parseInt(txtCapacidadFinal.getText());
		lista = new EventoAction().consultarPorCapacidad(capInicio, capFinal);
		// y si depende de un comboBox
		lista= new Action().consultar(comboBox.getSelectedItem().toString());
	// Evento del radioBtn para ordenar por Nombre
		protected void rdbtnNombreEventoActionPerformed(ActionEvent arg0) {
			Collections.sort(lista, new SortNombreEvento());
			if(! chckbxAscendente.isSelected())
				Collections.reverse(lista);
			listar();
		}
	// Función Listar
		private void listar() {
			DefaultTableModel model =(DefaultTableModel) tblLista.getModel();
			model.getDataVector().clear();
			if(lista != null){
				for (EventoBean bean : lista) {
					Object row[] = {bean.getIdEvento(), bean.getNombre(), 
							bean.getNombreLocal(), bean.getFechaInicio(), 
							bean.getFechaFin(), bean.getCapacidad(), 
							bean.getUrl(), bean.getEmailContacto()};
					model.addRow(row);
				}
			}
		}
	// Evento del check Ascendente
		protected void chckbxAscendenteActionPerformed(ActionEvent arg0) {
			if(rdbtnNombreEvento.isSelected())
				rdbtnNombreEventoActionPerformed(arg0);
			if(rdbtnNombreLocal.isSelected())
				rdbtnNombreLocalActionPerformed(arg0);
			if(rdbtnCapacidad.isSelected())
				rdbtnCapacidadActionPerformed(arg0);
		}
/* Crear Store Procedure BD */
CREATE PROCEDURE spDistrito(xnom VARCHAR(30))
BEGIN    
insert into tb_distrito(nom_dis) values(xnom);
END
/* Conexión a la BD */
import java.sql.Connection;
import java.sql.DriverManager;
public class MySqlDBConexion {
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public static Connection getConexion() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost/modelo", "root", "mysql");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
}
/* REGEX */
public static String REGEX_TITULO = "[A-Za-z0-9\\s]{5,100}";
public static String REGEX_CONTENIDO = "[A-Za-z0-9\\s]{50,500}";
public static String REGEX_EMAIL="^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
public static String REGEX_VISITAS = "\\d{3}[\\d]*";
public static String REGEX_TWITTER="@[A-Za-z0-9_]{3,14}";
