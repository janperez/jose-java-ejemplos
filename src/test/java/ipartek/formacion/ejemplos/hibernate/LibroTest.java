package ipartek.formacion.ejemplos.hibernate;

import static org.junit.Assert.*;

import org.hibernate.Session;
import org.junit.AfterClass;
import org.junit.Test;

public class LibroTest {

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void test() {
		/*Primero creamos una persona y la asociamos con dos libros*/ 
	    Libro libro1 = new Libro(); 
	    libro1.setTitulo("20000 leguas de viaje submarino");  

	    Libro libro2 = new Libro(); 
	    libro2.setTitulo("La maquina del tiempo");  

	    Persona persona1 = new Persona(); 
	    persona1.setNombre("Persona que se eliminara");  
	    persona1.getLibros().add(libro1); 
	    persona1.getLibros().add(libro2);   

	    /*Creamos una segunda persona, que sera eliminada, y la asociamos
	    con otros dos libros*/ 
	    Libro libro3 = new Libro(); 
	    libro3.setTitulo("El ingenioso hidalgo don Quijote de la Mancha");  

	    Libro libro4 = new Libro(); 
	    libro4.setTitulo("La Galatea");  

	    Persona persona2 = new Persona(); 
	    persona2.setNombre("Alex");  
	    persona2.getLibros().add(libro3); 
	    persona2.getLibros().add(libro4);   

	    /*En la primer sesion guardamos las dos personas (los libros
	    correspondientes seran guardados en cascada*/ 
	    
	    Session sesion = HibernateUtil.getSession();
	    sesion.beginTransaction();  

	    sesion.persist(persona1); 
	    sesion.persist(persona2);  

	    sesion.getTransaction().commit(); 
	    sesion.close();   

	    /*En la segunda sesion eliminamos la persona1 (los dos primeros
	    libros seran borrados en cascada)*/ 
	    sesion = HibernateUtil.getSession();
	    sesion.beginTransaction();  

	    sesion.delete(persona1);  

	    sesion.getTransaction().commit(); 
	    sesion.close();   
	}

}
