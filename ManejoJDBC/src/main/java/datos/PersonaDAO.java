package datos;

import java.sql.*;
import java.util.*;
import entidades.Persona;
import static datos.Conexion.*;

public class PersonaDAO {

	private static final String SQL_SELECT = "SELECT id_persona, nombre, apellido, email, telefono FROM persona";
	private static final String SQL_INSERT = "INSERT INTO persona (nombre, apellido, email, telefono) VALUES (?,?,?,?)";
	private static final String SQL_UPDATE = "UPDATE persona SET nombre=?, apellido=?, email=?, telefono=? WHERE id_persona = ?";
	private static final String SQL_DELETE = "DELETE FROM persona WHERE id_persona=?";

	public List<Persona> seleccionar() {

		List<Persona> personas = new ArrayList<Persona>();

		try {
			Connection con = getConnection();
			PreparedStatement stmt = con.prepareStatement(SQL_SELECT);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				int idPersona = rs.getInt("id_persona");
				String nombre = rs.getString("nombre");
				String apellido = rs.getString("apellido");
				String email = rs.getString("email");
				String telefono = rs.getString("telefono");

				Persona persona = new Persona(idPersona, nombre, apellido, email, telefono);
				personas.add(persona);

			}

			close(rs);
			close(stmt);
			close(con);

		} catch (SQLException e) {
			e.printStackTrace(System.out);
		}

		return personas;

	}

	public int insertar(Persona persona) {

		int registros = 0;
		try {
			Connection con = getConnection();
			PreparedStatement stmt = con.prepareStatement(SQL_INSERT);

			stmt.setString(1, persona.getNombre());
			stmt.setString(2, persona.getApellido());
			stmt.setString(3, persona.getEmail());
			stmt.setString(4, persona.getTelefono());

			registros = stmt.executeUpdate();

			close(stmt);
			close(con);

		} catch (SQLException e) {
			e.printStackTrace(System.out);
		}

		return registros;

	}

	public int actualizar(Persona persona) {

		int registros = 0;

		try {
			Connection con = getConnection();
			PreparedStatement stmt = con.prepareStatement(SQL_UPDATE);

			stmt.setString(1, persona.getNombre());
			stmt.setString(2, persona.getApellido());
			stmt.setString(3, persona.getEmail());
			stmt.setString(4, persona.getTelefono());
			stmt.setInt(5, persona.getIdPersona());
			registros = stmt.executeUpdate();

			close(stmt);
			close(con);

		} catch (SQLException e) {
			e.printStackTrace(System.out);
		}

		return registros;

	}

	public int eliminar(Persona persona) {
		
		int registros = 0;
		
		try {
			Connection con = getConnection();
			PreparedStatement stmt = con.prepareStatement(SQL_DELETE);
			
			stmt.setString(1, persona.getNombre());
			stmt.setInt(1, persona.getIdPersona());
			registros = stmt.executeUpdate();

			close(stmt);
			close(con);					

		} catch (SQLException e) {
			e.printStackTrace(System.out);
		} 

		return registros;
	
	}
	
//VERSION ORIGINAL DEL CURSO (DA ERROR NULL POINTER EN LINEA Connection con = null;)
//	
//	public List<Persona> seleccionar() {
//
//		Connection con = null;
//		PreparedStatement stmt = null;
//		ResultSet rs = null;
//		Persona persona = null;
//		List<Persona> personas = new ArrayList<Persona>();
//
//		try {
//			con = getConnection();
//			con.prepareStatement(SQL_SELECT);
//			rs = stmt.executeQuery();
//
//			while (rs.next()) {
//				int idPersona = rs.getInt("id_persona");
//				String nombre = rs.getString("nombre");
//				String apellido = rs.getString("apellido");
//				String email = rs.getString("email");
//				String telefono = rs.getString("telefono");
//
//				persona = new Persona(idPersona, nombre, apellido, email, telefono);
//				personas.add(persona);
//			}
//
//			return personas;
//
//		} catch (SQLException e) {
//			e.printStackTrace(System.out);
//		} finally {
//			try {
//				close(rs);
//				close(stmt);
//				close(con);
//			} catch (SQLException e) {
//				e.printStackTrace(System.out);
//			}
//		}
//
//		return personas;
//
//	}
	
}
