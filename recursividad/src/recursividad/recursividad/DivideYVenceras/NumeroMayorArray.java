package recursividad.DivideYVenceras;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NumeroMayorArray {
    public static void main(String[] args) {
        System.out.println("Divide y Venceras; Encontrar el número mayor de un array.");
        List<Integer> numeros = new ArrayList<>();
        System.out.println("Ingrese los números que desee que estén en el array");
        System.out.println("Para parar, ingrese un número negativo.");
        
        agregarNumeros(numeros);
        
        List<Integer> numerosSub1 = new ArrayList<>(numeros.subList(0, numeros.size() / 2));
        List<Integer> numerosSub2 = new ArrayList<>(numeros.subList(numeros.size() / 2, numeros.size()));
        
        int mayorSub1 = numeroMayorPorArray(numerosSub1, 0);
        int mayorSub2 = numeroMayorPorArray(numerosSub2, 0);
        int mayor = encontrarMayor(mayorSub1, mayorSub2);
        
        System.out.println("Número mayor: " +  mayor);
    }

    public static void agregarNumeros(List<Integer> numeros){
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.print("Número: ");
            int numero = scanner.nextInt();
            if (numero < 0){
                if (numeros.size() % 2 != 0){
                    System.out.println("Por favor, ingrese una cantidad par de números.");
                } else {
                    break;
                }
            } else {
                numeros.add(numero);
            }
        }
        scanner.close();
    }

    public static int numeroMayorPorArray(List<Integer> lista, int index){
        if (index == lista.size() - 1){
            return lista.get(index);
        } else {
            int mayorEnResto = numeroMayorPorArray(lista, index + 1);
            return Math.max(lista.get(index), mayorEnResto);
        }
    }

    private static int encontrarMayor(int mayorSub1, int mayorSub2) {
        return Math.max(mayorSub1, mayorSub2);
    }
}
