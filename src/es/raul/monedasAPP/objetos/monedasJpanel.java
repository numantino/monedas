package es.raul.monedasAPP.objetos;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;

import es.raul.monedas.constantes.constantesLiterales;
import es.raul.monedas.constantes.constantesMonedas;
import es.raul.monedas.objetos.euros.monedaEuro;
import es.raul.monedas.objetos.euros.monedaEuroCon;
import es.raul.monedasAPP.vista_infoMonedas;
import es.raul.monedasAPP.vista_infoMonedasPeseta;
import es.raul.monedasAPP.utilidades.lecturasDB;
import es.raul.monedasAPP.utilidades.utils;

/**
 * Clase encargada de crear el JPanel con las botones donde se muestran las monedas y una pequeña informacion
 *
 */
public class monedasJpanel extends JPanel {

	private final static String NOMBRE_CLASS="monedasJpanel";

	//Botones
	private JButton btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9;
	private JButton btnAtras;
	private JButton btnOpcional;
	private JButton btnAdelante;
	private List<JButton> listaBotonesLayout = new ArrayList<JButton>();

	//Label
	private JLabel label_1,label_2,label_3,label_4,label_5,label_6,label_7,label_8,label_9;	
	private JLabel informacioPagina;
	private List<JLabel> listaLabelLayout = new ArrayList<JLabel>();

	//posicion en la que nos encontramos
	private int posicion=0;
	//Tipo de moneda
	private int tipo=0;
	//lista de monedas con la informacion necesaria para poder mostrar la moneda y en un posible "click" la informacion de esta
	private informacionJPanelMonedas listaCompleta;

	//Maximo numero de botones que se pueden mostrar
	private int MAX_BOTONES=9;

	//objetos necesario para la lectura de la DB
	private lecturasDB lectura = new lecturasDB();
	private utils util = utils.getInstance();


	/**
	 * Create the panel.
	 */
	public monedasJpanel() {

		informacioPagina = new JLabel("");

		btn1 = new JButton("");
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				botonPulsado(1);
			}
		});
		listaBotonesLayout.add(btn1);

		btn2 = new JButton("");
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				botonPulsado(2);
			}
		});
		listaBotonesLayout.add(btn2);

		btn3 = new JButton("");
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				botonPulsado(3);
			}
		});
		listaBotonesLayout.add(btn3);

		btn4 = new JButton("");
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				botonPulsado(4);
			}
		});
		listaBotonesLayout.add(btn4);

		btn5 = new JButton("");
		btn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				botonPulsado(5);
			}
		});
		listaBotonesLayout.add(btn5);

		btn6 = new JButton("");
		btn6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				botonPulsado(6);
			}
		});
		listaBotonesLayout.add(btn6);

		btn7 = new JButton("");
		btn7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				botonPulsado(7);
			}
		});
		listaBotonesLayout.add(btn7);

		btn8 = new JButton("");
		btn8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				botonPulsado(8);
			}
		});
		listaBotonesLayout.add(btn8);

		btn9 = new JButton("");
		btn9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				botonPulsado(9);
			}
		});
		listaBotonesLayout.add(btn9);

		//Boton ATRAS
		btnAtras = new JButton(constantesLiterales.BOTON_ANTERIOR);
		btnAtras.setVisible(false);
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				botonAtrasPulsado();
			}
		});

		//Boton OPCIONAL
		btnOpcional = new JButton(constantesLiterales.BOTON_CONMEMORATIVO);
		btnOpcional.setVisible(false);
		btnOpcional.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				botonEuroConmemorativo();
			}
		});

		//Boton ADELANTE
		btnAdelante = new JButton(constantesLiterales.BOTON_SIGUIENTE);
		btnAdelante.setVisible(false);
		btnAdelante.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				botonSiguientePulsado();
			}
		});

		//INFORMACION
		label_1 = new JLabel("");	
		listaLabelLayout.add(label_1);
		label_2 = new JLabel("");		
		listaLabelLayout.add(label_2);
		label_3 = new JLabel("");
		listaLabelLayout.add(label_3);
		label_4 = new JLabel("");		
		listaLabelLayout.add(label_4);
		label_5 = new JLabel("");		
		listaLabelLayout.add(label_5);
		label_6 = new JLabel("");		
		listaLabelLayout.add(label_6);
		label_7 = new JLabel("");	
		listaLabelLayout.add(label_7);
		label_8 = new JLabel("");
		listaLabelLayout.add(label_8);
		label_9 = new JLabel("");		
		listaLabelLayout.add(label_9);


		//LAYOUT
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(informacioPagina, GroupLayout.DEFAULT_SIZE, 674, Short.MAX_VALUE)
				.addGroup(groupLayout.createSequentialGroup()
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
										.addComponent(btn1, GroupLayout.PREFERRED_SIZE, 217, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(btn2, GroupLayout.PREFERRED_SIZE, 217, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(btn3, GroupLayout.PREFERRED_SIZE, 217, GroupLayout.PREFERRED_SIZE))
										.addGroup(groupLayout.createSequentialGroup()
												.addComponent(btn4, GroupLayout.PREFERRED_SIZE, 217, GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(btn5, GroupLayout.PREFERRED_SIZE, 217, GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(btn6, GroupLayout.PREFERRED_SIZE, 217, GroupLayout.PREFERRED_SIZE))
												.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
														.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
																.addComponent(btnAtras, GroupLayout.PREFERRED_SIZE, 218, GroupLayout.PREFERRED_SIZE)
																.addComponent(btn7, GroupLayout.PREFERRED_SIZE, 218, GroupLayout.PREFERRED_SIZE))
																.addPreferredGap(ComponentPlacement.RELATED)
																.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
																		.addGroup(groupLayout.createSequentialGroup()
																				.addComponent(btn8, GroupLayout.PREFERRED_SIZE, 217, GroupLayout.PREFERRED_SIZE)
																				.addPreferredGap(ComponentPlacement.RELATED)
																				.addComponent(btn9, GroupLayout.PREFERRED_SIZE, 217, GroupLayout.PREFERRED_SIZE))
																				.addGroup(groupLayout.createSequentialGroup()
																						.addComponent(btnOpcional, GroupLayout.PREFERRED_SIZE, 217, GroupLayout.PREFERRED_SIZE)
																						.addPreferredGap(ComponentPlacement.RELATED)
																						.addComponent(btnAdelante, GroupLayout.PREFERRED_SIZE, 217, GroupLayout.PREFERRED_SIZE))))
																						.addGroup(groupLayout.createSequentialGroup()
																								.addGap(29)
																								.addComponent(label_7, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE)
																								.addGap(73)
																								.addComponent(label_8, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE)
																								.addPreferredGap(ComponentPlacement.RELATED, 95, Short.MAX_VALUE)
																								.addComponent(label_9, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE)
																								.addGap(35))
																								.addGroup(groupLayout.createSequentialGroup()
																										.addGap(24)
																										.addComponent(label_4, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE)
																										.addGap(70)
																										.addComponent(label_5, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE)
																										.addPreferredGap(ComponentPlacement.RELATED, 94, Short.MAX_VALUE)
																										.addComponent(label_6, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE)
																										.addGap(44))
																										.addGroup(groupLayout.createSequentialGroup()
																												.addGap(26)
																												.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE)
																												.addGap(82)
																												.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE)
																												.addPreferredGap(ComponentPlacement.RELATED, 79, Short.MAX_VALUE)
																												.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE)
																												.addGap(45)))
																												.addContainerGap())
				);
		groupLayout.setVerticalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
						.addComponent(informacioPagina)
						.addGap(18)
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(btn2, GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE)
								.addComponent(btn1, GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE)
								.addComponent(btn3, GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
										.addComponent(label_1)
										.addComponent(label_2)
										.addComponent(label_3))
										.addPreferredGap(ComponentPlacement.RELATED)
										.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
												.addComponent(btn5, GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE)
												.addComponent(btn4, GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE)
												.addComponent(btn6, GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE))
												.addPreferredGap(ComponentPlacement.RELATED)
												.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
														.addComponent(label_4)
														.addComponent(label_5)
														.addComponent(label_6))
														.addPreferredGap(ComponentPlacement.RELATED)
														.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
																.addComponent(btn8, GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE)
																.addComponent(btn7, GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE)
																.addComponent(btn9, GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE))
																.addPreferredGap(ComponentPlacement.RELATED)
																.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
																		.addComponent(label_7)
																		.addComponent(label_8)
																		.addComponent(label_9))
																		.addPreferredGap(ComponentPlacement.RELATED)
																		.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
																				.addComponent(btnAdelante, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
																				.addComponent(btnOpcional, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
																				.addComponent(btnAtras, GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE))
																				.addContainerGap())
				);
		setLayout(groupLayout);

	}

	/**
	 * Muestra la informacion de las monedas EURO conmemorativas
	 */
	protected void botonEuroConmemorativo() {
		String pais=listaCompleta.getValorAux();
		util.escribirTrazas(NOMBRE_CLASS,"botonEuroConmemorativo() "+pais);

		List<monedaEuroCon> nombreMonedaCon = lectura.DBLeerMonedaEuroCon(pais);
		informacionJPanelMonedas valorFinal = new informacionJPanelMonedas();

		String fechaAnterior="";
		int posImagen=2;
		for (int i = 0; i < nombreMonedaCon.size(); ++i)
		{	
			String fecha=nombreMonedaCon.get(i).getFecha();
			String aux="";

			//Controlamos si existe mas de una moneda del mismo año
			if (fecha.equalsIgnoreCase(fechaAnterior)) aux="_"+(posImagen++);
			else posImagen=2;

			String patImagen=pais.replace(" ","") + "_" + fecha + aux;
			informacionBotonMoneda mo = new informacionBotonMoneda(fecha,patImagen,false, pais);
			mo.setValorAux(nombreMonedaCon.get(i).getDescripcion());
			valorFinal.setComponenteLista(mo);
			fechaAnterior=fecha;
		}

		valorFinal.setTitulo(constantesLiterales.TXT_MONEDA_CONMEMORATIVA + pais);
		posicion=0;
		tipo=constantesMonedas.TIPO_EURO_CON;

		pinarBotones(valorFinal);
	}

	/**
	 * Accion al pulsar el boton siguinte
	 */
	protected void botonSiguientePulsado() {
		switch (tipo) {
		case constantesMonedas.TIPO_EURO:
		{
			if (posicion+monedaEuro.MAX_MONEDAS_ERUROS < listaCompleta.getLista().size())
				posicion=posicion+monedaEuro.MAX_MONEDAS_ERUROS;
			break;
		}
		default:{
			if (posicion+MAX_BOTONES < listaCompleta.getLista().size()) posicion=posicion+MAX_BOTONES;
		}
		}

		pinarBotones(listaCompleta);
	}

	/**
	 * Accion al pulsar el boton anterior
	 */
	protected void botonAtrasPulsado() {
		switch (tipo) {
		case constantesMonedas.TIPO_EURO:
		{
			if (posicion-monedaEuro.MAX_MONEDAS_ERUROS >=0) posicion=posicion-monedaEuro.MAX_MONEDAS_ERUROS;
			break;
		}
		default:{
			if (posicion-MAX_BOTONES >=0) posicion=posicion-MAX_BOTONES;
			break;
		}
		}

		pinarBotones(listaCompleta);
	}

	/**
	 * Accion al pulsar el boton donde esta la imagen
	 * @param i
	 */
	private void botonPulsado(int i) {
		util.escribirTrazas(NOMBRE_CLASS,"Se a pulsado el boton="+i);

		try{
			switch (tipo) {
			case constantesMonedas.TIPO_EURO:
			{
				/** Si pulsamos el boton y la moneda no la tenemos, entonces se muestra un mensaje para incluir la moneda en la coleccion */
				if (listaCompleta!=null){
					if (!listaCompleta.getLista().get((posicion+i)-1).isTengoMonedaEuro()){
						//Incluimos un mensaje de confirmacion para
						int reply = JOptionPane.showConfirmDialog(null, constantesLiterales.TXT_MSN_MODIFICAR, "", JOptionPane.YES_NO_OPTION);
						if (reply == JOptionPane.YES_OPTION){
							util.escribirTrazas(NOMBRE_CLASS, constantesLiterales.TXT_MSN_MODIFICAR_1 + listaCompleta.getValorAux() + constantesLiterales.TXT_MSN_MODIFICAR_2 + util.getDenominacion(i-1));
							lectura.DBIncluirMonedaEuro(listaCompleta.getValorAux(), util.getDenominacion(i-1));
							//Refrescamos la informacion
							listaCompleta.getLista().get((posicion+i)-1).setTengoMonedaEuro();
							pinarBotones(listaCompleta);
						}
					}
				}
				break;
			}
			case constantesMonedas.TIPO_EURO_CON:{
				break;
			}
			case constantesMonedas.TIPO_MUNDO:{
				/** Si pulsamos el boton y hay una moneda, lanzamos ventana para mostar la informacion detallada de la moneda
				 *  Si pulsamos el boton y no hay una moneda, realizaremos la accion para insertar una nueva moneda*/
				if (listaCompleta.getLista().size()>i-1){
					mostrarInformacionDetalladaMoneda(listaCompleta.getLista().get(posicion+i-1));	
				}
				else if (listaCompleta.getLista().size()==i-1){
					int reply = JOptionPane.showConfirmDialog(null, constantesLiterales.TXT_MSN_INSERTAR_MONEDA, "", JOptionPane.YES_NO_OPTION);
					if (reply == JOptionPane.YES_OPTION){
						util.escribirTrazas(NOMBRE_CLASS,"Se va ha incluir una nueva moneda (NO IMPLEMENTADO)");
						//TODO esto faltaria por implementa
					}
				} 
				break;
			}
			case constantesMonedas.TIPO_PESETA:{
				if (listaCompleta.getLista().size()>i-1){
					mostrarInformacionDetalladaMoneda(listaCompleta.getLista().get(posicion+i-1));
				}
				break;
			}
			case constantesMonedas.TIPO_BILLETE:{
				if (listaCompleta.getLista().size()>i-1){
					mostrarInformacionDetalladaMoneda(listaCompleta.getLista().get(posicion+i-1));
				}
				else if (listaCompleta.getLista().size()==i-1){
					int reply = JOptionPane.showConfirmDialog(null, constantesLiterales.TXT_MSN_INSERTAR_BILLETE, "", JOptionPane.YES_NO_OPTION);
					if (reply == JOptionPane.YES_OPTION){
						util.escribirTrazas(NOMBRE_CLASS,"Se va ha incluir un nuevo billete");
						//TODO insertar un nuevo billete
					}
				} 
				break;
			}
			default:
				break;
			}
		}catch(Exception e){}
	}
	/**
	 * Modificar el tipo de moneda que se esta pintando
	 * @param p
	 */
	public void setTipoMoneda(int p){
		util.escribirTrazas(NOMBRE_CLASS,"tipo de boton "+tipo);
		this.tipo=p;
		this.posicion=0;
	}

	/**
	 * Genera la informacion dependiendo de la coleccion en la que nos encontremos
	 * @param listaBotones
	 */
	public void pinarBotones(informacionJPanelMonedas listaBotones) {

		if (listaBotones!=null){
			listaCompleta=listaBotones;
			List<informacionBotonMoneda> lista= listaBotones.getLista();
			String pathComun=""; //Path donde se encuentran las imagenes
			int maximo=MAX_BOTONES; //numero maximo de botones que vamos a mostrar
			String extension=constantesMonedas.IMAGEN_PATH_PNG; //Extension de la imagen
			Color colorTexto=Color.BLACK; //Indica el color del texto


			//Configuramos las diferentes opciones de configuracion dependiendo del tipo de moneda
			switch (tipo) {
			case constantesMonedas.TIPO_EURO:
			{
				pathComun=constantesMonedas.PATH_EURO;
				maximo=monedaEuro.MAX_MONEDAS_ERUROS;
				extension=constantesMonedas.IMAGEN_PATH_GIF;

				//Borramos el boton nueve
				label_9.setText("");
				btn9.setIcon(new ImageIcon(""));
				btn9.setBackground(Color.GRAY);
				break;
			}
			case constantesMonedas.TIPO_EURO_CON:
			{
				pathComun=constantesMonedas.PATH_EURO_CON;
				extension=constantesMonedas.IMAGEN_PATH_JPG;
				break;
			}
			case constantesMonedas.TIPO_MUNDO:
			{
				//No tiene ninguna caracteristica especial
				break;
			}
			case constantesMonedas.TIPO_PESETA:
			{
				pathComun=constantesMonedas.PATH_PESETAS;
				colorTexto=Color.RED;
				break;
			}
			case constantesMonedas.TIPO_BILLETE:
			{
				pathComun=constantesMonedas.PATH_BILLETES;
				break;
			}
			default:
				break;
			}


			//************ COMUN *********************************************************************************************************************************
			//Ponemos el titulo
			informacioPagina.setText(listaBotones.getTitulo());

			//Habilitamos el boton de monedas conmemorativas si es el caso
			btnOpcional.setVisible(listaBotones.isEsConmemorativa());


			//Pintamos los botones
			for(int i=0; i<maximo; i++){
				JButton boton = listaBotonesLayout.get(i);
				JLabel label = listaLabelLayout.get(i);
				try{
					boton.setIcon(getPathMoneda(pathComun,lista.get(posicion+i).getPathImagen(),extension,boton.getSize().width, boton.getSize().height));
					label.setText(lista.get(posicion+i).getNombre());
					if (lista.get(posicion+i).isTengoMonedaEuro()) boton.setBackground(Color.GREEN);
					else boton.setBackground(Color.RED);
					if (tipo==constantesMonedas.TIPO_EURO_CON) boton.setToolTipText(lista.get(posicion+i).getValorAux()); 
					label.setForeground(colorTexto);
				}
				catch(Exception e){
					util.escribirError(NOMBRE_CLASS,"error boton "+i);
					label.setText("");
					boton.setIcon(new ImageIcon(""));
					boton.setBackground(Color.GRAY);
				}
			}

			//Habilitamos/deshabilitamos botones de delante/detras  
			int numeroPantallasMonedas = lista.size() / maximo;
			if ((lista.size() % maximo)>0) numeroPantallasMonedas++;
			
			if (numeroPantallasMonedas == 1){
				btnAdelante.setVisible(false);	
				btnAtras.setVisible(false);
			}
			else {
				if (posicion == 0){
					btnAdelante.setVisible(true);	
					btnAtras.setVisible(false);
				}
				else if (((posicion / maximo) +1 ) == numeroPantallasMonedas){
					btnAdelante.setVisible(false);	
					btnAtras.setVisible(true);
				}
				else{
					btnAdelante.setVisible(true);
					btnAtras.setVisible(true);
				}
			}
		}
	}

	/**
	 * Obtiene la ruta de la imagen y en el caso de que sea necesario la renderiza, si no exite pone una por defecto y lo deja en un log
	 * @param ruta
	 * @param nombre
	 * @param extension
	 * @param ancho
	 * @param alto
	 * @return
	 */
	public ImageIcon getPathMoneda(String ruta, String nombre, String extension, int ancho, int alto){
		String path = util.obtenerPathImagen(ruta, nombre, extension);
		util.escribirTrazas(NOMBRE_CLASS,"Path imagen: " + path);

		ImageIcon imagenOriginal = new ImageIcon(path);

		//en el caso del euro dejamos la imagen original porque esta ya dimensionada correctamente para el boton
		if (tipo==constantesMonedas.TIPO_EURO) return imagenOriginal;
		else if (tipo==constantesMonedas.TIPO_PESETA)  return new ImageIcon(imagenOriginal.getImage().getScaledInstance(ancho, alto-15, java.awt.Image.SCALE_DEFAULT));
		else return new ImageIcon(imagenOriginal.getImage().getScaledInstance(ancho, alto, java.awt.Image.SCALE_DEFAULT));
	}

	/**
	 * Limpiar informacion
	 */
	public void limpiarInformacion() {		
		for(int i=0; i<MAX_BOTONES; i++){
			JButton boton = listaBotonesLayout.get(i);
			JLabel label = listaLabelLayout.get(i);

			label.setText("");
			boton.setIcon(new ImageIcon(""));
			boton.setBackground(Color.GRAY);
		}
	}

	/**
	 * lanza una nueva vista con informacion mas detallada de la moneda
	 * @param idMoneda
	 * @param continente
	 */
	private void mostrarInformacionDetalladaMoneda(informacionBotonMoneda info){
		util.escribirTrazas(NOMBRE_CLASS,"mostrarInformacionMonedasMundo() ");

		switch (tipo) {
		case constantesMonedas.TIPO_MUNDO:{			
			vista_infoMonedas v = new vista_infoMonedas();
			v.mostrarMoneda(info.getIdMoneda(), info.getValorAux());			
			v.setVisible(true);
			break;
		}
		case constantesMonedas.TIPO_PESETA:{
			vista_infoMonedasPeseta v = new vista_infoMonedasPeseta();
			v.mostrarMonedaPeseta(info.getIdMoneda(), info.getValorAux());
			v.setVisible(true);
			break;
		}
		default:
			break;
		}
	}
}
