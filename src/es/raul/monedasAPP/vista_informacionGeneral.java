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
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import es.raul.monedas.constantes.constantesLiterales;
import es.raul.monedas.constantes.constantesMonedas;
import es.raul.monedasAPP.utilidades.lecturasDB;
import es.raul.monedasAPP.utilidades.utilLog;

/**
 * 
 * Vista que muestra la informacion (numero de paises, numero de mondeas, colecciones) detallada
 * de las diferentes monedas de la difeentes colecciones
 *
 */
public class vista_informacionGeneral extends JFrame {

	private final static String NOMBRE_CLASS="vista_informacionGeneral";
	
	private JPanel contentPane;
	private JTextField txtNumeroTotalMonedasEuro;
	private JTextField txtNumeroTengoMonedasEuro;
	private JTextField txtNumeroMonedasConmemorativas;
	private JTextField txtMonedasDeEuro;
	private JTextField textMundoEuropa;
	private JTextField textMundoAfrica;
	private JTextField textMundoAsia;
	private JTextField textMundoAmericaSur;
	private JTextField textMundoAmericaNorte;
	private JTextField textMundoAmericaCentral;
	private JTextField textMundoOceania;
	private JTextField txtMonedasDeEuro_1;
	private JTextField txtNumeroTotalPaises;
	private JTextField txtNumeroTotalMonedas;
	private JTextField textTotalPaises;
	private JTextField textTotalMonedas;
	private JTextField txtNumeroTotalEuros;
	private JTextField textTotalEuro;
	private JTextField txtMonedasPesetaEspaola;
	private JTextField textPeseta;
	private JTextField textNumTotalPeseta;
	private JTextField textNumTotalPesetas;
	private JTextField textNumeroFinal;
	private JTextField txtElNumeroTotal;
	
	//Lectura de la DB
	private lecturasDB lectura = new lecturasDB();

	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					vista_informacionGeneral frame = new vista_informacionGeneral();
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
	public vista_informacionGeneral() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 741, 573);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		//Eliminamos los botones del JFrame
		setUndecorated(true);
		//Color del fondo
		contentPane.setBackground(Color.YELLOW);
		
		txtNumeroTotalMonedasEuro = new JTextField();
		txtNumeroTotalMonedasEuro.setColumns(10);
		txtNumeroTotalMonedasEuro.setEditable(false);
		
		txtNumeroTengoMonedasEuro = new JTextField();
		txtNumeroTengoMonedasEuro.setColumns(10);
		txtNumeroTengoMonedasEuro.setEditable(false);
		
		txtNumeroMonedasConmemorativas = new JTextField();
		txtNumeroMonedasConmemorativas.setColumns(10);
		txtNumeroMonedasConmemorativas.setEditable(false);
		
		txtMonedasDeEuro = new JTextField();
		txtMonedasDeEuro.setEditable(false);
		txtMonedasDeEuro.setForeground(new Color(255, 0, 0));
		txtMonedasDeEuro.setText(constantesLiterales.INFO_MUNDO);
		txtMonedasDeEuro.setColumns(10);
		
		textMundoEuropa = new JTextField();
		textMundoEuropa.setColumns(10);
		textMundoEuropa.setEditable(false);
		
		textMundoAfrica = new JTextField();
		textMundoAfrica.setColumns(10);
		textMundoAfrica.setEditable(false);
		
		textMundoAsia = new JTextField();
		textMundoAsia.setColumns(10);
		textMundoAsia.setEditable(false);
		
		textMundoAmericaSur = new JTextField();
		textMundoAmericaSur.setColumns(10);
		textMundoAmericaSur.setEditable(false);
		
		textMundoAmericaNorte = new JTextField();
		textMundoAmericaNorte.setColumns(10);
		textMundoAmericaNorte.setEditable(false);
		
		textMundoAmericaCentral = new JTextField();
		textMundoAmericaCentral.setColumns(10);
		textMundoAmericaCentral.setEditable(false);
		
		textMundoOceania = new JTextField();
		textMundoOceania.setColumns(10);
		textMundoOceania.setEditable(false);
		
		txtMonedasDeEuro_1 = new JTextField();
		txtMonedasDeEuro_1.setText(constantesLiterales.INFO_EUROS);
		txtMonedasDeEuro_1.setForeground(new Color(46, 139, 87));
		txtMonedasDeEuro_1.setEditable(false);
		txtMonedasDeEuro_1.setColumns(10);
		
		txtNumeroTotalPaises = new JTextField();
		txtNumeroTotalPaises.setText(constantesLiterales.INFO_TOTAL_PAISES);
		txtNumeroTotalPaises.setForeground(Color.RED);
		txtNumeroTotalPaises.setEditable(false);
		txtNumeroTotalPaises.setColumns(10);
		
		txtNumeroTotalMonedas = new JTextField();
		txtNumeroTotalMonedas.setText(constantesLiterales.INFO_TOTAL_MUNDO);
		txtNumeroTotalMonedas.setForeground(Color.RED);
		txtNumeroTotalMonedas.setEditable(false);
		txtNumeroTotalMonedas.setColumns(10);
		
		textTotalPaises = new JTextField();
		textTotalPaises.setFont(new Font("Tahoma", Font.BOLD, 14));
		textTotalPaises.setForeground(Color.RED);
		textTotalPaises.setEditable(false);
		textTotalPaises.setColumns(10);
		
		textTotalMonedas = new JTextField();
		textTotalMonedas.setFont(new Font("Tahoma", Font.BOLD, 14));
		textTotalMonedas.setForeground(Color.RED);
		textTotalMonedas.setEditable(false);
		textTotalMonedas.setColumns(10);
		
		txtNumeroTotalEuros = new JTextField();
		txtNumeroTotalEuros.setText(constantesLiterales.INFO_TOTAL_EUROS);
		txtNumeroTotalEuros.setForeground(new Color(0, 128, 0));
		txtNumeroTotalEuros.setEditable(false);
		txtNumeroTotalEuros.setColumns(10);
		
		textTotalEuro = new JTextField();
		textTotalEuro.setText("18");
		textTotalEuro.setForeground(new Color(0, 128, 0));
		textTotalEuro.setFont(new Font("Tahoma", Font.BOLD, 14));
		textTotalEuro.setEditable(false);
		textTotalEuro.setColumns(10);
		
		txtMonedasPesetaEspaola = new JTextField();
		txtMonedasPesetaEspaola.setText(constantesLiterales.INFO_PESETA);
		txtMonedasPesetaEspaola.setForeground(new Color(0, 0, 128));
		txtMonedasPesetaEspaola.setEditable(false);
		txtMonedasPesetaEspaola.setColumns(10);
		
		textPeseta = new JTextField();
		textPeseta.setText("");
		textPeseta.setEditable(false);
		textPeseta.setColumns(10);
		
		textNumTotalPeseta = new JTextField();
		textNumTotalPeseta.setText(constantesLiterales.INFO_TOTAL_PESETAS);
		textNumTotalPeseta.setForeground(Color.BLUE);
		textNumTotalPeseta.setEditable(false);
		textNumTotalPeseta.setColumns(10);
		
		textNumTotalPesetas = new JTextField();
		textNumTotalPesetas.setFont(new Font("Tahoma", Font.BOLD, 14));
		textNumTotalPesetas.setForeground(Color.BLUE);
		textNumTotalPesetas.setEditable(false);
		textNumTotalPesetas.setColumns(10);
		
		textNumeroFinal = new JTextField();
		textNumeroFinal.setFont(new Font("Tahoma", Font.BOLD, 20));
		textNumeroFinal.setEditable(false);
		textNumeroFinal.setColumns(10);
		
		txtElNumeroTotal = new JTextField();
		txtElNumeroTotal.setText(constantesLiterales.INFO_TOTAL);
		txtElNumeroTotal.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtElNumeroTotal.setEditable(false);
		txtElNumeroTotal.setColumns(10);
		
		//Generamos la informacion
		generarInformacion();
		
		JButton btnSalir = new JButton(constantesLiterales.BOTON_SALIR);
		btnSalir.setBackground(Color.CYAN);
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false); //you can't see me!
				dispose(); //Destroy the JFrame object
			}
		});
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(425, Short.MAX_VALUE)
					.addComponent(txtElNumeroTotal, GroupLayout.PREFERRED_SIZE, 296, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(0)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(txtMonedasPesetaEspaola, GroupLayout.PREFERRED_SIZE, 196, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
										.addComponent(txtMonedasDeEuro, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE)
										.addComponent(textMundoEuropa, GroupLayout.DEFAULT_SIZE, 540, Short.MAX_VALUE)
										.addComponent(textMundoAfrica)
										.addComponent(textMundoAsia)
										.addComponent(textMundoAmericaSur)
										.addComponent(textMundoAmericaNorte)
										.addComponent(textMundoAmericaCentral)
										.addComponent(textMundoOceania)
										.addComponent(txtMonedasDeEuro_1, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(txtNumeroTotalMonedasEuro, GroupLayout.PREFERRED_SIZE, 229, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(txtNumeroTengoMonedasEuro))
										.addComponent(txtNumeroMonedasConmemorativas))
									.addPreferredGap(ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addGap(10)
											.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
												.addComponent(txtNumeroTotalPaises, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE)
												.addComponent(textTotalPaises, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
												.addComponent(textTotalMonedas, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
												.addComponent(txtNumeroTotalMonedas, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)))
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
											.addComponent(textTotalEuro, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
											.addComponent(txtNumeroTotalEuros, GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
											.addGroup(gl_contentPane.createSequentialGroup()
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(textNumTotalPeseta, GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)))))
								.addComponent(textPeseta, GroupLayout.PREFERRED_SIZE, 501, GroupLayout.PREFERRED_SIZE))
							.addGap(13))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(19)
							.addComponent(btnSalir, GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
							.addGap(400)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(textNumTotalPesetas, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
									.addContainerGap())
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(textNumeroFinal, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE)
									.addGap(21))))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(txtMonedasDeEuro, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(textMundoEuropa, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtNumeroTotalPaises, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(textMundoAfrica, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textTotalPaises, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textMundoAsia, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(textMundoAmericaSur, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtNumeroTotalMonedas, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(textMundoAmericaNorte, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textTotalMonedas, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textMundoAmericaCentral, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textMundoOceania, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(txtMonedasDeEuro_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtNumeroTotalMonedasEuro, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtNumeroTengoMonedasEuro, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtNumeroTotalEuros, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtNumeroMonedasConmemorativas, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textTotalEuro, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
					.addGap(21)
					.addComponent(txtMonedasPesetaEspaola, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(textPeseta, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textNumTotalPeseta, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(6)
					.addComponent(textNumTotalPesetas, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(41)
					.addComponent(txtElNumeroTotal, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(textNumeroFinal, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnSalir, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(33, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
	
	private void generarInformacion() {		
		utilLog.getInstance().getInstance().escribirTrazas(NOMBRE_CLASS, "generarInformacion() generamos la informacion de las monedas");

		//INFORMACION MONEDAS MUNDO
		int numFinalPaises = 0;
		int num = lectura.DBContarNumeroPaises(constantesMonedas.CONTINENTES.EUROPA);
		numFinalPaises = numFinalPaises + num;
		int numTotalMonedas = 0;
		int numTotal =  lectura.DBContarNumeroMonedas(constantesMonedas.CONTINENTES.EUROPA);
		numTotalMonedas = numTotalMonedas + numTotal;
		textMundoEuropa.setText("EUROPA" + constantesLiterales.INFO_MUNDO_1 + num + constantesLiterales.INFO_MUNDO_2 + numTotal);
		
		num = lectura.DBContarNumeroPaises(constantesMonedas.CONTINENTES.AFRICA);
		numFinalPaises = numFinalPaises + num;
		numTotal =  lectura.DBContarNumeroMonedas(constantesMonedas.CONTINENTES.AFRICA);
		numTotalMonedas = numTotalMonedas + numTotal;
		textMundoAfrica.setText("AFRICA " + constantesLiterales.INFO_MUNDO_1 + num + constantesLiterales.INFO_MUNDO_2 + numTotal);
		
		num = lectura.DBContarNumeroPaises(constantesMonedas.CONTINENTES.ASIA);
		numFinalPaises = numFinalPaises + num;
		numTotal =  lectura.DBContarNumeroMonedas(constantesMonedas.CONTINENTES.ASIA);
		numTotalMonedas = numTotalMonedas + numTotal;
		textMundoAsia.setText("ASIA    " + constantesLiterales.INFO_MUNDO_1 + num + constantesLiterales.INFO_MUNDO_2 + numTotal);
		
		num = lectura.DBContarNumeroPaises(constantesMonedas.CONTINENTES.AMERICA_CENTRAL);
		numFinalPaises = numFinalPaises + num;
		numTotal =  lectura.DBContarNumeroMonedas(constantesMonedas.CONTINENTES.AMERICA_CENTRAL);
		numTotalMonedas = numTotalMonedas + numTotal;
		textMundoAmericaCentral.setText("AMERICA CENTRAL" + constantesLiterales.INFO_MUNDO_1 + num + constantesLiterales.INFO_MUNDO_2 + numTotal);
		
		num = lectura.DBContarNumeroPaises(constantesMonedas.CONTINENTES.AMERICA_NORTE);
		numFinalPaises = numFinalPaises + num;
		numTotal =  lectura.DBContarNumeroMonedas(constantesMonedas.CONTINENTES.AMERICA_NORTE);
		numTotalMonedas = numTotalMonedas + numTotal;
		textMundoAmericaNorte.setText("AMERICA DEL NORTE" + constantesLiterales.INFO_MUNDO_1 + num + constantesLiterales.INFO_MUNDO_2 + numTotal);
		
		num = lectura.DBContarNumeroPaises(constantesMonedas.CONTINENTES.AMERICA_SUR);
		numFinalPaises = numFinalPaises + num;
		numTotal =  lectura.DBContarNumeroMonedas(constantesMonedas.CONTINENTES.AMERICA_SUR);
		numTotalMonedas = numTotalMonedas + numTotal;
		textMundoAmericaSur.setText("AMERICA DEL SUR" + constantesLiterales.INFO_MUNDO_1 + num + constantesLiterales.INFO_MUNDO_2 + numTotal);
		
		num = lectura.DBContarNumeroPaises(constantesMonedas.CONTINENTES.OCEANIA);
		numFinalPaises = numFinalPaises + num;
		numTotal =  lectura.DBContarNumeroMonedas(constantesMonedas.CONTINENTES.OCEANIA);
		numTotalMonedas = numTotalMonedas + numTotal;
		textMundoOceania.setText("OCEANIA   " + constantesLiterales.INFO_MUNDO_1 + num + constantesLiterales.INFO_MUNDO_2 + numTotal);
		
		textTotalPaises.setText(""+numFinalPaises);
		textTotalMonedas.setText(""+numTotalMonedas);
		
		//INFORMACION MONEDAS EURO	
		int numEurNo = lectura.DBContarNumeroEuros(0);
		int numEurSi = lectura.DBContarNumeroEuros(1);		
		txtNumeroTotalMonedasEuro.setText(constantesLiterales.INFO_EUROS_1 + (numEurNo +numEurSi));
		txtNumeroTengoMonedasEuro.setText(constantesLiterales.INFO_EUROS_2 + numEurSi);
		
		int numEurCon = lectura.DBContarNumeroEurosConmemorativos();
		txtNumeroMonedasConmemorativas.setText(constantesLiterales.INFO_EUROS_3 + numEurCon);
		
		textTotalEuro.setText(""+(numEurSi+numEurCon));
		
		//INFORMACION MONEDAS PESETA
		int [] numPesetasSi = lectura.DBContarNumeroPesetas();
		int numPesetasTOtales = lectura.DBContarNumeroPesetasTotales();
		textPeseta.setText(constantesLiterales.INFO_PESETA_1 + numPesetasTOtales + constantesLiterales.INFO_PESETA_2 + numPesetasSi[0] + constantesLiterales.INFO_PESETA_3);
		textNumTotalPesetas.setText(""+numPesetasSi[1]);
		
		//INFORMACION FINAL
		int TOTAL = numTotalMonedas + numEurSi + numEurCon + numPesetasSi[1];
		textNumeroFinal.setText(""+TOTAL);
		
		
		//TODO NEcesitamos poner mas informacion???????
	}
}
