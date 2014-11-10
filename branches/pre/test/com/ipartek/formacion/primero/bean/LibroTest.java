package com.ipartek.formacion.primero.bean;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class LibroTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	//empiezan nuestros test unitarios
	@Test
	public void testLibro() {
		Libro libroPorDefecto = new Libro();
		assertTrue("NO son el numero de paginas esperado", Libro.PAGINAS_POR_DEFECTO==libroPorDefecto.getPaginas());
		assertFalse("Titulo vacio", libroPorDefecto.titulo.isEmpty());
		
		Libro libro1 = new Libro(-15, "Sin paginas");
		assertTrue("NO tiene paginas NEGATIVAS", libro1.getPaginas()==Libro.PAGINAS_POR_DEFECTO);
		
		Libro libro2 = new Libro(15,"'A'");
		assertTrue("NO es el titulo esperado", "'A'".equals(libro2.getTitulo()));
		
		libro1.setPaginas(15);
		assertTrue("NO es el numero de paginas esperado", 15==libro1.getPaginas());
		
		libro1.setTitulo("");
		assertTrue("NO es un titulo vacio", Libro.TITULO_POR_DEFECTO.equals(libro1.getTitulo()));
	}
	
	

}
