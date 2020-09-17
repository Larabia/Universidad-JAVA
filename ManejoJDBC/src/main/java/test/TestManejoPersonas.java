package test;

import java.util.*;
import datos.PersonaDAO;
import entidades.Persona;

public class TestManejoPersonas {
	public static void main(String[] args) {
		PersonaDAO personaDao = new PersonaDAO();
		
		
//		Insertar persona a la tabla
		Persona personaNueva = new Persona("Carlos", "Esparza", "carlos@gamil.com", "2423423423");
		personaDao.insertar(personaNueva);
		
//		Listar personas de la tabla
		
		List<Persona> personas= personaDao.seleccionar();		
		for(Persona persona:personas) {
			System.out.println("Persona: "+persona);
			
		}
		
	}
	
	

}
