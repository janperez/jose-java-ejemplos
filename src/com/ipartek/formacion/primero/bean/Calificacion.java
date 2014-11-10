package com.ipartek.formacion.primero.bean;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Calendar;

/**
 * Clase que contiene la informacion referente a la calificación de un asignatura
 * Una calificacion se compone de:
 * <ul>
 * 	<li>asignatura: {@code String} asignatura de la calificacion</li>
 * 	<li>nota: {@code float} nota de la calificacion (Su valor estara comprendido entre 0.0 y 10.0}</li>
 *  <li>fecha: {@code Date} fecha en la que se realizo la calificacion 
 * </ul>
 * @author Jose A. Perez
 *
 */
public class Calificacion {
	private String asignatura;
	private float nota;
	private Timestamp fecha;
	
	public static final float NOTA_MAXIMA = 10.0f;
	public static final float NOTA_MINIMA = 0.0f;
	public static final String ASIGNATURA_POR_DEFECTO = "Sin expecificar";
	

	
	//Constructores
	public Calificacion() {
		this.asignatura = ASIGNATURA_POR_DEFECTO;
		this.nota = NOTA_MINIMA;
		this.fecha = new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());		
	}	
	
	
	public Calificacion(String asignatura, float nota) {
		this.setAsignatura(asignatura);
		this.setNota(nota);
		this.setFecha(fecha);
		
		if (NOTA_MINIMA <= nota && nota<= NOTA_MAXIMA){
			this.nota = nota;
		}
		this.fecha = new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());
	}

	

	public Calificacion(String asignatura, float nota, Timestamp fecha) {
		new Calificacion(asignatura, nota);
		this.fecha=fecha;
	}

	
	// Getters y Setters
	public String getAsignatura() {
		return asignatura;
	}

	public void setAsignatura(String asignatura) {
		// Comprobamos que el objeto no sea NULL
		if (asignatura == null){
			this.asignatura = ASIGNATURA_POR_DEFECTO;
		}else{
			// Comprobamos que el objeto no sea vacio
			if (asignatura.isEmpty()){
				this.asignatura = ASIGNATURA_POR_DEFECTO;
			}else{
				this.asignatura = asignatura;
			}
		}
	}

	public float getNota() {
		return nota;
	}

	public void setNota(float nota) {
		if (NOTA_MINIMA <= nota && nota<= NOTA_MAXIMA){
			this.nota = nota;
		}else{
			this.nota = NOTA_MINIMA;
		}
	}

	public Timestamp getFecha() {
		return fecha;
	}

	public void setFecha(Timestamp fecha) {
		// Comprobamos que la fecha no sea NULL
		if (fecha == null){
			this.fecha = new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());
		}else{
			this.fecha = fecha;
		}
		
	}

	// Otros metodos
	@Override
	public String toString() {
		return "Calificacion [asignatura=" + asignatura + ", nota=" + nota
				+ ", fecha=" + this.textoFecha() + "]";
	}
	
	public String textoFecha(){
		String txtFecha="";
		Date dFecha = new Date(this.fecha.getTime());
		txtFecha = dFecha.toString();
		return txtFecha;
	}
}
