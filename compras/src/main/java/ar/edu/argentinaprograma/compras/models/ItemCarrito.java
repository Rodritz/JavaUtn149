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

	public Double getPrecioSiHayStock() throws SinStockException {
		
		if(this.getCantidad() > this.getProducto().getStock()) {
			throw new SinStockException(this.getProducto());
		}
		
		return this.precio();
	}

}