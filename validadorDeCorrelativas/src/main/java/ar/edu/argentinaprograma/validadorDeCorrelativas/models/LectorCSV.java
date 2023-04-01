package ar.edu.argentinaprograma.validadorDeCorrelativas.models;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.nio.charset.StandardCharsets;

import com.opencsv.bean.CsvToBeanBuilder;

import ar.edu.argentinaprograma.validadorDeCorrelativas.excepciones.NoExisteAlumnoExcepcion;
import ar.edu.argentinaprograma.validadorDeCorrelativas.excepciones.NoExisteMateriaExcepcion;

public class LectorCSV {
	public String rutaArchivo;
	public List<LineasCsvInscripcion> lineasArchivo;//aca vamos a guardas los datos obtenidos al leer el csv
	
	//creamos un metodo constructor que recibe la ruta, me setea la ruta archivo y me lee el archivo
	public LectorCSV(String ruta) {
		this.rutaArchivo = ruta;
		this.leerElArchivo();
	}
	
	//creo el metodo leer archivo
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void leerElArchivo() {
		
		List<LineasCsvInscripcion> lineasLeidas = null;
		
		try {
			//Agrego el encoding del archivo en FileReader
			lineasLeidas = new CsvToBeanBuilder(new FileReader(this.rutaArchivo, StandardCharsets.UTF_8))
					// con esta configuracion salteamos el encabezado
					.withSkipLines(1)
					// tenemos que declarar el tipo de dato que va a generar con cada linea del csv
					.withType(LineasCsvInscripcion.class)
					.build().parse();
			
		} catch (IllegalStateException e) {			
			e.printStackTrace();
		} catch (FileNotFoundException e) {			
			e.printStackTrace();
		} catch (IOException e) {//esta exception me aparece disponible al agregar charset UTF_8			
			e.printStackTrace();
		}
		
		this.lineasArchivo = lineasLeidas;
	}
	
	
	
	public void listarInscripciones(List<Alumno> alumnos, List<Materia> materias){
		//POR CADA LINEA DEL CSV LEIDO TENGO QUE CREAR LA INSCRIPCION
		//PARA CREAR LA INSCRIPCION DEBO BUSCAR EL ALUMNO POR EL NOMBRE
		// Y BUSCAR LA MATERIA POR EL NOMBRE
		List<Inscripcion> inscripciones = new ArrayList<Inscripcion>();
		
		for(LineasCsvInscripcion lineaLeida : this.lineasArchivo) {
			
			try {
				Inscripcion inscripcion = this.validarInscripcion(alumnos, materias, lineaLeida);
				this.imprimirEnPantalla(lineaLeida.getNombreAlumno(), lineaLeida.getNombreMateria(), inscripcion.aprobadaString());
			} catch (NoExisteAlumnoExcepcion e) {
				this.imprimirEnPantalla(lineaLeida.getNombreAlumno(), lineaLeida.getNombreMateria(), "No existe el/la alumno/a");
			} catch (NoExisteMateriaExcepcion e) {
				this.imprimirEnPantalla(lineaLeida.getNombreAlumno(), lineaLeida.getNombreMateria(), "No existe la materia");
			}

		}
	}
	
	public Inscripcion validarInscripcion(List<Alumno> alumnos, 
			List<Materia> materias, 
			LineasCsvInscripcion lineaLeida) 
			//debemos aclarar que el metodo puede devolvernos una inscripcion o arrojarnos una Exception
			throws NoExisteAlumnoExcepcion, NoExisteMateriaExcepcion {
		
		//busqueda del alumno por el nombre de la linea del csv
		//de esta manera valido que el alumno que tengo en el csv ya fue instanciado en mi programa
		Alumno alumnoLeido = null;
		for(Alumno alumnoDeLaLista : alumnos) {
			if(alumnoDeLaLista.getNombre().equalsIgnoreCase(lineaLeida.getNombreAlumno())) {
				alumnoLeido = alumnoDeLaLista;
			}
		}		
		//busqueda de la materia por el nombre de la linea del csv
		//de esta manera valido que la materia que tengo en el csv ya fue instanciada en mi programa
		Materia materiaLeida = null;
		for(Materia materiaDeLaLista : materias) {
			if(materiaDeLaLista.getNombre().equalsIgnoreCase(lineaLeida.getNombreMateria())){
				materiaLeida = materiaDeLaLista;
			}
		}
		
		//Agregar validacion de que la materia y el alumno exista
		if(alumnoLeido == null) {
			throw new NoExisteAlumnoExcepcion();
		}
		if(materiaLeida == null) {
			throw new NoExisteMateriaExcepcion();
		}
		
		return new Inscripcion(alumnoLeido,materiaLeida);
	}
	
	public void imprimirEnPantalla(String nombreAlumno, String nombreMateria, String resultado) {
		//el printf del system.ot me imprime en columnas
		// Se usa el % para formatear. Se indica con -20 la cantidad de espacios de texto de separacion
		System.out.printf("%-20s%-20s%-20s\n",nombreAlumno,nombreMateria,resultado);//el \n es para saltar de linea
	}
	
}

