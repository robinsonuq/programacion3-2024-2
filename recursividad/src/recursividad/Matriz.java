package recursividad;

import java.util.Scanner;

public class Matriz {
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int dimension = obtenerDimension();
        int[][] array = crearMatriz(dimension);
        imprimirMatriz(array);
        int suma = sumarDiagonalPrincipal(array, 0);
        System.out.println("La suma de la diagonal principal es: " + suma);
        scanner.close();
    }

    public static int obtenerDimension() {
        System.out.print("Introduce la dimensión de la matriz: ");
        return scanner.nextInt();
    }

    public static int[][] crearMatriz(int dimension) {
        int[][] array = new int[dimension][dimension];

        System.out.println("Introduce los valores del array:");
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                System.out.print("Elemento [" + i + "][" + j + "]: ");
                array[i][j] = scanner.nextInt();
            }
        }

        return array;
    }

    public static void imprimirMatriz(int[][] array) {
        System.out.println("El array es:");
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int sumarDiagonalPrincipal(int[][] array, int index) {
        if (index >= array.length) {
            return 0;
        }

        return array[index][index] + sumarDiagonalPrincipal(array, index + 1);
    }
}