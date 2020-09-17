package presentacion;

import java.util.Scanner;

import servicio.*;

public class CatalogoPeliculasPresentacion {

	public static void main(String[] args) {

		int opcion = -1;

		Scanner scan = new Scanner(System.in);

		CatalogoPeliculas catalogoPeliculas = new CatalogoPeliculasImpl();

		while (opcion != 0) {

			mostrarMenu();
			opcion = Integer.parseInt(scan.nextLine());

			switch (opcion) {

			case 1:
				catalogoPeliculas.iniciarArchivo();
				mostrarMenu();
				break;

			case 2:
				System.out.println("Introduce el nombre de la pelicula: ");
				String nombrePelicula = scan.nextLine();
				catalogoPeliculas.agregarPelicula(nombrePelicula);
				break;

			case 3:
				catalogoPeliculas.listarPeliculas();
				break;

			case 4:
				System.out.println("Introduce el nombre de la pelicula: ");
				String buscar = scan.nextLine();
				catalogoPeliculas.buscarPelicula(buscar);

				break;

			case 0:

				System.out.println("Hasta pronto! ");

				break;

			default:

				System.out.println("La opcion ingresada no existe.");

				break;
			}
			

		}
		

	}

	public static void mostrarMenu() {
		System.out.println("Elije una opcion:\n" + "1. Iniciar/Reiniciar catalogo de peliculas \n"
				+ "2. Agregar pelicula \n" + "3. Listar pelicula \n" + "4. Buscar pelicula \n" + "0. Salir \n");
	}

}
