package repaso.controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import repaso.bean.EventoBean;
import repaso.util.MySqlDBConexion;

public class EventoAction {
	
	public List<EventoBean> consultarPorCapacidad(int capacidadInicio, 
									int capacidadFinal){
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
				bean.setIdLocal(rs.getInt("idLocal"));
				bean.setNombre(rs.getString("nombre"));
				bean.setFechaInicio(rs.getString("fechaInicio"));
				bean.setFechaFin(rs.getString("fechaFin"));
				bean.setCapacidad(rs.getInt("capacidad"));
				bean.setUrl(rs.getString("url"));
				bean.setEmailContacto(rs.getString("emailContacto"));
				bean.setNombreLocal(rs.getString("nombreLocal"));
				
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

}











