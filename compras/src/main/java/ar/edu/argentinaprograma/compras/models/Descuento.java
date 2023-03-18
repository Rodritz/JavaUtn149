package ar.edu.argentinaprograma.compras.models;

//definiendo una clase como abstracta le digo a java que es solo una superclase
//no puedo crear clases de tipo descuento de una clase abstract
public abstract class Descuento {
	
	private double valor;
	
	public double getValorDescuento() {
		return valor;
	}
	
	public void setValorDescuento(double valor) {
		this.valor = valor;
	}
	
	public abstract double valorFinal(double valorFinal);

	
}
