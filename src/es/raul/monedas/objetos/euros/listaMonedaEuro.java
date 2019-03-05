package es.raul.monedas.objetos.euros;

import java.util.ArrayList;
import java.util.List;

import es.raul.monedas.constantes.constantesMonedas;

/**
 * 
 * @author rgtarancon
 * 
 * Estructura de la moneda euro de un pais
 *
 */
public class listaMonedaEuro {
	private String pais;					// PAIS
	List<monedaEuro> monedas;			// Lista con todas las monedas y periodos de un pais.
	private boolean tieneConmemorativas;	// indica si tiene monedas conmemorativas
	
	public listaMonedaEuro(String p, monedaEuro m, int con){
		this.pais = p;
		monedas = new ArrayList<monedaEuro>();
		monedas.add(m);
		if (con==0) this.tieneConmemorativas = false;
		else  this.tieneConmemorativas = true;
	}
	
	public String getPais() {
		return pais;
	}

	public monedaEuro getMonedasEuros(int pos) {
		return monedas.get(pos);
	}
	
	public boolean isTieneConmemorativas() {
		return tieneConmemorativas;
	}
	
	//To String
	public String toString() { 
		String fin= this.pais + constantesMonedas.SEPARADOR_E;

		for (int i=0;i<monedas.size();i++) fin= fin + monedas.toString();
		
		if (this.tieneConmemorativas) fin= fin + 0;
		else fin= fin + 1;
		
		return fin;
	}
}
