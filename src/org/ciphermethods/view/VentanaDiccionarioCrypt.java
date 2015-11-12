package org.ciphermethods.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import org.ciphermethods.Diccionario;
import org.ciphermethods.EscitaloDeEsparta;

public class VentanaDiccionarioCrypt extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panelConBorderLayout;
	private JPanel panelConFlowLayout;
	
	private JLabel lblTitulo;
	
	private JLabel lblClave;
	private JButton btnGenerarClave;
	private JTextField txtClave;
	
	private JLabel lblTexto;
	private JTextArea txtTexto;
	
	private JButton btnEncriptar;
	
	private JDialog dialogAlerta;
	
	private Dimension dimPreferida = new Dimension(300,360);
	
	private Diccionario dic = new Diccionario();
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaDiccionarioCrypt frame = new VentanaDiccionarioCrypt();
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
	public VentanaDiccionarioCrypt() {
		
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(dimPreferida);
		
		//Tamaño de la ventana
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

        //Localizacion de la ventana
        int w = this.getSize().width;
        int h = this.getSize().height;
        int x = (dim.width-w*4)/2;
        int y = (dim.height-h)/2;

        //Colocar la ventana
        this.setLocation(x, y);
       
		
		
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
		
		getTituloCryptDiccionario();
		getLblClave();
		
		
		getBtnClave();
		getTxtClave();
		
		getLblTexto();
		getTxtTexto();
		
		getBtnEncriptar();
		
	}
	
	private void getTituloCryptDiccionario(){
		
		lblTitulo = new JLabel("Método Diccionario");
		lblTitulo.setHorizontalAlignment(0);
		lblTitulo.setFont(new Font("Arial", Font.BOLD, 24));
		lblTitulo.setOpaque(true);
		lblTitulo.setForeground(Color.black);
		
		panelConBorderLayout.add(lblTitulo, BorderLayout.NORTH);
		
	}
	
	private void getLblClave(){
		
		lblClave = new JLabel("Clave");
		lblClave.setHorizontalAlignment(0);
		
		panelConFlowLayout.add(Box.createRigidArea(new Dimension(100,0)));
		panelConFlowLayout.add(lblClave);
		panelConFlowLayout.add(Box.createRigidArea(new Dimension(100,0)));
	}
	
	
	
	
	
	
	
	
	
	private void getBtnClave(){
		btnGenerarClave = new JButton("Generar clave");
		btnGenerarClave.setHorizontalAlignment(0);
		btnGenerarClave.setPreferredSize(new Dimension(125,30));
		
		btnGenerarClave.addActionListener(new ActionListener(){
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				dic.generarPalabraClave();
				txtClave.setText(dic.getPalabraClave());
			
			}
		});
		
		
		
		panelConFlowLayout.add(btnGenerarClave);
	}
	
	private void getTxtClave(){
		txtClave = new JTextField();
		txtClave.setEditable(true);
		txtClave.setPreferredSize(new Dimension(225,30));
		txtClave.setFont(new Font("Arial", Font.PLAIN, 14));
		
		
		
		panelConFlowLayout.add(txtClave);
		
	}
	
	private void getLblTexto(){
		lblTexto = new JLabel("Texto");
		lblTexto.setHorizontalAlignment(0);
		
		
		panelConFlowLayout.add(Box.createRigidArea(new Dimension(0,50)));
		panelConFlowLayout.add(Box.createRigidArea(new Dimension(125,0)));
		panelConFlowLayout.add(lblTexto);
		panelConFlowLayout.add(Box.createRigidArea(new Dimension(125,0)));
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
		
		
		
		
		panelConFlowLayout.add(Box.createRigidArea(new Dimension(0,50)));
		panelConFlowLayout.add(areaScrollPane);
	}
	
	private void getBtnEncriptar(){
		btnEncriptar = new JButton("Encriptar");
		btnEncriptar.setHorizontalAlignment(0);
		btnEncriptar.setPreferredSize(new Dimension(125,40));
		
		btnEncriptar.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				if(txtClave.getText().trim().length() == 0){
					crearDialogAlerta();
				}
				else{
					
					dic.filtrarYSetPalabraClave(txtClave.getText());
					
					if(txtTexto.getText().length() == 0){
						crearDialogNoTexto();
					}
					else{
						dic.setTextoEntrada(txtTexto.getText().toLowerCase());
						dic.encriptarDiccionario();
						txtTexto.setText(dic.getTextoEncriptado());
						txtTexto.setEditable(false);
						btnGenerarClave.setEnabled(false);
						txtClave.setEnabled(false);
						btnEncriptar.setEnabled(false);
					}
				}
					
				
				
				
			}
			
		});
		
		panelConFlowLayout.add(Box.createRigidArea(new Dimension(0,50)));
		panelConFlowLayout.add(btnEncriptar);
	}
	
	private void crearDialogAlerta(){
		GridBagConstraints csTexto = new GridBagConstraints();
		GridBagConstraints csBoton = new GridBagConstraints();
		GridBagConstraints csBoton2 = new GridBagConstraints();
		
		csTexto.weighty = 1;
		csTexto.gridx = 0;
		csTexto.gridy = 0;
		
		csBoton.weighty = 1;
		csBoton.gridx = 0;
		csBoton.gridy = 2;
		
		csBoton2.weighty = 1;
		csBoton2.gridx = 0;
		csBoton2.gridy = 1;
		
		
		JLabel texto = new JLabel();
		
		texto.setText("Primero debes generar una clave");
		
		JButton boton = new JButton("Cerrar");
		JButton boton2 = new JButton("Generar clave");
		
		boton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				dialogAlerta.dispose();
			}
			
		});
		
		boton2.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				dic.generarPalabraClave();
				txtClave.setText(dic.getPalabraClave());
				dialogAlerta.dispose();
			}
			
		});
		
		
		
		dialogAlerta = new JDialog();
		dialogAlerta.setSize(300,125);
		dialogAlerta.setModal(false);
		dialogAlerta.setVisible(true);
		dialogAlerta.setLocationRelativeTo(contentPane);
		dialogAlerta.setTitle("No hay texto");
		
		
		dialogAlerta.setLayout(new GridBagLayout());
		dialogAlerta.getContentPane().setBackground(new Color(0xFFFFFF));
	

		dialogAlerta.add(texto,csTexto);
		dialogAlerta.add(boton,csBoton);
		dialogAlerta.add(boton2,csBoton2);
		
	}
	
	private void crearDialogNoTexto(){
		GridBagConstraints csTexto = new GridBagConstraints();
		GridBagConstraints csBoton = new GridBagConstraints();
		
		csTexto.weighty = 1;
		csTexto.gridx = 0;
		csTexto.gridy = 0;
		
		csBoton.weighty = 1;
		csBoton.gridx = 0;
		csBoton.gridy = 1;
		
		
		
		
		JLabel texto = new JLabel();
		
		texto.setText("No se ha encontrado texto para encriptar");
		
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
		dialogAlerta.setTitle("Mensaje oculto");
		
		
		dialogAlerta.setLayout(new GridBagLayout());
		dialogAlerta.getContentPane().setBackground(new Color(0xFFFFFF));
	

		dialogAlerta.add(texto,csTexto);
		dialogAlerta.add(boton,csBoton);
		
		
	}

}
