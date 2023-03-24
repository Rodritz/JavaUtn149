package ar.edu.argentinaprograma.polimorfismo.models;

public abstract class Persona {
	
	private String nombre;
	
	public Persona(String nombre) {
		this.setNombre(nombre);
	}	

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public abstract int correr();

}