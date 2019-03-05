package es.raul.monedas.objetos.mundo;

/**
 * @author raul.gonzalez
 * 
 * Clase encargada de almacenar la informacion de la moneda de forma extendida
 *
 */
public class monedaExt extends moneda {
	private String composicionMoneda;
	private informacionMoneda informacion;
	private String formaMoneda;
	private String notaMoneda;
	private String estadoMoneda;
	
	public monedaExt(int m){
		super(m);
	}
	public monedaExt(moneda mon, String es){
		super(mon);
		this.composicionMoneda = "";
		this.informacion = null;
		this.formaMoneda = "";
		this.notaMoneda = "";
		this.estadoMoneda = es;
	}
	
	public monedaExt(moneda mon, String c, informacionMoneda inf, String f, String n, String es){
		super(mon);
		this.composicionMoneda = c;
		this.informacion = inf;
		this.formaMoneda = f;
		this.notaMoneda = n;
		this.estadoMoneda = es;
	}
	public monedaExt(moneda mon, informacionMoneda inf, String f, String es){
		super(mon);
		this.composicionMoneda = "";
		this.informacion = inf;
		this.formaMoneda = f;
		this.notaMoneda = "";
		this.estadoMoneda = es;
	}
	//***************************** GETTERS AND SETTERS ******************************************************
	public informacionMoneda getInformacionMoneda() {
		return informacion;
	}
	public void setInformacionMoneda(informacionMoneda informacionMoneda) {
		this.informacion = informacionMoneda;
	}
	public String getNotaMoneda() {
		return notaMoneda;
	}
	public void setNotaMoneda(String nota) {
		this.notaMoneda = nota;
	}
	public String getEstadoMoneda() {
		return estadoMoneda;
	}
	public void setEstadoMoneda(String estado) {
		this.estadoMoneda = estado;
	}
	public String getFormaMoneda() {
		return formaMoneda;
	}
	public void setFormaMoneda(String forma) {
		this.formaMoneda = forma;
	}
	public String getComposicionMoneda() {
		return composicionMoneda;
	}
	public void setComposicionMoneda(String composicion) {
		this.composicionMoneda = composicion;
	}
	@Override
	public String toString() {
		return super.toString() + "monedaExt [composicionMoneda=" + composicionMoneda + ", informacion=" + informacion + ", formaMoneda="
				+ formaMoneda + ", notaMoneda=" + notaMoneda + ", estadoMoneda=" + estadoMoneda + "]";
	}
}
