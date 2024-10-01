
public class Carcel {
    private static final int FILAS = 7;
    private static final int COLUMNAS = 8;
    private static final int TOTAL_PRESOS = 26;
    private static int cantidadPresos = 0;
    
    public static void main(String[] args) {
        char[][] carcel = {
            {'P', 'X', 'X', 'P', 'P', ' ', 'P', ' '},
            {'P', 'P', ' ', 'P', 'P', ' ', 'P', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {'P', ' ', 'P', 'P', ' ', ' ', 'P', ' '},
            {'P', ' ', 'X', 'P', ' ', 'P', 'P', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', 'G'},
            {'P', 'X', 'P', ' ', 'P', 'P', ' ', 'P'}
        };
        
        if (buscarPresos(carcel, 0, 0)) {
            System.out.println("Todos los presos están en la cárcel.");
        } else {
            int presosFaltantes = TOTAL_PRESOS - cantidadPresos;
            if (presosFaltantes > 0) {
                System.out.println("Faltan " + presosFaltantes + " presos.");
            } else {
                System.out.println("No se ha escapado ningún preso.");
            }
        }
    }

    private static boolean buscarPresos(char[][] carcel, int fila, int columna) {
        // Verificamos si la posición es válida
        if (fila < 0 || fila >= FILAS || columna < 0 || columna >= COLUMNAS || carcel[fila][columna] == 'X' || carcel[fila][columna] == '*') {
            return false;
        }
        
        // Si encontramos un preso, lo contamos
        if (carcel[fila][columna] == 'P') {
            cantidadPresos++;
        }
        
        // Marcamos la posición como visitada
        carcel[fila][columna] = '*';

        // Si llegamos a la posición de control (5,7), terminamos
        if (fila == 5 && columna == 7) {
            return true;
        }

        // Movimiento en las 4 direcciones: derecha, abajo, arriba, izquierda
        boolean encontrado = buscarPresos(carcel, fila, columna + 1) || // Derecha
                             buscarPresos(carcel, fila + 1, columna) || // Abajo
                             buscarPresos(carcel, fila - 1, columna) || // Arriba
                             buscarPresos(carcel, fila, columna - 1);   // Izquierda

        return encontrado;
    }
}
