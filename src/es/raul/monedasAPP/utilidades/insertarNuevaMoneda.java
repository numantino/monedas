package es.raul.monedasAPP.utilidades;

import es.raul.monedasAPP.vista_insertarMoneda;

public class insertarNuevaMoneda {
	private final static String NOMBRE_CLASS="insertarNuevaMoneda";
	
	private String nuevoPais;
	private String nuevoContinente;
	
	
	public insertarNuevaMoneda() {
		this.nuevoPais = "";
		this.nuevoContinente = "";
	}
	public void setNuevoPais(String nuevoPais) {
		this.nuevoPais = nuevoPais;
	}
	public void setNuevoContinente(String nuevoCOntinente) {
		this.nuevoContinente = nuevoCOntinente;
	}
	
	/**
	 * Inserta una nueva moneda de un pais que ya se tiene
	 */
	public void insertarMonedaNueva(){
		utilLog.getInstance().escribirTrazas(NOMBRE_CLASS,"insertarMonedaNueva() con Continente="+nuevoContinente+", Pais="+nuevoPais);
		
		//Lanzamos la vista
		vista_insertarMoneda in = new vista_insertarMoneda();
		in.setVisible(true);
		in.insertarMoneda(nuevoContinente, nuevoPais);
	}

	/**
	 * Inserta una nueva moneda de un pais que aun no se tiene
	 */
	public void insertarNuevoPaisMoneda(){
		utilLog.getInstance().escribirTrazas(NOMBRE_CLASS,"insertarNuevoPaisMoneda()");
		
		//TODO primero lanzamos la vista para crear el nuevo pais
		
		//Despues lanzamos la vista normal de insertar la nueva moneda
//		//Lanzamos la vista
//		vista_insertarMoneda in = new vista_insertarMoneda();
//		in.setVisible(true);
//		in.insertarMoneda(nuevoContinente, nuevoPais);
	}
}
