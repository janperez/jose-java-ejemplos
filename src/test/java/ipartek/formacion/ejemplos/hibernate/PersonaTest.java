package ipartek.formacion.ejemplos.hibernate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class PersonaTest {
	static Session s = null;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		s = HibernateUtil.getSession();
		s.beginTransaction();

		// crear nueva persona
		Persona p = new Persona();

		p.setNombre("dummy");
		p.setApellido("foo bar");
		p.setEdad(18);
		p.setFechaNacimiento(new Date());
		// insertar en BBDD
		s.save(p);

		p = new Persona();
		p.setNombre("dummy2");
		p.setApellido("foo2 bar2");
		p.setEdad(20);
		p.setFechaNacimiento(new Date());
		// insertar en BBDD
		s.save(p);

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

	/**
	 * Insercion de una persona en la tabla
	 */
	@Test
	public void testInsert() {
		// crear nueva persona
		Persona p = new Persona();

		p.setNombre("Antxon");
		p.setApellido("aberasturi");
		p.setEdad(35);
		p.setFechaNacimiento(new Date());
		s.save(p);
	}

	/**
	 * Obtener todas las personas de la tabla
	 */
	@Test
	public void testGetAll() {
		List<Persona> personas = null;
		personas = s.createQuery("from Persona order by edad").list();

		assertEquals(18, personas.get(0).getEdad());
		assertEquals(20, personas.get(1).getEdad());
	}

	/**
	 * Obtener una persona por su ID
	 */
	@Test
	public void testGetByID() {
		Persona p = (Persona) s.get(Persona.class, (long) 1);
		assertEquals("dummy", p.getNombre());
		assertEquals(18, p.getEdad());
	}

	/**
	 * Borrar una persona
	 */
	@Test
	public void testDelete() {
		// crear persona
		Persona p = new Persona();
		p.setNombre("Eliminar");
		s.save(p);
		long id = p.getId();
		// s.getTransaction().commit();

		// guardar persona

		// Obtener persona por ID
		p = (Persona) s.get(Persona.class, id);
		// eliminar persona pasando el objeto
		s.delete(p);

		// comito el borrado
		// s.getTransaction().commit();

		// intento recuperar de nuevo la misma persona
		Persona pEliminada = (Persona) s.get(Persona.class, id);
		assertNull(pEliminada);
	}

	@Test
	public void testUpdate() {
		// crear persona
		Persona p = new Persona();
		p.setNombre("Eliminar");
		// guardar persona
		s.save(p);
		long id = p.getId();

		// modificamos el nombre de "Eliminar" a "Modificado"
		p.setNombre("Modificado");
		s.update(p);

		// recuperar de la base de datos para comprobar cambio
		Persona modificada = (Persona) s.get(Persona.class, id);
		assertEquals("Modificado", modificada.getNombre());
	}

	@Test
	public void testPersonaCurso() {
		// crear curso
		Curso c = new Curso();
		c.setCodigo("IFCDXXXX");
		c.setNombre("Web");

		Curso c2 = new Curso();
		c2.setCodigo("IFCDXXXX");
		c2.setNombre("PHP");

		// incluirlos en la Coleccion
		Set<Curso> cursos = new HashSet<Curso>();
		cursos.add(c);
		cursos.add(c2);

		// recuperar primea persona y asignarle un curso
		Persona p = (Persona) s.get(Persona.class, (long) 1);
		p.setCursos(cursos);

		// modificar persona
		s.update(p);

	}
}
