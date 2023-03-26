package ar.edu.argentinaprograma.compras.models;

import ar.edu.argentinaprograma.compras.exceptions.SinStockException;

public class ItemCarrito {
	
	private Producto producto;
	private Integer cantidad;
	
	public ItemCarrito(Producto producto, Integer cantidad) {
		this.setProducto(producto);
		this.setCantidad(cantidad);
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public Double precio() {
		return this.getProducto().getPrecio()*this.getCantidad();
	}
	
	//creamos el metodo que retorne si hay stock, sino lanzara una exception
	public Double getPrecioSiHayStock() throws SinStockException {
		
		if(this.getCantidad() > this.getProducto().getStock()) {
			//SinStockException abc = new SinStockException(this.getProducto());
			throw new SinStockException(this.getProducto());//aca estoy instanciando la exception, la estoy creando de otro modo
		}													//si valida que no hay producto suficiente, en este caso, lanzara la exception
		
		return this.precio();
	}

}