package entidad;

public class Pelicula {
	
	private String nombre;
	
	

	public Pelicula() {
		super();
	}


	public Pelicula(String nombre) {
		super();
		this.nombre = nombre;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	@Override
	public String toString() {
		return this.nombre;
	}
	
	

	
}

