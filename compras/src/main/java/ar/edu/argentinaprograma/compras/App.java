package ar.edu.argentinaprograma.compras;

import ar.edu.argentinaprograma.compras.models.DescuentoFijo;
import ar.edu.argentinaprograma.compras.models.DescuentoPorcentaje;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	//Descuento desc1 = new Descuento(); //me sale error porque no puedo instanciar una clase abstracta
    	
    	DescuentoFijo desc1 = new DescuentoFijo();
    	desc1.setValorDescuento(14);
    	
    	DescuentoPorcentaje desc2 = new DescuentoPorcentaje();
    	desc2.setValorDescuento(0.3);
    	
    	System.out.println(desc1.valorFinal(100));
    	System.out.println(desc2.valorFinal(100));
    }
}
