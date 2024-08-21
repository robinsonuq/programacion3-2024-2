package centroimpresion;

public class ImpresoraCartucho implements Impresora {
	@Override
	public void imprimirDocumento(Documento documento) {
		
		System.out.println("Imprimiendo documento en cartucho "+documento.getTexto());
		
	}

}
