package parcial1;



public class DiagonalRepetida {

    public static void main(String[] args) {
        String[] matriz =      {"AXCDEDH",
        		                "BADEDGG",
        		                "BAAEDGG",
                                "BVAADGG"};
        // Llamar al m�todo recursivo
        boolean resultado = hay4LetrasRepetidasEnDiagonal2(matriz, 0, 0);
        System.out.println("�Hay 4 letras repetidas consecutivas en la diagonal? " + resultado);
    }

    public static boolean hay4LetrasRepetidasEnDiagonal(String[] matriz, int indice, char letraActual, int contador) {
        // Caso base: si se llega al final de la diagonal y el contador alcanza 4
        if (indice == matriz.length) {
            return contador >= 4;
        }

        // Verifica si la letra en la posici�n diagonal es la misma que la anterior
        if (matriz[indice].charAt(indice) == letraActual) {
            contador++;
        } else {
            // Si la letra es diferente, reiniciar el contador
            letraActual = matriz[indice].charAt(indice);
            contador = 1;
        }

        // Llamada recursiva
        return hay4LetrasRepetidasEnDiagonal(matriz, indice + 1, letraActual, contador);
    }
    
    public static boolean hay4LetrasRepetidasEnDiagonal2(String[] matriz, int indice, int contador) {
        // Caso base: si hemos llegado al pen�ltimo �ndice, ya no se puede seguir comparando
        if (indice >= matriz.length - 1) {
            return contador >= 4;
        }

        // Verifica si la letra en la posici�n diagonal es la misma que la siguiente
        if (matriz[indice].charAt(indice) == matriz[indice + 1].charAt(indice + 1)) {
            contador++;
        } else {
            // Si la letra es diferente, reiniciar el contador
            contador = 1;
        }

        // Llamada recursiva con el siguiente �ndice
        return hay4LetrasRepetidasEnDiagonal2(matriz, indice + 1, contador);
    }
}
