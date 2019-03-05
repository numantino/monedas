package es.raul.monedasAPP.objetos;

import java.util.ArrayList;
import java.util.List;

import es.raul.monedas.constantes.constantesMonedas;

public class informacionJPanelMonedas {
	private List<informacionBotonMoneda> lista;
	private int tipo;
	private boolean esConmemorativa;
	private String titulo;
	private String valorAux;
	
	public informacionJPanelMonedas(){
		this.lista = new ArrayList<informacionBotonMoneda>();
		this.tipo = 0;
		this.esConmemorativa = false;
		this.titulo="";
		this.valorAux="";
	}
	public informacionJPanelMonedas(List<informacionBotonMoneda> lista, int tipo, boolean esConmemorativa, String ti) {
		this.lista = lista;
		this.tipo = tipo;
		this.esConmemorativa = esConmemorativa;
		this.titulo = ti;
		this.valorAux="";
	}
	
	public void setComponenteLista(informacionBotonMoneda info){
		if (lista!=null) lista.add(info);
	}
	public void setLista(List<informacionBotonMoneda> lista) {
		this.lista = lista;
	}
	public List<informacionBotonMoneda> getLista() {
		return lista;
	}
	public informacionBotonMoneda getComponenteLista(int pos) {
		if (lista!=null)  return lista.get(pos);
		else return new informacionBotonMoneda();
	}
	public int getTipo() {
		return tipo;
	}
	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	public boolean isEsConmemorativa() {
		if (constantesMonedas.TIPO_EURO==tipo) return esConmemorativa;
		else return false;
	}
	public void setEsConmemorativa(boolean esConmemorativa) {
		this.esConmemorativa = esConmemorativa;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getValorAux() {
		return valorAux;
	}
	public void setValorAux(String valorAux) {
		this.valorAux = valorAux;
	}
}
