package ar.edu.argentinaprograma.calculadora;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class CalculadoraTest {
	
	@Test
	public void dadosNumerosEnteros_cuandoSeSuman_elResultadoEsperadoEs() {
		
		Integer numero1 = 3;
		Integer numero2 = 4;
		
		Integer resultadoEsperado = 7;
		
		assertEquals(resultadoEsperado, Calculadora.sumar(numero1, numero2));
	}
	
	@Test
	public void dadosNumerosEnteros_cuandoSePreguntanSiUnoEsMayor() {
		
		Integer numero1 =3;
		Integer numero2 =2;
		
		assertTrue(Calculadora.esMayoroIgualque(numero1, numero2));
	}

}
