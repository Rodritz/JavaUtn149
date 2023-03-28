package ar.edu.argentinaprograma.lombok.models;


import java.time.LocalDate;

import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode


public class Persona {
	
	private String nombre;
	private String apellido;
	private String fechaDeNacimiento;

}
