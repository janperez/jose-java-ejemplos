package com.ipartek.formacion.primero.bean;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CalificacionTest {

	Calificacion cal;
	static final float DELTA = 0.0f;
	
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
		cal  = null;
	}

	@Test
	public void testCalificacion() {
		cal=new Calificacion();
		assertEquals(Calificacion.ASIGNATURA_POR_DEFECTO, cal.getAsignatura());
		assertEquals(Calificacion.NOTA_MINIMA, cal.getNota(), DELTA);
	}

	@Test
	public void testCalificacionStringFloat() {
		fail("Not yet implemented");
	}

	@Test
	public void testCalificacionStringFloatTimestamp() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetAsignatura() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetAsignatura() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetNota() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetNota() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetFecha() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetFecha() {
		fail("Not yet implemented");
	}

	@Test
	public void testToString() {
		fail("Not yet implemented");
	}

	@Test
	public void testTextoFecha() {
		fail("Not yet implemented");
	}

}
