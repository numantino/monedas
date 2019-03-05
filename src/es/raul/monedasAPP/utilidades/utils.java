package es.raul.monedasAPP.utilidades;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import es.raul.monedas.constantes.constantesDatabase;
import es.raul.monedas.constantes.constantesMonedas;



public class utils {

	private final static boolean ACTIVAR_TRAZAS=true;

	public static String PATH_PC = "D:\\_cosasRAUL\\MONEDAS"; //TODO esto se tiene que obtener de un fichero de configuracion
	private static String PATH_LOGS = PATH_PC + "\\" + constantesMonedas.PATH_MONEDAS + "\\logs";
	private static String PATH_FILE_Y = utils.PATH_PC + "\\" + constantesMonedas.PATH_MONEDAS + "\\sonY.txt";
	private List<String> listaMonedasY = new ArrayList<>();

	private static utils instancia = new utils();

	public static utils getInstance () {
		return instancia;
	}

	private utils(){
		//Obtener datos de valores de Y
		readFileValoresY();
	}


	/**
	 * ************************ TRAZAS ************************
	 */
	public void escribirError(String titulo, String msn){
		if (ACTIVAR_TRAZAS) System.err.println(titulo + msn);
		//		escribirFichero(PATH_LOGS + "\\error.log", msn);
	}
	public void escribirExcepcion(String titulo, String metodo, Exception e){
		if (ACTIVAR_TRAZAS) System.err.println(titulo + metodo + e.getMessage());
		//		escribirFichero(PATH_LOGS + "\\error.log", titulo + metodo + e.getMessage());
	}
	public void escribirTrazas(String titulo, String msn){
		if (ACTIVAR_TRAZAS) System.out.println(titulo + msn);
		//		escribirFichero(PATH_LOGS + "\\trazas.log", msn);
	}

	public void escribirFaltaImagen(String msn){
		if (ACTIVAR_TRAZAS) System.out.println(msn);
		escribirFichero(PATH_LOGS + "\\noExisteLaImagen.log", msn);
	}
	/**
	 * Funcion que escribe en un fichero de texto
	 */
	public void escribirFichero(String path, String dato)
	{
		FileWriter fichero = null;
		PrintWriter pw = null;
		try
		{
			fichero = new FileWriter(path,true);
			pw = new PrintWriter(fichero);

			pw.write(dato + "\n");

		} catch (Exception e) {
			System.err.println(e.getMessage());
		} finally {
			try {
				if (null != fichero)
					fichero.close();
			} catch (Exception e2) {
			}
		}
	}
	/**
	 * Funcion que lee de un fichero de texto
	 */
	public String leerFichero(String path, String datoLeer){
		String datoLeido="";
		//TODO implementar esta parte
		return datoLeido;
	}
	/**
	 * Obtenemos el path de la imagen de la moneda a mostrar, si no existe, lo dejamos en un log y ponemos una imagen por defecto.
	 */
	public String obtenerPathImagen(String ruta, String nombre, String extension){
		String path = "";
		try{
			path= PATH_PC + File.separator 
					+ constantesMonedas.PATH_MONEDAS + File.separator
					+ ruta + File.separator					
					+ nombre + extension;

			File imgFile = new  File(path);
			if(!imgFile.exists()){
				//Informamos de que no existe esta moneda
				escribirFaltaImagen(path);
				//Ponemos la imagen por defecto
				path = PATH_PC + File.separator 
						+ constantesMonedas.PATH_MONEDAS + File.separator				
						+ constantesMonedas.IMAGEN_BASE + constantesMonedas.IMAGEN_PATH_PNG;
			}
		}
		catch (Exception e) {}

		return path;
	}
	/**
	 *Devuelve la denominacion en euros de una determinada posicion
	 */	
	public String getDenominacion(int pos){
		String aux;
		switch (pos) {
		case 0: aux=constantesDatabase.EURO_1C; break;
		case 1: aux=constantesDatabase.EURO_2C; break;
		case 2: aux=constantesDatabase.EURO_5C; break;
		case 3: aux=constantesDatabase.EURO_10C; break;
		case 4: aux=constantesDatabase.EURO_20C; break;
		case 5: aux=constantesDatabase.EURO_50C; break;
		case 6: aux=constantesDatabase.EURO_1E; break;
		case 7: aux=constantesDatabase.EURO_2E; break;
		default: aux=constantesDatabase.EURO_1C; break;
		}
		return aux;
	}
	/**
	 * Devuelve el literal de los centimos, que se le puede añadir la palaba ' de ' en el caso necesario para construir el dialogo a mostrar
	 */
	public String getDenominacionString(int pos, boolean flag){
		String aux;
		switch (pos) {
		case 0: aux="1 centimo"; break;
		case 1: aux="2 centimos"; break;
		case 2: aux="5 centimos"; break;
		case 3: aux="10 centimos"; break;
		case 4: aux="20 centimos"; break;
		case 5: aux="50 centimos"; break;
		case 6: aux="1 Euro"; break;
		case 7: aux="2 Euros"; break;
		default: aux="1 centimo"; break;
		}

		if (flag) aux=aux+" de ";
		return aux;
	}

	/**
	 * 
	 */
	public int getContinente(String continente){
		//TODO ver como hacer esto

		return 0;
	}
	/**
	 * Obtenemos el path donde se esta almacenada toda la informacion relacionada con las monedas.
	 * @return
	 */
	public static String getPath() {
		return PATH_PC;
	}
	
	/**
	 * 
	 */
	private boolean readFileValoresY(){
		boolean noError=true;

		String cadena;
		FileReader f;
		try {
			f = new FileReader(PATH_FILE_Y);
			BufferedReader b = new BufferedReader(f);
			while((cadena = b.readLine())!=null) {
				listaMonedasY.add(cadena);
			}
			b.close();
		} catch (IOException e) {}
		return noError;
	}
	public boolean esY(String pais){
		if (pais==null || listaMonedasY.size()<0) return false;

		int i=0;
		boolean fin=false;
		while (!fin && i<listaMonedasY.size()){
			if (listaMonedasY.get(i).equals(pais)) fin =true;
			else i++;
		}
		return fin;
	}
}
