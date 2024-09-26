package empresa.persistencia;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

import empresa.model.Empleado;
import empresa.model.Empresa;

public class Persistencia {

	String rutaArchivoClientes = "";
	
	
	
	
	public void guardarEmpleado(Empleado empleado) throws IOException {
		rutaArchivoClientes = obtenerRutaProperties();
		
		StringBuilder textoEmpleado = new StringBuilder();
		
		textoEmpleado.append(empleado.getNombre()+",");
		textoEmpleado.append(empleado.getIdentificacion()+",");
		textoEmpleado.append(empleado.getSalario()+",");
		textoEmpleado.append(empleado.getTelefono()+",");
		textoEmpleado.append(empleado.getCorreo()+"\n");
		
		ArchivoUtil.guardarArchivo(rutaArchivoClientes,textoEmpleado.toString(),false);
		
	}




	private String obtenerRutaProperties() {
		Properties properties= new Properties();
		try {
			properties.load(new FileInputStream(new File("C:/td/pro3/rutas/rutas.properties")));
			return properties.get("rutaArchivoUsers").toString();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}

	public void guardarEmpleados(List<Empleado> empleados) throws IOException {

		rutaArchivoClientes = obtenerRutaProperties();
		StringBuilder textoEmpleado = new StringBuilder();
		for (Empleado empleado : empleados) {
			textoEmpleado.append(empleado.getNombre()+",");
			textoEmpleado.append(empleado.getIdentificacion()+",");
			textoEmpleado.append(empleado.getSalario()+",");
			textoEmpleado.append(empleado.getTelefono()+",");
			textoEmpleado.append(empleado.getCorreo()+"\n");
		}
		ArchivoUtil.guardarArchivo(rutaArchivoClientes,textoEmpleado.toString(),false);
		
		ArchivoUtil.guardarRegistroLog("Empleados guardados", 1, "btnAgregarEmpleado", "C://td/log.txt");
		
	}

	public LinkedList<Empleado> cargarEmpleados(Empresa empresa) throws IOException {

		rutaArchivoClientes = obtenerRutaProperties();

		ArrayList<String> contenido = ArchivoUtil.leerArchivo(rutaArchivoClientes);
		
		for (String empleadoTexto : contenido) {
			String[] split = empleadoTexto.split(",");
			Empleado empleado = new Empleado(split[0], 
					split[1], Double.valueOf(split[2]), split[3],split[4]);
			empresa.getEmpleados().add(empleado);
		}
		return empresa.getEmpleados();
	}

}
