package com.ipartek.formacion.primero.util;

import java.util.ArrayList;

public class Utilidades {
	
	/**
	 * Muestra todas las posiciones del Array por pantalla
	 * usando un separador de " , " y comienfo y final con "[" y "]"
	 * ej: [0,1,2]
	 * @author Curso
	 */
	public static void pintarArray(int[] myArray){
		System.out.print("[");
		for (int i= 0; i<myArray.length; i++){
			// pintar valor de la posicion del array
			System.out.print(myArray[i]);
			// Si no es el ultimo, pintar separador
			if (i != (myArray.length-1)){
				System.out.print(" , ");
			}
		}
		System.out.println("]");
	}
	
	/**
	 * Invierte los valores de un array
	 * Ej: [0,1,2,3,4] salida: [4,3,2,1,0]
	 * @param myArray
	 * @author Curso
	 */
	public static void invertirMiArray(int[] myArray){
		//Variable auxiliar para los valores
		int aux;
		//Variable que contiene la posicion mas alta del Array a tratar
		int jArray=myArray.length-1;
		
		//Recorrer el array mientras su indice sea menor a la posicion mas alta del Array a tratar
		for (int i=0; i<jArray; i++){
			// Intercambiar los valores
			aux=myArray[i];
			myArray[i]=myArray[jArray];
			myArray[jArray]=aux;
			// Disminuimos en 1 la posicion del Array a tratar
			jArray--;
		}
	}
	
	/**
	 * Invierte los valores de un array
	 * Ej: [0,1,2,3,4] salida: [4,3,2,1,0]
	 * @param myArray
	 * @return int[] array pasado por parametro invertido
	 */
	public static int[] invertirArray(int[] myArray){
		//declarar tamaño array
		int tamanio = myArray.length;
		 
		//crear nuevo array para retornar
		int[] resul = new int[tamanio];
		
		//recorrer array para parametro y rellenar el de retorno
		for (int i = 0; i<tamanio; i++){
			resul[tamanio-1-i] = myArray[i];
		}
		//retornar array invertido
		return resul;
	}
	
	/**
	 * Ordena los valores de un array de menor a mayor
	 * Ej: [89,54,3,1,45] salida: [2,3,45,54,89]
	 * @param myArray
	 * @author Curso
	 */
	public static void ordenarMiArray(int[] myArray){
		//Variable que indica si el array esta ordenado o no
		//Consideramos que inicialmente el array no esta ordenado
		boolean bOrdenado=false;
		int aux;
		//Indice maximo del Array a recorrer
		int iTope = myArray.length-1;
		
		while (!bOrdenado){
			//Inicializamos para indicar que esta ordenado el Array
			bOrdenado=true;
			for (int i=0; i<iTope; i++){
				// Comprobamos que el segundo elemento sea mayor que el primero
				if (myArray[i]>myArray[i+1]){
					//Indicamos que hay un elemento Desordenado
					bOrdenado=false;
					aux=myArray[i];
					myArray[i]=myArray[i+1];
					myArray[i+1]=aux;
				}
			}
			//Una vez acabado de recorrer el Array comprobamos si esta ordenado o no
			if (!bOrdenado){
				//Disminuimos el indice maximo del Array
				iTope--;
			}
		}
	}


	/**
	 * Devuelve un Array ordenado a partir de un Array desordenado
	 * @param myArray - array desordenado
	 * @return int[] array ordenado
	 */
	public static int[] ordenarArray(int[] myArray){
		int[] resul= new int[myArray.length];
		resul=myArray;
		ordenarMiArray(resul);
		return resul;
	}
	
	
	/**
	 * Indica si un caracter es vocal o no
	 * @param caracter {@code char} caracter a comprobar
	 * @return true en caso de que sea vocal, false eoc
	 */
	public static boolean esVocal(char caracter){
		boolean bEsVocal;
		char aux=(char)Character.toLowerCase(caracter);
		switch (aux) {
		case 'a':
		case 'e':
		case 'i':
		case 'o':
		case 'u':
		// Caracteres con acento
		case 'á':
		case 'é':
		case 'í':
		case 'ó':
		case 'ú':
		// Caracteres con dieresis	
		case 'ü':
			bEsVocal = true;
			break;

		default:
			bEsVocal = false;
			break;
		}
		return bEsVocal;
	}
	
	/**
	 * Busca la ultima aparicion del elemento en el ArrayList y lo elimina si existe
	 * @param listaPaises {@code String} ArrayList de los elementos
	 * @param elemento {@code String} elemento a eliminar
	 */
	public static void eliminarUltimoElemento(ArrayList<String> listaPaises, String elemento){
		// Comprueba que la lista no este vacia
		if (!listaPaises.isEmpty()){
			// Busca la ultima posicion en la que se encuentra el elemento
			int iPosicion = listaPaises.lastIndexOf(elemento);
			// Si existe ese elemento lo elimina
			if (iPosicion>0){
					listaPaises.remove(iPosicion);
			}
		}
	}
}
