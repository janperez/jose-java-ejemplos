package ipartek.formacion.ejemplos.hibernate;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class Material implements Serializable {
	@Id
	@GeneratedValue
	Long id;

	@Basic
	@Column(name = "nombre")
	private String nombre;

	public Long getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
