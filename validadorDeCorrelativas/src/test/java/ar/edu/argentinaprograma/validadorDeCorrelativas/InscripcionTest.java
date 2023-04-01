package ar.edu.argentinaprograma.validadorDeCorrelativas;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


import org.junit.Test;

import ar.edu.argentinaprograma.validadorDeCorrelativas.models.Alumno;
import ar.edu.argentinaprograma.validadorDeCorrelativas.models.Inscripcion;
import ar.edu.argentinaprograma.validadorDeCorrelativas.models.Materia;


public class InscripcionTest {
	
	//a. Una materia sin correlativas
		@Test
		public void validarInscripcionDeMateriaSinCorrelativas() {
			
			//Creamos materias
			Materia programacionI = new Materia("Programacion I");
			Materia programacionII = new Materia("Programacion II");
			Materia baseDeDatosI = new Materia("Base de datos I");
			
			//Agregamos una materia correlativa
			//la instancia programacionII es creada, se llama al metodo agregar... y se le agrega programacionI al array correlativas
			programacionII.agregarMateriaCorrelativa(programacionI);
			
			//Creamos un alumno
			Alumno alumno = new Alumno("Nahuel Ramirez","138000-0");
			
			//Creamos una inscripción SIN CORRELATIVAS
			Inscripcion inscripcion = new Inscripcion(alumno, baseDeDatosI);
			
			assertTrue(inscripcion.aprobada());
		}
		
		
		//b. Una materia con correlativas y que el alumno las tenga
		@Test
		public void validarInscripcionDeMateriaConCorrelativasYQueElAlumnoLasTenga() {
			
			//Creamos materias
			Materia programacionI = new Materia("Programacion I");
			Materia programacionII = new Materia("Programacion II");
			Materia baseDeDatosI = new Materia("Base de datos I");
			
			//Agregamos una materia correlativa
			programacionII.agregarMateriaCorrelativa(programacionI);
			
			//Creamos un alumno
			Alumno alumno = new Alumno("Nahuel Ramirez","138000-0");
			
			alumno.agregarMateriaAprobada(programacionI);

			//Creamos una inscripcion CON CORRELATIVAS APROBADAS
			Inscripcion inscripcion = new Inscripcion(alumno, programacionII);
			
			//evalua si la tiene aprobada
			assertTrue(inscripcion.aprobada());
		}
		
		//c. Otra materia con correlativas, y que el alumno no las tenga
		@Test
		public void validarInscripcionDeMateriaConCorrelativasYQueElAlumnoNoLasTenga() {
			
			//Creamos materias
			Materia programacionI = new Materia("Programacion I");
			Materia programacionII = new Materia("Programacion II");
			Materia baseDeDatosI = new Materia("Base de datos I");
			
			//Agregamos una materia correlativa
			programacionII.agregarMateriaCorrelativa(programacionI);
			
			//Creamos un alumno
			Alumno alumno = new Alumno("Nahuel Ramirez","138000-0");

			//Creamos una inscripción SIN CORRELATIVAS
			Inscripcion inscripcion = new Inscripcion(alumno, programacionII);
			
			//evalua si NO la tiene aprobada, por eso es assertFalse
			assertFalse(inscripcion.aprobada());
			//assertTrue(inscripcion.aprobada()); seria invalido porque TRUE + FALSE = FALSE
		}
		
	}