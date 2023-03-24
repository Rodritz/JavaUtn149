package ar.edu.argentinaprograma.polimorfismo.models;

public class Deportista extends Persona{

	public Deportista(String nombre) {
		super(nombre);
	}

	@Override
	public int correr() {
		return 7;
	}	
	
}