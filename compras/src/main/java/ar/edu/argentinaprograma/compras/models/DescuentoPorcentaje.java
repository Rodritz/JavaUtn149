package ar.edu.argentinaprograma.compras.models;

public class DescuentoPorcentaje extends Descuento{

	//como no puedo heredar el metodo abstracto de Descuento, me obliga a sobreescribir el metodo
	@Override
	public double valorFinal(double valorInicial) {
		return valorInicial - (valorInicial * this.getValorDescuento());
	}
	
}