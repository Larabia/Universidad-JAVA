import java.sql.*;

public class TestMySqlJDBC {
	
	public static void main(String[] args) {
		
		String url = "jdbc:MySql://localhost:3306/test?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
		
		try {
			Connection conexion = DriverManager.getConnection(url, "root", "");
			Statement stmt = conexion.createStatement();
			String sql = "SELECT id_persona, nombre, apellido, email, telefono FROM persona";
			
			ResultSet result = stmt.executeQuery(sql);
			
			while(result.next()) {
				System.out.print("id_persona: "+result.getInt("id_persona")); 
				System.out.print(" nombre: "+result.getString("nombre"));
				System.out.print(" apellido: "+result.getString("apellido"));
				System.out.print(" email: "+result.getString("email"));
				System.out.print(" telefono: "+result.getString("telefono"));
				System.out.print("\n");
			}
			
			result.close();
			stmt.close();
			conexion.close();
		
		
		} catch (SQLException e) {	
			e.printStackTrace(System.out);
		}
	}

}
