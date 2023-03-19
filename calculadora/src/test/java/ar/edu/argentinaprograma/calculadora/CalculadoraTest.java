package ar.edu.argentinaprograma.calculadora;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Test;

public class CalculadoraTest {
	
	@Test
	public void dadosNumerosEnteros_cuandoSePreguntanSiUnoEsMayor() {
		
		Double numero1 =3.0;
		Double numero2 =2.0;
		
		assertTrue(Calculadora.esMayoroIgualque(numero1, numero2));
	}
	
	@Test
    public void dadoUnNumeroEntero_cuandoSeLoDividePorCero_seObtieneUnaExcepcion() {
    
		Double numero1 = 1.0;
		Double numero2 = 0.0;    			;
    	
        assertThrows(ArithmeticException.class, () -> Calculadora.dividir(numero1, numero2));
    }
	
	@Test
	public void dadosNumerosEnteros_cuandoSeSuman_elResultadoEsperadoEs() {
		
		Double numero1 = 3.0;
		Double numero2 = 4.0;
		
		Double resultadoEsperado = 7.0;
		
		assertEquals(resultadoEsperado, Calculadora.sumar(numero1, numero2));
	}
	
	@Test
	public void dadosNumerosEnteros_cuandoSeRestan_elResultadoEsperadoEs() {
		
		Double numero1 = 5.0;
		Double numero2 = 2.0;
		
		Double resultadoEsperado = 3.0;
		
		assertEquals(resultadoEsperado, Calculadora.restar(numero1, numero2));
	}
	
	@Test
	public void dadosNumerosEnteros_cuandoSeMultiplican_elResultadoEsperadoEs() {
		
		Double numero1 = 15.0;
		Double numero2 = 3.0;
		
		Double resultadoEsperado = 45.0;
		
		assertEquals(resultadoEsperado, Calculadora.multiplicar(numero1, numero2));
	}
	
	@Test
	public void dadosNumerosEnteros_cuandoSeDividen_elResultadoEsperadoEs() {
		
		Double numero1 = 10.0;
		Double numero2 = 5.0;
		
		Double resultadoEsperado = 2.0;
		
		assertEquals(resultadoEsperado, Calculadora.dividir(numero1, numero2));
	}
	
	
	
	@Test
	public void dadosNumerosEnteros_cuandoSeSuman_yLuegoSeDividenPorOtroEntero() {
		
		Double numero1 = 150.0;
		Double numero2 = 180.0;
		Double numero3 = 3.0;
		
		Double resultadoEsperado = 110.0;
		
		assertEquals(resultadoEsperado, Calculadora.dividir(Calculadora.sumar(numero1, numero2), numero3));
		
	}
	
	@Test
	public void dadosNumerosEnteros_cuandoSeRestan_yLuegoSeMultiplicanPorOtroEntero() {
		
		Double numero1 = 90.0;
		Double numero2 = 50.0;
		Double numero3 = 15.0;
		
		Double resultadoEsperado = 605.0;//resultado correcto seria 600
		
		assertEquals(resultadoEsperado, Calculadora.multiplicar(Calculadora.restar(numero1, numero2), numero3));
		
	}
	
	@Test
	public void dadosNumerosEnteros_cuandoSeSuman_yLuegoSeMultiplicanPorOtroEntero() {
		
		Double numero1 = 70.0;
		Double numero2 = 40.0;
		Double numero3 = 25.0;
		
		Double resultadoEsperado = 2700.0;//resultado correcto seria 2750
		
		assertEquals(resultadoEsperado, Calculadora.multiplicar(Calculadora.sumar(numero1, numero2), numero3));
		
	}
	
}
