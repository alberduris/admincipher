package org.admincipher;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;



public class VentanaPrincipal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	
	private JPanel panelPrincipal;
	
	private JPanel panelOcultar;
	private JPanel panelMostrar;
	
	private JLabel lblTitulo;
	
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
		
		//OPCIONES DE VENTANA
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 300);
		setLocationRelativeTo(null);
		
		//CREAR PANELES
		contentPane = new JPanel();
		panelPrincipal = new JPanel();
		panelOcultar = new JPanel();
		panelMostrar = new JPanel();
		
		//CREAR LAYOUTS
		BorderLayout borderLayout = new BorderLayout();
		GridLayout gridLayout = new GridLayout(0,2,10,5);
		GridBagLayout gridBagLayout1 = new GridBagLayout();
		GridBagLayout gridBagLayout2 = new GridBagLayout();
		
		
		//AÑADIR LAYOUTS Y PANELES
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(borderLayout);
		setContentPane(contentPane);
		
		panelPrincipal.setLayout(gridLayout);
		Border paddingBorder = BorderFactory.createEmptyBorder(10,10,10,10);
		Border border = BorderFactory.createLineBorder(Color.BLACK);
		panelPrincipal.setBorder(BorderFactory.createCompoundBorder(border,paddingBorder));
		
		
		contentPane.add(panelPrincipal, BorderLayout.CENTER);
		
		panelOcultar.setLayout(gridBagLayout1);
		panelMostrar.setLayout(gridBagLayout2);
		
		panelPrincipal.add(panelOcultar);
		panelPrincipal.add(panelMostrar);
		
		//LabelTitulo
		crearLblTitulo();
		
		//Label Ruta
		crearLblRutaOcultar();
		
		crearLblRutaMostrar();
		
		//TextField ruta
		crearTxtRutaOcultar();
		
		crearTxtRutaMostrar();
	
		
		//Label bit
		crearLblBitOcultar();
					
		crearLblBitMostrar();
		
		//Spinner bit
		crearSpinnerBitOcultar();
		
		crearSpinnerBitMostrar();
		
		//Label vacio
		crearLblRelleno();
		
		//Label mensaje
		crearLblMensaje();
		
		//TextField mensaje
		crearTxtMensaje();
		
		//Botones
		crearBtnOcultar();
		
		crearBtnMostrar();
		
		
		
		
		
	}

	private void crearLblTitulo() {
		lblTitulo = new JLabel("APLICACION ESTEGANOGRAFIA");
		
		Border paddingBorder = BorderFactory.createEmptyBorder(10,10,10,10);
		Border border = BorderFactory.createBevelBorder(0);
		lblTitulo.setBorder(BorderFactory.createCompoundBorder(border,paddingBorder));
		
		
		lblTitulo.setFont(new Font("Arial", Font.BOLD, 24));
		
		lblTitulo.setHorizontalAlignment(0);
		contentPane.add(lblTitulo,BorderLayout.NORTH);
		
	}

	private void crearBtnMostrar() {
		btnMostrar = new JButton("Mostrar");
		GridBagConstraints cBtnMostrar = new GridBagConstraints();
		cBtnMostrar.ipady = 15;
		cBtnMostrar.gridwidth = 3;
		cBtnMostrar.fill = GridBagConstraints.HORIZONTAL;
		cBtnMostrar.gridx = 0;
		cBtnMostrar.gridy = 3;
		panelMostrar.add(btnMostrar,cBtnMostrar);
	}

	private void crearBtnOcultar() {
		btnOcultar = new JButton("Ocultar");
		GridBagConstraints cBtnOcultar = new GridBagConstraints();
		cBtnOcultar.ipady = 15;
		cBtnOcultar.gridwidth = 3;
		cBtnOcultar.fill = GridBagConstraints.HORIZONTAL;
		cBtnOcultar.gridx = 0;
		cBtnOcultar.gridy = 3;
		
		btnOcultar.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				ocultar();
				
			}
			
		});
		
		panelOcultar.add(btnOcultar,cBtnOcultar);
	}

	private void crearTxtMensaje() {
		txtMensaje = new JTextField();
		GridBagConstraints cTxtMensaje = new GridBagConstraints();
		
		cTxtMensaje.weightx = 1;
		cTxtMensaje.gridx = 1;
		cTxtMensaje.gridy = 2;
		cTxtMensaje.fill = GridBagConstraints.HORIZONTAL;
		panelOcultar.add(txtMensaje,cTxtMensaje);
	}

	private void crearLblMensaje() {
		lblMensaje = new JLabel("Mensaje: ");
		GridBagConstraints cLblMensaje = new GridBagConstraints();
		cLblMensaje.ipady = 15;
		cLblMensaje.gridwidth = 1;
		cLblMensaje.weightx = 0.5;
		cLblMensaje.anchor = GridBagConstraints.CENTER;
		cLblMensaje.gridx = 0;
		cLblMensaje.gridy = 2;
		panelOcultar.add(lblMensaje,cLblMensaje);
	}

	private void crearLblRelleno() {
		lblRelleno = new JLabel();
		GridBagConstraints cLblRelleno = new GridBagConstraints();
		cLblRelleno.ipady = 7;
		cLblRelleno.insets = new Insets(20, 0, 0, 0);
		cLblRelleno.gridx = 0;
		cLblRelleno.gridy = 2;
		panelMostrar.add(lblRelleno, cLblRelleno);
	}

	private void crearSpinnerBitMostrar() {
		spinnerBitMostrar = new JSpinner();
		
		SpinnerNumberModel model =
		        new SpinnerNumberModel(1, //initial value
		                               1, //min
		                               8, //max
		                               1);                //step
		spinnerBitMostrar.setModel(model);
		
		GridBagConstraints cSpinnerBitMostrar = new GridBagConstraints();
		cSpinnerBitMostrar.ipadx = 5;
		cSpinnerBitMostrar.ipady = 5;
		cSpinnerBitMostrar.gridx = 1;
		cSpinnerBitMostrar.gridy = 1;
		panelMostrar.add(spinnerBitMostrar,cSpinnerBitMostrar);
	}

	private void crearSpinnerBitOcultar() {
		spinnerBitOcultar = new JSpinner();
		
		SpinnerNumberModel model =
		        new SpinnerNumberModel(1, //initial value
		                               1, //min
		                               8, //max
		                               1);                //step
		spinnerBitOcultar.setModel(model);
		
		
		GridBagConstraints cSpinnerBitOcultar = new GridBagConstraints();
		cSpinnerBitOcultar.ipadx = 5;
		cSpinnerBitOcultar.ipady = 5;
		cSpinnerBitOcultar.gridx = 1;
		cSpinnerBitOcultar.gridy = 1;
		panelOcultar.add(spinnerBitOcultar,cSpinnerBitOcultar);
	}

	private void crearLblBitMostrar() {
		lblBitMostrar = new JLabel("Bit: ");
		GridBagConstraints cLblBitMostrar = new GridBagConstraints();
		cLblBitMostrar.ipady = 15;
		cLblBitMostrar.gridx = 0;
		cLblBitMostrar.gridy = 1;
		panelMostrar.add(lblBitMostrar,cLblBitMostrar);
	}

	private void crearLblBitOcultar() {
		lblBitOcultar = new JLabel("Bit: ");
		GridBagConstraints cLblBitOcultar = new GridBagConstraints();
		cLblBitOcultar.ipady = 10;
		cLblBitOcultar.gridx = 0;
		cLblBitOcultar.gridy = 1;
		panelOcultar.add(lblBitOcultar,cLblBitOcultar);
	}

	private void crearTxtRutaMostrar() {
		txtRutaMostrar = new JTextField();
		GridBagConstraints cTxtRutaMostrar = new GridBagConstraints();
		
		cTxtRutaMostrar.weightx = 1;
		cTxtRutaMostrar.gridx = 1;
		cTxtRutaMostrar.gridy = 0;
		cTxtRutaMostrar.fill = GridBagConstraints.HORIZONTAL;
		panelMostrar.add(txtRutaMostrar,cTxtRutaMostrar);
	}

	private void crearTxtRutaOcultar() {
		txtRutaOcultar = new JTextField();
		GridBagConstraints cTxtRutaOcultar = new GridBagConstraints();
		
		cTxtRutaOcultar.weightx = 1;
		cTxtRutaOcultar.gridx = 1;
		cTxtRutaOcultar.gridy = 0;
		cTxtRutaOcultar.fill = GridBagConstraints.HORIZONTAL;
		panelOcultar.add(txtRutaOcultar,cTxtRutaOcultar);
	}

	private void crearLblRutaMostrar() {
		lblRutaMostrar = new JLabel("Ruta: ");
		GridBagConstraints cLblRutaMostrar = new GridBagConstraints();
		cLblRutaMostrar.ipady = 15;
		cLblRutaMostrar.gridwidth = 1;
		cLblRutaMostrar.weightx = 0.5;
		cLblRutaMostrar.anchor = GridBagConstraints.CENTER;
		cLblRutaMostrar.gridx = 0;
		cLblRutaMostrar.gridy = 0;
		panelMostrar.add(lblRutaMostrar,cLblRutaMostrar);
	}

	private void crearLblRutaOcultar() {
		lblRutaOcultar = new JLabel("Ruta: ");
		GridBagConstraints cLblRutaOcultar = new GridBagConstraints();
		cLblRutaOcultar.ipady = 15;
		cLblRutaOcultar.gridwidth = 1;
		cLblRutaOcultar.weightx = 0.5;
		cLblRutaOcultar.anchor = GridBagConstraints.CENTER;
		cLblRutaOcultar.gridx = 0;
		cLblRutaOcultar.gridy = 0;
		panelOcultar.add(lblRutaOcultar,cLblRutaOcultar);
	}
	
	private void ocultar(){
		String rutaOcultar = txtRutaOcultar.getText();
		String mensaje = txtMensaje.getText();
		int bit = (int) spinnerBitOcultar.getValue();
		System.out.println("Ruta: "+rutaOcultar+"\nMensaje: "+mensaje+"\nBit: "+bit);
		
		try {
			Esteganografia es = new Esteganografia(rutaOcultar,mensaje,bit);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
