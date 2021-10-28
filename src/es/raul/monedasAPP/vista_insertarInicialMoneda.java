package es.raul.monedasAPP;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import es.raul.monedas.constantes.constantesLiterales;
import es.raul.monedas.constantes.constantesMonedas;
import es.raul.monedasAPP.utilidades.lecturasDB;
import es.raul.monedasAPP.utilidades.utilLog;

/**
 * Clase utilizada para incluir una nueva moneda, en esta clase solo se le pide el nombre del continente y el nombre del pais, 
 * en el caso de que no exista, se podra insertar uno nuevo.
 *
 */
public class vista_insertarInicialMoneda extends JFrame {

	private final static String NOMBRE_CLASS="vista_infoInicialMoneda";

	private JPanel contentPane;
	private JComboBox comboBoxPais;
	private JComboBox comboBoxContinente;
	private JTextField textNuevoPais;
	private JLabel lblnuevoPais;
	private JLabel lblNewLabel_1;

	//variables que se tienen que enciar
	private String paisSel="";
	private String continenteSel="";

	//Lectura de la DB
	private lecturasDB lectura = new lecturasDB();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					vista_insertarInicialMoneda frame = new vista_insertarInicialMoneda();
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
	public vista_insertarInicialMoneda() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 319, 205);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		//Eliminamos los botones del JFrame
		setUndecorated(true);
		//Color del fondo
		contentPane.setBackground(Color.BLUE);
		setContentPane(contentPane);

		//LISTA CONTINENTE
		String[] listaContiennte = {constantesMonedas.CONTINENTES.AFRICA.getNombre(),
				constantesMonedas.CONTINENTES.EUROPA.getNombre(),
				constantesMonedas.CONTINENTES.ASIA.getNombre(),
				constantesMonedas.CONTINENTES.AMERICA_CENTRAL.getNombre(),
				constantesMonedas.CONTINENTES.AMERICA_NORTE.getNombre(),
				constantesMonedas.CONTINENTES.AMERICA_SUR.getNombre(),
				constantesMonedas.CONTINENTES.OCEANIA.getNombre(),};
		comboBoxContinente = new JComboBox(listaContiennte);
		comboBoxContinente.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				generarListaPaises(comboBoxContinente.getSelectedItem().toString());
			}
		});

		//LISTA PAIS
		comboBoxPais = new JComboBox();
		comboBoxPais.setVisible(false);

		//TEXTO INFORMATIVOS
		JLabel lblNewLabel = new JLabel(constantesLiterales.TXT_SEL_CONTINENTE);
		lblNewLabel.setForeground(Color.RED);

		lblNewLabel_1 = new JLabel(constantesLiterales.TXT_SEL_PAIS);
		lblNewLabel_1.setForeground(Color.RED);
		lblNewLabel_1.setVisible(false);

		JLabel lblNewLabel_2 = new JLabel(constantesLiterales.TXT_MONEDA_NUEVA);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setForeground(Color.RED);

		lblnuevoPais = new JLabel("Insertar nuevo pais");
		lblnuevoPais.setForeground(Color.RED);
		lblnuevoPais.setVisible(false);

		textNuevoPais = new JTextField();
		textNuevoPais.setColumns(10);
		textNuevoPais.setVisible(false);

		//BOTON nueva moneda
		JButton btnNueva = new JButton(constantesLiterales.BOTON_NUEVA);
		btnNueva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pulsadoBotonInserta();
			}
		});


		//LAYOUT
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblNewLabel)
									.addGap(18)
									.addComponent(lblNewLabel_1))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(comboBoxContinente, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(comboBoxPais, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(32)
							.addComponent(lblNewLabel_2)))
					.addContainerGap(59, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(lblnuevoPais))
						.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnNueva, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED, 92, Short.MAX_VALUE)
					.addComponent(textNuevoPais, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(37))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel_2)
					.addGap(17)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(lblNewLabel_1))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(comboBoxContinente, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBoxPais, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(31)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(textNuevoPais, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblnuevoPais))
					.addPreferredGap(ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
					.addComponent(btnNueva)
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}

	/**
	 * Con la infirmacion recolectada, se llama a la nueva vista para continuar modificando la imagen.
	 */
	protected void pulsadoBotonInserta() {
		utilLog.getInstance().escribirTrazas(NOMBRE_CLASS,"pulsadoBotonInserta()");
		boolean nuevo = false;
		if (paisSel!=null && paisSel.length()==0){
			paisSel = textNuevoPais.getText();
			utilLog.getInstance().escribirTrazas(NOMBRE_CLASS,"pulsadoBotonInserta(), el valor del nuevo pais es " + paisSel);
			nuevo=true;
		}

		//Lanzamos la nueva vista
//TODO esto se tiene que enviar al objeto que lo ha llamado para lanzar la otra vista
		
		//eliminamos la vista
		setVisible(false); 
		dispose(); 
	}

	/**
	 * Dependiendo el continente seleccionado, mostramos la lista de los paises que tenemos en la actualidad, si no existe, con la primera opcion se puede insertar
	 * el nombre de un nuevo pais.
	 */
	private void generarListaPaises(String continente) {
		utilLog.getInstance().escribirTrazas(NOMBRE_CLASS,"generarListaPaises(), el continente pulsado es " + continente);
		//asignamos el valor del continente
		continenteSel = continente;

		List<String> listaPaises  = lectura.DBLeerPaisNombres(continente);
		if (listaPaises!=null){
			//lo habilitamos
			comboBoxPais.setVisible(true);
			lblNewLabel_1.setVisible(true);
			//El primer valor es para una nueva moneda
			comboBoxPais.addItem(constantesLiterales.TXT_SEL_NUEVO_PAIS);

			try{
				//Resto de paises
				for (int i=0;i<listaPaises.size();i++) comboBoxPais.addItem(listaPaises.get(i));
			}
			catch (Exception e) {
				utilLog.getInstance().escribirExcepcion(NOMBRE_CLASS,"generarListaPaises()",e);
			}
			
			//activamos la pulsacion de la lista
			comboBoxPais.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					
					//habilitamos la opcion para insertar un nuevo pais
					String valor = comboBoxPais.getSelectedItem().toString();					
					if (valor.equalsIgnoreCase(constantesLiterales.TXT_SEL_NUEVO_PAIS)){
						utilLog.getInstance().escribirTrazas(NOMBRE_CLASS,"generarListaPaises(), Insertamos un nuevo pais");
						
						//habilitamos la opcion
						lblnuevoPais.setVisible(true);
						textNuevoPais.setVisible(true);
					}
					else paisSel = valor; //asignamos el valor del pais
				}
			});
		}
	}
}
