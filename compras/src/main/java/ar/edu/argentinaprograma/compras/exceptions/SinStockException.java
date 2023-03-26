package ar.edu.argentinaprograma.compras.exceptions;

import ar.edu.argentinaprograma.compras.models.Producto;

public class SinStockException extends Exception{
	//todas las exception que creemos son subclases de Exception, por 
	//eso extends Exception
	
	//atributo final indica que una vez que se instancia la clase no se 
	//va a modificar, por eso el setter no lo crea automaticamente
	private final Producto producto;
	
	//getters y setters(el cual debo crear a mano)
	public SinStockException(Producto producto) {
		this.producto = producto;
	}

	public Producto getProducto() {
		return producto;
	}	
	
}