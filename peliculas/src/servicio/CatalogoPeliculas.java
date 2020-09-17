package servicio;

public interface CatalogoPeliculas {
	
	public static final String NOMBRE_ARCHIVO = "peliculas.txt";
	
	public void agregarPelicula(String nombrePelicula);
	
	public void listarPeliculas();
	
	public void buscarPelicula(String buscar);
	
	public void iniciarArchivo();
	

}
