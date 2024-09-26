package empresa.view;

import java.util.LinkedList;

import javax.swing.JOptionPane;

import empresa.controllers.CrudEmpleadoController;
import empresa.model.Empleado;

public class CrudEmpleadoView {

	public void addEmpleado(String nombre, String identificacion, int salario, String telefono, String correo) {
		
		CrudEmpleadoController crudEmpleadoController = new CrudEmpleadoController();
//		
//		Empleado empleado = new Empleado(nombre, identificacion, salario, telefono, correo);
//		crudEmpleadoController.addEmpleado(empleado);
		
		crudEmpleadoController.mostrarListaEmpleados();
		
		
	}

    public void mostrarEmpleados() {
		
		CrudEmpleadoController crudEmpleadoController = new CrudEmpleadoController();
		LinkedList<Empleado> mostrarListaEmpleados = crudEmpleadoController.mostrarListaEmpleados();
		String emplados = "";
		for (Empleado empleado : mostrarListaEmpleados) {
			emplados += empleado.getNombre()+"\n";
		}
		JOptionPane.showMessageDialog(null,"Empleados de la Empresa\n"+emplados);
	}

	
}
