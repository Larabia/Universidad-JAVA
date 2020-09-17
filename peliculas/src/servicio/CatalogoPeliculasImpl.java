package servicio;

import java.util.List;

import datos.*;
import entidad.Pelicula;
import excepciones.AccesoDatosEx;
import excepciones.LecturaDatosEx;

public class CatalogoPeliculasImpl implements CatalogoPeliculas {

	private final AccesoDatos datos;

	public CatalogoPeliculasImpl() {
		super();
		this.datos = new AccesoDatosImpl();
	}

	@Override
	public void agregarPelicula(String nombrePelicula) {
		Pelicula pelicula = new Pelicula(nombrePelicula);
		boolean anexar = false;

		try {
			anexar = datos.existe(NOMBRE_ARCHIVO);
			datos.escribir(pelicula, NOMBRE_ARCHIVO, anexar);

		} catch (AccesoDatosEx e) {
			System.out.println("Error de acceso a datos en agregarPelicula");
			e.printStackTrace(System.out);
		}
	}

	@Override
	public void listarPeliculas() {
		try {
			List<Pelicula> peliculas = datos.listar(NOMBRE_ARCHIVO);
			int indice = 1;
			for (Pelicula pelicula : peliculas) {
				System.out.println(indice + ". " + pelicula);
				indice++;
			}

		} catch (LecturaDatosEx e) {
			System.out.println("Error de lectura de datosen listarPeliculas");
			e.printStackTrace(System.out);
		}

	}

	@Override
	public void buscarPelicula(String buscar) {
		String resultado = null;

		try {
			resultado = datos.buscar(NOMBRE_ARCHIVO, buscar);

		} catch (LecturaDatosEx e) {
			System.out.println("Error de lectura de datosen buscarPelicula");
			e.printStackTrace(System.out);
		}

		System.out.println("Resultado = " + resultado);

	}

	@Override
	public void iniciarArchivo() {
		
		try {
			if(datos.existe(NOMBRE_ARCHIVO)){
				datos.borrar(NOMBRE_ARCHIVO);
				datos.crear(NOMBRE_ARCHIVO);
				System.out.println("Catalogo reiniciado");
			} else {
				datos.crear(NOMBRE_ARCHIVO);
				System.out.println("Catalogo iniciado");
			}
		} catch (AccesoDatosEx e) {
			System.out.println("Error de acceso a datos en iniciarArchivo");
			e.printStackTrace(System.out);
		}

	}

}
