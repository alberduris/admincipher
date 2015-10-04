package org.admincipher;

import java.awt.EventQueue;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class VentanaPrincipal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	
	private JPanel panelOcultar;
	private JPanel panelMostrar;
	
	private JLabel lblRutaOcultar;
	private JLabel lblRutaMostrar;
	
	private JTextField txtRutaOcultar;
	private JTextField txtRutaMostrar;
	
	private JLabel lblBitOcultar;
	private JLabel lblBitMostrar;
	
	private JSpinner spinnerBitOcultar;
	private JSpinner spinnerBitMostrar;
	
	private JLabel lblMensaje;
	
	private JTextField txtMensaje;
	
	private JButton btnOcultar;
	private JButton btnMostrar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal frame = new VentanaPrincipal();
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
	public VentanaPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		
		GridLayout gridLayout = new GridLayout(0,2,10,5);
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(gridLayout);
		setContentPane(contentPane);
		
		GridBagLayout gridBagLayout1 = new GridBagLayout();
		GridBagLayout gridBagLayout2 = new GridBagLayout();
		
		contentPane.add(panelOcultar);
		contentPane.add(panelMostrar);
		
		
		//Label Ruta
		lblRutaOcultar = new JLabel("Ruta: ");
		contentPane.add(lblRutaOcultar);
		
		lblRutaMostrar = new JLabel("Ruta: ");
		contentPane.add(lblRutaMostrar);
		
		//TextField ruta
		txtRutaOcultar = new JTextField();
		contentPane.add(txtRutaOcultar);
		
		txtRutaMostrar = new JTextField();
		contentPane.add(txtRutaMostrar);
	
		
		//Label bit
		lblBitOcultar = new JLabel("Bit: ");
		contentPane.add(lblBitOcultar);
					
		lblBitMostrar = new JLabel("Bit: ");
		contentPane.add(lblBitMostrar);
		
		//Spinner bit
		spinnerBitOcultar = new JSpinner();
		contentPane.add(spinnerBitOcultar);
		spinnerBitMostrar = new JSpinner();
		contentPane.add(spinnerBitMostrar);
		
		//Label mensaje
		lblMensaje = new JLabel("Mensaje: ");
		contentPane.add(lblMensaje);
		
		//TextField mensaje
		txtMensaje = new JTextField("TextField mensaje");
		contentPane.add(txtMensaje);
		
		//Botones
		btnOcultar = new JButton("Ocultar");
		contentPane.add(btnOcultar);
		
		btnMostrar = new JButton("Mostrar");
		contentPane.add(btnMostrar);
		
		
		
		
		
	}

}
