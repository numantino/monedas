package es.raul.monedas.objetos.mundo;

/**
 * @author raul.gonzalez
 * 
 * Es la informacion de la moneda
 * 
 */
public class informacionMoneda {
	private String anverso; 
	private String anversoLeyenda;   			  
	private String reverso;	
	private String reversoLeyenda;
	private String canto;
	private String cantoLeyenda;
	
	public informacionMoneda(){
		this.anverso = "";
		this.anversoLeyenda = "";
		this.reverso = "";
		this.reversoLeyenda = "";
		this.canto = "";
		this.cantoLeyenda = "";
	}
	public informacionMoneda(String a, String aL, String r, String rL, String c, String cL){
		this.anverso = a;
		this.anversoLeyenda = aL;
		this.reverso = r;
		this.reversoLeyenda = rL;
		this.canto = c;
		this.cantoLeyenda = cL;
	}
	//***************************** GETTERS AND SETTERS ******************************************************	
	public String getAnverso() {
		return anverso;
	}
	public void setAnverso(String anverso) {
		if (anverso==null) this.anverso = "";
		else this.anverso = anverso;
	}
	public String getAnversoLeyenda() {
		return anversoLeyenda;
	}
	public void setAnversoLeyenda(String anversoLeyenda) {
		if (anversoLeyenda==null) this.anversoLeyenda = "";
		else this.anversoLeyenda = anversoLeyenda;
	}
	public String getReverso() {
		return reverso;
	}
	public void setReverso(String reverso) {
		if (reverso==null) this.reverso = "";
		else this.reverso = reverso;
	}
	public String getReversoLeyenda() {
		return reversoLeyenda;
	}
	public void setReversoLeyenda(String reversoLeyenda) {
		if (reversoLeyenda==null) this.reversoLeyenda = "";
		else this.reversoLeyenda = reversoLeyenda;
	}
	public String getCanto() {
		return canto;
	}
	public void setCanto(String canto) {
		if (canto==null) this.canto = "";
		else this.canto = canto;
	}
	public String getCantoLeyenda() {
		return cantoLeyenda;
	}
	public void setCantoLeyenda(String cantoLeyenda) {
		if (cantoLeyenda==null) this.cantoLeyenda = "";
		else this.cantoLeyenda = cantoLeyenda;
	}
	@Override
	public String toString() {
		return "informacionMoneda [anverso=" + anverso + ", anversoLeyenda=" + anversoLeyenda + ", reverso=" + reverso
				+ ", reversoLeyenda=" + reversoLeyenda + ", canto=" + canto + ", cantoLeyenda=" + cantoLeyenda + "]";
	}
}
