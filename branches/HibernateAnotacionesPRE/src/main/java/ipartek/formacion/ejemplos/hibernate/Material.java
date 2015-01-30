package ipartek.formacion.ejemplos.hibernate;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Material implements Serializable {

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	private String nombre;

	@ManyToOne
	@JoinColumn ( name="persona_id")
	private Persona persona;
	
	
	public Material(String nombre) {
		super();
		this.nombre = nombre;
	}

	public long getId() {
		return id;
	}

	protected void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}
	
	
	
	
}
