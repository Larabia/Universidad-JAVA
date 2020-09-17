package datos;

import java.util.List;

import entidad.Pelicula;
import excepciones.*;



public interface AccesoDatos {
	
	boolean existe(String nombreArchivo) throws AccesoDatosEx;
	
	List<Pelicula> listar(String nombre) throws LecturaDatosEx;
	
	void escribir(Pelicula pelicula, String nombreArchivo, boolean anexar) throws EscrituraDatosEx;
	
	String buscar(String nombreArchivo,String buscar) throws LecturaDatosEx;
	
	void crear(String nombreArchivo) throws AccesoDatosEx;
	
	void borrar(String nombreArchivo) throws AccesoDatosEx;

}
