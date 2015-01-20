package demo.controlador;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
//import java.sql.SQLException;
import java.util.List;
import demo.entidad.DistritoBean;
import demo.util.ConexionDB;

public class DistritoAction {

	
	public int insertaDistrito(DistritoBean bean){
		int salida = -1;
		Connection conn = null;
		CallableStatement cstmt = null;
		try {
			//1 Crear la conexion
				conn = new ConexionDB().getConexion();
			//2 Preparar el SQL
				cstmt = conn.prepareCall("{call spDistrito(?)}"); 
				//pstm = conn.prepareStatement(sql);
				cstmt.setString(1, bean.getDescripcion());
			//3 Lanzar a la BD el sql
				//conn.setAutoCommit(false);//transacci�n
				salida = cstmt.executeUpdate();
				//conn.commit();//Confirmar la transacci�n
		} catch (SQLException e) {
			try {
				conn.rollback();//Cancelar transacci�n
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally{
			try {
				if (cstmt!= null)cstmt.close();
				if (conn!= null)conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return salida;
	}

	public int eliminaDistrito(int pos){
		return -1;
	}

	public List<DistritoBean> listaDistrito(){
		return null;
	}
}
