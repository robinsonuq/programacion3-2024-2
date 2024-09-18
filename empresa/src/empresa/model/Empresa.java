package empresa.model;
import java.util.LinkedList;

public class Empresa {
    private String nombre;
    private LinkedList<Empleado> empleados;

    // Constructor
    public Empresa(String nombre) {
        this.nombre = nombre;
        this.empleados = new LinkedList<>();
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LinkedList<Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(LinkedList<Empleado> empleados) {
        this.empleados = empleados;
    }

    // Método para añadir un empleado
    public void agregarEmpleado(Empleado empleado) {
        empleados.add(empleado);
    }

    // Método para eliminar un empleado
    public void eliminarEmpleado(Empleado empleado) {
        empleados.remove(empleado);
    }

    // Método toString para una representación en cadena
    @Override
    public String toString() {
        return "Empresa{" +
                "nombre='" + nombre + '\'' +
                ", empleados=" + empleados +
                '}';
    }
}
