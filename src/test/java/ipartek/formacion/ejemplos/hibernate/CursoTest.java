package ipartek.formacion.ejemplos.hibernate;

import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CursoTest {
	static Session s = null;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		s = HibernateUtil.getSession();
		s.beginTransaction();

		// crear nueva persona
		Curso c = new Curso();

		c.setNombre("Desarrolllo App Web");
		c.setCodigo("IFCD0210");

		SimpleDateFormat sdfFecha = new SimpleDateFormat("dd-MM-yyyy");
		String sInicio = "11-09-2014";
		String sFin = "12-02-2015";

		c.setFechaInicio(sdfFecha.parse(sInicio));
		c.setFechaFin(sdfFecha.parse(sFin));
		// insertar en BBDD
		s.save(c);

		s.getTransaction().commit();
		s.close();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		s = HibernateUtil.getSession();
		s.beginTransaction();

	}

	@After
	public void tearDown() throws Exception {
		s.getTransaction().commit();
		s.close();

	}

	@Test
	public void testCursoPersona() {
		// recuperar el curso con id == 1
		Curso c = (Curso) s.get(Curso.class, (long) 1);

		// crear una persona y añadir a la coleccion
		Set<Persona> personas = new HashSet<Persona>();
		Persona p = new Persona();
		p.setNombre("mock");
		personas.add(p);

		// insertar persona en curso
		c.setPersonas(personas);

		// persistir el curso
		s.update(c);
	}
}
