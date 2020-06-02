package main;

public class videojuego {
	
	int numeroVidiojuego;
	String nombreVidiojuego;
	String plataforma;
	Double precio;
	public videojuego() {
		super();
	}
	public videojuego(int numeroVidiojuego, String nombreVidiojuego, String plataforma, Double precio) {
		super();
		this.numeroVidiojuego = numeroVidiojuego;
		this.nombreVidiojuego = nombreVidiojuego;
		this.plataforma = plataforma;
		this.precio = precio;
	}
	public int getNumeroVidiojuego() {
		return numeroVidiojuego;
	}
	public void setNumeroVidiojuego(int numeroVidiojuego) {
		this.numeroVidiojuego = numeroVidiojuego;
	}
	public String getNombreVidiojuego() {
		return nombreVidiojuego;
	}
	public void setNombreVidiojuego(String nombreVidiojuego) {
		this.nombreVidiojuego = nombreVidiojuego;
	}
	public String getPlataforma() {
		return plataforma;
	}
	public void setPlataforma(String plataforma) {
		this.plataforma = plataforma;
	}
	public Double getPrecio() {
		return precio;
	}
	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	@Override
	public String toString() {
		return "videojuego [numeroVidiojuego=" + numeroVidiojuego + ", nombreVidiojuego=" + nombreVidiojuego
				+ ", plataforma=" + plataforma + ", precio=" + precio + "]";
	}
	
	
	
}
