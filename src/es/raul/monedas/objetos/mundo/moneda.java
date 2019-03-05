package es.raul.monedas.objetos.mundo;

import java.io.File;

import es.raul.monedas.constantes.constantesMonedas;
import es.raul.monedasAPP.utilidades.utils;

/**
 * @author raul.gonzalez
 * 
 * Informacion de la moneda
 * 
 */

public class moneda implements Comparable<moneda>{
	/*
	El ID de la moneda es 10010001 y se divide de la siguinte manera:
						bit 1 = continente
						bit [2-4] = pais
						bit [4-7] = numero de moneda
	 */
	private int idMoneda;
	private String kmMoneda;
	private denominacion denominacionMoneda;
	private localizacion localizacionMoneda;
	private boolean esKM;

	public moneda(moneda mon){
		this.idMoneda = mon.getIdMoneda();
		this.kmMoneda = mon.getKmMoneda();
		this.denominacionMoneda = mon.getDenominacionMoneda();
		this.localizacionMoneda = mon.getLocalizacionMoneda(); 
		this.esKM = isKM(mon.getLocalizacionMoneda().getPais());
	}
	public moneda(int mon){
		this.idMoneda = mon;
	}

	public moneda(int id, String km, denominacion den, localizacion loc,boolean k){
		this.idMoneda = id;
		this.kmMoneda = km;
		this.denominacionMoneda = den;
		this.localizacionMoneda = loc; 
		this.esKM = k;
	}
	public moneda(int id, String km, denominacion den,String pais, boolean k){
		this.idMoneda = id;
		this.kmMoneda = km;
		this.denominacionMoneda = den;
		this.localizacionMoneda = null; 
		this.esKM = k;
	}
	//***************************** GETTERS AND SETTERS ******************************************************
	public int getIdMoneda() {
		return idMoneda;
	}
	public void setIdMoneda(int idMoneda) {
		this.idMoneda = idMoneda;
	}
	public String getKmMoneda() {
		return kmMoneda;
	}
	public void setKmMoneda(String kmMoneda) {
		this.kmMoneda = kmMoneda;
	}
	public denominacion getDenominacionMoneda() {
		return denominacionMoneda;
	}
	public void setDenominacionMoneda(denominacion denominacionMoneda) {
		this.denominacionMoneda = denominacionMoneda;
	}
	public localizacion getLocalizacionMoneda() {
		return localizacionMoneda;
	}
	public void setlocalizacionMoneda(localizacion localizacionMoneda) {
		this.localizacionMoneda = localizacionMoneda;
	}
	public boolean isEsKM() {
		return esKM;
	}
	public void setEsKM(boolean esKM) {
		this.esKM = esKM;
	}
	public void setLocalizacionMoneda(localizacion localizacionMoneda) {
		this.localizacionMoneda = localizacionMoneda;
	}
	/**
	 * No todas las monedas son KM#, tambine existen Y#, se crea una lista con ellas 
	 */
	private boolean isKM(String pais){	
		return !utils.getInstance().esY(pais);
	}
	@Override
	public int compareTo(moneda o) {
		//TODO mirar si tendriamos que usar la fecha para la ordenacion tambien? ordena por el primer numero
		String a=new String(
				this.getDenominacionMoneda().getCurrencyCompare()  
				+ this.getDenominacionMoneda().getValorCompare()  
				+ this.getDenominacionMoneda().getAnoCompare()
				);
		utils.getInstance().escribirTrazas("prueba","valor "+this.getDenominacionMoneda().getCurrencyCompare());
		String b=new String(
				o.getDenominacionMoneda().getCurrencyCompare()  
				+ o.getDenominacionMoneda().getValorCompare()  
				+ o.getDenominacionMoneda().getAnoCompare()
				);
		return a.compareTo(b);
	}
	public String getRutaImagen(){
		String continente;
		int valInicial = Integer.parseInt(String.valueOf(this.idMoneda).substring(0, 1)); 
		switch (valInicial) {
		case 1: continente="Africa";break;
		case 2: continente="AmericaDelSur";break;
		case 3: continente="Europa";break;
		case 4: continente="AmericaDelNorte";break;
		case 5: continente="Asia";break;
		case 6: continente="AmericaCentral";break;
		case 7: continente="Oceania";break;
		default:
			continente="error";
			break;
		}
		
		return continente + File.separator + this.idMoneda + constantesMonedas.IMAGEN_PATH_PNG;
	}
	@Override
	public String toString() {
		return "moneda [idMoneda=" + idMoneda + ", kmMoneda=" + kmMoneda + ", denominacionMoneda=" + denominacionMoneda
				+ ", localizacionMoneda=" + localizacionMoneda + ", esKM=" + esKM + "]";
	}
}
