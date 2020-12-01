package es.raul.monedasAPP;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import es.raul.monedas.constantes.constantesLiterales;
import es.raul.monedas.constantes.constantesMonedas;
import es.raul.monedas.objetos.peseta.estrellasPesetas;
import es.raul.monedas.objetos.peseta.monedaPesetaAux;
import es.raul.monedasAPP.objetos.imagenJpanel;
import es.raul.monedasAPP.utilidades.lecturasDB;
import es.raul.monedasAPP.utilidades.utilLog;
import es.raul.monedasAPP.utilidades.utils;

/**
 * Muestra la informacion detallada de las monedas de la coleccion de las pesetas
 *
 */
public class vista_infoMonedasPeseta extends JFrame {

	private final static String NOMBRE_CLASS="vista_infoMonedasPeseta";

	//Paneles 
	private JPanel contentPane;
	private JPanel panelEstrellas;

	//Imagen que queremos mostrar
	private static imagenJpanel panelImagen;

	//Informacion de la moneda o datos a ingresar
	private static JTextField textTitulo;
	private static JTextField textID;
	private static JTextField textKM;
	private static JTextField textValor;
	private static JTextField textComposicion;
	private static JTextField textNota;
	private static JTextField textAnverso;
	private static JTextField textReverso;

	//Indica lo que es cada uno de los textos mostrados
	private JLabel lbID;
	private JLabel lblK;
	private JLabel lbValor;
	private JLabel lblCompesptam;
	private JLabel lblNota;
	private JLabel lblAnverso;
	private JLabel lblReverso;

	//Para las estrellas
	private JTable table;
	private	JScrollPane scrollPane;

	//Botones
	private JButton btnSalir;

	//variable ID
	private int ID_MONEDA=0;
	private String PERIODO_MONEDA="";
	
	//informcion de la moneda que estamos pintando
	private monedaPesetaAux moneda=null;

	//Lectura de la DB
	private lecturasDB lectura = new lecturasDB();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					vista_infoMonedasPeseta frame = new vista_infoMonedasPeseta();
					frame.mostrarMonedaPeseta(6001, "Alfonzo XIII"); //Ejemplo
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
	public vista_infoMonedasPeseta() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 696, 466);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		//Eliminamos los botones del JFrame
		setUndecorated(true);
		//Color del fondo
		contentPane.setBackground(Color.BLUE);

		//TODO El color y el formateo de los objetos en la vista se tienen que modificar

		//LABEL
		lbID = new JLabel(constantesLiterales.INFO_MONEDA_ID);
		lbID.setForeground(Color.RED);
		lbID.setFont(new Font("Tahoma", Font.BOLD, 14));

		lblK = new JLabel(constantesLiterales.INFO_MONEDA_K);
		lblK.setForeground(Color.RED);
		lblK.setFont(new Font("Tahoma", Font.BOLD, 14));

		lbValor = new JLabel(constantesLiterales.INFO_MONEDA_VALOR);
		lbValor.setForeground(Color.RED);
		lbValor.setFont(new Font("Tahoma", Font.BOLD, 12));

		lblCompesptam = new JLabel(constantesLiterales.INFO_MONEDA_COMPOSICION);
		lblCompesptam.setForeground(Color.RED);
		lblCompesptam.setFont(new Font("Tahoma", Font.BOLD, 10));

		lblNota = new JLabel(constantesLiterales.INFO_MONEDA_NOTA);
		lblNota.setForeground(Color.RED);
		lblNota.setFont(new Font("Tahoma", Font.BOLD, 10));

		lblAnverso = new JLabel(constantesLiterales.INFO_MONEDA_ANVERSO);
		lblAnverso.setForeground(Color.RED);
		lblAnverso.setFont(new Font("Tahoma", Font.BOLD, 10));

		lblReverso = new JLabel(constantesLiterales.INFO_MONEDA_REVERSO);
		lblReverso.setForeground(Color.RED);
		lblReverso.setFont(new Font("Tahoma", Font.BOLD, 10));

		//TEXTOS
		textTitulo = new JTextField();
		textTitulo.setForeground(Color.RED);
		textTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		textTitulo.setBackground(Color.BLUE);
		textTitulo.setFont(new Font("Tahoma", Font.BOLD, 13));
		textTitulo.setEditable(false);
		textTitulo.setColumns(10);

		textID = new JTextField();
		textID.setFont(new Font("Tahoma", Font.BOLD, 11));
		textID.setEditable(false);
		textID.setColumns(10);

		textKM = new JTextField();
		textKM.setFont(new Font("Tahoma", Font.BOLD, 11));
		textKM.setEditable(false);
		textKM.setColumns(10);

		textValor = new JTextField();
		textValor.setFont(new Font("Tahoma", Font.BOLD, 11));
		textValor.setEditable(false);
		textValor.setColumns(10);

		textComposicion = new JTextField();
		textComposicion.setEditable(false);
		textComposicion.setColumns(10);

		textNota = new JTextField();
		textNota.setEditable(false);
		textNota.setColumns(10);

		textAnverso = new JTextField();
		textAnverso.setEditable(false);
		textAnverso.setColumns(10);

		textReverso = new JTextField();
		textReverso.setEditable(false);
		textReverso.setColumns(10);


		//BOTON SALIR
		btnSalir = new JButton(constantesLiterales.BOTON_SALIR);
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false); //you can't see me!
				dispose(); //Destroy the JFrame object
			}
		});


		//Imagen de la moneda
		panelImagen = new imagenJpanel();

		//informacion de las Estrellas de las monedas
		panelEstrellas = new JPanel();
		panelEstrellas.setForeground(Color.BLUE);
		panelEstrellas.setLayout(new BorderLayout());
		panelEstrellas.setBackground(Color.BLUE);
		getContentPane().add(panelEstrellas);

		//Generamos la tabla
		table = new JTable(){
			@Override
			public void changeSelection(int rowIndex, int columnIndex, boolean toggle, boolean extend) {
				super.changeSelection(rowIndex, columnIndex, toggle, extend);
				if (columnIndex==5){ 
					String fecha="";
					String tirada="";
					String estado="";
					boolean esta=false;

					try{
						Object dato = table.getValueAt(rowIndex, 0);
						if(dato instanceof String) fecha = (String)dato;

						dato = table.getValueAt(rowIndex, 1);
						if(dato instanceof String) tirada = (String)dato;
						
						dato = table.getValueAt(rowIndex, 4);
						if(dato instanceof String) estado = (String)dato;
						
						dato = table.getValueAt(rowIndex, 5);
						if(dato instanceof Boolean) esta = (Boolean)dato;
					}
					catch (Exception e) {}

					if (!esta) incluirMoneda(fecha,tirada,estado,rowIndex);
				}
			}
		};
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
			},
			new String[] {
				"Fecha", "Estrella", "CECA", "Tirada", "Estado", "Esta"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, Integer.class, String.class, Boolean.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, true, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});

		table.setRowSelectionAllowed(false);
		scrollPane = new JScrollPane(table);
		panelEstrellas.add(scrollPane, BorderLayout.CENTER);

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addGap(10)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(lblReverso, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
										.addGap(12)
										.addComponent(textReverso, GroupLayout.DEFAULT_SIZE, 558, Short.MAX_VALUE))
								.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(btnSalir, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
										.addGap(18)
										.addComponent(panelEstrellas, GroupLayout.DEFAULT_SIZE, 558, Short.MAX_VALUE))
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
										.addGroup(gl_contentPane.createSequentialGroup()
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(lbValor)
												.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(textValor, GroupLayout.PREFERRED_SIZE, 317, GroupLayout.PREFERRED_SIZE))
										.addComponent(textTitulo, GroupLayout.PREFERRED_SIZE, 409, GroupLayout.PREFERRED_SIZE)
										.addGroup(gl_contentPane.createSequentialGroup()
												.addComponent(lbID)
												.addGap(70)
												.addComponent(textID, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.UNRELATED)
												.addComponent(lblK, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(textKM, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)))
								.addGroup(gl_contentPane.createSequentialGroup()
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(lblCompesptam, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(textComposicion, GroupLayout.PREFERRED_SIZE, 317, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
										.addPreferredGap(ComponentPlacement.RELATED)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addComponent(lblNota, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
												.addComponent(lblAnverso, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(ComponentPlacement.RELATED)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
												.addComponent(textAnverso)
												.addGroup(gl_contentPane.createSequentialGroup()
														.addComponent(textNota, GroupLayout.PREFERRED_SIZE, 317, GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(ComponentPlacement.UNRELATED)
														.addComponent(panelImagen, GroupLayout.PREFERRED_SIZE, 231, GroupLayout.PREFERRED_SIZE)))))
						.addGap(126))
				);
		gl_contentPane.setVerticalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(textTitulo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addGap(38)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addComponent(lbID)
												.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
														.addComponent(textID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
														.addComponent(lblK)
														.addComponent(textKM, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
										.addPreferredGap(ComponentPlacement.RELATED)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addComponent(lbValor, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
												.addComponent(textValor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(ComponentPlacement.RELATED)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addComponent(lblCompesptam, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
												.addComponent(textComposicion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(ComponentPlacement.RELATED)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
												.addComponent(lblNota, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
												.addComponent(textNota, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
								.addComponent(panelImagen, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(textAnverso, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblAnverso, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(textReverso, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblReverso, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
										.addGap(14)
										.addComponent(panelEstrellas, GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE))
								.addGroup(gl_contentPane.createSequentialGroup()
										.addGap(60)
										.addComponent(btnSalir)))
						.addContainerGap())
				);
		contentPane.setLayout(gl_contentPane);
	}

	/**
	 * MONEDA PESETA
	 */
	public void mostrarMonedaPeseta(int idMoneda, String periodo){
		utilLog.getInstance().escribirTrazas(NOMBRE_CLASS,"mostrarMonedaPeseta() Mostramos la informacion de la moneda con ID="+idMoneda);

		//Obtenemos la informacion de la DB
		if (moneda==null) moneda = lectura.DBLeerPesetaExtendida(idMoneda);

		//Insertamos la informacion en los diferentes objetos
		if (moneda!=null){
			ID_MONEDA = moneda.getIdMoneda();
			PERIODO_MONEDA = moneda.getPeriodo();
			textTitulo.setText(PERIODO_MONEDA);
			textID.setText(Integer.toString(ID_MONEDA));
			textKM.setText(moneda.getKmMoneda());
			textValor.setText(moneda.getvalorMoneda());
			textComposicion.setText(moneda.getComposicionMoneda());
			if (moneda.getNotaMoneda().length() > 1) textNota.setText(moneda.getNotaMoneda());
			else {
				//TODO no funciona muy bien revisar
				lblNota.setForeground(Color.BLUE);
				textNota.setBackground(Color.BLUE);
				//TODO Eliminar el borde blanco
			}
			if (moneda.getInformacion().getAnverso().length() > 1) textAnverso.setText(moneda.getInformacion().getAnverso());
			if (moneda.getInformacion().getReverso().length() > 1) textReverso.setText(moneda.getInformacion().getReverso());

			//Insertamos la imagen de la moneda
			getPathMoneda(constantesMonedas.PATH_PESETAS,periodo+File.separator+ Integer.toString(idMoneda),constantesMonedas.IMAGEN_PATH_PNG);

			//Informacion de las estrellas
			pintarDatosEstrella(moneda.getEstrellas());
		}
		else utilLog.getInstance().escribirTrazas(NOMBRE_CLASS,"mostrarMonedaPeseta() Los datos de la moneda no se han obtenido correctamente");
	}

	public void pintarDatosEstrella(List<estrellasPesetas> datosEstrellas){
		utilLog.getInstance().escribirTrazas(NOMBRE_CLASS,"pintarDatosEstrella() ");

		DefaultTableModel modelo = (DefaultTableModel) table.getModel();
		modelo.setNumRows(0);

		if (datosEstrellas!=null){
			for (estrellasPesetas estrella : datosEstrellas) modelo.addRow(estrella.getRow());				
		}
	}

	/**
	 * Metodo para incluir una nueva moneda
	 */
	protected void incluirMoneda(String fecha, String estrella, String estado, int position) {
		utilLog.getInstance().escribirTrazas(NOMBRE_CLASS,"incluirMoneda() INICIO");

		int reply = JOptionPane.showConfirmDialog(null, constantesLiterales.TXT_MSN_MODIFICAR, "", JOptionPane.YES_NO_OPTION);
		if (reply == JOptionPane.YES_OPTION){
			utilLog.getInstance().escribirTrazas(NOMBRE_CLASS, "Se va a modificar la moneda con ID=" + ID_MONEDA +", FECHA="+fecha+", ESTRELLA="+estrella+", ESTADO="+estado);
			//Incluimos la moneda
			lectura.DBIncluirPeseta(ID_MONEDA, fecha, estrella,estado);
			
			//Repintamos la informacion de las estrellas
			moneda.getEstrellas().get(position).setEsta(true);
			moneda.getEstrellas().get(position).setEstado(estado);
			pintarDatosEstrella(moneda.getEstrellas());
		}
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
