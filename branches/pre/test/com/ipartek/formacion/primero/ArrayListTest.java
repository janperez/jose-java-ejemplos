package com.ipartek.formacion.primero;

import com.ipartek.formacion.primero.util.Utilidades;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ArrayListTest {
	ArrayList<String> listaPaises;
	
	static final String ESPANA = "España";
	static final String FRANCIA = "Francia";
	static final String PORTUGAL = "Portugal";
	static final String EUSKADI = "Euskadi";
	static final String BARAKALDO = "Barakaldo";

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		listaPaises = new ArrayList<String>();
		
		listaPaises.add(ESPANA); //Ocupa la posición 0
		listaPaises.add(FRANCIA); //Ocupa la posición 1
		listaPaises.add(PORTUGAL); //Ocupa la posición 2
	}

	@After
	public void tearDown() throws Exception {
		listaPaises = null;
	}

	@Test
	public void testPosicion() {

		assertSame(ESPANA, listaPaises.get(0));
		assertSame(FRANCIA, listaPaises.get(1));
		assertSame(PORTUGAL, listaPaises.get(2));
		assertSame(3, listaPaises.size());
	}
	
	@Test
	public void testInsertarPosicion(){
		// Insertar Barakaldo en posicion 1
		listaPaises.add(1, BARAKALDO);

		assertSame(ESPANA, listaPaises.get(0));
		assertSame(BARAKALDO, listaPaises.get(1));
		assertSame(FRANCIA, listaPaises.get(2));
		assertSame(PORTUGAL, listaPaises.get(3));
		assertSame(4, listaPaises.size());
		
	}
	
	@Test
	public void testEliminar(){
		//eliminar por key o valor
		listaPaises.remove(FRANCIA);
		
		assertSame(ESPANA, listaPaises.get(0));
		assertSame(PORTUGAL, listaPaises.get(1));
		assertSame(2, listaPaises.size());
				
		//eliminar por index o posicion
		listaPaises.remove(1);
		assertSame(ESPANA, listaPaises.get(0));
		assertSame(1, listaPaises.size());
	}

	@Test(expected=IndexOutOfBoundsException.class)
	public void testIndexException(){
		listaPaises.get(3);
	}
	
	@Test
	public void testEliminarIntegers(){
		ArrayList<Integer> listaNumeros = new ArrayList<Integer>();
		listaNumeros.add(1);
		listaNumeros.add(2);
		listaNumeros.add(3);
		listaNumeros.add(1);
		
		// Borrado segun posicion
		int index = 1;
		listaNumeros.remove(index);
		assertSame(3, listaNumeros.size());
		assertSame(1, listaNumeros.get(0));
		assertSame(3, listaNumeros.get(1));
		assertSame(1, listaNumeros.get(2));
		
		// Borrado segun valor
		// Borra el PRIMERO con esa coincidencia
		Integer objeto = new Integer(1);
		listaNumeros.remove(objeto);
		assertSame(2, listaNumeros.size());
		assertSame(3, listaNumeros.get(0));
		assertSame(1, listaNumeros.get(1));
		
	}
	
	@Test
	public void testAgurEspana(){
		listaPaises.set(0, EUSKADI);
		
		assertSame(EUSKADI, listaPaises.get(0));
		assertSame(FRANCIA, listaPaises.get(1));
		assertSame(PORTUGAL, listaPaises.get(2));
		assertSame(3, listaPaises.size());
		assertFalse(listaPaises.contains(ESPANA));

	}
	
	@Test
	public void testEliminarUltimoObjeto(){
		// No contiene el elemento
		Utilidades.eliminarUltimoElemento(listaPaises, BARAKALDO);
		assertSame(3, listaPaises.size());
		assertFalse(listaPaises.contains(BARAKALDO));
		
		// Contiene un solo elemento
		Utilidades.eliminarUltimoElemento(listaPaises, ESPANA);
		assertSame(2, listaPaises.size());
		assertFalse(listaPaises.contains(ESPANA));
	}
	
	// TODO remover el ultimo objeto con el valor especificado
	// TODO probar Empty y Null
	// TODO usar indexOf
	// TODO Contains ESPANA
	
}
