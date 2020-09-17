package datos;

import java.sql.*;

public class Conexion {

	private static final String JDBC_URL = "jdbc:MySql://localhost:3306/test?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
	private static final String JDBC_ADMIN = "root";
    private static final String JDBC_PASS = "";
    
    public static Connection getConnection() throws SQLException {
    	return DriverManager.getConnection(JDBC_URL,JDBC_ADMIN, JDBC_PASS);
    }
	
    public static void close(ResultSet rs) throws SQLException {
    	rs.close();
    }
    
    public static void close(Statement stmt) throws SQLException {
    	stmt.close();
    }
    
    public static void close(PreparedStatement stmt) throws SQLException {
    	stmt.close();
    }
    
    public static void close(Connection con) throws SQLException {
    	con.close();
    }
    
    
}
