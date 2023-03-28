package ar.edu.argentinaprograma.lombok;

import java.util.ArrayList;
import java.util.Scanner;

import ar.edu.argentinaprograma.lombok.models.Persona;
import lombok.ToString;


public class App {
    public static void main( String[] args ){
    	
    	ArrayList<Persona> personas = new ArrayList<Persona>();
    	
    	
    	Scanner scanner = new Scanner(System.in);
        String respuesta;

        do {
            Persona persona = new Persona();

            System.out.println("Ingrese el nombre:");
            persona.setNombre(scanner.nextLine());

            System.out.println("Ingrese el apellido:");
            persona.setApellido(scanner.nextLine());

            System.out.println("Ingrese la fecha de nacimiento:");
            persona.setFechaDeNacimiento(scanner.nextLine());

            personas.add(persona);

            System.out.println("¿Desea agregar otra persona? (S/N)");
            respuesta = scanner.nextLine().toUpperCase();
        } while (respuesta.equals("S"));
    	
        System.out.println(personas);
        
    }
}
