package es.raul.monedasAPP;

import java.awt.Color;
import java.awt.EventQueue;
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
import es.raul.monedas.objetos.mundo.denominacion;

public class vista_datosAuxiliares extends JFrame {

	private JPanel contentPane;
	private JTextField txtValor;
	private JTextField txtCurrency;
	private JTextField txtAno;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					vista_datosAuxiliares frame = new vista_datosAuxiliares();
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
	public vista_datosAuxiliares() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(50, 50, 350, 150);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		//Eliminamos los botones del JFrame
		setUndecorated(true);
		//Color del fondo
		contentPane.setBackground(Color.LIGHT_GRAY);
		
		JLabel lbValor = new JLabel(constantesLiterales.INFO_MONEDA_VALOR);
		
		JLabel lbCurrency = new JLabel(constantesLiterales.INFO_MONEDA_CURRENCY);
		
		JLabel lbAno = new JLabel(constantesLiterales.INFO_MONEDA_DATE);
		
		txtValor = new JTextField();
		txtValor.setColumns(10);
		
		txtCurrency = new JTextField();
		txtCurrency.setColumns(10);
		
		txtAno = new JTextField();
		txtAno.setColumns(10);
		
		JButton btnFin = new JButton(constantesLiterales.BOTON_INSERTAR);
		btnFin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				devolverValoresDenominacion();
				
				setVisible(false); //you can't see me!
				dispose(); //Destroy the JFrame obje
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lbAno)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(txtAno, GroupLayout.PREFERRED_SIZE, 204, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addComponent(lbValor)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(txtValor, GroupLayout.PREFERRED_SIZE, 204, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lbCurrency)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(txtCurrency, GroupLayout.PREFERRED_SIZE, 204, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(50, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(224, Short.MAX_VALUE)
					.addComponent(btnFin)
					.addGap(33))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lbValor)
						.addComponent(txtValor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lbCurrency)
						.addComponent(txtCurrency, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lbAno)
						.addComponent(txtAno, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
					.addComponent(btnFin)
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}
	
	public denominacion dameValores(){
		denominacion val = null;
		
		return val;
	}
	
	private void devolverValoresDenominacion() {
		// TODO Falta de implementar
	}
}
