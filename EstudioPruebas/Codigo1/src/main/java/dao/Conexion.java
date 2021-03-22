package dao;

import java.sql.*;

public class Conexion {
	private static final String JDBC_URL = "jdbc:oracle:thin:@localhost:1521:XE";
	private static final String JDBC_USER = "USRPRUEBA";
	private static final String JDBC_PASSWORD = "1234";
	
	public static Connection conectar() throws SQLException {
		return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
	}
	
	public static void desconectar(ResultSet rs) throws SQLException {
		rs.close();
	}
	
	public static void desconectar(PreparedStatement stmt) throws SQLException {
		stmt.close();
	}
	
	public static void desconectar(Statement stmt) throws SQLException {
		stmt.close();
	}
	
	public static void desconectar(Connection conn) throws SQLException {
		conn.close();
	}
}
