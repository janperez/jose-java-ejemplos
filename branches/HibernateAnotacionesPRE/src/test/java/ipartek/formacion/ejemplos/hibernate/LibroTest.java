package ipartek.formacion.ejemplos.hibernate;

import org.hibernate.Session;
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

	@Test
	public void test() {
		Persona persona1 = new Persona();
		persona1.setNombre("Alex");

		Persona persona2 = new Persona();
		persona2.setNombre("Juan");

		Session sesion = HibernateUtil.getSession();
		sesion.beginTransaction();

		sesion.persist(persona1);
		sesion.persist(persona2);

	}

}
