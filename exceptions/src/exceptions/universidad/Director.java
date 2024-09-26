package exceptions.universidad;

public class Director {

	private String nombre = "Robinson Pulgarin";
	
	public Director() {
		
	}

	public String autorizarSupletorio(String estudiante, String estado) throws SupletorioException {
		
		if(estado.equals("bien")) {
			return "aprueba";
		}
		else {
			throw new SupletorioException("El supletorio no cumple para poder firmar por el director");
		}
	}
}
