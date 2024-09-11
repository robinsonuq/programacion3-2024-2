import java.util.InputMismatchException;
import java.util.Scanner;

public class HolaMundo {
    @SuppressWarnings("resource")
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Ingrese 1 si quiere ver Hola Mundo. Ingrese otro número si quiere ver la excepción");
            int numero = scanner.nextInt();
            if (numero != 1){
                throw new IllegalArgumentException("Excepción de tipo IllegalArgumentException!");
            } else {
                System.out.println("Hola, Mundo!");
            }
        } catch (IllegalArgumentException ex){
            System.out.println(ex.getMessage());
        } catch (InputMismatchException ex){
            System.out.println("Ingresó un caracter no valido.");
        }
        scanner.close();
    }
}   