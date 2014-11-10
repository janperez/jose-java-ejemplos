package com.ipartek.formacion.primero.util;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class UtilidadesTest {

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

	@Test
	public void testEsVocal() {
		//test vocales
		char[] vocales = new char[]{'a', 'e', 'i', 'o', 'u', 'á', 'é', 'í', 'ó', 'ú', 'ü'};
		for (int i=0; i<vocales.length; i++){
			assertTrue("la vocal ["+vocales[i]+"] deberia ser true", Utilidades.esVocal(vocales[i]));
			assertTrue("la vocal ["+Character.toUpperCase(vocales[i])+"] deberia ser true", Utilidades.esVocal(Character.toUpperCase(vocales[i])));
		}
		
		//test NO vocales
		char[] noVocales = new char[]{'b', 'c', 'd', 'f', 'g', 'h','j', 'k', 'l', 'm', 'n', 'p', 'q', 'r', 's', 't', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '?', '¿'};
		for (int i=0; i<noVocales.length; i++){
			assertFalse("la NO vocal ["+noVocales[i]+"] deberia ser false", Utilidades.esVocal(noVocales[i]));
			assertFalse("la NO vocal ["+Character.toUpperCase(noVocales[i])+"] deberia ser false", Utilidades.esVocal(Character.toUpperCase(noVocales[i])));
		}
	}

	@Test
	public void testOrdenarMiArray(){
		// test array NO ordenado
		int[] vNumDesordenados = new int[]{89,54,3,1,45};
		Utilidades.ordenarMiArray(vNumDesordenados);
		for (int i = 0; i < vNumDesordenados.length-1; i++){
			int j=i+1;
			assertTrue("El numero["+i+"] = "+vNumDesordenados[i]+" deberia ser menor que el numero["+j+"] = "+vNumDesordenados[j],vNumDesordenados[i]<vNumDesordenados[j]);
		}
		
		// test array ordenado
		int[] vNumOrdenados = new int[]{1, 3, 45, 54, 89};
		Utilidades.ordenarMiArray(vNumOrdenados);
		for (int i = 0; i < vNumOrdenados.length-1; i++){
			int j=i+1;
			assertTrue("El numero["+i+"] = "+vNumOrdenados[i]+" deberia ser menor que el numero["+j+"] = "+vNumOrdenados[j],vNumOrdenados[i]<vNumOrdenados[j]);
		}

		// test de un array de un elemento
		int[] vNumSoloUnElemento = new int[]{23};
		Utilidades.ordenarMiArray(vNumSoloUnElemento);
		assertTrue("Deberia estar ordenado", vNumSoloUnElemento.length==1);
		
		// test de un array vacio
		int[] vNumVacios = new int[0];
		Utilidades.ordenarMiArray(vNumVacios);
		assertTrue("Deberia estar ordenado", vNumVacios.length==0);
	}
	
	@Test
	public void testInvertirArray(){
		//test de un array vacio
		int[] vNumVacios = new int[0];
		int[] vResultado = Utilidades.invertirArray(vNumVacios);
		assertTrue("Deberian tener el mismo tamanio", vResultado.length==vNumVacios.length);
		assertTrue("Deberia estar invertido", vResultado.length==0);
		
		//test de un array de un elemento
		int[] vNumUnicoElemento = new int[]{1};
		vResultado = Utilidades.invertirArray(vNumUnicoElemento);
		assertTrue("Deberian tener el mismo tamanio", vResultado.length==vNumUnicoElemento.length);
		assertTrue("Deberia estar invertido", vNumUnicoElemento[0]==vResultado[0]);
		
		//test de un array normal
		int [] vNumeros = new int[]{0,1,2,3,4};
		vResultado = Utilidades.invertirArray(vNumeros);
		assertTrue("Deberian tener el mismo tamanio", vResultado.length==vNumeros.length);
		for (int i=0; i<vNumeros.length; i++){
			assertTrue("vInicial["+i+"]="+vNumeros[i]+" deberia tener el mismo valor que vFinal["+vNumeros.length+"-1"+i+"]="+vResultado[vNumeros.length-1-i], vNumeros[i]==vResultado[vNumeros.length-1-i]);
		}
	}
	
	
}
