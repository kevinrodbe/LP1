package demo.util;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

/*
 * Esta clase permitira crea conexiones de base de datos 
 */
public class ConexionDB {
	//Metodo para crear conexiones
	public Connection  getConexion(){
		Connection connection = null;
		try {
			//agregar driver
			Class.forName("com.mysql.jdbc.Driver");
			connection =
			DriverManager.getConnection("jdbc:mysql://localhost:3306/consorcio","root","");

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return connection;
	}

}
