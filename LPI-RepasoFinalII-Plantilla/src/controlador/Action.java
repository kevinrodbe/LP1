package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.Bean;

import util.MySqlDBConexion;

public class Action {
	
	public List<Bean>consultar(String marca){
		List<Bean>lista= new ArrayList<Bean>();
		Connection conn= null;
		PreparedStatement pstm = null;
		ResultSet rs= null;
		try{
			String sql= " Select p.*,m.nom_marca "
					+ " from tb_producto p "
					+ " INNER JOIN  tb_marca m "
					+ " ON p.cod_marca= m.cod_marca"
					+ " where m.nom_marca = ?";
			
			conn= MySqlDBConexion.getConexion();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, marca);
			
			rs=pstm.executeQuery();
			
			while(rs.next()){
				Bean bena= new Bean( rs.getInt("cod_pro"), rs.getString("des_pro"), rs.getInt("stock_pro"), rs.getDouble("pre_pro"),rs.getInt("cod_marca"),rs.getString("nom_marca"));
				lista.add(bena);
			}
			
		}catch (Exception e){
			e.printStackTrace();
		}finally{
			try{
				if(rs!= null){	rs.close();		}
				if(pstm!= null){rs.close();}
				if(conn!=null){conn.close();}
				
			}catch (SQLException e){
				e.printStackTrace();
			}
		}
		return lista;
	}

}
