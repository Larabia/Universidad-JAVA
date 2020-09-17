package datos;

import java.sql.*;
import java.util.*;
import entidades.Persona;
import static datos.Conexion.*;

public class PersonaDAO {

	private static final String SQL_SELECT = "SELECT id_persona, nombre, apellido, email, telefono FROM persona";

	public List<Persona> seleccionar() {

		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Persona persona = null;
		List<Persona> personas = new ArrayList<Persona>();

		try {
			con = getConnection();
			con.prepareStatement(SQL_SELECT);
			rs = stmt.executeQuery();

			while (rs.next()) {
				int idPersona = rs.getInt("id_persona");
				String nombre = rs.getString("nombre");
				String apellido = rs.getString("apellido");
				String email = rs.getString("email");
				String telefono = rs.getString("telefono");

				persona = new Persona(idPersona, nombre, apellido, email, telefono);
				personas.add(persona);
			}

			return personas;

		} catch (SQLException e) {
			e.printStackTrace(System.out);
		} finally {
			try {
				close(rs);
				close(stmt);
				close(con);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return personas;

	}

}
