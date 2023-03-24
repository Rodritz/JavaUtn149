package ar.edu.argentinaprograma.compras;

import static org.junit.Assert.assertEquals;

import java.util.Iterator;


import org.junit.Test;

import ar.edu.argentinaprograma.compras.models.Carrito;
import ar.edu.argentinaprograma.compras.models.ItemCarrito;
import ar.edu.argentinaprograma.compras.models.Producto;

public class CarritoTest {

	@Test
	public void validarCostoFinalBienCalculado() {
		
		//Instancie 3 productos
		Producto harina = new Producto("harina",100.0);
		Producto roastBeef = new Producto("roast beef",1250.5);
		Producto leche = new Producto("leche",250.0);

    	ItemCarrito item1 = new ItemCarrito(harina,3);
    	ItemCarrito item2 = new ItemCarrito(roastBeef,1);
    	ItemCarrito item3 = new ItemCarrito(leche,3);

    	Carrito unCarrito = new Carrito();
    	
    	unCarrito.agregarItem(item1);
    	unCarrito.agregarItem(item2); 	
    	
    	//Iterar lista usando Iterator
    	Double costoFinalDelCarritoUsandoIterator = 0.0;
    	Iterator<ItemCarrito> iterador = unCarrito.getItems().iterator();		
		while(iterador.hasNext()) {
			ItemCarrito item = iterador.next();
			costoFinalDelCarritoUsandoIterator= costoFinalDelCarritoUsandoIterator+ item.precio();	
		}  
		
		assertEquals(unCarrito.costoFinal(),costoFinalDelCarritoUsandoIterator);	
   	}
	
	@Test
	public void validarCostoFinalBienCalculadoUsandoMapeo() {
		
		//Instancie 3 productos
		Producto harina = new Producto("harina",100.0);
		Producto roastBeef = new Producto("roast beef",1250.5);
		Producto leche = new Producto("leche",250.0);

    	ItemCarrito item1 = new ItemCarrito(harina,3);
    	ItemCarrito item2 = new ItemCarrito(roastBeef,1);
    	ItemCarrito item3 = new ItemCarrito(leche,3);

    	Carrito unCarrito = new Carrito();
    	
    	unCarrito.agregarItem(item1);
    	unCarrito.agregarItem(item2); 	
    	
    	//Iterar lista usando Mapeo
    	Double costoFinalDelCarritoUsandoIterator = 0.0;
    	
    	costoFinalDelCarritoUsandoIterator = unCarrito.getItems().stream()
    			.mapToDouble(item -> item.precio())
    			.map(precio -> precio).sum();
    			
		assertEquals(unCarrito.costoFinal(),costoFinalDelCarritoUsandoIterator);	
   	}
	
}