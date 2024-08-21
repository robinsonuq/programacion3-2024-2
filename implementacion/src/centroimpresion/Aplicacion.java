package centroimpresion;

public class Aplicacion {

	public static void main(String[] args) {
		
		CentroImpresion centroImpresion = new CentroImpresion();
		
	
		ImpresoraCartucho impresoraCartucho = new ImpresoraCartucho();
		ImpresoraLaser impresoraLaser = new ImpresoraLaser();
		
		centroImpresion.conectarImpresora(impresoraLaser);
		
//		centroImpresion.conectarImpresora(impresoraCartucho);
		
		centroImpresion.imprimirDocumento(new Documento("Hola como estas"));
	}
}
