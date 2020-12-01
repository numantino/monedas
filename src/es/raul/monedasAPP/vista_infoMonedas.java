package es.raul.monedasAPP;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import es.raul.monedas.constantes.constantesLiterales;
import es.raul.monedas.constantes.constantesMonedas;
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
public class vista_infoMonedas extends JFrame {

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

	//Botones
	private JButton btnSalir;
	private JButton btnModificar;   //TODO este boton no esta implementado por el momento

	//Lectura de la DB
	private lecturasDB lectura = new lecturasDB();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					vista_infoMonedas frame = new vista_infoMonedas();
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
	public vista_infoMonedas() {
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

		//TEXTOS
		textTitulo = new JTextField();
		textTitulo.setColumns(10);
		listaTextLayout.add(textTitulo);

		textID = new JTextField();
		textID.setColumns(10);
		listaTextLayout.add(textID);

		textKM = new JTextField();
		textKM.setColumns(10);
		listaTextLayout.add(textKM);

		textValor = new JTextField();
		textValor.setColumns(10);
		listaTextLayout.add(textValor);

		textEstado = new JTextField();
		textEstado.setColumns(10);
		listaTextLayout.add(textEstado);

		textComposicion = new JTextField();
		textComposicion.setColumns(10);
		listaTextLayout.add(textComposicion);

		textForma = new JTextField();
		textForma.setColumns(10);
		listaTextLayout.add(textForma);

		textAnverso = new JTextField();
		textAnverso.setColumns(10);
		listaTextLayout.add(textAnverso);

		textAnversoLey = new JTextField();
		textAnversoLey.setColumns(10);
		listaTextLayout.add(textAnversoLey);

		textReverso = new JTextField();
		textReverso.setColumns(10);
		listaTextLayout.add(textReverso);

		textReversoLey = new JTextField();
		textReversoLey.setColumns(10);
		listaTextLayout.add(textReversoLey);

		textCanto = new JTextField();
		textCanto.setColumns(10);
		listaTextLayout.add(textCanto);

		textCantoLey = new JTextField();
		textCantoLey.setColumns(10);
		listaTextLayout.add(textCantoLey);

		textNota = new JTextField();
		textNota.setColumns(10);
		listaTextLayout.add(textNota);


		//BOTON SALIR
		btnSalir = new JButton(constantesLiterales.BOTON_SALIR);
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false); //you can't see me!
				dispose(); //Destroy the JFrame object
			}
		});

		//BOTON MODIFICAR
		btnModificar = new JButton(constantesLiterales.BOTON_MODIFICAR);
		btnModificar.setVisible(false);

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
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
														.addGroup(gl_contentPane.createSequentialGroup()
																.addComponent(lblDenominacion)
																.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
																.addComponent(textValor, GroupLayout.PREFERRED_SIZE, 317, GroupLayout.PREFERRED_SIZE))
														.addComponent(textTitulo, GroupLayout.PREFERRED_SIZE, 409, GroupLayout.PREFERRED_SIZE)
														.addGroup(gl_contentPane.createSequentialGroup()
																.addComponent(lblK, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
																.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
																		.addComponent(textID, GroupLayout.PREFERRED_SIZE, 317, GroupLayout.PREFERRED_SIZE)
																		.addComponent(textKM, GroupLayout.PREFERRED_SIZE, 317, GroupLayout.PREFERRED_SIZE))))
												.addGroup(gl_contentPane.createSequentialGroup()
														.addComponent(lblCompesptam, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(ComponentPlacement.RELATED)
														.addComponent(textComposicion, GroupLayout.PREFERRED_SIZE, 317, GroupLayout.PREFERRED_SIZE)))
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
														.addGap(26)
														.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
																.addComponent(lbID)
																.addComponent(textID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
														.addPreferredGap(ComponentPlacement.RELATED)
														.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
																.addComponent(lblK, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
																.addComponent(textKM, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
														.addPreferredGap(ComponentPlacement.RELATED)
														.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
																.addComponent(lblDenominacion, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
																.addComponent(textValor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
														.addPreferredGap(ComponentPlacement.UNRELATED)
														.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
																.addComponent(lblCompesptam, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
																.addComponent(textComposicion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
														.addPreferredGap(ComponentPlacement.UNRELATED)
														.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
																.addComponent(lblForma, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
																.addComponent(textForma, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
												.addComponent(panelImagen, GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE))
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
												.addComponent(lblAnversoLey, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(ComponentPlacement.RELATED))
								.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(textTitulo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addGap(357)))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(textNota, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNota, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnSalir)
								.addComponent(btnModificar))
						.addContainerGap())
				);
		contentPane.setLayout(gl_contentPane);
	}

	/**
	 * mostramos la informacion de la MONEDA MUNDO
	 */
	public void mostrarMoneda(int valorIdMoneda, String continente){
		utilLog.getInstance().escribirTrazas(NOMBRE_CLASS,"mostrarMoneda() Mostramos la informacion de la moneda con ID="+valorIdMoneda);

		//Ponemos todos los objetos solo para ver
		modoTextoSoloLectura();

		//Obtenemos la informacion de la DB
		monedaExt moneda = lectura.DBLeerMonedaExtendida(valorIdMoneda, continente);

		//Insertamos la informacion en los diferentes objetos
		if (moneda!=null){
			textTitulo.setText(moneda.getLocalizacionMoneda().getTitulo());
			textID.setText(Integer.toString(moneda.getIdMoneda()));
			if (moneda.isEsKM()) lblK.setText(constantesLiterales.INFO_MONEDA_K);
			else lblK.setText(constantesLiterales.INFO_MONEDA_Y);
			textKM.setText(moneda.getKmMoneda());
			textValor.setText(moneda.getDenominacionMoneda().toString());
			textComposicion.setText(moneda.getComposicionMoneda());
			if (moneda.getFormaMoneda().length() > 1) textForma.setText(moneda.getFormaMoneda());
			if (moneda.getInformacionMoneda().getAnverso().length() > 1) textAnverso.setText(moneda.getInformacionMoneda().getAnverso());
			if (moneda.getInformacionMoneda().getAnversoLeyenda().length() > 1) textAnversoLey.setText(moneda.getInformacionMoneda().getAnversoLeyenda());
			if (moneda.getInformacionMoneda().getReverso().length() > 1) textReverso.setText(moneda.getInformacionMoneda().getReverso());
			if (moneda.getInformacionMoneda().getReversoLeyenda().length() > 1) textReversoLey.setText(moneda.getInformacionMoneda().getReversoLeyenda());
			if (moneda.getInformacionMoneda().getCanto().length() > 1) textCanto.setText(moneda.getInformacionMoneda().getCanto());
			if (moneda.getInformacionMoneda().getCantoLeyenda().length() > 1) textCantoLey.setText(moneda.getInformacionMoneda().getCantoLeyenda());
			if (moneda.getNotaMoneda().length() > 1) textNota.setText(moneda.getNotaMoneda());
			textEstado.setText(moneda.getEstadoMoneda());

			//Insertamos la imagen de la moneda
			getPathMoneda("",continente+File.separator+ Integer.toString(valorIdMoneda),constantesMonedas.IMAGEN_PATH_PNG);
		}
		else utilLog.getInstance().escribirTrazas(NOMBRE_CLASS,"mostrarMonedaMundo() Los datos de la moneda no se han obtenido correctamente");
	}
	/**
	 * Metodo que pone los objetos de texto para que no se puedan modificar
	 */
	private void modoTextoSoloLectura(){
		for (int i=0; i<listaTextLayout.size();i++) listaTextLayout.get(i).setEditable(false);
	}
	/**
	 * Inserta la ruta de la imagen en el objeto
	 */
	private void getPathMoneda(String ruta, String nombre, String extension){
		String path = utils.getInstance().obtenerPathImagen(ruta, nombre, extension);
		utilLog.getInstance().escribirTrazas(NOMBRE_CLASS,"Path imagen: " + path);
		panelImagen.setBackground(path);
	}
}
