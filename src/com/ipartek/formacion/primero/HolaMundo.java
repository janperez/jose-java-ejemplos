package com.ipartek.formacion.primero;

import com.ipartek.formacion.primero.bean.Alumno;
import com.ipartek.formacion.primero.bean.Libro;

/* package
 * 	- Tipo de Compañia: com / org
 * 	- Nombre de Compañia
 * 	- Departamento
 * 	- Nombre del paquete
 */
public class HolaMundo {

	public static void main(String[] args) {
		System.out.println("Hola Mundo");
		
		/*
		//1- Saludo con la variable		
		String cadena="Hola Mundo";
		String nombre="Pepe";		
		int repeticion = 10;
		
		String texto=cadena+" "+nombre;
		
		for(int i=0; i<repeticion; i++){
			System.out.println(i+" "+texto);
		}
		*/
		
		// instanciar un objeto de tipo Libro
		Libro lib = new Libro();
		System.out.println(lib);
		
		Libro lib2 = new Libro(10, "Java7");
		System.out.println(lib2);
		
		lib.setTitulo("Quijote");
		System.out.println(lib.getTitulo());
		
		// instanciar un objeto de tipo Persona
		Alumno al = new Alumno();
		System.out.println(al);
		
		Alumno al2 = new Alumno("Luis", "Pedro", "12345678z");
		System.out.println(al2);
		
		Alumno al3 = new Alumno("Andres", "Pedro", 12, "45678912z");
		System.out.println(al3);

		Alumno al4 = new Alumno("Jose", "Zubizarreta", 25, "78912345z");
		System.out.println(al4);

		// Añadimos valores a los atributos del primer alumno
		al.setNombre("Andres");
		al.setApellido1("Ayala");
		al.setApellido2("Rodriguez");
		al.setDni("23456789x");
		al.setEdad(25);
		al.setPoblacion("Bilbao");
		
		// Correguido problemas con los datos de sexo y telefono
		al.setSexo(Alumno.SEXO_VARON);
		al.setTelefono("94123456");
		
		System.out.println(al);
	
		
		
	}

	
}
