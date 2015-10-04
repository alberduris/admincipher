package org.admincipher;

import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.Insets;

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
	private JLabel lblRelleno;
	
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
		setSize(500, 300);
		setLocationRelativeTo(null);
		
		contentPane = new JPanel();
		
		GridLayout gridLayout = new GridLayout(0,2,10,5);
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(gridLayout);
		setContentPane(contentPane);
		
		GridBagLayout gridBagLayout1 = new GridBagLayout();
		GridBagLayout gridBagLayout2 = new GridBagLayout();
		gridBagLayout2.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0};
		
		panelOcultar = new JPanel();
		panelOcultar.setLayout(gridBagLayout1);
		panelMostrar = new JPanel();
		panelMostrar.setLayout(gridBagLayout2);
		
		contentPane.add(panelOcultar);
		contentPane.add(panelMostrar);
		
		
		//Label Ruta
		lblRutaOcultar = new JLabel("Ruta: ");
		GridBagConstraints cLblRutaOcultar = new GridBagConstraints();
		cLblRutaOcultar.gridwidth = 1;
		cLblRutaOcultar.weightx = 0.5;
		cLblRutaOcultar.anchor = GridBagConstraints.CENTER;
		cLblRutaOcultar.gridx = 0;
		cLblRutaOcultar.gridy = 0;
		panelOcultar.add(lblRutaOcultar,cLblRutaOcultar);
		
		lblRutaMostrar = new JLabel("Ruta: ");
		GridBagConstraints cLblRutaMostrar = new GridBagConstraints();
		cLblRutaMostrar.gridwidth = 1;
		cLblRutaMostrar.weightx = 0.5;
		cLblRutaMostrar.anchor = GridBagConstraints.CENTER;
		cLblRutaMostrar.gridx = 0;
		cLblRutaMostrar.gridy = 0;
		panelMostrar.add(lblRutaMostrar,cLblRutaMostrar);
		
		//TextField ruta
		txtRutaOcultar = new JTextField();
		GridBagConstraints cTxtRutaOcultar = new GridBagConstraints();
		cTxtRutaOcultar.weightx = 1;
		cTxtRutaOcultar.gridx = 1;
		cTxtRutaOcultar.gridy = 0;
		cTxtRutaOcultar.fill = GridBagConstraints.HORIZONTAL;
		panelOcultar.add(txtRutaOcultar,cTxtRutaOcultar);
		
		txtRutaMostrar = new JTextField();
		GridBagConstraints cTxtRutaMostrar = new GridBagConstraints();
		cTxtRutaMostrar.weightx = 1;
		cTxtRutaMostrar.gridx = 1;
		cTxtRutaMostrar.gridy = 0;
		cTxtRutaMostrar.fill = GridBagConstraints.HORIZONTAL;
		panelMostrar.add(txtRutaMostrar,cTxtRutaMostrar);
	
		
		//Label bit
		lblBitOcultar = new JLabel("Bit: ");
		GridBagConstraints cLblBitOcultar = new GridBagConstraints();
		cLblBitOcultar.gridx = 0;
		cLblBitOcultar.gridy = 1;
		panelOcultar.add(lblBitOcultar,cLblBitOcultar);
					
		lblBitMostrar = new JLabel("Bit: ");
		GridBagConstraints cLblBitMostrar = new GridBagConstraints();
		cLblBitMostrar.gridx = 0;
		cLblBitMostrar.gridy = 1;
		panelMostrar.add(lblBitMostrar,cLblBitMostrar);
		
		//Spinner bit
		spinnerBitOcultar = new JSpinner();
		GridBagConstraints cSpinnerBitOcultar = new GridBagConstraints();
		cSpinnerBitOcultar.gridx = 1;
		cSpinnerBitOcultar.gridy = 1;
		panelOcultar.add(spinnerBitOcultar,cSpinnerBitOcultar);
		
		spinnerBitMostrar = new JSpinner();
		GridBagConstraints cSpinnerBitMostrar = new GridBagConstraints();
		cSpinnerBitMostrar.gridx = 1;
		cSpinnerBitMostrar.gridy = 1;
		panelMostrar.add(spinnerBitMostrar,cSpinnerBitMostrar);
		
		//Label vacio
		lblRelleno = new JLabel();
		GridBagConstraints cLblRelleno = new GridBagConstraints();
		cLblRelleno.insets = new Insets(20, 0, 0, 0);
		cLblRelleno.gridx = 0;
		cLblRelleno.gridy = 2;
		panelMostrar.add(lblRelleno, cLblRelleno);
		
		//Label mensaje
		lblMensaje = new JLabel("Mensaje: ");
		GridBagConstraints cLblMensaje = new GridBagConstraints();
		cLblMensaje.gridwidth = 1;
		cLblMensaje.weightx = 0.5;
		cLblMensaje.anchor = GridBagConstraints.CENTER;
		cLblMensaje.gridx = 0;
		cLblMensaje.gridy = 2;
		panelOcultar.add(lblMensaje,cLblMensaje);
		
		//TextField mensaje
		txtMensaje = new JTextField();
		GridBagConstraints cTxtMensaje = new GridBagConstraints();
		cTxtMensaje.weightx = 1;
		cTxtMensaje.gridx = 1;
		cTxtMensaje.gridy = 2;
		cTxtMensaje.fill = GridBagConstraints.HORIZONTAL;
		panelOcultar.add(txtMensaje,cTxtMensaje);
		
		//Botones
		btnOcultar = new JButton("Ocultar");
		GridBagConstraints cBtnOcultar = new GridBagConstraints();
		cBtnOcultar.gridwidth = 3;
		cBtnOcultar.fill = GridBagConstraints.HORIZONTAL;
		cBtnOcultar.gridx = 0;
		cBtnOcultar.gridy = 3;
		panelOcultar.add(btnOcultar,cBtnOcultar);
		
		btnMostrar = new JButton("Mostrar");
		GridBagConstraints cBtnMostrar = new GridBagConstraints();
		cBtnMostrar.gridwidth = 3;
		cBtnMostrar.fill = GridBagConstraints.HORIZONTAL;
		cBtnMostrar.gridx = 0;
		cBtnMostrar.gridy = 3;
		panelMostrar.add(btnMostrar,cBtnMostrar);
		
		
		
		
		
	}

}
