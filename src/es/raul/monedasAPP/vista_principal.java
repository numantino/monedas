package es.raul.monedasAPP;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Collections;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import es.raul.monedas.constantes.constantesDatabase;
import es.raul.monedas.constantes.constantesLiterales;
import es.raul.monedas.constantes.constantesMonedas;
import es.raul.monedas.objetos.euros.listaMonedaEuro;
import es.raul.monedas.objetos.euros.monedaEuro;
import es.raul.monedas.objetos.mundo.moneda;
import es.raul.monedas.objetos.peseta.monedaPeseta;
import es.raul.monedasAPP.objetos.informacionBotonMoneda;
import es.raul.monedasAPP.objetos.informacionJPanelMonedas;
import es.raul.monedasAPP.objetos.monedasJpanel;
import es.raul.monedasAPP.utilidades.generarPdf;
import es.raul.monedasAPP.utilidades.insertarNuevaMoneda;
import es.raul.monedasAPP.utilidades.lecturasDB;
import es.raul.monedasAPP.utilidades.utils;

/**
 * Esta es la vista principal de las monedas, en esta vista se crean los botones fijos de las 
 * diferentes colecciones de monedas.
 * 
 * MUNDO	EUROPA
 * 			AFRICA
 * 			ASIA
 * 			AMERICA DEL NORTE
 * 			AMERICA DEL SUR
 * 			AMERICA CENTRAL
 * 			OCEANIA
 * 
 * EURO
 * PESETAS
 * BILLETES
 * 
 * INFORMACION MONEDAS
 * 
 * 
 * Ademas, dependiendo de la seleccion de la coleccion deseada se crea la lista de los paises o la lista
 * de las sub-colecciones.			
 *
 */
public class vista_principal extends JFrame {

	private final static String NOMBRE_CLASS="vista_principal";
	//Objetos de la vista.
	private JPanel contentPane;
	private monedasJpanel panelMonedas;
	private JPanel panelListado;
	private JButton btGenerarPdf;
	private JButton btnNuevaMoneda;
	private String botonPulsado;
	private String botonPulsadoValue;
	//lecturas de la DB
	private lecturasDB lectura = new lecturasDB();
	private utils util = utils.getInstance();
	//Objeto para generar el pdf
	private generarPdf objetoGenerarPdf = new generarPdf();
	//Objeto para insertar una nueva moneda
	private insertarNuevaMoneda objetoNuevaMoneda = new insertarNuevaMoneda();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					vista_principal frame = new vista_principal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public vista_principal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setTitle(constantesLiterales.STR_NAME_APP + lectura.DBLeerDatosInformacion(constantesDatabase.INFORMACION_ULTIMA_MODIFICACION));
		setBounds(100, 100, 1044, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		
		panelMonedas = new monedasJpanel();
		panelListado = new JPanel();

		//BOTON MONEDAS DE AFRICA
		JButton btnAfrica = new JButton(constantesMonedas.CONTINENTES.AFRICA.getNombre());
		btnAfrica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {	
				util.escribirTrazas(NOMBRE_CLASS,"boton pulsado de AFRICA");	
				botonPulsado=constantesMonedas.CONTINENTES.AFRICA.getNombre();
				botonPulsadoValue = constantesMonedas.CONTINENTES.AFRICA.getNumeroString();
				crearListaBotones(lectura.DBLeerPaisNombres(botonPulsadoValue), constantesMonedas.TIPO_MUNDO);
			}
		});

		//BOTON MONEDAS DE EUROPA
		JButton btnEuropa = new JButton(constantesMonedas.CONTINENTES.EUROPA.getNombre());
		btnEuropa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				util.escribirTrazas(NOMBRE_CLASS,"boton pulsado de EUROPA");	
				botonPulsado=constantesMonedas.CONTINENTES.EUROPA.getNombre();
				botonPulsadoValue = constantesMonedas.CONTINENTES.EUROPA.getNumeroString();
				crearListaBotones(lectura.DBLeerPaisNombres(botonPulsadoValue), constantesMonedas.TIPO_MUNDO);
			}
		});

		//BOTON MONEDAS DE ASIA
		JButton btnAsia = new JButton(constantesMonedas.CONTINENTES.ASIA.getNombre());
		btnAsia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				util.escribirTrazas(NOMBRE_CLASS,"boton pulsado de ASIA");	
				botonPulsado=constantesMonedas.CONTINENTES.ASIA.getNombre();
				botonPulsadoValue = constantesMonedas.CONTINENTES.ASIA.getNumeroString();
				crearListaBotones(lectura.DBLeerPaisNombres(botonPulsadoValue), constantesMonedas.TIPO_MUNDO);
			}
		});

		//BOTON MONEDAS DE AMERICA DEL NORTE
		JButton btnAmNorte = new JButton(constantesMonedas.CONTINENTES.AMERICA_NORTE.getNombre());
		btnAmNorte.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				util.escribirTrazas(NOMBRE_CLASS,"boton pulsado de AMERICA DEL NORTE");
				botonPulsado=constantesMonedas.CONTINENTES.AMERICA_NORTE.getNombre();
				botonPulsadoValue = constantesMonedas.CONTINENTES.AMERICA_NORTE.getNumeroString();
				crearListaBotones(lectura.DBLeerPaisNombres(botonPulsadoValue), constantesMonedas.TIPO_MUNDO);
			}
		});

		//BOTON MONEDAS DE AMERICA DEL SUR
		JButton btnAmSur = new JButton(constantesMonedas.CONTINENTES.AMERICA_SUR.getNombre());
		btnAmSur.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				util.escribirTrazas(NOMBRE_CLASS,"boton pulsado de AMERICA DEL SUR");	
				botonPulsado=constantesMonedas.CONTINENTES.AMERICA_SUR.getNombre();
				botonPulsadoValue = constantesMonedas.CONTINENTES.AMERICA_SUR.getNumeroString();
				crearListaBotones(lectura.DBLeerPaisNombres(botonPulsadoValue), constantesMonedas.TIPO_MUNDO);
			}
		});

		//BOTON MONEDAS DE AMERICA CENTRAL
		JButton btnAmCentral = new JButton(constantesMonedas.CONTINENTES.AMERICA_CENTRAL.getNombre());
		btnAmCentral.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				util.escribirTrazas(NOMBRE_CLASS,"boton pulsado de AMERICA CENTRAL");
				botonPulsado=constantesMonedas.CONTINENTES.AMERICA_CENTRAL.getNombre();
				botonPulsadoValue = constantesMonedas.CONTINENTES.AMERICA_CENTRAL.getNumeroString();
				crearListaBotones(lectura.DBLeerPaisNombres(botonPulsadoValue), constantesMonedas.TIPO_MUNDO);
			}
		});

		//BOTON MONEDAS DE OCEANIA
		JButton btnOceania = new JButton(constantesMonedas.CONTINENTES.OCEANIA.getNombre());
		btnOceania.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				util.escribirTrazas(NOMBRE_CLASS,"boton pulsado de OCEANIA");	
				botonPulsado=constantesMonedas.CONTINENTES.OCEANIA.getNombre();
				botonPulsadoValue = constantesMonedas.CONTINENTES.OCEANIA.getNumeroString();
				crearListaBotones(lectura.DBLeerPaisNombres(botonPulsadoValue), constantesMonedas.TIPO_MUNDO);
			}
		});

		//BOTON COLECCION EUROS
		JButton btnEuros = new JButton(constantesLiterales.BOTON_EUROS);
		btnEuros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				util.escribirTrazas(NOMBRE_CLASS,"boton pulsado de EUROS");	
				crearListaBotones(lectura.DBLeerPaisEuro(), constantesMonedas.TIPO_EURO);
			}
		});

		//BOTON COLECCION PESETAS
		JButton btnPesetas = new JButton(constantesLiterales.BOTON_PESETA);
		btnPesetas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				util.escribirTrazas(NOMBRE_CLASS,"boton pulsado de PESETA");
				crearListaBotones(lectura.DBLeerPeriodosPeseta(), constantesMonedas.TIPO_PESETA);
			}
		});
		
		//BOTON INFORMACION MONEDAS
		JButton btnEstadisticas = new JButton(constantesLiterales.BOTON_INFORMACION);
		btnEstadisticas.setBackground(Color.CYAN);
		btnEstadisticas.setForeground(Color.BLUE);
		btnEstadisticas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				util.escribirTrazas(NOMBRE_CLASS,"boton pulsado de INFORMACION MONEDAS");	
				vista_informacionGeneral v = new vista_informacionGeneral();		
				v.setVisible(true);
			}
		});
		
		btGenerarPdf = new JButton("");
		String rutaIcono = util.getPath() + File.separator 
				+ constantesMonedas.PATH_MONEDAS + File.separator				
				+ constantesMonedas.IMAGEN_ICONO_PDF + constantesMonedas.IMAGEN_PATH_PNG;
		btGenerarPdf.setIcon(new ImageIcon(rutaIcono));
		btGenerarPdf.setVisible(false);
		btGenerarPdf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				objetoGenerarPdf.generarElPdf();
			}
		});
		
		btnNuevaMoneda = new JButton("");
		String rutaIcono2 = util.getPath() + File.separator 
				+ constantesMonedas.PATH_MONEDAS + File.separator				
				+ constantesMonedas.IMAGEN_ICONO_MAS + constantesMonedas.IMAGEN_PATH_PNG;
		btnNuevaMoneda.setIcon(new ImageIcon(rutaIcono2));
		btnNuevaMoneda.setVisible(false);
		btnNuevaMoneda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				objetoNuevaMoneda.insertarMonedaNueva();
			}
		});
		
		JButton btnNuevoPais = new JButton("Nuevo Pais");
		btnNuevoPais.setEnabled(false);
		btnNuevoPais.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				objetoNuevaMoneda.insertarNuevoPaisMoneda();
			}
		});
		btnNuevoPais.setForeground(Color.BLUE);
		btnNuevoPais.setBackground(Color.CYAN);


		//LAYOUT
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
									.addComponent(btnEuropa, GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
									.addComponent(btnAfrica, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(btnAsia, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(btnAmNorte, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(btnAmSur, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(btnAmCentral)
									.addComponent(btnOceania, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
									.addComponent(btnEuros, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
									.addComponent(btnPesetas, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
									.addComponent(btnEstadisticas, 0, 0, Short.MAX_VALUE))
								.addComponent(btnNuevoPais, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(panelListado, GroupLayout.PREFERRED_SIZE, 184, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panelMonedas, GroupLayout.DEFAULT_SIZE, 695, Short.MAX_VALUE)
							.addContainerGap())
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnNuevaMoneda, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btGenerarPdf, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
							.addGap(35))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNuevaMoneda, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btGenerarPdf))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(panelListado, GroupLayout.DEFAULT_SIZE, 612, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnAfrica)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnEuropa)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnAsia)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnAmNorte)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnAmSur)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnAmCentral)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnOceania)
							.addGap(45)
							.addComponent(btnEuros)
							.addGap(27)
							.addComponent(btnPesetas)
							.addGap(84)
							.addComponent(btnEstadisticas)
							.addGap(35)
							.addComponent(btnNuevoPais))
						.addComponent(panelMonedas, GroupLayout.DEFAULT_SIZE, 612, Short.MAX_VALUE))
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
		
		//Limpiamos toda la informacion
		panelListado.removeAll();
		panelMonedas.removeAll();
	}

	/**
	 * Metodo que crea la lista de botones de los paises, colecciones, tipos...
	 */
	private void crearListaBotones(List<String> lista, final int tipo){
		//eliminamos todos los botones creados con anterioridad
		panelListado.removeAll();

		//TODO ver si se puede poner scroll???
		if (lista!=null && lista.size()>0){
			util.escribirTrazas(NOMBRE_CLASS,"crearListaBotones(), Se van a crear " + lista.size() + " botones");
			for (int i=0; i<lista.size();i++){
				final String name = lista.get(i);
				JButton btn = new JButton(name);
				btn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						pintarMonedas(name, tipo);
					}
				});
				panelListado.add(btn);
			}
		}
		else util.escribirTrazas(NOMBRE_CLASS,"crearListaBotones(), No tenemos informacion");

		panelListado.updateUI();
	}

	/**
	 * Metodo que pone las monedas en el JPanel
	 */
	private void pintarMonedas(String valor, int tipo) {
		util.escribirTrazas(NOMBRE_CLASS,"pintarMonedas() con valor="+valor+", tipo="+tipo);
		informacionJPanelMonedas listaBotones = null;
		btGenerarPdf.setVisible(false);
		btnNuevaMoneda.setVisible(false);
		
		//Ponemos el tipo de moneda
		panelMonedas.setTipoMoneda(tipo);
		
		//Creamos la lista de los objetos a mostrar
		switch (tipo) {
		case constantesMonedas.TIPO_EURO:
		{
			listaBotones=crearObjetoMonedasEuro(valor);
			break;
		}
		case constantesMonedas.TIPO_MUNDO:
		{
			btGenerarPdf.setVisible(true); //TODO solo por el momento
			objetoGenerarPdf.setPais(valor);
			objetoGenerarPdf.setTipo(tipo);
			
			btnNuevaMoneda.setVisible(true);
			objetoNuevaMoneda.setNuevoPais(valor);
			objetoNuevaMoneda.setNuevoContinente(botonPulsado);
			
			listaBotones=crearObjetoMonedasMundo(valor);
			break;
		}
		case constantesMonedas.TIPO_PESETA:
		{
			listaBotones=crearObjetoMonedasPeseta(valor);
			break;
		}
		case constantesMonedas.TIPO_BILLETE:
		{
			listaBotones=crearObjetoBilletes();
			break;
		}
		default:{
			util.escribirTrazas(NOMBRE_CLASS,"pintarMonedas() No esta definido el tipo");
			break;
			}
		}
		
		if (listaBotones!=null) panelMonedas.pinarBotones(listaBotones);
		else panelMonedas.limpiarInformacion();
		
		panelMonedas.updateUI();
	}
	
	/**
	 * Crea la estructuras de las diferentes monedas de peseta
	 */
	private informacionJPanelMonedas crearObjetoMonedasPeseta(String periodo) {
		util.escribirTrazas(NOMBRE_CLASS,"crearObjetoMonedasPeseta() INICIO");
		List<monedaPeseta> nombreMoneda;
		informacionJPanelMonedas valorFinal = new informacionJPanelMonedas();
		try {
			//obtenemos de la DB las diferentes monedas
			nombreMoneda =lectura.DBLeerPeseta(periodo);
			Collections.sort(nombreMoneda);
			
			if (nombreMoneda!=null && nombreMoneda.size()>0){
				valorFinal.setTipo(constantesMonedas.TIPO_PESETA);
				valorFinal.setEsConmemorativa(false);
				valorFinal.setTitulo(constantesLiterales.TXT_MONEDA_PESETA + periodo);
				
				for (int i = 0; i < nombreMoneda.size(); ++i)
				{		
					monedaPeseta mo = nombreMoneda.get(i);
					String patImagen = ""+mo.getIdMoneda();
					String nombre = mo.getvalorMoneda();
					valorFinal.setComponenteLista(new informacionBotonMoneda(nombre,patImagen,mo.getIdMoneda(),"",mo.isTengoMoneda()));
				}
			}
			else util.escribirTrazas(NOMBRE_CLASS,"crearObjetoMonedasPeseta() no tenemos informacion");
		} 
		catch (Exception e) {
			util.escribirError(NOMBRE_CLASS,"Exception en crearObjetoMonedasPeseta(), " + e.toString());			
		}

		return valorFinal;
	}

	/**
	 * Nos muestra la lista de billetes
	 */
	private informacionJPanelMonedas crearObjetoBilletes() {
		util.escribirTrazas(NOMBRE_CLASS,"crearObjetoBilletes() INICIO");

//		List<billete> nombreBilletes;
		informacionJPanelMonedas valorFinal = new informacionJPanelMonedas();
//		try {
//			//obtenemos de la DB las diferentes monedas
//			nombreBilletes = lectura.DBLeerBilletes();
//
//			if (nombreBilletes!=null && nombreBilletes.size()>0){
//				valorFinal.setTipo(constantesMonedas.TIPO_BILLETE);
//				valorFinal.setEsConmemorativa(false);
//				valorFinal.setTitulo(constantesLiterales.TXT_MONEDA_BILLETE + constantesLiterales.INFO_SEPARADOR + nombreBilletes.size() + constantesLiterales.INFO_BILLETES);
//				
//				for (int i = 0; i < nombreBilletes.size(); ++i)
//				{		
//					billete mo = nombreBilletes.get(i);
//					String patImagen = Integer.toString(mo.getID());
//					valorFinal.setComponenteLista(new informacionBotonMoneda(mo.toString(),patImagen,mo.getID(),mo.getDescripcion(),false));
//				}
//			}
//			else util.escribirTrazas(NOMBRE_CLASS,"crearObjetoBilletes() no tenemos informacion");
//		} 
//		catch (Exception e) {
//			util.escribirError(NOMBRE_CLASS,"Exception en crearObjetoBilletes(), " + e.toString());			
//		}

		return valorFinal;
	}
	
	/**
	 * Nos muestra la lista de monedas
	 */
	private informacionJPanelMonedas crearObjetoMonedasMundo(String pais) {
		util.escribirTrazas(NOMBRE_CLASS,"crearObjetoMonedasMundo() INICIO");
		List<moneda> nombreMoneda;
		informacionJPanelMonedas valorFinal = new informacionJPanelMonedas();
		
		try {
			//obtenemos de la DB las diferentes monedas
			nombreMoneda = lectura.DBLeerMoneda(pais); 
			Collections.sort(nombreMoneda);

			if (nombreMoneda!=null){
				valorFinal.setTipo(constantesMonedas.TIPO_MUNDO);
				valorFinal.setEsConmemorativa(false);
				valorFinal.setTitulo(pais.toUpperCase() + "   -->   " + nombreMoneda.size() + " monedas");
				
				for (int i = 0; i < nombreMoneda.size(); ++i)
				{		
					moneda mo = nombreMoneda.get(i);
					String patImagen = botonPulsado + File.separator + mo.getIdMoneda();
					valorFinal.setComponenteLista(new informacionBotonMoneda(mo.getDenominacionMoneda().toString(),patImagen,mo.getIdMoneda(),botonPulsado,false));
				}
			}
			else util.escribirTrazas(NOMBRE_CLASS,"crearObjetoMonedasMundo() no tenemos informacion");
		} 
		catch (Exception e) {
			util.escribirError(NOMBRE_CLASS,"Exception en crearObjetoMonedasMundo(), " + e.toString());			
		}

		return valorFinal;
	}
	/**
	 * Nos muestra la lista de monedas de EURO
	 */
	private informacionJPanelMonedas crearObjetoMonedasEuro(final String pais) {
		util.escribirTrazas(NOMBRE_CLASS,"crearObjetoMonedasEuro() INICIO");
		List<listaMonedaEuro> listaEuros;
		informacionJPanelMonedas valorFinal = new informacionJPanelMonedas();

		try {
			//obtenemos de la DB las diferentes monedas
			listaEuros = lectura.DBLeerMonedaEuro(pais);

			if (listaEuros!=null && listaEuros.size()>0){
				boolean conmemorativa=false;
				valorFinal.setTipo(constantesMonedas.TIPO_EURO);
				
				for (int ii=0;ii<listaEuros.size();ii++){
					listaMonedaEuro nombreMoneda = listaEuros.get(ii);
					monedaEuro mo = nombreMoneda.getMonedasEuros(0);
					
					if (nombreMoneda.isTieneConmemorativas()) conmemorativa=true;

					for (int i = 0; i < monedaEuro.MAX_MONEDAS_ERUROS; ++i)
					{		
						String aux="";
						if (ii>0)aux=""+(ii+1);
						String patImagen=pais.replace(" ","") + aux + "_" + monedaEuro.euroDenominacion[i];
						valorFinal.setComponenteLista(new informacionBotonMoneda(util.getDenominacionString(i,false),patImagen,mo.isTengoMoneda(i),pais.replace(" ","")));
					}
				}	
				
				valorFinal.setEsConmemorativa(conmemorativa);
				
				//Titulo que se va a mostrar en la cabecera
				valorFinal.setTitulo(constantesLiterales.TXT_MONEDA_EURO + pais);
				valorFinal.setValorAux(pais);
			}
			else util.escribirTrazas(NOMBRE_CLASS,"crearObjetoMonedasEuro() no tenemos informacion");
		} 
		catch (Exception e) {
			util.escribirError(NOMBRE_CLASS,"Exception en crearObjetoMonedasEuro(), " + e.toString());			
		}
		
		return valorFinal;
	}
}
