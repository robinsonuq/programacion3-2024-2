package backtracking;

import java.util.Scanner;

public class SopaDeLetras {

    public static void main(String[] args) {
        char[][] sopaDeLetras = {
            {'E', 'X', 'A', 'M', 'P', 'L', 'E', 'T', 'T', 'R'},
            {'T', 'A', 'X', 'Y', 'W', 'O', 'R', 'D', 'I', 'Z'},
            {'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K'},
            {'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U'},
            {'U', 'V', 'W', 'X', 'Y', 'Z', 'A', 'B', 'C', 'D'},
            {'E', 'F', 'G', 'H', 'I', 'A', 'K', 'L', 'M', 'N'},
            {'O', 'P', 'Q', 'R', 'S', 'T', 'N', 'V', 'W', 'X'},
            {'Y', 'Z', 'A', 'B', 'C', 'D', 'E', 'A', 'G', 'H'},
            {'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R'},
            {'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'A', 'B'}
        };

        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese la palabra a buscar: ");
        String palabra = scanner.nextLine();
        scanner.close();

        if (buscarPalabra(sopaDeLetras, palabra)) {
            System.out.println("¡Palabra encontrada en diagonal!");
        } else {
            System.out.println("Palabra no encontrada.");
        }
    }

    public static boolean buscarPalabra(char[][] sopa, String palabra) {
        int filas = sopa.length;
        int columnas = sopa[0].length;
        int lenPalabra = palabra.length();

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (sopa[i][j] == palabra.charAt(0)) {
                    if (buscarDiagonal(sopa, palabra, i, j, lenPalabra)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static boolean buscarDiagonal(char[][] sopa, String palabra, int i, int j, int lenPalabra) {
        int[][] direcciones = {
            {-1, -1},
            {-1, 1},
            {1, -1},
            {1, 1}
        };

        for (int[] dir : direcciones) {
            int x = i, y = j;
            boolean encontrada = true;

            for (int k = 0; k < lenPalabra; k++) {
                if (x < 0 || y < 0 || x >= sopa.length || y >= sopa[0].length || sopa[x][y] != palabra.charAt(k)) {
                    encontrada = false;
                    break;
                }
                x += dir[0];
                y += dir[1];
            }

            if (encontrada) {
                return true;
            }
        }
        return false;
    }
}
