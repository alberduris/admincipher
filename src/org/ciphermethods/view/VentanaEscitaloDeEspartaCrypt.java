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

import org.ciphermethods.EscitaloDeEsparta;

public class VentanaEscitaloDeEspartaCrypt extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panelConBorderLayout;
	private JPanel panelConFlowLayout;
	
	private JLabel lblTitulo;
	
	private JLabel lblMedidas;
	
	private JLabel lblFilas;
	private JSpinner spinnerFilas; 
	
	private JLabel lblColumnas;
	private JSpinner spinnerColumnas; 
	
	//private JLabel lblClave;
	private JButton btnGenerarClave;
	private JTextField txtClave;
	
	private JLabel lblTexto;
	private JTextArea txtTexto;
	
	private JButton btnEncriptar;
	
	private JDialog dialogAlerta;
	
	private Dimension dimPreferida = new Dimension(300,380);
	
	private EscitaloDeEsparta ede = new EscitaloDeEsparta();
	
	
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
		
		getTituloCryptEscitalo();
		
		getLblMedidas();
		
		getLblFilas();
		getSpinnerFilas();
		
		getLblColumnas();
		getSpinnerColumnas();
		
		getBtnClave();
		getTxtClave();
		
		getLblTexto();
		getTxtTexto();
		
		getBtnEncriptar();
		
		ede.reset();
	}
	
	private void getTituloCryptEscitalo(){
		
		lblTitulo = new JLabel("Escitalo de Esparta");
		lblTitulo.setHorizontalAlignment(0);
		lblTitulo.setFont(new Font("Arial", Font.BOLD, 24));
		lblTitulo.setOpaque(true);
		lblTitulo.setForeground(Color.black);
		
		panelConBorderLayout.add(lblTitulo, BorderLayout.NORTH);
		
	}
	
	private void getLblMedidas(){
		lblMedidas = new JLabel("Medidas del bastón: ");
		lblMedidas.setHorizontalAlignment(0);
		
	
		panelConFlowLayout.add(Box.createRigidArea(new Dimension(60,0)));
		panelConFlowLayout.add(lblMedidas);
		panelConFlowLayout.add(Box.createRigidArea(new Dimension(60,0)));
	}
	
	private void getLblFilas(){
		lblFilas = new JLabel("Diametro: ");
		lblFilas.setHorizontalAlignment(0);
		
		
		//panelConFlowLayout.add(Box.createRigidArea(new Dimension(0,50)));
		panelConFlowLayout.add(lblFilas);
	}
	
	private void getSpinnerFilas(){
		spinnerFilas = new JSpinner();
		SpinnerNumberModel model =
		        new SpinnerNumberModel(1, //initial value
		                               1, //min
		                               9, //max
		                               1);                //step
		spinnerFilas.setModel(model);
		
		spinnerFilas.addChangeListener(new ChangeListener(){


			@Override
			public void stateChanged(ChangeEvent arg0) {
			}
			
		});
		
	
		spinnerFilas.setMinimumSize(new Dimension(35,25));
		spinnerFilas.setPreferredSize(new Dimension(35,25));
		spinnerFilas.setMaximumSize(new Dimension(Short.MAX_VALUE, Short.MAX_VALUE));
		
		panelConFlowLayout.add(spinnerFilas);
	}
	
	private void getLblColumnas(){
		lblColumnas = new JLabel("Longitud: ");
		lblColumnas.setHorizontalAlignment(0);
		
		
		panelConFlowLayout.add(Box.createRigidArea(new Dimension(0,50)));
		panelConFlowLayout.add(lblColumnas);
	}
	
	private void getSpinnerColumnas(){
		spinnerColumnas = new JSpinner();
		SpinnerNumberModel model =
		        new SpinnerNumberModel(1, //initial value
		                               1, //min
		                               9, //max
		                               1);                //step
		spinnerColumnas.setModel(model);
		
		spinnerColumnas.addChangeListener(new ChangeListener(){


			@Override
			public void stateChanged(ChangeEvent arg0) {
				txtClave.setText("");
			}
			
		});
		
	
		spinnerColumnas.setMinimumSize(new Dimension(35,25));
		spinnerColumnas.setPreferredSize(new Dimension(35,25));
		spinnerColumnas.setMaximumSize(new Dimension(Short.MAX_VALUE, Short.MAX_VALUE));
		
		panelConFlowLayout.add(spinnerColumnas);
	}
	
	private void getBtnClave(){
		btnGenerarClave = new JButton("Generar clave");
		btnGenerarClave.setHorizontalAlignment(0);
		btnGenerarClave.setPreferredSize(new Dimension(125,30));
		
		btnGenerarClave.addActionListener(new ActionListener(){
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ede.setFilas((int)spinnerFilas.getValue());
				ede.setColumnas((int)spinnerColumnas.getValue());
				txtClave.setText(ede.generarClaveAleatoria());
				
				if(txtTexto.equals("El texto es demasiado largo y no cabe en el bastón que has elegido. "
							+ "Por favor, elige un bastón más grande o introduce menos texto.")){
					txtTexto.setText("");
				}
			}
		});
		
		
		panelConFlowLayout.add(Box.createRigidArea(new Dimension(0,50)));
		panelConFlowLayout.add(btnGenerarClave);
	}
	
	private void getTxtClave(){
		txtClave = new JTextField();
		txtClave.setEditable(false);
		txtClave.setPreferredSize(new Dimension(125,30));
		
		
		panelConFlowLayout.add(Box.createRigidArea(new Dimension(0,50)));
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
				
				
				if(!txtClave.getText().equals("")){
					
				
					//Comprobar longitud
					if(ede.longitudOk((int)spinnerFilas.getValue(),(int)spinnerColumnas.getValue(),txtTexto.getText())){
						ede.setFilas((int)spinnerFilas.getValue());
						ede.setColumnas((int)spinnerColumnas.getValue());
						ede.setTexto(txtTexto.getText());
						ede.encriptarEscitaloDeEsparta();
						
						txtTexto.setEditable(false);
						btnEncriptar.setEnabled(false);
						spinnerColumnas.setEnabled(false);
						spinnerFilas.setEnabled(false);
						btnGenerarClave.setEnabled(false);
						
						txtTexto.setText(ede.getTextoEncriptado());
					}
					else{
						txtTexto.setText("El texto es demasiado largo y no cabe en el bastón que has elegido. "
								+ "Por favor, elige un bastón más grande o introduce menos texto.");
						
					}//Fin longitud
					
				}//Fin clave
				else{
					crearDialogAlerta();
				}
				
				
				
				
			}
			
		});
		
		panelConFlowLayout.add(Box.createRigidArea(new Dimension(0,50)));
		panelConFlowLayout.add(btnEncriptar);
	}
	
	private void crearDialogAlerta(){
		GridBagConstraints csTexto = new GridBagConstraints();
		GridBagConstraints csBoton = new GridBagConstraints();
		
		csTexto.weighty = 1;
		csTexto.gridx = 0;
		csTexto.gridy = 0;
		
		csBoton.weighty = 1;
		csBoton.gridx = 0;
		csBoton.gridy = 1;
		
		JLabel texto = new JLabel();
		
		texto.setText("Primero debes generar una clave");
		
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
