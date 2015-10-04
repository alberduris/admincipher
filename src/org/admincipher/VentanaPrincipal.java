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
		
		panelOcultar = new JPanel();
		panelMostrar = new JPanel();
		
		contentPane.add(panelOcultar);
		contentPane.add(panelMostrar);
		
		
		//Label Ruta
		lblRutaOcultar = new JLabel("Ruta: ");
		panelOcultar.add(lblRutaOcultar);
		
		lblRutaMostrar = new JLabel("Ruta: ");
		panelMostrar.add(lblRutaMostrar);
		
		//TextField ruta
		txtRutaOcultar = new JTextField();
		panelOcultar.add(txtRutaOcultar);
		
		txtRutaMostrar = new JTextField();
		panelMostrar.add(txtRutaMostrar);
	
		
		//Label bit
		lblBitOcultar = new JLabel("Bit: ");
		panelOcultar.add(lblBitOcultar);
					
		lblBitMostrar = new JLabel("Bit: ");
		panelMostrar.add(lblBitMostrar);
		
		//Spinner bit
		spinnerBitOcultar = new JSpinner();
		panelOcultar.add(spinnerBitOcultar);
		spinnerBitMostrar = new JSpinner();
		panelMostrar.add(spinnerBitMostrar);
		
		//Label mensaje
		lblMensaje = new JLabel("Mensaje: ");
		panelOcultar.add(lblMensaje);
		
		//TextField mensaje
		txtMensaje = new JTextField("TextField mensaje");
		panelOcultar.add(txtMensaje);
		
		//Botones
		btnOcultar = new JButton("Ocultar");
		panelOcultar.add(btnOcultar);
		
		btnMostrar = new JButton("Mostrar");
		panelMostrar.add(btnMostrar);
		
		
		
		
		
	}

}
