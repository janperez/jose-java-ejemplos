package com.ipartek.formacion.primero.bean;

import java.util.ArrayList;

/**
 * Clase para representar un Alumno
 * Se compone de:
 * <ul>
 * 	<li>nombre {@code String} obligatorio</li>
 * 	<li>apellido1 {@code String}</li>
 * 	<li>apellido2 {@code String}</li>
 * 	<li>edad {@code int}</li>
 * 	<li>dni {@code String}</li>
 * 	<li>poblacion {@code String}</li>
 * 	<li>mayorEdad {@code boolean}</li>
 * 	<li>telefono {@code String}</li>
 * 	<li>sexo {@code char}</li>
 * </ul>
 * @author Curso
 *
 */
public class Alumno {
	public static final char SEXO_VARON = 'v';
	public static final char SEXO_MUJER = 'm';
	public static final char SEXO_OTROS = 'o';
	
	public static final int MAYOR_EDAD = 18;
	
	public static final String NOMBRE_POR_DEFECTO ="Jhon";
	public static final String APELLIDO_POR_DEFECTO = "Doe";
	public static final int EDAD_POR_DEFECTO = 0;
	public static final String DNI_POR_DEFECTO = "xxxxxxxxx";
	
			
	// Atributos
	String nombre;
	String apellido1;
	String apellido2;
	int edad;
	String dni;
	String poblacion;
	boolean mayorEdad;
	String telefono;
	char sexo;
	
	ArrayList<Libro> libros;
	ArrayList<Calificacion> calificaciones;
	
	// TODO añadir un ArrayList de Libros
	// TODO añadir un ArrayList de Calificaciones
	
	// Constructor
	public Alumno() {
		super();
		this.setNombre(null);
		this.setApellido1(null);
		this.setDni(null);
		this.setSexo(SEXO_OTROS);
	}
	
	public Alumno(String nombre, String apellido1, String dni) {
		super();
		this.setNombre(null);
		this.setApellido1(null);
		this.setDni(null);
		this.setSexo(SEXO_OTROS);
	}

	
	public Alumno(String nombre, String apellido1, int edad, String dni) {
		super();
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.edad = edad;
		this.dni = dni;
		this.mayorEdad = (this.edad>=MAYOR_EDAD)? true: false; 
	}

	// Getters y Setters

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		if (this.nombre == null){
			this.nombre = NOMBRE_POR_DEFECTO;
		}else{
			if (this.nombre.isEmpty()){
				this.nombre = NOMBRE_POR_DEFECTO;
			}else{
				this.nombre = nombre;
			}
		}
		
	}

	public String getApellido1() {
		return apellido1;
	}

	public void setApellido1(String apellido1) {
		if (this.apellido1 == null){
			this.apellido1 = APELLIDO_POR_DEFECTO;
		}else{
			if (this.apellido1.isEmpty()){
				this.apellido1 = APELLIDO_POR_DEFECTO;
			}else{
				this.apellido1 = apellido1;				
			}
		}
	}

	public String getApellido2() {
		return apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
		this.mayorEdad = (this.edad>=18)? true: false;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		if (dni == null){
			this.dni = DNI_POR_DEFECTO;
		}else{
			if (dni.isEmpty()){
				this.dni = DNI_POR_DEFECTO;
			}else{
				this.dni = dni;		
			}
		}
	}

	public String getPoblacion() {
		return poblacion;
	}

	public void setPoblacion(String poblacion) {
		this.poblacion = poblacion;
	}

	public boolean isMayorEdad() {
		return mayorEdad;
	}


	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public ArrayList<Libro> getLibros() {
		return libros;
	}

	public void setLibros(ArrayList<Libro> libros) {
		this.libros = libros;
	}

	public ArrayList<Calificacion> getCalificaciones() {
		return calificaciones;
	}

	public void setCalificaciones(ArrayList<Calificacion> calificaciones) {
		this.calificaciones = calificaciones;
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		char auxSexo = Character.toLowerCase(sexo);
		switch (auxSexo) {
		case SEXO_MUJER:
		case SEXO_OTROS:
		case SEXO_VARON:
			this.sexo = auxSexo;
			break;
		default:
			this.sexo = SEXO_OTROS;
			break;
		}
	}


	// Metodos
	@Override
	public String toString() {
		return "Alumno [nombre=" + nombre + ", apellido1=" + apellido1
				+ ", apellido2=" + apellido2 + ", edad=" + edad + ", dni="
				+ dni + ", poblacion=" + poblacion + ", mayorEdad=" + mayorEdad
				+ ", telefono=" + telefono + ", sexo=" + sexo + "]";
	}
	
	
	
	

}
