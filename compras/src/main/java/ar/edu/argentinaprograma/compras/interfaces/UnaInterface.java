package ar.edu.argentinaprograma.compras.interfaces;

import ar.edu.argentinaprograma.compras.models.Producto;

public interface UnaInterface {
	
	//los metodos de las interfaces no se declaran, solo se definen
	//quien las declara es la clase que las implementa
	public void hacerAlgo(Producto p);
	
	public Producto obtenerProducto(String nombre);
	
}
