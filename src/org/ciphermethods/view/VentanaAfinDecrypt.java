package org.ciphermethods.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
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

import org.ciphermethods.Afin;
import org.ciphermethods.EscitaloDeEsparta;

public class VentanaAfinDecrypt extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panelConBorderLayout;
	private JPanel panelConFlowLayout;
	
	private JLabel lblTitulo;
	
	private JLabel lblParametroA;
	private JComboBox<Object> comboBoxA; 
	
	private JLabel lblParametroB;
	private JComboBox<Object> comboBoxB; 
	
	private JLabel lblTexto;
	private JButton btnAlfabeto;
	private JTextArea txtTexto;
	
	private JButton btnDesencriptar;
	
	private JDialog dialogAlerta;
	
	private Dimension dimPreferida = new Dimension(300,340);
	
	private Afin afin = new Afin();
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaAfinDecrypt frame = new VentanaAfinDecrypt();
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
	public VentanaAfinDecrypt() {
		afin.reset();
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(dimPreferida);
		
		//Tamaño de la ventana
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

        //Localizacion de la ventana
        int w = this.getSize().width;
        int h = this.getSize().height;
        int x = (dim.width+w*2)/2;
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
		
		getTituloCryptAfin();
		
		//getLblClave();
		
		getLblParametroA();
		getComboBoxA();
		
		getLblParametroB();
		getComboBoxB();
	
		
		getLblTextoYBtnAlfabeto();
		getTxtTexto();
		
		getBtnDesencriptar();
		
	
	}
	
	private void getTituloCryptAfin(){
		
		lblTitulo = new JLabel("Método Afín");
		lblTitulo.setHorizontalAlignment(0);
		lblTitulo.setFont(new Font("Arial", Font.BOLD, 24));
		lblTitulo.setOpaque(true);
		lblTitulo.setForeground(Color.black);
		
		panelConBorderLayout.add(lblTitulo, BorderLayout.NORTH);
		
	}
	
	
	private void getLblParametroA(){
		lblParametroA = new JLabel("Parámetro A: ");
		lblParametroA.setHorizontalAlignment(0);
		
		
		
		panelConFlowLayout.add(lblParametroA);
	}
	
	private void getComboBoxA(){
		Integer[] valoresA = new Integer[]{1,3,5,7,9,11,15,17,19,21,23,25};
		comboBoxA = new JComboBox<Object>(valoresA);
	
		comboBoxA.setMinimumSize(new Dimension(40,25));
		comboBoxA.setPreferredSize(new Dimension(40,25));
		comboBoxA.setMaximumSize(new Dimension(Short.MAX_VALUE, Short.MAX_VALUE));
		
		panelConFlowLayout.add(comboBoxA);
	}
	
	private void getLblParametroB(){
		lblParametroB = new JLabel("Parámetro B: ");
		lblParametroB.setHorizontalAlignment(0);
		
		
		panelConFlowLayout.add(Box.createRigidArea(new Dimension(0,50)));
		panelConFlowLayout.add(lblParametroB);
	}
	
	private void getComboBoxB(){
		Integer[] valoresB = new Integer[26];
		for(int i = 0; i < valoresB.length; i++){
			valoresB[i] = i;
		}
		comboBoxB = new JComboBox<Object>(valoresB);
	
		comboBoxB.setMinimumSize(new Dimension(40,25));
		comboBoxB.setPreferredSize(new Dimension(40,25));
		comboBoxB.setMaximumSize(new Dimension(Short.MAX_VALUE, Short.MAX_VALUE));
	
		
		
		panelConFlowLayout.add(comboBoxB);
		
	}
	
	
		
		

	
	
	
	private void getLblTextoYBtnAlfabeto(){
		lblTexto = new JLabel("Texto");
		lblTexto.setHorizontalAlignment(0);
		
		btnAlfabeto = new JButton("?");
		btnAlfabeto.setHorizontalAlignment(0);
		//Button customization
		btnAlfabeto.setMargin(new Insets(0,0,0,0));
		btnAlfabeto.setFont(new Font("Arial", Font.PLAIN, 12));
		btnAlfabeto.setPreferredSize(new Dimension(20,20));
		btnAlfabeto.setMinimumSize(new Dimension(20,20));
		btnAlfabeto.setMaximumSize(new Dimension(20,20));
		//End Button customization
		
		btnAlfabeto.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				crearDialogAlerta();
				
			}
		});
		
		panelConFlowLayout.add(Box.createRigidArea(new Dimension(0,50)));
		panelConFlowLayout.add(Box.createRigidArea(new Dimension(100,0)));
		panelConFlowLayout.add(lblTexto);
		panelConFlowLayout.add(btnAlfabeto);
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
		
		
		
		
		panelConFlowLayout.add(Box.createRigidArea(new Dimension(0,50)));
		panelConFlowLayout.add(areaScrollPane);
	}
	
	private void getBtnDesencriptar(){
		btnDesencriptar = new JButton("Desencriptar");
		btnDesencriptar.setHorizontalAlignment(0);
		btnDesencriptar.setPreferredSize(new Dimension(125,40));
		
		btnDesencriptar.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				afin.setPrimeraClave((Integer)comboBoxA.getSelectedItem());
				afin.setSegundaClave((Integer)comboBoxB.getSelectedItem());
				afin.setTextoADesencriptar(txtTexto.getText().toLowerCase());
				String textoSalida = afin.desencriptarAfin();
				txtTexto.setText(textoSalida);
				txtTexto.setEditable(false);
				comboBoxA.setEnabled(false);
				comboBoxB.setEnabled(false);
				btnDesencriptar.setEnabled(false);
				
			}
			
		});
		
		panelConFlowLayout.add(Box.createRigidArea(new Dimension(0,50)));
		panelConFlowLayout.add(btnDesencriptar);
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
