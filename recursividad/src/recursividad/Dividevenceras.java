package recursividad;

public class Dividevenceras {

	
	public static void main(String[] args) {
		int arreglo[] = {1,2,3};
		sumarArreglo(arreglo);
	}

	public static int sumarArreglo(int[] arreglo) {
		return sumarArreglo(arreglo,0,arreglo.length-1);
	}

	private static int sumarArreglo(int[] arreglo, int inicio, int fin) {
		
		// caso base
		if(inicio == fin) {
			return arreglo[inicio];
		}
		int mitad = (inicio+fin)/2;
		
		int izq = sumarArreglo(arreglo, inicio, mitad);
		int derecha = sumarArreglo(arreglo, mitad+1, fin);
		
		return izq + derecha;
	}

	
}
