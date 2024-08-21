package centroimpresion;

public class ImpresoraLaser implements Impresora  {

	@Override
	public void imprimirDocumento(Documento documento) {
		
		System.out.println("Imprimiendo documento "+documento.getTexto());
		
	}

}
