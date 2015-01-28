package ipartek.formacion.ejemplos.hibernate;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



@Entity
@Table(name = "Persona")
public class Persona {
	
	@Id
    @GeneratedValue
    Long id;
    
	/* Persistente, un tipo basico (string) */
    @Basic
    @Column(name = "nombre")
    private String nombre;
    
	@Basic
	@Column(name = "apellido")
	private String apellido;

	@Basic
	@Column(name = "edad")
	private int edad;

    /*
     * Las fechas son m�s complejas, 
     * ya que no hay forma de saber a priori si un Date de java es un TIME, DATE o TIMESTAMP de base de datos 
     * (s�lo hora, s�lo fecha o fecha y hora). 
     * Por ello, debemos poner la annotation @Temporal, 
     * indicando detr�s qu� tipo de campo deseamos en base de datos. 
     *  
     * */
    
    @Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_nacimiento")
    private Date fechaNacimiento;

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "Persona_curso", joinColumns = { @JoinColumn(name = "personaId") }, inverseJoinColumns = { @JoinColumn(name = "cursoId") })
	private Set<Curso> cursos = new HashSet<Curso>(0);

    
    public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public Long getId() {
        return id;
    }

    private void setId(Long id) {
        this.id = id;
    }

    
    public String getNombre() {    	
        return nombre;
    }

    public void setNombre( String nombre ) {    	
        this.nombre = nombre;
    }

    
    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fecha) {
        this.fechaNacimiento = fecha;
    }
    
	public Set<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(Set<Curso> cursos) {
		this.cursos = cursos;
	}

}
