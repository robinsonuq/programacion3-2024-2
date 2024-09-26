package exceptions.universidad;

public class Profesor {

	private String nombre = "Robinson Arias Muñoz";
	
	public Profesor() {
		
	}

	public void presentarSupletorio() throws ParcialException {
		// TODO Auto-generated method stub
		throw new ParcialException("No puede fechas invalidad");
	}
}
