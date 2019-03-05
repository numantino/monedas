package es.raul.monedas.objetos.peseta;

import es.raul.monedasAPP.utilidades.utils;

/**
 * @author raul.gonzalez
 * 
 * Informacion de la moneda de peseta
 * 
 */

public class monedaPeseta implements Comparable<monedaPeseta>{
	private int idMoneda;
	private String kmMoneda;
	private String periodo;
	private String valorMoneda;
	private boolean tengoMoneda;
	
	public monedaPeseta(monedaPeseta mon){
		this.idMoneda = mon.getIdMoneda();
		this.kmMoneda = mon.getKmMoneda();
		this.periodo = mon.getPeriodo();
		this.valorMoneda = mon.getvalorMoneda();
		this.tengoMoneda = false;
	}
	
	public monedaPeseta(int id, String km, String pe, String v){
		this.idMoneda = id;
		this.kmMoneda = km;
		this.periodo = pe;
		this.valorMoneda = v;
		this.tengoMoneda = false;
	}
	public monedaPeseta(int id, String km, String pe, String v, boolean t){
		this.idMoneda = id;
		this.kmMoneda = km;
		this.periodo = pe;
		this.valorMoneda = v;
		this.tengoMoneda = t;
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

	public String getPeriodo() {
		return periodo;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}
	
	public String getvalorMoneda() {
		return valorMoneda;
	}
	
	public void setvalorMoneda(String valorMoneda) {
		this.valorMoneda = valorMoneda;
	}
	
	public void setTengoMoneda(boolean tengo){
		this.tengoMoneda = tengo;
	}

	public boolean isTengoMoneda(){
		return tengoMoneda;
	}
	/**
	 * Metodo que actualiza el valor de la moneda para que pueda ser comparado
	 */
	@Override
	public int compareTo(monedaPeseta o) {
		String a=new String(
				this.getValorCompare() 
				+ this.getKmMoneda()
				);
		String b=new String(
				o.getValorCompare()  
				+ o.getKmMoneda()
				);
		return a.compareTo(b);
	}
	public String getValorCompare(){
		int valor=10;
		try{
			if (this.valorMoneda==null) return "0";
			if (this.valorMoneda.contains("2000")) return "99999999";
			
			utils.getInstance().escribirTrazas("getValorCompare","INICIO "+valorMoneda);
			if (this.valorMoneda.contains("CENTIMO") || this.valorMoneda.contains("CENTIMOS")){
				valor=Integer.parseInt(this.valorMoneda.substring(0, this.valorMoneda.indexOf("CENTIMO")).trim());
			}
			else if (this.valorMoneda.contains("PESETA") || this.valorMoneda.contains("PESETAS")){
				valor=Integer.parseInt(this.valorMoneda.substring(0, this.valorMoneda.indexOf("PESETA")).trim())*100;
			}
		}
		catch(Exception e){
			if (this.valorMoneda.contains("2.5")) valor=250;
		}
		
		if (valor<9) return "00000" + valor;
		else{ 
			if (valor<99) return  "0000" + valor;
			else {
				if (valor<999) return  "000" + valor;
				else {
					if (valor<999) return  "000" + valor;
					else{
						if (valor<9999) return  "00" + valor;
						else return Integer.toString(valor);
					}
				}
			}
		}
	}
}
