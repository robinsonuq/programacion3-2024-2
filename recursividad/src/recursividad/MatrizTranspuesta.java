
public class MatrizTranspuesta {

    public static void main(String[] args) {
        int[][] matriz = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        int[][] transpuesta = transponerMatriz(matriz, new int[matriz[0].length][matriz.length], 0, 0);

        // Imprimir la matriz transpuesta
        imprimirMatriz(transpuesta, 0, 0);
    }

    public static int[][] transponerMatriz(int[][] matriz, int[][] transpuesta, int fila, int columna) {
        // Caso base: si hemos recorrido todas las filas y columnas de la matriz original
        if (fila == matriz.length) {
            return transpuesta;
        }

        // Si hemos recorrido todas las columnas de la fila actual, pasamos a la siguiente fila
        if (columna == matriz[0].length) {
            return transponerMatriz(matriz, transpuesta, fila + 1, 0);
        }

        // Intercambiar fila por columna
        transpuesta[columna][fila] = matriz[fila][columna];

        // Continuar con la siguiente columna de la fila actual
        return transponerMatriz(matriz, transpuesta, fila, columna + 1);
    }

    public static void imprimirMatriz(int[][] matriz, int fila, int columna) {
        // Caso base: si hemos recorrido todas las filas
        if (fila == matriz.length) {
            return;
        }

        // Si hemos recorrido todas las columnas de la fila actual, pasamos a la siguiente fila
        if (columna == matriz[0].length) {
            System.out.println();
            imprimirMatriz(matriz, fila + 1, 0);
        } else {
            // Imprimir el valor actual y pasar a la siguiente columna
            System.out.print(matriz[fila][columna] + " ");
            imprimirMatriz(matriz, fila, columna + 1);
        }
    }
}
