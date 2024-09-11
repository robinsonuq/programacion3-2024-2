

//Esteban Gómez León

import java.util.Scanner;

public class MatriuskaRecursiva {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduzca el grado de la Matriuska: ");
        int GradoMatriuska = scanner.nextInt();
        System.out.println("Abriendo Matriuska " + GradoMatriuska);
        esperar(1000);
        imprimirDescendente(GradoMatriuska);
        System.out.println("Cerrando Matriuska");
        esperar(1000);
        imprimirAscendente(1, GradoMatriuska);
        System.out.println("Matriuska Cerrada");
        esperar(1000);
        scanner.close();
    }

    public static void imprimirDescendente(int n) {
        if (n < 1) return;
        System.out.println("Matriuska " + n);
        esperar(1000);
        imprimirDescendente(n - 1);
    }

    public static void imprimirAscendente(int start, int end) {
        if (start > end) return;
        System.out.println("Matriuska " + start);
        esperar(1000);
        imprimirAscendente(start + 1, end);
    }

    public static void esperar(int milisegundos){
        try {
            Thread.sleep(milisegundos);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Error: " + e.getMessage());
        }
    }
}