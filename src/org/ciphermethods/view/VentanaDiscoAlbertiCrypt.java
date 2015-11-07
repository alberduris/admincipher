package org.ciphermethods.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.KeyEventDispatcher;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.AbstractButton;
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
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.text.GapContent;

import org.ciphermethods.DiscoAlberti;

import javafx.scene.control.ComboBox;

public class VentanaDiscoAlbertiCrypt extends JFrame {

	private static final long serialVersionUID = 1L;
	static VentanaDiscoAlbertiCrypt ventana;
	
	private JPanel contentPane;
	
	
	JPanel centro, sur, superior;
	JPanel discoInterior, clave, movimiento, direccion;
	

	JComboBox cl1, cl2, direc;
	JSpinner mov;
	JButton[] disco;
	JButton btnEncriptar;
	
	DiscoAlberti dA;

	Dimension dimPreferida = new Dimension(700,370);
	
	JButton seleccion;
	
	JTextArea txtTexto;
	

	/**
	 * Create the frame.
	 * @throws LineUnavailableException 
	 * @throws UnsupportedAudioFileException 
	 * @throws IOException 
	 */
	public VentanaDiscoAlbertiCrypt() {
		dA = new DiscoAlberti();
		
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(dimPreferida);
		setLocationRelativeTo(null);
		
		contentPane = new JPanel();
		setContentPane(contentPane);
		setLayout(new BorderLayout());
		setVisible(true);
		
		centro = new JPanel();
		centro.setLayout(new GridLayout(2,1));
	
		
		add(centro, BorderLayout.CENTER);
		getTituloCryptAlberti();
		superior = new JPanel();
		superior.setLayout(new GridLayout(1, 3));
		crearClave();
		crearDireccion();
		crearMovimiento();
		centro.add(superior);
		crearOrdenDiscoInterior();
		sur = new JPanel();
		add(sur,BorderLayout.SOUTH);
		sur.setLayout(new BorderLayout());
		getTxtTexto();
		getBtnEncriptar();
	}
		
	private void getTituloCryptAlberti(){
		
		JLabel lblTitulo;		
		lblTitulo = new JLabel("Disco de Alberti");
		lblTitulo.setHorizontalAlignment(0);
		lblTitulo.setFont(new Font("Arial", Font.BOLD, 24));
		lblTitulo.setOpaque(true);
		lblTitulo.setForeground(Color.black);
		
		contentPane.add(lblTitulo,BorderLayout.NORTH);
		
		
	}
	
	private void crearClave(){
		clave = new JPanel();
		JLabel lblClave = new JLabel("Clave: ");
		lblClave.setHorizontalAlignment(0);
		lblClave.setOpaque(true);
		clave.add(lblClave);
		cl1 = new JComboBox<Object>(dA.obtenerDiscoFijo());
		cl1.setSelectedIndex(0);
		clave.add(cl1);
		cl2 = new JComboBox<Object>(dA.obtenerDiscoMovil());
		cl2.setSelectedIndex(0);
		clave.add(cl2);
		superior.add(clave);
	}
	
	private void crearDireccion(){
		direccion = new JPanel();
		JLabel lblDireccion = new JLabel("Dirección: ");
		lblDireccion.setHorizontalAlignment(0);
		lblDireccion.setOpaque(true);
		direccion.add(lblDireccion);
		String[] txt = {"Derecha", "Izquierda"};
		direc = new JComboBox(txt);
		direc.setSelectedIndex(0);
		direccion.add(direc);
		superior.add(direccion);
	}
	
	private void crearMovimiento(){
		movimiento = new JPanel();
		JLabel lblMovimiento = new JLabel("Movimiento: ");
		lblMovimiento.setHorizontalAlignment(0);
		lblMovimiento.setOpaque(true);
		movimiento.add(lblMovimiento);
		mov = new JSpinner();
		SpinnerNumberModel model = 
		        new SpinnerNumberModel(0, //initial value
		                               0, //min
		                               dA.obtenerDiscoMovil().length, //max
		                               1);                //step
		mov.setModel(model);
		movimiento.add(mov);
		superior.add(movimiento);
	}
	
	private void crearOrdenDiscoInterior(){
		discoInterior = new JPanel();
		discoInterior.setLayout(new GridLayout(2,1));
		JPanel interior = new JPanel();
		JLabel lblDisco = new JLabel("Disco Interno: ");
		lblDisco.setHorizontalAlignment(0);
		lblDisco.setOpaque(true);
		discoInterior.add(lblDisco);
		centro.add(discoInterior);
		disco = new JButton[dA.obtenerDiscoMovil().length];
		for(int i=0; i<dA.obtenerDiscoMovil().length; i++){
			disco[i] = new JButton(dA.obtenerDiscoMovil()[i]);
			interior.add(disco[i]);
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
		discoInterior.add(interior);
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
		
		sur.add(areaScrollPane, BorderLayout.NORTH);
	}
	
	private void getBtnEncriptar(){
		btnEncriptar = new JButton("Encriptar");
		btnEncriptar.setHorizontalAlignment(0);
		btnEncriptar.setSize(new Dimension(10,40));
		
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
				txtTexto.setText(dA.encriptar(txtTexto.getText()));
			}
		});
		sur.add(btnEncriptar, BorderLayout.SOUTH);
	}
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaDiscoAlbertiCrypt frame = new VentanaDiscoAlbertiCrypt();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
