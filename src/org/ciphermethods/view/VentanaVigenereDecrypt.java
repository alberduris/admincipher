package org.ciphermethods.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.NumberFormatter;

import org.ciphermethods.Vigenere;

public class VentanaVigenereDecrypt extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panelConBorderLayout;
	private JPanel panelConFlowLayout;
	
	private JLabel lblTitulo;
	
	private JLabel lblClave;
	private JTextField txtClave; 
	
	private JLabel lblTexto;
	private JTextArea txtTexto; 
	
	private JButton btnEncriptar;
	
	private JDialog dialogAlerta;
	
	private Dimension dimPreferida = new Dimension(300,320);
	

	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaVigenereDecrypt frame = new VentanaVigenereDecrypt();
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
	public VentanaVigenereDecrypt() {
		
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(dimPreferida);
        setLocationRelativeTo(null);
		
		
		contentPane = new JPanel();
		contentPane.setMaximumSize(dimPreferida);
		contentPane.setMinimumSize(dimPreferida);
		contentPane.setPreferredSize(dimPreferida);
		setContentPane(contentPane);
		panelConBorderLayout = new JPanel();
		panelConFlowLayout = new JPanel();
		
		panelConBorderLayout.setMaximumSize(dimPreferida);
		panelConBorderLayout.setMinimumSize(dimPreferida);
		panelConBorderLayout.setPreferredSize(dimPreferida);
		
		panelConFlowLayout.setMaximumSize(dimPreferida);
		panelConFlowLayout.setMinimumSize(dimPreferida);
		panelConFlowLayout.setPreferredSize(dimPreferida);
		
		
		
		BorderLayout border = new BorderLayout();
		panelConBorderLayout.setLayout(border);
		FlowLayout box = new FlowLayout(FlowLayout.CENTER);
		panelConFlowLayout.setLayout(box);
		
		
		contentPane.add(panelConBorderLayout);
		panelConBorderLayout.add(panelConFlowLayout,BorderLayout.CENTER);
		
		getTituloCryptVigenere();
		
		
		getLblClave();
		getTxtClave();
		
		getLblTexto();
		getTxtTexto();
		
		getBtnDesencriptar();
		
	
	}
	
	private void getTituloCryptVigenere(){
		
		lblTitulo = new JLabel("Vigenère");
		lblTitulo.setHorizontalAlignment(0);
		lblTitulo.setFont(new Font("Arial", Font.BOLD, 24));
		lblTitulo.setOpaque(true);
		lblTitulo.setForeground(Color.black);
		
		
		panelConBorderLayout.add(lblTitulo, BorderLayout.NORTH);
		
		
	}
	
	
	private void getLblClave(){
		lblClave = new JLabel("Clave: ");
		
		
		panelConFlowLayout.add(Box.createRigidArea(new Dimension(100,30)));
		panelConFlowLayout.add(lblClave);
		panelConFlowLayout.add(Box.createRigidArea(new Dimension(100,0)));
	}
	
	private void getTxtClave(){
		txtClave = new JTextField();
		txtClave.setEditable(true);
		txtClave.setPreferredSize(new Dimension(210,30));
		txtClave.setHorizontalAlignment(JTextField.CENTER);
		
		
		panelConFlowLayout.add(txtClave);
	}
	
	private void getLblTexto(){
		lblTexto = new JLabel("Texto: ");
		lblTexto.setHorizontalAlignment(0);
		
		panelConFlowLayout.add(Box.createRigidArea(new Dimension(100,0)));
		panelConFlowLayout.add(lblTexto);
		panelConFlowLayout.add(Box.createRigidArea(new Dimension(100,0)));
	}
	
	private void getTxtTexto(){
		txtTexto = new JTextArea();
		txtTexto.setRows(10);
		txtTexto.setEditable(true);
		txtTexto.setFont(new Font("Serif", Font.ITALIC, 16));
		txtTexto.setLineWrap(true);
		txtTexto.setWrapStyleWord(true);
		
		txtTexto.setPreferredSize(new Dimension(250,100));
		
		JScrollPane areaScrollPane = new JScrollPane(txtTexto);
		areaScrollPane.setVerticalScrollBarPolicy(
		                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		areaScrollPane.setPreferredSize(new Dimension(250, 100));
		
		panelConFlowLayout.add(areaScrollPane);
	}
	
	
	
	
	
	private void getBtnDesencriptar(){
		btnEncriptar = new JButton("Desencriptar");
		btnEncriptar.setHorizontalAlignment(0);
		btnEncriptar.setPreferredSize(new Dimension(125,40));
		
		btnEncriptar.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				Vigenere vg = Vigenere.getVigenere();
				vg.introducirTexto(txtTexto.getText().toUpperCase());
				vg.introducirClave(txtClave.getText().toUpperCase());
				txtTexto.setText(vg.descifrar());
				txtTexto.setEditable(false);
				txtClave.setEditable(false);
				vg.reset();
			}
			
		});
		
		panelConFlowLayout.add(Box.createRigidArea(new Dimension(0,50)));
		panelConFlowLayout.add(btnEncriptar);
	}
	
	private void crearDialogAlerta(){
		GridBagConstraints csTexto = new GridBagConstraints();
		GridBagConstraints csTexto2 = new GridBagConstraints();
		GridBagConstraints csBoton = new GridBagConstraints();
		
		csTexto.weighty = 1;
		csTexto.gridx = 0;
		csTexto.gridy = 0;
		
		csTexto2.weighty = 1;
		csTexto2.gridx = 0;
		csTexto2.gridy = 1;
		
		csBoton.weighty = 1;
		csBoton.gridx = 0;
		csBoton.gridy = 2;
		
		JLabel texto = new JLabel();
		JLabel texto2 = new JLabel();
		
		texto.setText("El alfabeto disponible para encriptar es:");
		texto2.setText("a-b-c-d-e-f-g-h-i-j-k-l-m-n-o-p-q-r-s-t-u-v-w-x-y-z");
		
		JButton boton = new JButton("Cerrar");
		
		boton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				dialogAlerta.dispose();
			}
			
		});
		
		dialogAlerta = new JDialog();
		dialogAlerta.setSize(300,125);
		dialogAlerta.setModal(false);
		dialogAlerta.setVisible(true);
		dialogAlerta.setLocationRelativeTo(contentPane);
		dialogAlerta.setTitle("Alfabeto");
		
		
		dialogAlerta.setLayout(new GridBagLayout());
		dialogAlerta.getContentPane().setBackground(new Color(0xFFFFFF));
	

		dialogAlerta.add(texto,csTexto);
		dialogAlerta.add(texto2,csTexto2);
		dialogAlerta.add(boton,csBoton);
		
	}

}
