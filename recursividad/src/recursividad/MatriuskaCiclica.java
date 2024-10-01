

//Esteban Gómez León

import java.util.Scanner;

public class MatriuskaCiclica {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduzca el grado de la Matriuska: ");
        int numero = scanner.nextInt();
        int i = numero;
        while (i >= 1) {
            System.out.println("Matriuska " + i);
            i--;
        }
        i = 2;
        while (i <= numero) {
            System.out.println("Matriuska " + i);
            i++;
        }
        scanner.close();
    }
  
}