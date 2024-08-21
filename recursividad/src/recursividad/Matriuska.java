package recursividad;

import java.util.Iterator;

public class Matriuska {

	public static void main(String[] args) {
		imprimirMatriuska2(3);
	}
	
	private static void imprimirMatriuska2(int numeroMatriuskas) {
		System.out.println("abriendo matriuska "+numeroMatriuskas);
		if(numeroMatriuskas == 1) {// caso base
			System.out.println("termino");
		}else {
			imprimirMatriuska2(numeroMatriuskas-1);// caso recursivo
		}
		
		System.out.println("cerrando matriuska "+numeroMatriuskas);
	}
	
	
}
