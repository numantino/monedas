package es.raul.monedas.objetos.euros;

public class monedaEuro {
	/**
	 * Numero de monedas de euro de un determinado pais
	 */
	public final static int MAX_MONEDAS_ERUROS = 8;
	/**
	 * Denominaciones del euro
	 */
	public final static String[] euroDenominacion = {"1c","2c","5c","10c","20c","50c","1e","2e"};
	
	//Indica el periodo de la moneda (algunos paises tienen varios periodos)
	private String periodo;
	//Array que indica si se tiene la moneda o no, [0=no esta; 1=si esta]
	private int[] monedasEuros = new int[MAX_MONEDAS_ERUROS];
	//Indica si la serie esta completa
	private boolean completa;
	
	public monedaEuro(String p, int c1, int c2, int c5, int c10, int c20, int c50, int e1, int e2){
		this.periodo = p;
		this.monedasEuros[0]=c1;
		this.monedasEuros[1]=c2;
		this.monedasEuros[2]=c5;
		this.monedasEuros[3]=c10;
		this.monedasEuros[4]=c20;
		this.monedasEuros[5]=c50;
		this.monedasEuros[6]=e1;
		this.monedasEuros[7]=e2;
		this.completa = estaTodoCompleto();
	}
	
	public String getPeriodo() {
		return periodo;
	}

	public int[] getMonedasEuros() {
		return monedasEuros;
	}
	
	public void setTengoMoneda(int pos){
		this.monedasEuros[pos]=1;
		
		//se comprueba si se completa la seleccion
		this.completa = estaTodoCompleto();
	}

	public boolean isTengoMoneda(int p) {
		if (this.monedasEuros[p]==0) return false;
		else return true;
	}
	
	public boolean isCompleta() {
		return completa;
	}
	
	/**
	 * Funcion que nos indica si las monedas de ese pais estan completas
	 */
	private boolean estaTodoCompleto(){
		boolean fin = true;
		int i=0;
		while (fin && (i<(MAX_MONEDAS_ERUROS-1))){
			if (this.monedasEuros[i]==0) fin=false;	
			i++;
		}

		return fin;
	}
	
	//To String
	public String toString() { 
		return this.periodo;
	}
}
