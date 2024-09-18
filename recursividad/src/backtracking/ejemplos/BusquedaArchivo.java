package backtracking.ejemplos;

import java.io.File;

public class BusquedaArchivo {

	
	
	
    /* --------------------- PRUEBA DEL ALGORITMO --------------------- */
	public static void main(String[] args)
	{
		buscarArchivo(new File("C:\\td"), "MiArchivo.txt");
	}
	
	
	
	public static void buscarArchivo(File carpeta, String nombre){
		
		for(File f : carpeta.listFiles() ){
			if(f.isDirectory())
			{
				buscarArchivo(f, nombre);
			}
			else{
				if(f.getName().equals(nombre)){
					System.out.printf("Encontrado en %s", f.getAbsolutePath()+"\n");
				}
			}
		}
			
	}
	
	
	
	
	
	
	
	
	
	
	
	
}



