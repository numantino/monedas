package es.raul.monedas.objetos.peseta;


/**
 * @author raul.gonzalez
 * 
 * Informacion de la moneda de peseta
 * 
 */

public class estrellasPesetas{
	private String ano;
	private String estrella;
	private String CECA;
	private int tirada;
	private boolean esta;
	private String estado;
	
	public estrellasPesetas(String a, String e, boolean t, String es){
		this.ano=a;
		this.estrella=e;
		this.tirada=0;
		this.CECA="";
		this.estado=es;
		this.esta = t;
	}
	public estrellasPesetas(String a, String e, int ti, String c, String es, int t){
		this.ano=a;
		if (e==null) this.estrella="";
		else this.estrella=e;
		this.tirada=ti;
		this.CECA=c;
		if (es==null) this.estado="";
		else this.estado=es;
		if (t==0) this.esta = false;
		else this.esta = true;
	}
	//***************************** GETTERS AND SETTERS ******************************************************
	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public String getEstrella() {
		return estrella;
	}

	public void setEstrella(String estrella) {
		this.estrella = estrella;
	}

	public boolean isEsta() {
		return esta;
	}

	public void setEsta(boolean esta) {
		this.esta = esta;
	}
	
	public int getTirada() {
		return tirada;
	}
	
	public void setTirada(int tirada) {
		this.tirada = tirada;
	}
	
	public String getEstado() {
		return estado;
	}
	
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getCECA() {
		return CECA;
	}
	public void setCECA(String cECA) {
		CECA = cECA;
	}
	
	public Object[] getRow(){
		return new Object[]{ano,estrella,CECA,tirada,estado,esta};
	}
}