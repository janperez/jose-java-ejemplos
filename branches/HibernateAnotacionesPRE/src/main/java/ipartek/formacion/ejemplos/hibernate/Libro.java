package ipartek.formacion.ejemplos.hibernate;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Libro implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String titulo;

	public Libro(String titulo) {
		super();
		this.titulo = titulo;
	}

	public long getId() {
		return id;
	}

	// Recomendables quitar el 'setId' porque ya lo gestiona Hibernate
	/*
	public void setId(long id) {
		this.id = id;
	}
	*/

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

}
