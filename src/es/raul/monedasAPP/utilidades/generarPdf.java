package es.raul.monedasAPP.utilidades;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import es.raul.monedas.constantes.constantesMonedas;
import es.raul.monedas.objetos.mundo.moneda;

public class generarPdf {
	private final static String NOMBRE_CLASS="generarPdf   ";
	private final static String PATH_PDF =  utils.getPath() + File.separator + constantesMonedas.PATH_MONEDAS + File.separator + "Pdfs"+ File.separator;
	private final static String PATH_IMA =  utils.getPath() + File.separator + constantesMonedas.PATH_MONEDAS + File.separator;
	//
	private utils util = utils.getInstance();
	//lecturas de la DB
	private lecturasDB lectura = new lecturasDB();

	//
	private String pais;
	private int tipo;

	public static void main(String[] a3d)  {
		generarPdf prueba = new generarPdf();
		prueba.setPais("Marruecos");
		prueba.setTipo(3);
		prueba.generarElPdf();
	}

	public generarPdf() {
		this.pais="";
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public void generarElPdf(){
		boolean error=false;
		switch (tipo) {
		case constantesMonedas.TIPO_EURO:
		{
			util.escribirTrazas(NOMBRE_CLASS,"generarElPdf() No esta implementado este tipo");
			break;
		}
		case constantesMonedas.TIPO_MUNDO:
		{
			error=generarPdfMonedasMundo();
			break;
		}
		case constantesMonedas.TIPO_PESETA:
		{
			util.escribirTrazas(NOMBRE_CLASS,"generarElPdf() No esta implementado este tipo");
			break;
		}
		case constantesMonedas.TIPO_BILLETE:
		{
			util.escribirTrazas(NOMBRE_CLASS,"generarElPdf() No esta implementado este tipo");
			break;
		}
		default:{
			util.escribirTrazas(NOMBRE_CLASS,"generarElPdf() No esta definido el tipo");
			break;
		}
		}

		if (error) JOptionPane.showMessageDialog(null,"Error en la generacion del pdf");
		else JOptionPane.showMessageDialog(null, "PDf generado correctamente");

	}
	private boolean generarPdfMonedasMundo(){
		boolean error =false;
		String ruta = PATH_PDF + pais + constantesMonedas.IMAGEN_PATH_PDF;
		util.escribirTrazas(NOMBRE_CLASS,"generarPdfMonedasMundo--> INICIO, con ruta" + ruta);
		FileOutputStream archivo;
		Document documento = null;
		try {
			archivo = new FileOutputStream(ruta);
			documento = new Document();
			PdfWriter.getInstance(documento, archivo);
			documento.open();
			//Leemos la informacion de las monedas del pais
			List<moneda> datosMonedas= lectura.DBLeerMoneda(pais);
			//Valor del titulo
			documento.add(new Paragraph("MONEDAS DE " + pais.toUpperCase() + " QUE TENGO"));
			documento.add(new Paragraph("    "));

			//Generamos la informacion
			Image imagen;
			String info;
			moneda moneda;
			Paragraph texto;
			for (int i=0;i<datosMonedas.size();i++){
				moneda = datosMonedas.get(i);
				//Incluimos la informacion
				info= "KM#" + moneda.getKmMoneda() + " -- " + moneda.getDenominacionMoneda().toString();
				util.escribirTrazas(NOMBRE_CLASS,"generarPdfMonedasMundo--> informacion de la moneda" + info);
				texto = new Paragraph(info);
				documento.add(texto);
				//Incluimos la imagen
				String val = PATH_IMA + moneda.getRutaImagen();
				util.escribirTrazas(NOMBRE_CLASS,"generarPdfMonedasMundo--> ruta imagen moneda" + val);
				imagen = Image.getInstance(val);  
				documento.add(imagen);
			}
			//Informacion del dia de la generacion
			documento.add(new Paragraph("    "));
			DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			documento.add(new Paragraph("generado --> " + sdf.format(new Date())));
			error =false;
		} catch (FileNotFoundException e) {
			error =true;
			util.escribirError(NOMBRE_CLASS,"generarPdfMonedasMundo--> No se encuentra el fichero: "+ e.getMessage());
		} catch (DocumentException e) {
			error =true;
			util.escribirError(NOMBRE_CLASS,"generarPdfMonedasMundo--> DocumentException: "+ e.getMessage());
		} catch (MalformedURLException e) {
			error =true;
			util.escribirError(NOMBRE_CLASS,"generarPdfMonedasMundo--> MalformedURLException: "+ e.getMessage());
		} catch (IOException e) {
			error =true;
			util.escribirError(NOMBRE_CLASS,"generarPdfMonedasMundo--> IOException : "+ e.getMessage());
		}catch (Exception e) {
			error =true;
			util.escribirError(NOMBRE_CLASS,"generarPdfMonedasMundo--> Exception general : "+ e.getMessage());
		}
		finally{
			if (documento!=null) documento.close();
		}
		util.escribirTrazas(NOMBRE_CLASS,"generarPdfMonedasMundo--> FIN");
		return error;
	}
}
