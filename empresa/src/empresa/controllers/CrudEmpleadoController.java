package empresa.controllers;



import java.io.IOException;
import java.util.LinkedList;

import empresa.model.Empleado;
import empresa.model.Empresa;
import empresa.persistencia.Persistencia;

public class CrudEmpleadoController {

	public void addEmpleado(Empresa empresa, Empleado empleado) {
		
		System.out.println("Empleado Creado");
		empresa.getEmpleados().add(empleado);
		Persistencia persistencia = new Persistencia();
		try {
			persistencia.guardarEmpleados(empresa.getEmpleados());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public LinkedList<Empleado> mostrarListaEmpleados() {
		
		Empresa empresa = new Empresa("xxxxx");
		Persistencia persistencia = new Persistencia();
		try {
			persistencia.cargarEmpleados(empresa);
			
			return empresa.getEmpleados();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}

}
