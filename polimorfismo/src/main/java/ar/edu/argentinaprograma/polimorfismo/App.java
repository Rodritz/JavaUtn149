package ar.edu.argentinaprograma.polimorfismo;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;

import ar.edu.argentinaprograma.polimorfismo.models.Deportista;
import ar.edu.argentinaprograma.polimorfismo.models.Ingeniero;
import ar.edu.argentinaprograma.polimorfismo.models.Persona;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Persona i1 = new Ingeniero("pedro");
        Persona d2 = new Deportista("gema");
        Persona i3 = new Ingeniero("pedro");
        Persona d4 = new Deportista("angel");
        Persona i5 = new Ingeniero("pedro");      
        
    	List<Persona> lista = Arrays.asList(i1,d2,i3,d4,i5);
    	
    	OptionalDouble resultado = calcularMediaVelocidad(lista);
    	
    	System.out.println(resultado);
        
    }
    
    public static OptionalDouble calcularMediaVelocidad(List<Persona> lista) {
    	return lista.stream().mapToDouble(Persona::correr).average();
    }
    
}