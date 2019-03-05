package es.raul.monedasAPP;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
import es.raul.monedasAPP.objetos.imagenJpanel;
import es.raul.monedasAPP.utilidades.lecturasDB;
import es.raul.monedasAPP.utilidades.utils;

public class vista_infoBilletes extends JFrame {

	private final static String NOMBRE_CLASS="vista_infoBilletes";

	private JPanel contentPane;

	//Imagen completa de la moneda
	private static imagenJpanel panelImagen;

	//Informacion de la moneda o datos a ingresar
	private static JTextField textTitulo;

	//Botones
	private JButton btnSalir;
	
	//Lectura de la DB
	private lecturasDB lectura = new lecturasDB();
	private utils util = utils.getInstance();
	private JTextField textEstado;
	private JTextField textNota;

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
	public vista_infoBilletes() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 596, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		//Eliminamos los botones del JFrame
		setUndecorated(true);
		//Color del fondo
		contentPane.setBackground(Color.BLUE);
		
		JLabel lbEstado = new JLabel(constantesLiterales.INFO_MONEDA_ESTADO);
		lbEstado.setForeground(Color.RED);
		lbEstado.setFont(new Font("Tahoma", Font.BOLD, 10));
		
		JLabel lbNota = new JLabel(constantesLiterales.INFO_MONEDA_NOTA);
		lbNota.setForeground(Color.RED);
		lbNota.setFont(new Font("Tahoma", Font.BOLD, 10));
		
		//TEXTOS
		textTitulo = new JTextField();
		textTitulo.setFont(new Font("Tahoma", Font.BOLD, 14));
		textTitulo.setEditable(false);
		textTitulo.setColumns(10);
		
		textEstado = new JTextField();
		textEstado.setEditable(false);
		textEstado.setColumns(10);
		
		textNota = new JTextField();
		textNota.setEditable(false);
		textNota.setColumns(10);
		

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

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lbEstado, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(textEstado, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, 280, Short.MAX_VALUE)
									.addComponent(btnSalir, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE))
								.addComponent(panelImagen, GroupLayout.DEFAULT_SIZE, 546, Short.MAX_VALUE)
								.addComponent(textTitulo, GroupLayout.DEFAULT_SIZE, 546, Short.MAX_VALUE))
							.addGap(30))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lbNota, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(textNota, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(400, Short.MAX_VALUE))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(textTitulo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panelImagen, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lbEstado, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
								.addComponent(textEstado, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lbNota, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
								.addComponent(textNota, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(135))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(18)
							.addComponent(btnSalir)
							.addContainerGap())))
		);
		contentPane.setLayout(gl_contentPane);
	}
	
	/**
	 * mostramos la informacion de la MONEDA MUNDO
	 */
	public void mostrarBilletes(int valorIDBillete){
		util.escribirTrazas(NOMBRE_CLASS,"mostrarBilletes() Mostramos la informacion del billete con ID="+valorIDBillete);
//TODO Comentado para implemantar mas tarde		
//		//Obtenemos la informacion de la DB
//		billete billete = lectura.DBLeerBilleteInfo(valorIDBillete);
//
//		//Insertamos la informacion en los diferentes objetos
//		if (billete!=null){
//			textTitulo.setText(billete.toString());			
//			textEstado.setText(billete.getEstado());
//			if (billete.getDescripcion().length() > 1) textNota.setText(billete.getDescripcion());
//			
//			//Insertamos la imagen de la moneda
//			getPathBillete(constantesMonedas.PATH_BILLETES, Integer.toString(valorIDBillete),constantesMonedas.IMAGEN_PATH_PNG);
//		}
//		else util.escribirTrazas(NOMBRE_CLASS,"mostrarBilletes() Los datos de la moneda no se han obtenido correctamente");
	}

	
	/**
	 * Inserta la ruta de la imagen en el objeto
	 */
	private void getPathBillete(String ruta, String nombre, String extension){
		String path = util.obtenerPathImagen(ruta, nombre, extension);
		util.escribirTrazas(NOMBRE_CLASS,"Path imagen: " + path);
		panelImagen.setBackground(path);
	}
}
