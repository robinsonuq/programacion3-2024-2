package parcial1;

import java.util.ArrayList;

public class Matriz {

	public static void main(String[] args) {
        // Definici�n de la matriz de n�meros en formato de cadenas
        String[][] matriz = {
            {"454", "1010", "4141", "4444", "234"},
            {"100", "2163", "5456", "222", "444"},
            {"1001", "0", "99", "111", "5654"},
            {"13", "89", "6", "112", "555"}
        };

        // Lista para almacenar los n�meros cuya suma de d�gitos es mayor a 10
        ArrayList<String> listaNumeros = new ArrayList<>();

        // Llamar al m�todo para recorrer la matriz y verificar la suma de los d�gitos
        recorrerMatriz(matriz,listaNumeros);

        // Imprimir los n�meros cuya suma de d�gitos es mayor a 10
        System.out.println("N�meros cuya suma de d�gitos es mayor a 10: " + listaNumeros);
    }

	private static void recorrerMatriz(String[][] matriz, ArrayList<String> listaNumeros) {
		recorrerMatriz(matriz,0, 0,listaNumeros); 
		
	}
	
	
	public static void recorrerMatriz(String[][] matriz, int i, int j, ArrayList<String> listaNumeros) {
        // Caso base: si llegamos al final de la matriz
        if (i < 0) {
            return;
        }

        // Verificar la suma de los d�gitos del n�mero actual
        String numeroActual = matriz[i][j];
        int sumaDigitos = obtenerSuma(numeroActual, 0);

        // Si la suma de los d�gitos es mayor a 10, agregar el n�mero a la lista
        if (sumaDigitos > 10) {
            listaNumeros.add(numeroActual);
        }

        // Avanzar a la siguiente columna o fila
        if (j < matriz[i].length - 1) {
            recorrerMatriz(matriz, i, j + 1, listaNumeros); // Avanza en las columnas
        } else {
            recorrerMatriz(matriz, i - 1, 0, listaNumeros); // Avanza a la siguiente fila
        }
    }
	
	// M�todo recursivo para sumar los d�gitos de un n�mero
    public static int obtenerSuma(String numero, int indice) {
        // Caso base: si llegamos al final del n�mero
        if (indice >= numero.length()) {
            return 0;
        }

        // Sumar el d�gito actual (convertido de char a entero) y continuar recursivamente
        return (int)(numero.charAt(indice)) + obtenerSuma(numero, indice + 1);
    }
}
