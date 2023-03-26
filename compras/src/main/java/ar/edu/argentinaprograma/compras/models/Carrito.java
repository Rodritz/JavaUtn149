package ar.edu.argentinaprograma.compras.models;

import java.util.ArrayList;
import java.util.List;

import ar.edu.argentinaprograma.compras.exceptions.SinStockException;

public class Carrito {
	
	//atributos
	private Persona persona;

	private List<ItemCarrito> items;//declaramos la lista
	
	//creo el constructor carrito el cual va a crear si o si la lista
	public Carrito() {
		this.items = new ArrayList<ItemCarrito>();
	}
	
	public List<ItemCarrito> getItems(){
		return this.items;
	}
	
	//metodos
	public void agregarItem(ItemCarrito ic) {
		this.items.add(ic);
	}
	
	public void quitarItem(ItemCarrito ic) {
		this.items.remove(ic);
	}
		
	public void imprimiEnPantallaElDueño() {
		System.out.println(this.persona.getApellido() + ", " + this.persona.getNombre());;
	}
	
	//en el sig metodo debemos iterar la lista
	public Double costoFinal() {
		Double costoFinal = 0.0;
		for(ItemCarrito item : this.getItems()) {
			costoFinal = costoFinal + item.precio();
		}
		return costoFinal;
	}
	
	//en el sig metodo asignamos un desc como argumento
	public Double costoFinal(Descuento desc) {
		Double costoFinal = 0.0;
		for(ItemCarrito item : this.getItems()) {
			costoFinal = costoFinal + item.precio();
		}
		return desc.valorFinal(costoFinal);
	}
	
	public Double costoFinalSiHayStock() throws SinStockException {
		Double costoFinal = 0.0;
		for(ItemCarrito item : this.getItems()) {
			costoFinal = costoFinal + item.getPrecioSiHayStock();
		}
		return costoFinal;
	}
	
	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

}