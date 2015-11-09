package org.ciphermethods.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.SpinnerNumberModel;

import org.ciphermethods.DiscoAlberti;

public class VentanaDiscoAlbertiDecrypt extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panelConBorderLayout;
	private JPanel panelConFlowLayout;
	
	//Titulo
	private JLabel lblTitulo;
	
	//Clave
	private JLabel lblClave;
	private JComboBox<Object> cl1,cl2;
	
	//Direccion
	private JLabel lblDireccion;
	private JComboBox<Object> direc;
	
	//Movimiento
	private JLabel lblMovimiento;
	private JSpinner mov;
	
	//Disco Interno
	private JLabel lblDiscoInterno;
	private JButton[] disco;
	private JButton seleccion;
	
	//Area de texto
	private JLabel lblTexto;
	private JTextArea txtTexto;
	
	//Boton encriptar
	private JButton btnEncriptar;
	
	private DiscoAlberti dA;
	
	private Dimension dimPreferida = new Dimension(560,435);
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaDiscoAlbertiDecrypt frame = new VentanaDiscoAlbertiDecrypt();
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
	public VentanaDiscoAlbertiDecrypt() {
		dA = new DiscoAlberti();
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(dimPreferida);
		
		//Tamaño de la ventana
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

        //Localizacion de la ventana
        int w = this.getSize().width;
        int h = this.getSize().height;
        int x = (dim.width-w)/2;
        int y = (dim.height-h)/2;

        //Colocara la ventana
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
		
		getTituloCryptDiscoAlberti();
		
		getLblClave();
		getComboCl1();
		getComboCl2();
		
		getLblDireccion();
		getComboDirec();
		
		getLblMovimiento();
		getSpinnerMov();
		
		getLblDiscoInterno();
		getBotonesDiscoInterior();
		
		getLblTexto();
		getTxtTexto();
		
		getBtnDesencriptar();
		
		
	}
	
	private void getTituloCryptDiscoAlberti(){
		
		lblTitulo = new JLabel("Disco De Alberti");
		lblTitulo.setHorizontalAlignment(0);
		lblTitulo.setFont(new Font("Arial", Font.BOLD, 24));
		lblTitulo.setOpaque(true);
		lblTitulo.setForeground(Color.black);
		
		panelConBorderLayout.add(lblTitulo, BorderLayout.NORTH);
		panelConFlowLayout.add(Box.createRigidArea(new Dimension(0,70)));
		
	}
	
	private void getLblClave(){
		lblClave = new JLabel("Clave: ");
		lblClave.setHorizontalAlignment(0);
		
		panelConFlowLayout.add(lblClave);
		
	}
	
	private void getComboCl1(){
		
		cl1 = new JComboBox<Object>(dA.obtenerDiscoFijo());
		cl1.setSelectedIndex(0);
		panelConFlowLayout.add(cl1);
		
	}
	
	private void getComboCl2(){
		
		cl2 = new JComboBox<Object>(dA.obtenerDiscoMovil());
		cl2.setSelectedIndex(0);
		panelConFlowLayout.add(cl2);
		panelConFlowLayout.add(Box.createRigidArea(new Dimension(25,0)));
		
	}
	
	private void getLblDireccion(){
		lblDireccion = new JLabel("Dirección: ");
		lblDireccion.setHorizontalAlignment(0);
		
		panelConFlowLayout.add(lblDireccion);
	}
	
	private void getComboDirec(){
		String[] txt = {"Derecha", "Izquierda"};
		direc = new JComboBox<Object>(txt);
		direc.setSelectedIndex(0);
		
		panelConFlowLayout.add(direc);
		panelConFlowLayout.add(Box.createRigidArea(new Dimension(25,0)));
		
	}
	
	private void getLblMovimiento(){
		lblMovimiento = new JLabel("Movimiento: ");
		lblMovimiento.setHorizontalAlignment(0);
		
		panelConFlowLayout.add(lblMovimiento);
	}
	
	private void getSpinnerMov(){
		mov = new JSpinner();
		SpinnerNumberModel model = 
		        new SpinnerNumberModel(0, //initial value
		                               0, //min
		                               dA.obtenerDiscoMovil().length, //max
		                               1);                //step
		mov.setModel(model);
		
		panelConFlowLayout.add(mov);
	}
	
	private void getLblDiscoInterno(){
		lblDiscoInterno = new JLabel("Disco interno: ");
		lblDiscoInterno.setHorizontalAlignment(0);
		
		
		panelConFlowLayout.add(Box.createRigidArea(new Dimension(210,0)));
		panelConFlowLayout.add(lblDiscoInterno);
		panelConFlowLayout.add(Box.createRigidArea(new Dimension(210,0)));
		
	}
	
	private void getBotonesDiscoInterior(){
		
		disco = new JButton[dA.obtenerDiscoMovil().length];
		for(int i=0; i<dA.obtenerDiscoMovil().length; i++){
			disco[i] = new JButton(dA.obtenerDiscoMovil()[i]);
			
			//Button customization
			disco[i].setMargin(new Insets(0,0,0,0));
			disco[i].setFont(new Font("Arial", Font.PLAIN, 14));
			disco[i].setPreferredSize(new Dimension(40,40));
			disco[i].setMinimumSize(new Dimension(40,40));
			disco[i].setMaximumSize(new Dimension(40,40));
			//End Button customization
			
			panelConFlowLayout.add(disco[i]);
			disco[i].addActionListener(new ActionListener(){
				
				@Override
				public void actionPerformed(ActionEvent e) {
					JButton boton = ((JButton) e.getSource());
					if(seleccion == null){
						seleccion = boton;
						boton.setBackground(Color.GREEN);
						boton.updateUI();
					}else{
						if(seleccion == boton){
							seleccion = null;
							boton.setBackground(null);
							boton.updateUI();
						}else{
							String botonAux = boton.getText();
							boton.setText(seleccion.getText());
							seleccion.setText(botonAux);
							seleccion.setBackground(null);
							seleccion = null;
							boton.updateUI();
						}
					}
				}
			});	
		}
		
	}
	
	private void getLblTexto(){
		lblTexto = new JLabel("  Texto:   ");
		lblTexto.setHorizontalAlignment(0);
		
		panelConFlowLayout.add(lblTexto);
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
		areaScrollPane.setPreferredSize(new Dimension(this.getSize().width-50, 100));
		
		panelConFlowLayout.add(areaScrollPane);
	}
	
	private void getBtnDesencriptar(){
		btnEncriptar = new JButton("Desencriptar");
		btnEncriptar.setHorizontalAlignment(0);
		btnEncriptar.setPreferredSize(new Dimension(125,40));
		
		btnEncriptar.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String discoCompleto = "";
				for(int i =0; i<disco.length; i++){
					discoCompleto += disco[i].getText().charAt(0);
				}
				dA.crearDiscoInterno(discoCompleto);
				String clave = cl1.getSelectedItem()+""+cl2.getSelectedItem();
				dA.introducirClave(clave.charAt(0)+""+clave.charAt(2));
				dA.introducirMovimiento((int) mov.getValue());
				if(direc.getSelectedItem() == "Derecha"){
					dA.introducirDireccion(true);
				}else{
					dA.introducirDireccion(false);
				}
				txtTexto.setEditable(false);
				txtTexto.setText(dA.desencriptar(txtTexto.getText()));
			}
		});
		
		panelConFlowLayout.add(btnEncriptar);
	}
}
