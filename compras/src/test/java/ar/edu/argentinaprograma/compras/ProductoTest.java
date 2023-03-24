package ar.edu.argentinaprograma.compras;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.HashSet;

import org.junit.Test;

import ar.edu.argentinaprograma.compras.models.Producto;

public class ProductoTest {

	@Test
	public void validarQueDosProductosSonIguales() {
		
		Producto harina = new Producto("harina",100.0);
		Producto harina1 = new Producto("harina",100.0);
		
		assertTrue(harina.equals(harina1));
	}
	
	@Test
	public void validarQueDosProductosSonDistintos() {
		
		Producto harina = new Producto("harina",100.0);
		Producto harina1 = new Producto("harina",200.0);
		
		assertFalse(harina.equals(harina1));
	}
	
	@Test
	public void validarQueLosProductosSonIgualesUsandoHashSet() {
		
		Producto harina = new Producto("harina",100.0);
		Producto harina1 = new Producto("harina",200.0);
		Producto harina2 = new Producto("harina",100.0);
		
		HashSet<Producto> listaProductos = new HashSet<Producto>();
		
		listaProductos.add(harina);
		listaProductos.add(harina);
		listaProductos.add(harina1);
		listaProductos.add(harina2); //No debería agregarse porque tiene el mismo nombre y precio que la instancia harina
		
		//Deberían quedar solo dos elementos en el set.
		
		assertTrue(listaProductos.size() == 2);
	}
}