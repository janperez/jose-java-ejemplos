package ipartek.formacion.ejemplos.hibernate;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javassist.expr.NewArray;

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
				
		//crear personas de prueba
		Persona p =  new Persona();
		p.setNombre("dummy");
		p.setFechaNacimiento( new Date() );
		p.setApellidos("foo bar");
		p.setEdad(18);
		s.save(p);
		
		p =  new Persona();
		p.setNombre("dummy2");
		p.setFechaNacimiento( new Date() );
		p.setApellidos("foo2 bar2");
		p.setEdad(20);
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
	

	@Test
	public void testInsert() {
		
		//crear nueva persona
		Persona p =  new Persona();
		p.setNombre("Antton");
		p.setFechaNacimiento( new Date() );
		p.setApellidos("Gorriti");
		p.setEdad(38);		
		
		//insertar en bbdd
		s.save(p);
		
		// segun guardamos tenemos el ID
		//assertTrue( (long)3 == p.getId() );
		
	}
	
	
	@Test
	public void testGetAll() {		
		List<Persona> personas = null;
		personas = s.createQuery("from Persona order by edad").list();
		
		assertTrue( 0 < personas.size() );
				
	}
	
	
	@Test
	public void testGetByID() {
		
		Persona p = (Persona) s.get( Persona.class, (long)1 );
		assertEquals("dummy", p.getNombre() );		
		assertEquals( 18 , p.getEdad() );
		
	}
	
	
	@Test
	public void testDelete() {
		
		//crear persona
		Persona p =  new Persona();
		p.setNombre("Eliminar");				
		//guardar persona
		s.save(p);		
		long id = p.getId();
		
		//eliminar persona pasando el objeto
		s.delete( p );		
		
		//intento recuperar de nueva la misma persona
		Persona eliminada = (Persona)s.get( Persona.class, id ); 
		assertNull( eliminada );	
		
	}
	

	@Test
	public void testUpdate() {
		//crear persona
		Persona p =  new Persona();
		p.setNombre("Eliminar");				
		//guardar persona
		s.save(p);		
		long id = p.getId();
		
		//modificamos el nombre de "Eliminar" a "Modificado"
		p.setNombre("Modificado");
		s.update(p);
		
		//recuperar de la base de datos para comprobar cambio nombre		
		Persona modificada = (Persona)s.get( Persona.class, id ); 
		assertEquals( "Modificado", modificada.getNombre() );
	}

	
	@Test
	public void testPersonaCurso() {
		
		
		Persona p = (Persona)s.get( Persona.class, (long) 1 );	
		
		//crear curso
		Curso c = new Curso();
		c.setCodigo("IFCDXXXX");
		c.setNombre("Web");
		
		//salvar curso primero si no existe o se crea al vuelo
		s.save(c);
		
		
		//crear objeto tabla intermedia
		PersonaCurso pc = new PersonaCurso();
		pc.setPersona(p);
		pc.setCurso(c);
		pc.setFechaMatriculacion(new Date());
		pc.setUsuario("admin");
		
		//asociar tabla intermedia a  la persona
		p.getPersonaCurso().add(pc);
		
		//modificar persona
		s.update(p);
		
		
	}
	
	
	@Test
	public void testPersonaDireccion() {
		
		//crear direccion	
		Direccion dir = new Direccion();
		dir.setCalle("Melancolia");
		dir.setCodigoPostal("48900");
		//persistirla
		s.save(dir);
		
		//obtener persona y asociarle direccion
		Persona p = (Persona)s.get( Persona.class, (long) 1 );
		p.setDireccion(dir);
		s.update(p);			
		
	}
	
	/*
	 * Comprobar que se añada la direccion en cascada al insertar 
	 */
	@Test
	public void testPersonaDireccionCascadeInsert() {
		
		String nombreCalle= "calle inserccion casacade";
		
		Persona p =  new Persona();
		p.setNombre("persona direccion insert");
		
		Direccion d = new Direccion();
		d.setCalle( nombreCalle );
		
		p.setDireccion(d);
		
		s.persist(p);		
		
				
		//terminar la transaccion comitando y cerramos
		s.getTransaction().commit();
		s.close();
		
		long idPersona = p.getId();
		
		
		//comenzamo nueva
		s = HibernateUtil.getSession();
		s.beginTransaction();
		
		Persona pCheck = (Persona)s.get(Persona.class, idPersona);
		
		assertNotNull( pCheck.getDireccion() );
		assertEquals( nombreCalle ,  pCheck.getDireccion().getCalle() );
		
		
		
	}
	
	@Test
	public void testPersonaMaterial() {
		
		Persona p = new Persona();
		p.setNombre("Fran");		
		
		Material m1 = new Material("PC");
		Material m2 = new Material("Teclado");
		
		m1.setPersona(p);
		m2.setPersona(p);		
		
		p.getMateriales().add(m1);
		p.getMateriales().add(m2);	
		
		s.save(p);
		
		Persona p2 = new Persona();
		p2.setNombre("Maitane");
		
		Material m3 = new Material("PC");
		Material m4 = new Material("Teclado");
		
		m3.setPersona(p2);
		m4.setPersona(p2);		
		
		p2.getMateriales().add(m3);
		p2.getMateriales().add(m4);
		
		s.save(p2);
			
	}
		
	
	
}
