package es.raul.monedasAPP.utilidades;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import es.raul.monedas.constantes.constantesDatabase;
import es.raul.monedas.constantes.constantesMonedas;



public class utils {

	private static utils instancia = new utils();
	
	public final String CONFIGURADOR = "coleccionMonedas.conf";
	
	private Path PATH;
	private Path PATH_PC;
	private List<String> datosY;

	public static utils getInstance () {
		return instancia;
	}
	
	private utils(){
		//Obtenemos el directorio actual
		PATH = Paths.get("").toAbsolutePath();
		System.out.println("PATH="+PATH);
		//Ruta donde se encuentra el proyecto
		String p = leerFichero(PATH,CONFIGURADOR,"PATH_PC");
		if (p.isEmpty()) PATH_PC=PATH;
		else PATH_PC=Paths.get(p);
		//Realizamos lectura de paises Y
		lecturaDatosY();
	}
	/**
	 * Funcion que lee de un fichero de texto
	 */
	public String leerFichero(Path path, String file, String datoLeer){
		String datoLeido="";

		
		String cadena;
		boolean fin=false;
		FileReader f;
		try {
			f = new FileReader(path.toString() + File.separator + file);
			BufferedReader b = new BufferedReader(f);
			while(!fin && (cadena = b.readLine())!=null) {
				String[] parts = cadena.split("=");
				if (parts[0].equalsIgnoreCase(datoLeer)) {
					datoLeido=parts[1];
					fin=true;
				}
			}
			b.close();
		} catch (IOException e) {
			System.err.println("Error leerFichero(" + path.toString() + file + ")" + e);
		}
		return datoLeido;
	}
	/**
	 * Obtenemos el path de la imagen de la moneda a mostrar, si no existe, lo dejamos en un log y ponemos una imagen por defecto.
	 */
	public String obtenerPathImagen(String ruta, String nombre, String extension){
		String path = "";
		try{
			path= PATH_PC
					+ File.separator + "imagenes" + File.separator + ruta + File.separator					
					+ nombre + extension;

			File imgFile = new  File(path);
			if(!imgFile.exists()){
				//Ponemos la imagen por defecto
				path = PATH_PC			
						+ constantesMonedas.IMAGEN_BASE + constantesMonedas.IMAGEN_PATH_PNG;
			}
		}
		catch (Exception e) {
			System.err.println(e);
		}

		return path;
	}
	/**
	 * Obtenemos el path donde se esta almacenada toda la informacion relacionada con las monedas.
	 * @return
	 */
	public String getPath() {
		return PATH_PC.toAbsolutePath().toString() + File.separator;
	}
	public boolean isTrazas() {
		String val = leerFichero(PATH,CONFIGURADOR,"ACTIVAR_TRAZAS").toLowerCase();
		if (val.equalsIgnoreCase("false")) return false;
		else return true;
	}
	private void lecturaDatosY() {
		String datos = leerFichero(PATH,CONFIGURADOR,"VAL_Y");
		datosY = new ArrayList<String>();
		try {
			if (!datos.isEmpty()) {
				String[] parts = datos.split(";");
				for (int i=0; i>parts.length; i++) datosY.add(parts[i]);
			}
		} catch (Exception e) {
			System.err.println(e);
		}
	}
	public boolean esY(String pais) {
		if (datosY.contains(pais)) return true;
		else return false;
	}
	//****************************************** static ***********************************************************
	/**
	 *Devuelve la denominacion en euros de una determinada posicion
	 */	
	public static String getDenominacion(int pos){
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
	public static String getDenominacionString(int pos, boolean flag){
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
}
