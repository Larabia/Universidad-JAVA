package datos;

import java.io.*;
import java.util.*;

import entidad.Pelicula;
import excepciones.AccesoDatosEx;
import excepciones.EscrituraDatosEx;
import excepciones.LecturaDatosEx;

public class AccesoDatosImpl implements AccesoDatos {

	@Override
	public boolean existe(String nombreArchivo){
		File archivo = new File(nombreArchivo);
		return archivo.exists();
	}

	@Override
	public List<Pelicula> listar(String nombre) throws LecturaDatosEx {

		File archivo = new File(nombre);
		List<Pelicula> peliculas = new ArrayList<>();

		try {
			BufferedReader entrada = new BufferedReader(new FileReader(archivo));
			String linea = entrada.readLine();

			while (linea != null) {
				Pelicula pelicula = new Pelicula(linea);
				peliculas.add(pelicula);
				linea = linea = entrada.readLine();
			}

			entrada.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new LecturaDatosEx("Excepcion al listar peliculas" + e.getMessage());
		} catch (IOException e) {
			e.printStackTrace();
			throw new LecturaDatosEx("Excepcion al listar peliculas" + e.getMessage());
		}
		return peliculas;
	}

	@Override
	public void escribir(Pelicula pelicula, String nombreArchivo, boolean anexar) throws EscrituraDatosEx {
		File archivo = new File(nombreArchivo);

		try {
			PrintWriter salida = new PrintWriter(new FileWriter(archivo, anexar));
			salida.println(pelicula.toString());
			salida.close();

			System.out.println("Se ha escrito informacion en el archivo" + pelicula);

		} catch (IOException e) {
			e.printStackTrace();
			throw new EscrituraDatosEx("Excepcion al listar peliculas" + e.getMessage());

		}

	}

	@Override
	public String buscar(String nombreArchivo, String buscar) throws LecturaDatosEx {
		File archivo = new File(nombreArchivo);
		String resultado = "La pelicula no se encuentra en el catalogo";

		try {
			BufferedReader entrada = new BufferedReader(new FileReader(archivo));
			String linea = entrada.readLine();
			int indice = 1;

			while (linea != null) {
				if (buscar != null && buscar.equalsIgnoreCase(linea)) {
					resultado = "Pelicula " + linea + " en el indice " + indice;
					break;
				}
				linea = entrada.readLine();
				indice++;
			}
			entrada.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new LecturaDatosEx("Excepcion al buscar pelicula" + e.getMessage());

		} catch (IOException e) {
			e.printStackTrace();
			throw new LecturaDatosEx("Excepcion al buscar pelicula" + e.getMessage());

		}

		return resultado;
	}

	@Override
	public void crear(String nombreArchivo) throws AccesoDatosEx {
		File archivo = new File(nombreArchivo);

		try {
			PrintWriter salida = new PrintWriter(new FileWriter(archivo, true));
			salida.close();
			System.out.println("Archivo creado");

		} catch (IOException e) {
			e.printStackTrace();
			throw new AccesoDatosEx("Excepcion al crear archivoa" + e.getMessage());

		}

	}

	@Override
	public void borrar(String nombreArchivo) {
		File archivo = new File(nombreArchivo);
		if(archivo.exists()){
			archivo.delete();
			System.out.println("Archivo borrado");

		}

	}

}
