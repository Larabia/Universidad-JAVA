package test;

import java.util.*;
import datos.PersonaDAO;
import entidades.Persona;

public class TestManejoPersonas {
	public static void main(String[] args) {
		PersonaDAO personaDao = new PersonaDAO();
		
		
//		Insertar persona a la tabla
		
//		Persona personaNueva = new Persona("Carlos", "Esparza", "carlos@gamil.com", "2423423423");
//		personaDao.insertar(personaNueva);
		
//		Modificar un registro de persona existente
		
//		Persona personaModificar = new Persona(5, "Ludmila", "Esparza", "ludmila@gamil.com", "2423423423");
//		personaDao.actualizar(personaModificar);		
		
//		Eliminar registro
		Persona personaEliminar = new Persona (4);
		personaDao.eliminar(personaEliminar);
		
//		Listar personas de la tabla
		
		List<Persona> personas= personaDao.seleccionar();		
		for(Persona persona:personas) {
			System.out.println("Persona: "+persona);
			
		}
		
	}
	
	

}
