package empresa.view;



import empresa.model.Empleado;
import empresa.model.Empresa;

public class CrudEmpleadoController {

	public void addEmpleado(Empleado empleado) {
		
		Empresa empresa = new Empresa("Empresa xxxx");
		empresa.agregarEmpleado(empleado);
		System.out.println("Empleado Creado");
		
		Persistencia persistencia = new Persistencia();
		persistencia.guardarEmpleado(empleado);
		
	}

}
