package empresa.view;

import empresa.model.Empleado;

public class CrudEmpleadoView {

	public void addEmpleado(String nombre, String identificacion, int salario, String telefono, String correo) {
		
		CrudEmpleadoController crudEmpleadoController = new CrudEmpleadoController();
		
		Empleado empleado = new Empleado(nombre, identificacion, salario, telefono, correo);
		crudEmpleadoController.addEmpleado(empleado);
	}

	
	
}
