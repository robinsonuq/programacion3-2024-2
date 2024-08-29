package recursividad;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Collections;

public class ImprimirLista {
    public static void main(String[] args) {
        List<Integer> lista = obtenerNumerosDelUsuario();
        Collections.sort(lista);
        
        System.out.println("Imprimiendo lista de menor a mayor:");
        imprimirMenorAMayor(lista, 0);
        
        System.out.println("Imprimiendo lista de mayor a menor:");
        imprimirMayorAMenor(lista, lista.size() - 1);
    }

    public static List<Integer> obtenerNumerosDelUsuario() {
        Scanner scanner = new Scanner(System.in);
        List<Integer> lista = new ArrayList<>();
        System.out.println("Introduce números enteros. Escribe 'fin' para terminar:");

        while (true) {
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("fin")) {
                break;
            }
            try {
                int numero = Integer.parseInt(input);
                lista.add(numero);
            } catch (NumberFormatException e) {
                System.out.println("Por favor, introduce un número válido o 'fin' para terminar.");
            }
        }
        scanner.close();
        return lista;
    }

    public static void imprimirMenorAMayor(List<Integer> lista, int index) {
        if (index >= lista.size()) return;
        System.out.println(lista.get(index));
        imprimirMenorAMayor(lista, index + 1);
    }

    public static void imprimirMayorAMenor(List<Integer> lista, int index) {
        if (index < 0) return;
        System.out.println(lista.get(index));
        imprimirMayorAMenor(lista, index - 1);
    }
}