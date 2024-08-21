package centroimpresion;

import java.util.ArrayList;


public class CentroImpresion {
	
	private Impresora impresora;
	
	private ArrayList<Documento> documentosImpresos = new ArrayList<>();
	
	public CentroImpresion() {
		super();
	}
	public Impresora getImpresora() {
		return impresora;
	}
	public void setImpresora(Impresora impresora) {
		this.impresora = impresora;
	}

	public ArrayList<Documento> getDocumentosImpresos() {
		return documentosImpresos;
	}

	public void setDocumentosImpresos(ArrayList<Documento> documentosImpresos) {
		this.documentosImpresos = documentosImpresos;
	}
	
	public void imprimirDocumento(Documento documento) {
		if(hayImpresoraConectada()) {
			impresora.imprimirDocumento(documento);
			documentosImpresos.add(documento);
		}else {
			System.err.println("NO hay impresora conectada");
		}
	}

	private boolean hayImpresoraConectada() {
		return impresora!= null ;
	}

	public void conectarImpresora(Impresora impresora) {
		this.impresora = impresora;
	}
	
	
}
