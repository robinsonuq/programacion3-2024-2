package centroimpresion;

public class Impresora3D implements Impresora {

	@Override
	public void imprimirDocumento(Documento documento) {
		System.out.println("Imprimiendo documento en 3D "+documento.getTexto());
	}
	
	

}
