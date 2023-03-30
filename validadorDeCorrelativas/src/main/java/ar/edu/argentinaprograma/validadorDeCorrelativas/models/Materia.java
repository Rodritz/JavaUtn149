package ar.edu.argentinaprograma.validadorDeCorrelativas.models;


import java.util.ArrayList;
import java.util.List;

public class Materia {
	
	private String nombre;
	private List<Materia> correlativas;//cuando tenemos una lista como atributo debemos crearla en el metodo constructor
	
	/*
	  el motodo constructor no hace falta si utilizo lombok, al igual que los setters y getters
	  public Materia(){
	  
	*/
	
	//cuando tenemos atributos que son listas debemos instanciar la lista en el metodo constructor
	public Materia(String nombre) {
		this.setNombre(nombre);
		this.correlativas = new ArrayList<Materia>();
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Materia> getCorrelativas() {
		return correlativas;
	}

	public void setCorrelativas(List<Materia> correlativas) {
		this.correlativas = correlativas;
	}
	
	//cuando usamos una lista como atributo de una clase tenemos que crear metodos que nos permitan agregar o quitar elementos, en este caso materias
	public void agregarMateriaCorrelativa(Materia materia) {
		this.correlativas.add(materia);
	}
	
	public void quitarMateriaCorrelativa(Materia materia) {
		this.correlativas.remove(materia);
	}

	public boolean puedeCursar(Alumno alumno) {
		//Verificar que el alumno tenga las materias correlativas aprobadas
		if(this.getCorrelativas().size()==0) { //aca evaluo si la materia tiene correlativas, si no tiene, es decir es 0, entonces devuelve TRUE y al puede cursar
			return true;
		}else {//si llega a tener correlativas
			for(Materia materia : this.getCorrelativas()) {
				if(!alumno.getMateriasAprobadas().contains(materia)) {
					return false;//Basta que solo una materia no la tenga aprobada para que devuelva false
				}		
			}
			return true;//si sale del ciclo quiere decir que tiene las materias correlativas aprobadas
		}
	}
	

}
