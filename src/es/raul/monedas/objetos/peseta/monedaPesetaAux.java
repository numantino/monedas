package es.raul.monedas.objetos.peseta;

import java.util.ArrayList;
import java.util.List;

import es.raul.monedas.objetos.mundo.informacionMoneda;


/**
 * @author raul.gonzalez
 * 
 * Informacion completa de la moneda peseta
 * 
 */

public class monedaPesetaAux extends monedaPeseta{
	private String composicionMoneda;
	private informacionMoneda informacion;
	private String notaMoneda;
	private List<estrellasPesetas> estrellas;
	
	public monedaPesetaAux(monedaPeseta mon, String c, informacionMoneda inf, String n, List<estrellasPesetas> es){
		super(mon);
		this.composicionMoneda = c;
		this.informacion = inf;
		this.notaMoneda = n;
		this.estrellas = es;
	}
	public monedaPesetaAux(monedaPeseta mon, String c, informacionMoneda inf){
		super(mon);
		this.composicionMoneda = c;
		this.informacion = inf;
		this.notaMoneda = "";
		this.estrellas = new ArrayList<estrellasPesetas>();
	}
	//***************************** GETTERS AND SETTERS ******************************************************

	public informacionMoneda getInformacion() {
		return informacion;
	}

	public void setInformacion(informacionMoneda informacion) {
		this.informacion = informacion;
	}

	public String getNotaMoneda() {
		return notaMoneda;
	}

	public void setNotaMoneda(String notaMoneda) {
		this.notaMoneda = notaMoneda;
	}
	
	public String getComposicionMoneda() {
		return composicionMoneda;
	}
	
	public void setComposicionMoneda(String composicion) {
		this.composicionMoneda = composicion;
	}

	public List<estrellasPesetas> getEstrellas() {
		return estrellas;
	}

	public void setEstrellas(List<estrellasPesetas> estrellas) {
		this.estrellas = estrellas;
	}
	public estrellasPesetas getEstrellas(int id) {
		return estrellas.get(id);
	}

	public void setEstrellas(estrellasPesetas estrellas) {
		this.estrellas.add(estrellas);
	}
	
	public boolean estanTodasMonedasEstrella(){
		int i=0;
		boolean fin =true;
		while (i<estrellas.size() && fin){
			if (estrellas.get(i).isEsta()==false) fin=false;
			i++;
		}
		return fin;
	}
	
	public boolean tieneEstrella(){
		if (estrellas.size()<=0) return false;
		else return true;
	}
	public String getTitulo() {
		//TODO Poner informacion de la moneda??? nombre .....
		return "";
	}
}
