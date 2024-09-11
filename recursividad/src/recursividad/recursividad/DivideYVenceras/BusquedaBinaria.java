package recursividad.DivideYVenceras;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class BusquedaBinaria {

    public static void main(String[] args) {
        // Utilizar try-with-resources para asegurar el cierre del scanner
        try (Scanner scanner = new Scanner(System.in)) {
            List<Integer> lista = new ArrayList<>();
            String input;

            System.out.println("Ingrese los números (ingrese 'fin' para terminar):");

            while (true) {
                input = scanner.nextLine();
                if (input.equalsIgnoreCase("fin")) {
                    break;
                }
                try {
                    int numero = Integer.parseInt(input);
                    lista.add(numero);
                } catch (NumberFormatException e) {
                    System.out.println("Entrada inválida. Por favor, ingrese un número entero o 'fin' para terminar.");
                }
            }

            if (lista.isEmpty()) {
                System.out.println("No se ingresaron números.");
                return;
            }

            Collections.sort(lista);

            System.out.print("Ingrese el número que desea buscar: ");
            int elementoABuscar = scanner.nextInt();

            int resultado = busquedaBinariaRecursiva(lista, elementoABuscar, 0, lista.size() - 1);

            if (resultado != -1) {
                System.out.println("Elemento encontrado en la posición: " + resultado);
            } else {
                System.out.println("Elemento no encontrado.");
            }
        }
    }

    public static int busquedaBinariaRecursiva(List<Integer> lista, int elemento, int inicio, int fin) {
        if (inicio > fin) {
            return -1;
        }

        int medio = inicio + (fin - inicio) / 2;

        if (lista.get(medio) == elemento) {
            return medio;
        } else if (lista.get(medio) > elemento) {
            return busquedaBinariaRecursiva(lista, elemento, inicio, medio - 1);
        } else {
            return busquedaBinariaRecursiva(lista, elemento, medio + 1, fin);
        }
    }
}
