package exceptions.universidad;

public class Secretaria {

	private String nombre = "Luisa Dia";
	
	public Secretaria() {
		
	}

	public String solicitarSupletorio(String estudiante) throws SupletorioException {
		
		//verificar estudiante activi
		//verificar el curso 
		// 
		Director director = new Director();
		return director.autorizarSupletorio(estudiante,"mal");
			
	}
}
