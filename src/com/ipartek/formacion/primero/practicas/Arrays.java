package com.ipartek.formacion.primero.practicas;

import com.ipartek.formacion.primero.util.Utilidades;

public class Arrays {

	/**
	 * Clase para probar los Arrays en Java
	 * @author Jose A. Perez
	 */
	public static void main(String[] args) {
		// declarar un array de enteros con 10 posiciones
		int[] myArray = new int[10];
		Utilidades.pintarArray(myArray);
		
		// cambiar valor de la posicion 4 a 25
		myArray[3]=25;
		
		Utilidades.pintarArray(myArray);
		
		//inicializar array de 3 posiciones de enteros 
		// y en cada posicion debe tener el valor de la posicion
		int[] myArray2 = new int[]{0,1,2};
		Utilidades.pintarArray(myArray2);
		
		//Ejercicio1: Dado el siguiente array invertir los valores
		//Ej: [0,1,2,3,4] salida: [4,3,2,1,0]
		int[] myArray3 = new int[]{0,1,2,3,4};
		System.out.println("Array Original:");
		Utilidades.pintarArray(myArray3);
		System.out.println("Arrays Invertido:");
		int[] arrayInvertido = Utilidades.invertirArray(myArray3);
		Utilidades.pintarArray(arrayInvertido);
		Utilidades.invertirMiArray(myArray3);
		Utilidades.pintarArray(myArray3);
		
		//Ejercicio2: Dado un array ordenar sus valores de menor a mayor
		//Ej: [89,54,3,1,45] salida: [2,3,45,54,89]
		int[] myArray4 = new int[]{89,54,3,1,45,0};
		System.out.println("Array Original:");
		Utilidades.pintarArray(myArray4);
		Utilidades.ordenarMiArray(myArray4);
		System.out.println("Array Ordenado:");
		Utilidades.pintarArray(myArray4);
	}

}
