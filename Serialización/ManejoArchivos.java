import java.io.*;
import java.nio.file.*;
import java.util.Scanner;

public class ManejoArchivos {

    public static void crearArchivo(String nombreArchivo, String contenido) {
        try (FileWriter escritor = new FileWriter(nombreArchivo)) {
            escritor.write(contenido);
            System.out.println("Archivo creado y contenido asignado.");
        } catch (IOException e) {
            System.out.println("Error al crear el archivo: " + e.getMessage());
        }
    }

    public static void eliminarArchivo(String nombreArchivo) {
        File archivo = new File(nombreArchivo);
        if (archivo.delete()) {
            System.out.println("El archivo " + nombreArchivo + " fue eliminado.");
        } else {
            System.out.println("No se pudo eliminar el archivo.");
        }
    }

    public static void cambiarNombreArchivo(String nombreActual, String nuevoNombre) {
        File archivoActual = new File(nombreActual);
        File archivoNuevo = new File(nuevoNombre);
        if (archivoActual.renameTo(archivoNuevo)) {
            System.out.println("El archivo fue renombrado a: " + nuevoNombre);
        } else {
            System.out.println("No se pudo cambiar el nombre del archivo.");
        }
    }

    public static void sobreescribirArchivo(String nombreArchivo, String nuevoContenido) {
        try (FileWriter escritor = new FileWriter(nombreArchivo)) {
            escritor.write(nuevoContenido);
            System.out.println("Archivo sobrescrito.");
        } catch (IOException e) {
            System.out.println("Error al sobrescribir el archivo: " + e.getMessage());
        }
    }

    public static void obtenerInformacionArchivo(String nombreArchivo) {
        File archivo = new File(nombreArchivo);
        if (archivo.exists()) {
            System.out.println("Nombre del archivo: " + archivo.getName());
            System.out.println("Ruta absoluta: " + archivo.getAbsolutePath());
            System.out.println("Tamaño (bytes): " + archivo.length());
            System.out.println("¿Es un directorio?: " + archivo.isDirectory());
            System.out.println("¿Se puede leer?: " + archivo.canRead());
            System.out.println("¿Se puede escribir?: " + archivo.canWrite());
        } else {
            System.out.println("El archivo no existe.");
        }
    }

    public static void copiarArchivo(String origen, String destino) {
        Path fuentePath = Paths.get(origen);
        Path destinoPath = Paths.get(destino);
        try {
            Files.copy(fuentePath, destinoPath, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Archivo copiado a: " + destino);
        } catch (IOException e) {
            System.out.println("Error al copiar el archivo: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            System.out.println("\n--- MENÚ ---");
            System.out.println("1. Crear un archivo y asignar contenido");
            System.out.println("2. Eliminar un archivo");
            System.out.println("3. Cambiar el nombre de un archivo");
            System.out.println("4. Sobreescribir un archivo");
            System.out.println("5. Obtener información de un archivo");
            System.out.println("6. Copiar un archivo");
            System.out.println("7. Cerrar");

            System.out.println("Elija una opción:");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.println("Ingrese el nombre del archivo a crear:");
                    String nombreArchivo = scanner.nextLine();
                    System.out.println("Ingrese el contenido para el archivo:");
                    String contenido = scanner.nextLine();
                    crearArchivo(nombreArchivo, contenido);
                    break;
                case 2:
                    System.out.println("Ingrese el nombre del archivo a eliminar:");
                    String archivoAEliminar = scanner.nextLine();
                    eliminarArchivo(archivoAEliminar);
                    break;
                case 3:
                    System.out.println("Ingrese el nombre actual del archivo:");
                    String nombreActual = scanner.nextLine();
                    System.out.println("Ingrese el nuevo nombre para el archivo:");
                    String nuevoNombre = scanner.nextLine();
                    cambiarNombreArchivo(nombreActual, nuevoNombre);
                    break;
                case 4:
                    System.out.println("Ingrese el nombre del archivo a sobrescribir:");
                    String archivoSobreescribir = scanner.nextLine();
                    System.out.println("Ingrese el nuevo contenido:");
                    String nuevoContenido = scanner.nextLine();
                    sobreescribirArchivo(archivoSobreescribir, nuevoContenido);
                    break;
                case 5:
                    System.out.println("Ingrese el nombre del archivo para obtener información:");
                    String archivoInformacion = scanner.nextLine();
                    obtenerInformacionArchivo(archivoInformacion);
                    break;
                case 6:
                    System.out.println("Ingrese la ruta del archivo de origen:");
                    String archivoOrigen = scanner.nextLine();
                    System.out.println("Ingrese la ruta de destino:");
                    String archivoDestino = scanner.nextLine();
                    copiarArchivo(archivoOrigen, archivoDestino);
                    break;
                case 7:
                    System.out.println("Cerrando el programa...");
                    continuar = false;
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        }
        scanner.close();
    }
}
