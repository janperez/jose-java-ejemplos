package ipartek.formacion.ejemplos.hibernate;

import static org.junit.Assert.assertTrue;

import org.hibernate.Session;
import org.junit.Test;

public class HibernateUtilTest {


	@Test
	public void test() {
		Session sesion = HibernateUtil.getSession();
		sesion.close();
		assertTrue("No se ha podido obtener sesion de Hibernate", true);
	}

}
