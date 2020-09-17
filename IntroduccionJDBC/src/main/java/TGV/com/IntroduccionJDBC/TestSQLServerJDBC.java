package TGV.com.IntroduccionJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestSQLServerJDBC {
	
	public static void main(String[] args) {
		String url = "jdbc:sqlserver://(localdb)\\induccion:1433;databaseName=test;user=tgvad\\larabia;password=Alta112233;integratedSecurity=true;";
		
		
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection conexion = DriverManager.getConnection(url);
			
			Statement stmt = conexion.createStatement();
			String sql = "SELECT ID_Persona, Nombre, Apellido, Email, Telefono FROM Persona";
			ResultSet resSet = stmt.executeQuery(sql);
			
			while (resSet.next()){
				System.out.println("Id Persona" + resSet.getInt("ID_Persona"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 
			catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
