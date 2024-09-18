package empresa.view;

import empresa.model.Empleado;

public class Persistencia {

	public void guardarEmpleado(Empleado empleado) {
		
		StringBuilder textoEmpleado = new StringBuilder();
		
		textoEmpleado.append(empleado.getNombre()+",");
		textoEmpleado.append(empleado.getIdentificacion()+",");
		textoEmpleado.append(empleado.getSalario()+",");
		textoEmpleado.append(empleado.getTelefono()+",");
		textoEmpleado.append(empleado.getCorreo());
		
		ArchivoUtil.guardarTexto(textoEmpleado.toString());
		
	}

}
