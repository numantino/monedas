package es.raul.monedas.objetos.mundo;

/**
 * @author raul.gonzalez
 * 
 * Informacion relativa a la procedencia de la moneda
 */
public class localizacion {
	private String pais;   			  
	private String continente;
	private String periodoMoneda;
	private int numMonedas;
	
	/*
	 * Constructor solo para almacenar nombre y numero de monedas (primero de los casos)
	 */
	public localizacion(String c, int p){
		this.pais = c;
		this.numMonedas = p;
	}
	/*
	 * Constructor solo para almacenar nombre y numero de monedas (primero de los casos)
	 */
	public localizacion(String c, String p){
		this.pais = p;
		this.continente = c;
	}
	/*
	 * Constructor con todos los parametros excepto el numero de monedas
	 */
	public localizacion(String n, String c, String p){
		this.pais = n;
		this.continente = c;
		this.periodoMoneda = p;
		this.numMonedas = 0;
	}
	/*
	 * Constructor con todos los parametros
	 */
	public localizacion(String n, String c, String p, int numMon){
		this.pais = n;
		this.continente = c;
		this.periodoMoneda = p;
		this.numMonedas = numMon;
	}
	//***************************** GETTERS AND SETTERS ******************************************************	
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	public String getContinente() {
		return continente;
	}
	public void setContinenteID(String continente) {
		this.continente = continente;
	}
	public String getPeriodoMoneda() {
		return periodoMoneda;
	}
	public void setPeriodoMoneda(String periodoMoneda) {
		this.periodoMoneda = periodoMoneda;
	}
	public int getNumMonedas() {
		return numMonedas;
	}
	public void setNumMonedas(int numMonedas) {
		this.numMonedas = numMonedas;
	}
	public String getTitulo(){
		if (periodoMoneda.length() <= 0) return this.getPais();
		else return this.getPais() + " del periodo " + this.periodoMoneda;
	}
	
	//To String
	public String toString() { 
		if (periodoMoneda.length() <= 0) return continente + "//" + pais;
		else return continente + "//" + pais + "//" + periodoMoneda;
	}
}
