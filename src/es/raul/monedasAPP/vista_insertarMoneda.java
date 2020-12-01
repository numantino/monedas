package es.raul.monedasAPP;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import es.raul.monedas.constantes.constantesLiterales;
import es.raul.monedas.constantes.constantesMonedas;
import es.raul.monedas.objetos.mundo.denominacion;
import es.raul.monedas.objetos.mundo.informacionMoneda;
import es.raul.monedas.objetos.mundo.localizacion;
import es.raul.monedas.objetos.mundo.monedaExt;
import es.raul.monedasAPP.objetos.imagenJpanel;
import es.raul.monedasAPP.utilidades.lecturasDB;
import es.raul.monedasAPP.utilidades.utilLog;
import es.raul.monedasAPP.utilidades.utils;


/**
 * Muestra la informacion detallada de las monedas del mundo
 * 
 * 
 * 
 *
 */
public class vista_insertarMoneda extends JFrame {

	private final static String NOMBRE_CLASS="vista_infoMonedas";

	private JPanel contentPane;

	//Imagen completa de la moneda
	private static imagenJpanel panelImagen;

	//Informacion de la moneda o datos a ingresar
	private List<JTextField> listaTextLayout = new ArrayList<JTextField>();
	private static JTextField textTitulo;
	private static JTextField textID;
	private static JTextField textKM;
	private static JTextField textValor;
	private static JTextField textComposicion;
	private static JTextField textForma;
	private static JTextField textAnverso;
	private static JTextField textAnversoLey;
	private static JTextField textReverso;
	private static JTextField textReversoLey;
	private static JTextField textCanto;
	private static JTextField textCantoLey;
	private static JTextField textEstado;
	private static JTextField textNota;
	private JTextField textPeriodo;

	//Indica lo que es cada uno de los textos mostrados
	private List<JLabel> listaTextJLabel = new ArrayList<JLabel>();
	private JLabel lbID;
	private JLabel lblK;
	private JLabel lblDenominacion;
	private JLabel lblCompesptam;
	private JLabel lblForma;
	private JLabel lblCanto;
	private JLabel lblCantoLey;
	private JLabel lblReverso;
	private JLabel lblReversoLey;
	private JLabel lblAnverso;
	private JLabel lblAnversoLey;
	private JLabel lblNota;
	private JLabel lbPeriodo;

	//Botones
	private JButton btnSalir;
	private JButton btnModificar;

	//Lectura de la DB
	private lecturasDB lectura = new lecturasDB();
	private JTextField textFecha;
	private JLabel lblFecha;


	//
	private localizacion infoInicialMoneda;
	private boolean noExisteKM = false;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					vista_insertarMoneda frame = new vista_insertarMoneda();

					String continente = constantesMonedas.CONTINENTES.AMERICA_SUR.getNombre();
					String pais = "Peru";
					frame.insertarMoneda(continente,pais);
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
	public vista_insertarMoneda() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 796, 466);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		//Eliminamos los botones del JFrame
		setUndecorated(true);
		//Color del fondo
		contentPane.setBackground(Color.BLUE);

		//LABEL
		lbID = new JLabel(constantesLiterales.INFO_MONEDA_ID);
		lbID.setForeground(Color.RED);
		lbID.setFont(new Font("Tahoma", Font.BOLD, 14));
		listaTextJLabel.add(lbID); 

		lblK = new JLabel(constantesLiterales.INFO_MONEDA_K);
		lblK.setForeground(Color.RED);
		lblK.setFont(new Font("Tahoma", Font.BOLD, 14));
		listaTextJLabel.add(lblK);

		lblDenominacion = new JLabel(constantesLiterales.INFO_MONEDA_VALOR);
		lblDenominacion.setForeground(Color.RED);
		lblDenominacion.setFont(new Font("Tahoma", Font.BOLD, 12));
		listaTextJLabel.add(lblDenominacion);

		lblCompesptam = new JLabel(constantesLiterales.INFO_MONEDA_COMPOSICION);
		lblCompesptam.setForeground(Color.RED);
		lblCompesptam.setFont(new Font("Tahoma", Font.BOLD, 10));
		listaTextJLabel.add(lblCompesptam);

		lblForma = new JLabel(constantesLiterales.INFO_MONEDA_FORMA);
		lblForma.setForeground(Color.RED);
		lblForma.setFont(new Font("Tahoma", Font.BOLD, 10));
		listaTextJLabel.add(lblForma);

		lblReverso = new JLabel(constantesLiterales.INFO_MONEDA_REVERSO);
		lblReverso.setForeground(Color.RED);
		lblReverso.setFont(new Font("Tahoma", Font.BOLD, 10));
		listaTextJLabel.add(lblReverso);

		lblReversoLey = new JLabel(constantesLiterales.INFO_MONEDA_REVERSO_L);
		lblReversoLey.setForeground(Color.RED);
		lblReversoLey.setFont(new Font("Tahoma", Font.BOLD, 10));
		listaTextJLabel.add(lblReversoLey);

		lblAnverso = new JLabel(constantesLiterales.INFO_MONEDA_ANVERSO);
		lblAnverso.setForeground(Color.RED);
		lblAnverso.setFont(new Font("Tahoma", Font.BOLD, 10));
		listaTextJLabel.add(lblAnverso);

		lblAnversoLey = new JLabel(constantesLiterales.INFO_MONEDA_ANVERSO_L);
		lblAnversoLey.setForeground(Color.RED);
		lblAnversoLey.setFont(new Font("Tahoma", Font.BOLD, 10));
		listaTextJLabel.add(lblAnversoLey);

		lblCanto = new JLabel(constantesLiterales.INFO_MONEDA_CANTO);
		lblCanto.setForeground(Color.RED);
		lblCanto.setFont(new Font("Tahoma", Font.BOLD, 10));
		listaTextJLabel.add(lblCanto);

		lblCantoLey = new JLabel(constantesLiterales.INFO_MONEDA_CANTO_L);
		lblCantoLey.setForeground(Color.RED);
		lblCantoLey.setFont(new Font("Tahoma", Font.BOLD, 10));
		listaTextJLabel.add(lblCantoLey);

		lblNota = new JLabel(constantesLiterales.INFO_MONEDA_NOTA);
		lblNota.setForeground(Color.RED);
		lblNota.setFont(new Font("Tahoma", Font.BOLD, 10));
		listaTextJLabel.add(lblNota);

		lbPeriodo = new JLabel(constantesLiterales.INFO_MONEDA_PERIODO);
		lbPeriodo.setForeground(Color.RED);
		lbPeriodo.setFont(new Font("Tahoma", Font.BOLD, 10));
		listaTextJLabel.add(lbPeriodo);

		lblFecha = new JLabel(constantesLiterales.INFO_MONEDA_DATE);
		lblFecha.setForeground(Color.RED);
		lblFecha.setFont(new Font("Tahoma", Font.BOLD, 10));
		listaTextJLabel.add(lblFecha);

		//TEXTOS
		textTitulo = new JTextField();
		textTitulo.setColumns(10);
		listaTextLayout.add(textTitulo);  //0

		textID = new JTextField();
		textID.setColumns(10);
		listaTextLayout.add(textID); //1

		textKM = new JTextField();
		textKM.setColumns(10);
		listaTextLayout.add(textKM); //2

		textValor = new JTextField();
		textValor.setColumns(10);
		listaTextLayout.add(textValor); //3

		textEstado = new JTextField();		//TODO hacerlo desplegable
		textEstado.setColumns(10);
		listaTextLayout.add(textEstado); //4

		textComposicion = new JTextField();		//TODO hacerlo de forma que se puedan seleccionar los datos bien por separado y desplegables
		textComposicion.setColumns(10);
		listaTextLayout.add(textComposicion); //5

		textForma = new JTextField();
		textForma.setColumns(10);
		listaTextLayout.add(textForma);//6

		textAnverso = new JTextField();
		textAnverso.setColumns(10);
		listaTextLayout.add(textAnverso);//7

		textAnversoLey = new JTextField();
		textAnversoLey.setColumns(10);
		listaTextLayout.add(textAnversoLey);//8

		textReverso = new JTextField();
		textReverso.setColumns(10);
		listaTextLayout.add(textReverso);//9

		textReversoLey = new JTextField();
		textReversoLey.setColumns(10);
		listaTextLayout.add(textReversoLey);//10

		textCanto = new JTextField();
		textCanto.setColumns(10);
		listaTextLayout.add(textCanto);//11

		textCantoLey = new JTextField();
		textCantoLey.setColumns(10);
		listaTextLayout.add(textCantoLey);//12

		textNota = new JTextField();
		textNota.setColumns(10);
		listaTextLayout.add(textNota);//13

		textPeriodo = new JTextField();
		textPeriodo.setColumns(10);
		listaTextLayout.add(textPeriodo);//14

		textFecha = new JTextField();
		textFecha.setColumns(10);
		listaTextLayout.add(textFecha);//15


		//BOTON SALIR
		btnSalir = new JButton(constantesLiterales.BOTON_SALIR);
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false); //you can't see me!
				dispose(); //Destroy the JFrame object
			}
		});

		//BOTON MODIFICAR
		btnModificar = new JButton(constantesLiterales.BOTON_INSERTAR);
		btnModificar.setVisible(false);
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				botonInsertarNuevaMoneda();

				setVisible(false); //you can't see me!
				dispose(); //Destroy the JFrame object
			}
		});

		//Imagen de la moneda
		panelImagen = new imagenJpanel();	

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lbID)
								.addGroup(gl_contentPane.createSequentialGroup()
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addComponent(lblForma, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
												.addComponent(lblCanto, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
												.addComponent(lblCantoLey, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
												.addComponent(lblReverso, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
												.addComponent(lblReversoLey, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
												.addComponent(lblAnverso, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
												.addComponent(lblAnversoLey, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
												.addComponent(lblNota, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(ComponentPlacement.RELATED)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
												.addComponent(textReverso, GroupLayout.PREFERRED_SIZE, 629, GroupLayout.PREFERRED_SIZE)
												.addComponent(textCantoLey, GroupLayout.PREFERRED_SIZE, 317, GroupLayout.PREFERRED_SIZE)
												.addComponent(textForma, GroupLayout.PREFERRED_SIZE, 317, GroupLayout.PREFERRED_SIZE)
												.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
														.addGroup(gl_contentPane.createSequentialGroup()
																.addComponent(textCanto, GroupLayout.PREFERRED_SIZE, 317, GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
																.addComponent(textEstado, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE))
														.addComponent(textAnversoLey, Alignment.LEADING)
														.addComponent(textAnverso, Alignment.LEADING)
														.addComponent(textReversoLey, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 629, Short.MAX_VALUE)
														.addComponent(textNota, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 629, GroupLayout.PREFERRED_SIZE))))
								.addGroup(gl_contentPane.createSequentialGroup()
										.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
												.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
														.addComponent(lblDenominacion)
														.addPreferredGap(ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
														.addComponent(textValor, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(ComponentPlacement.UNRELATED)
														.addComponent(lblFecha, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
														.addGap(48)
														.addComponent(textFecha, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE))
												.addComponent(textTitulo, GroupLayout.PREFERRED_SIZE, 409, GroupLayout.PREFERRED_SIZE)
												.addGroup(gl_contentPane.createSequentialGroup()
														.addComponent(lblK, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
																.addComponent(textID, GroupLayout.PREFERRED_SIZE, 317, GroupLayout.PREFERRED_SIZE)
																.addComponent(textKM, GroupLayout.PREFERRED_SIZE, 317, GroupLayout.PREFERRED_SIZE)))
												.addGroup(gl_contentPane.createSequentialGroup()
														.addComponent(lblCompesptam, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(ComponentPlacement.RELATED)
														.addComponent(textComposicion, GroupLayout.PREFERRED_SIZE, 317, GroupLayout.PREFERRED_SIZE))
												.addGroup(gl_contentPane.createSequentialGroup()
														.addComponent(lbPeriodo, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addComponent(textPeriodo, GroupLayout.PREFERRED_SIZE, 317, GroupLayout.PREFERRED_SIZE)))
										.addGap(18)
										.addComponent(panelImagen, GroupLayout.DEFAULT_SIZE, 294, Short.MAX_VALUE)))
						.addContainerGap(55, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
						.addGap(249)
						.addComponent(btnSalir, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
						.addGap(40)
						.addComponent(btnModificar, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(316, Short.MAX_VALUE))
				);
		gl_contentPane.setVerticalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
										.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
												.addGroup(gl_contentPane.createSequentialGroup()
														.addGap(41)
														.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
																.addComponent(lbPeriodo, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
																.addComponent(textPeriodo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
														.addPreferredGap(ComponentPlacement.RELATED)
														.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
																.addComponent(lbID)
																.addComponent(textID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
														.addPreferredGap(ComponentPlacement.RELATED)
														.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
																.addComponent(lblK, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
																.addComponent(textKM, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
														.addPreferredGap(ComponentPlacement.RELATED)
														.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
																.addComponent(lblDenominacion, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
																.addComponent(textValor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
																.addComponent(textFecha, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
																.addComponent(lblFecha, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE))
														.addPreferredGap(ComponentPlacement.UNRELATED)
														.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
																.addComponent(lblCompesptam, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
																.addComponent(textComposicion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
														.addPreferredGap(ComponentPlacement.UNRELATED)
														.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
																.addComponent(lblForma, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
																.addComponent(textForma, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
												.addComponent(panelImagen, GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE))
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addComponent(lblCanto, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
												.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
														.addComponent(textCanto, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
														.addComponent(textEstado, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
												.addComponent(lblCantoLey, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
												.addComponent(textCantoLey, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addGap(12)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
												.addGroup(gl_contentPane.createSequentialGroup()
														.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
																.addComponent(textReversoLey, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
																.addComponent(lblReversoLey, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE))
														.addPreferredGap(ComponentPlacement.UNRELATED)
														.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
																.addComponent(textAnverso, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
																.addComponent(lblAnverso, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE))
														.addPreferredGap(ComponentPlacement.RELATED))
												.addGroup(gl_contentPane.createSequentialGroup()
														.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
																.addComponent(lblReverso, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
																.addComponent(textReverso, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
														.addGap(59)))
										.addGap(6)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
												.addComponent(textAnversoLey, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(lblAnversoLey, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)))
								.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(textTitulo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addGap(357)))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(textNota, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNota, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnSalir)
								.addComponent(btnModificar))
						.addContainerGap())
				);
		contentPane.setLayout(gl_contentPane);
	}
	/**
	 * 
	 */
	private void botonInsertarNuevaMoneda() {
		utilLog.getInstance().escribirTrazas(NOMBRE_CLASS,"Se a pulsado el botonInsertarNuevaMoneda");
		//Obtenemos la informacion de la moneda que se ha insertado
		monedaExt mon = obtenerInformacion();		
		utilLog.getInstance().escribirTrazas(NOMBRE_CLASS,"Datos de la moneda --> "+mon.toString());
		lectura.DBInsertarMoneda(mon);
		JOptionPane.showMessageDialog(null, "Moneda insertada correctamente");
		utilLog.getInstance().escribirTrazas(NOMBRE_CLASS,"Valor insertado en la DB");

		//Modificamos la fecha del ultimo cambio
		lectura.modificarFechaUltimoCambio();
	}

	/**
	 * Insertamos una nueva moneda
	 */
	public void insertarMoneda(String continente, String pais){
		utilLog.getInstance().escribirTrazas(NOMBRE_CLASS,"Creacion de la vista insertarMoneda");
		//Modificamos el nombre del boton 
		btnModificar.setText(constantesLiterales.BOTON_INSERTAR);
		//Lo primero realizamos un borrado de todos los datos
		borrarTextoInformacion();
		//Ponemos todos los objetos en modo escritura
		modoTextoEscritura();
		//Modificamos el boton que ponga insertar
		btnModificar.setVisible(true);
		//Obtenemos el valor del ID, este valor es unico no se puede modificar
		textTitulo.setText("Continente="+continente+", y el pais="+pais);
		textTitulo.setEditable(false);
		int idNuevo = lectura.DBgetIDMoneda(pais); 
		textID.setText(Integer.toString(idNuevo));
		textID.setEditable(false);

		//informacion del pais y el continente de la moneda.
		infoInicialMoneda = new localizacion(continente, pais);
	}

	/**
	 * Obtiene la informacion de la moneda
	 */
	private monedaExt obtenerInformacion() {
		monedaExt moneda = null;
		boolean datosCorrectos=false;

		while (!datosCorrectos){
			//			if (listaTextLayout.get(2).getText().length()<0 || noExisteKM){   //TODO ver como hacer esta parte, para cuando aun no este el KM
			if (listaTextLayout.get(2).getText().length()<0){
				utilLog.getInstance().escribirTrazas(NOMBRE_CLASS,"No esta el valor de KM que es obligatorio");
			}
			else if (listaTextLayout.get(4).getText().length()<0){
				utilLog.getInstance().escribirTrazas(NOMBRE_CLASS,"No esta el valor de ESTADO que es obligatorio");
			}
			else{
				datosCorrectos=true;
				moneda = new monedaExt(Integer.parseInt(listaTextLayout.get(1).getText()));//ID
				moneda.setKmMoneda(listaTextLayout.get(2).getText()); //KM

				moneda.setDenominacionMoneda(new denominacion(listaTextLayout.get(3).getText(),listaTextLayout.get(15).getText(),"")); // VALOR / AÑO
				moneda.setEstadoMoneda(listaTextLayout.get(4).getText()); //ESTADO
				moneda.setComposicionMoneda(listaTextLayout.get(5).getText()); //COMPOSICION
				moneda.setFormaMoneda(listaTextLayout.get(6).getText()); //FORMA
				moneda.setInformacionMoneda(new informacionMoneda(listaTextLayout.get(7).getText(),listaTextLayout.get(8).getText(),  	//ANVERSO
						listaTextLayout.get(9).getText(),listaTextLayout.get(10).getText(),												//REVERSO
						listaTextLayout.get(11).getText(),listaTextLayout.get(12).getText()));											//CANTO
				moneda.setNotaMoneda(listaTextLayout.get(13).getText());//NOTA

				infoInicialMoneda.setPeriodoMoneda(listaTextLayout.get(14).getText());
				moneda.setLocalizacionMoneda(infoInicialMoneda);
			}
		}
		return moneda;
	}
	/**
	 * Borra toda la informacion que se encuentra en los objetos de texto
	 */
	private void borrarTextoInformacion(){
		for (int i=0; i<listaTextLayout.size();i++) listaTextLayout.get(i).setText("");
	}
	/**
	 * Metodo que pone los objetos de texto para que se puedan modificar
	 */
	private void modoTextoEscritura(){
		for (int i=0; i<listaTextLayout.size();i++) listaTextLayout.get(i).setEditable(true);
	}
}
