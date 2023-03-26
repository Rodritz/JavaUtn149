package ar.edu.argentinaprograma.compras.models;

public class DescuentoPorcentajeConTope extends Descuento {
	
	private Integer descTopeFijo;

	public Integer getDescTopeFijo() {
		return descTopeFijo;
	}

	public void setDescTopeFijo(Integer descTopeFijo) {
		this.descTopeFijo = descTopeFijo;
	}

	@Override
	public double valorFinal(double valorInicial) {
		if((valorInicial * this.getValorDescuento())<getDescTopeFijo()) {
		return valorInicial - (valorInicial * this.getValorDescuento());
		}else {
			return valorInicial - this.getDescTopeFijo();
		}
	}
		
}
