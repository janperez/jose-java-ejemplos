package com.ipartek.formacion.primero.bean;

/**
 * Clase para representar un <code>Libro</code>
 * <ul>
 * 	<li>{@code int} <b>paginas</b> Numero de paginas</li>
 * 	<li>{@code String} <b>titulo</b> Titulo</li>
 * </ul>
 * @author Jose A. Perez
 * @since v1.0
 */
public class Libro {
	// ATRIBUTOs
	/**
	 * {@code int} Numero de paginas del {@code Libro} 
	 */
	int paginas;
	public static final int PAGINAS_POR_DEFECTO = 0;
	/**
	 * {@code String} Titulo del {@code Libro}
	 */
	 String titulo;
	public static final String TITULO_POR_DEFECTO = "Sin definir";
	
	// CONSTRUCTORes
	// Source >> Generator Consultor using Fields
	
	// Constructor sin parametros
	/**
	 * Constructor vacio para {@code Libro}
	 * Parametros iniciales de los atributos
	 * <ul>
	 * 	<li>paginas = 0</li>
	 * 	<li>titulo = "Sin definir"</li>
	 * </ul> 
	 */
	public Libro() {
		super();
		this.paginas = PAGINAS_POR_DEFECTO;
		this.titulo = TITULO_POR_DEFECTO;
	}

	// Constructor con parametros
	public Libro(int paginas, String titulo) {
		super();
		this.setPaginas(paginas);
		this.setTitulo(titulo);
	}


	// GETTERs y SETTERs
	public int getPaginas() {
		return paginas;
	}

	public void setPaginas(int paginas) {
		if (paginas<PAGINAS_POR_DEFECTO){
			this.paginas = PAGINAS_POR_DEFECTO;
		}else{
			this.paginas = paginas;
		}
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		// equalsIgnoreCase => ignora si es mayuscula o minuscula
		if ("".equalsIgnoreCase(titulo)){
			this.titulo = TITULO_POR_DEFECTO;
		}else{
			this.titulo = titulo;
		}
	}


	// METODOs

	// Source >> Generate toString
	// Sobreescribe la funcion de 'toString' para este objeto
	@Override
	public String toString() {
		return "Libro [paginas=" + paginas + ", titulo=" + titulo + "]";
	}
	
	
}
