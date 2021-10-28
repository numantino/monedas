package es.raul.monedasAPP.utilidades;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;



public class utilLog {

	private static utilLog instancia = new utilLog();
	private String PATH_LOGS;
	private boolean ACTIVAR_TRAZAS;
	
	
	public static utilLog getInstance () {
		return instancia;
	}

	private utilLog(){
		PATH_LOGS = utils.getInstance().getPath() + "logs" + File.separator;
		//Activacion de trazas
		ACTIVAR_TRAZAS=utils.getInstance().isTrazas();
	}


	/**
	 * ************************ TRAZAS ************************
	 */
	public void escribirError(String titulo, String msn){
		escribirFichero(PATH_LOGS + "monedas.error", titulo +" "+ msn);
		System.err.println(titulo + msn);
	}
	public void escribirExcepcion(String titulo, String metodo, Exception e){
		escribirFichero(PATH_LOGS + "monedas.error", titulo +" "+ metodo +" "+ e.getMessage());
		System.err.println(titulo + metodo + e.getMessage());
	}
	public void escribirTrazas(String titulo, String msn){
		if (ACTIVAR_TRAZAS) escribirFichero(PATH_LOGS + "monedas.log", titulo +" "+ msn);
		System.out.println(titulo + msn);
	}

	public void escribirFaltaImagen(String msn){
		escribirFichero(PATH_LOGS + "noExisteLaImagen.log", msn);
		System.out.println(msn);
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
			//comprobamos la existencia del fichero
			File archivo = new File(path);
			if (!archivo.exists()) archivo.createNewFile();
			
			//escribimos la informacion
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
}
