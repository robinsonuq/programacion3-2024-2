package recursividad;

import java.util.Iterator;

public class Ejemplos {

	public static void main(String[] args) {
		
		int arreglo[] = {1,2,3};
		imprimirArreglo(arreglo,0);
	}

	private static void imprimirArreglo(int[] arreglo, int i) {
		if(i == arreglo.length -1) {// caso base explicito
			System.out.println(arreglo[i]);
		}else {
			System.out.println(arreglo[i]);
			imprimirArreglo(arreglo, i+1);
			
		}		
	}

	private static void imprimirArreglo2(int[] arreglo, int i) {

		if(i < arreglo.length) {
			System.out.println(arreglo[i]);
			imprimirArreglo2(arreglo, i+1);
		}//caso base implicito
		
	}
	
}
