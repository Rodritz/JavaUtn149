package ar.com.argentinaPrograma.DBConnection;

import java.sql.Connection;
import java.sql.DriverManager;

public class App 
{
    public static void main( String[] args ){
        
        try {
        	//Registrar el driver
        	Class.forName("com.mysql.jdbc.Driver");
        	
        	//Crear el objeto de conexion
        	Connection con = DriverManager.getConnection(
        			"jdbc:mysql://localhost:3306/prueba",
        			"root", "root");
        	
        	//Creacion de sentencia
        	
			
		} catch (Exception e) {
			// TODO: handle exception
		}
    	
    	
        
    	
    	
        
    }
}
