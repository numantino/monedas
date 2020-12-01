package es.raul.monedas.objetos.mundo;

import es.raul.monedas.constantes.constantesLiterales;
import es.raul.monedasAPP.utilidades.utilLog;

/**
 * @author raul.gonzalez
 * 
 * Clase que almacena la denominacion y año de la moneda
 * 
 */

public class denominacion{
	//Una isntancia del objeto de utilidades
	private final static String NOMBRE_CLASS="Obj-denominacion";

	private String valor;	//numerico de la moneda 				(Obligatoria)   DB_MONEDAS_VALOR
	private String año;		//acuñacion de la moneda				(Opcional)		DB_MONEDAS_DATE
	private String currency;//y denominacion						(Obligatoria)   DB_MONEDAS_VALOR
	private String []listCurrency;//lista de las denominaciones

	public denominacion(String val, String a) {
		descomponerValores(val);
		this.año = a;
		this.listCurrency=null;
	}
	public denominacion(String v, String a, String c) {
		this.valor = v;
		this.año = a;
		this.currency=c;
		this.listCurrency=null;
	}
	//***************************** GETTERS AND SETTERS ******************************************************
	public String getValor() {
		return valor;
	}
	public int getValorNumerico() {
		int val=10000;
		try{
			val = Integer.parseInt(this.valor);
		}
		catch(Exception e){
			//en el caso de que salte excepcion puede que tenga decimales o valores medios.
		}
		return val;
	}
	public void setValor(String valor) {
		this.valor = valor;
	}
	public String getAño() {
		return año;
	}
	public void setAño(String año) {
		this.año = año;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String[] getListCurrency() {
		return listCurrency;
	}
	public void setListCurrency(String[] listCurrency) {
		this.listCurrency = listCurrency;
	}
	/**
	 * Metodo que actualiza el valor de la moneda para que pueda ser comparado
	 */
	public String getValorCompare(){
		int val=1000;
		try{
			val = Integer.parseInt(this.valor);

			if (val<9) return "00000"+this.valor;
			else{ 
				if (val<99) return  "0000"+this.valor;
				else {
					if (val<999) return  "000"+this.valor;
					else {
						if (val<999) return  "000"+this.valor;
						else return this.valor;
					}
				}
			}
		}
		catch(Exception e){
			if (this.valor.equalsIgnoreCase("1/2")) return "00005";
			else if (this.valor.equalsIgnoreCase("1/4")) return "00002";
			else return this.valor; 
		}
	}
	/**
	 * Nos idica la posicion en la que se encuentra en la lista de denominaciones
	 */
	public String getCurrencyCompare() {
		int posicion =0;
		boolean fin =false;
		if (listCurrency==null) return "10"; //valor alto ya que no estaria controlado
		while (!fin && posicion<listCurrency.length){
			if (listCurrency[posicion].toLowerCase().equalsIgnoreCase(this.currency.toLowerCase())) fin =true;
			else posicion++;
		}
		if (fin==false) return "11"; //valor alto ya que no estaria controlado
		return Integer.toString(posicion);
	}
	/**
	 * 
	 */
	public String getAnoCompare(){
		if (this.año.contains("-")){
			int pos = this.año.indexOf("-");
			return this.año.substring(pos+1, this.año.length());
		}
		else return this.año;
	}
	//To String
	public String toString() { 
		if (año!=null && año.length() > 1) return valor + " " + currency + constantesLiterales.TXT_INFORMACION_DE + año;
		else return valor + " " + currency;
	}

	/**
	 * Metodo que compone el valor
	 */
	private void descomponerValores(String v){
		String[] palabrasSeparadas = v.split(" ");
		try{
			//util.escribirTrazas(NOMBRE_CLASS,"descomponerValores, valor1= "+palabrasSeparadas[0]+"; valor2="+palabrasSeparadas[1]);
			this.valor = palabrasSeparadas[0];
			this.currency = palabrasSeparadas[1].toLowerCase();
			if (palabrasSeparadas.length==3) currency = currency + " " + palabrasSeparadas[2].toLowerCase();  // en el caso que la currency sea compuesta
		}
		catch(Exception e){
			utilLog.getInstance().escribirError(NOMBRE_CLASS,"descomponerValores, excepcion=" + e.getMessage());
		}
	}
}
