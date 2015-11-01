package org.ciphermethods;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.EmptyBorder;

public class VentanaEscitaloDeEspartaCrypt extends JFrame {

	private JPanel contentPane;
	private JPanel panelConBorderLayout;
	private JPanel panelConFlowLayout;
	
	private JLabel lblTitulo;
	
	private JLabel lblFilas;
	private JSpinner spinnerFilas; 
	
	private JLabel lblColumnas;
	private JSpinner spinnerColumnas; 
	
	//private JLabel lblClave;
	private JButton btnGenerarClave;
	private JTextField txtClave;
	
	private JLabel lblTexto;
	private JTextField txtTexto;
	
	private JButton btnEncriptar;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaEscitaloDeEspartaCrypt frame = new VentanaEscitaloDeEspartaCrypt();
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
	public VentanaEscitaloDeEspartaCrypt() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300, 300);
		setLocationRelativeTo(null);
		
		
		contentPane = new JPanel();
		contentPane.setMaximumSize(new Dimension(300,300));
		contentPane.setMinimumSize(new Dimension(300,300));
		contentPane.setPreferredSize(new Dimension(300,300));
		setContentPane(contentPane);
		panelConBorderLayout = new JPanel();
		panelConFlowLayout = new JPanel();
		panelConBorderLayout.setMaximumSize(new Dimension(300,300));
		panelConBorderLayout.setMinimumSize(new Dimension(300,300));
		panelConBorderLayout.setPreferredSize(new Dimension(300,300));
		panelConFlowLayout.setMaximumSize(new Dimension(300,300));
		panelConFlowLayout.setMinimumSize(new Dimension(300,300));
		panelConFlowLayout.setPreferredSize(new Dimension(300,300));
		
		
		
		BorderLayout border = new BorderLayout();
		panelConBorderLayout.setLayout(border);
		FlowLayout box = new FlowLayout(FlowLayout.CENTER);
		panelConFlowLayout.setLayout(box);
		
		
		contentPane.add(panelConBorderLayout);
		panelConBorderLayout.add(panelConFlowLayout,BorderLayout.CENTER);
		
		getTituloCryptEscitalo();
		
		getLblFilas();
		getSpinnerFilas();
		
		getLblColumnas();
		getSpinnerColumnas();
		
		getBtnClave();
		getTxtClave();
	}
	
	private void getTituloCryptEscitalo(){
		
		lblTitulo = new JLabel("Encriptar por Escitalo de Esparta");
		lblTitulo.setHorizontalAlignment(0);
		lblTitulo.setFont(new Font("Arial", Font.BOLD, 14));
		lblTitulo.setOpaque(true);
		lblTitulo.setForeground(Color.black);
		
		panelConBorderLayout.add(lblTitulo, BorderLayout.NORTH);
		
	}
	
	private void getLblFilas(){
		lblFilas = new JLabel("Nº de filas");
		lblFilas.setHorizontalAlignment(0);
		
		
		panelConFlowLayout.add(Box.createRigidArea(new Dimension(0,50)));
		panelConFlowLayout.add(lblFilas);
	}
	
	private void getSpinnerFilas(){
		spinnerFilas = new JSpinner();
		SpinnerNumberModel model =
		        new SpinnerNumberModel(1, //initial value
		                               1, //min
		                               12, //max
		                               1);                //step
		spinnerFilas.setModel(model);
		
	
		spinnerFilas.setMinimumSize(new Dimension(35,25));
		spinnerFilas.setPreferredSize(new Dimension(35,25));
		spinnerFilas.setMaximumSize(new Dimension(Short.MAX_VALUE, Short.MAX_VALUE));
		
		panelConFlowLayout.add(spinnerFilas);
	}
	
	private void getLblColumnas(){
		lblColumnas = new JLabel("Nº de columnas");
		lblColumnas.setHorizontalAlignment(0);
		
		
		panelConFlowLayout.add(Box.createRigidArea(new Dimension(0,50)));
		panelConFlowLayout.add(lblColumnas);
	}
	
	private void getSpinnerColumnas(){
		spinnerColumnas = new JSpinner();
		SpinnerNumberModel model =
		        new SpinnerNumberModel(1, //initial value
		                               1, //min
		                               12, //max
		                               1);                //step
		spinnerColumnas.setModel(model);
		
	
		spinnerColumnas.setMinimumSize(new Dimension(35,25));
		spinnerColumnas.setPreferredSize(new Dimension(35,25));
		spinnerColumnas.setMaximumSize(new Dimension(Short.MAX_VALUE, Short.MAX_VALUE));
		
		panelConFlowLayout.add(spinnerColumnas);
	}
	
	private void getBtnClave(){
		btnGenerarClave = new JButton("Generar clave");
		btnGenerarClave.setHorizontalAlignment(0);
		
		
		panelConFlowLayout.add(Box.createRigidArea(new Dimension(0,50)));
		panelConFlowLayout.add(btnGenerarClave);
	}
	
	private void getTxtClave(){
		txtClave = new JTextField();
		txtClave.setEditable(false);
		txtClave.setPreferredSize(new Dimension(100,30));
		
		panelConFlowLayout.add(Box.createRigidArea(new Dimension(0,50)));
		panelConFlowLayout.add(txtClave);
	}

}
