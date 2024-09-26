package exceptions.universidad;

public class Estudiante {

	private String nombre = "William";
	
	public Estudiante() {
		
	}
	
	public String solicitarSupletorio() throws ParcialException {
		Secretaria secretaria = new Secretaria();
		try {
			secretaria.solicitarSupletorio(nombre);
			Profesor profesor = new Profesor();
			profesor.presentarSupletorio();
		} catch (SupletorioException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return nombre;
	}
}
