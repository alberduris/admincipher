package org.ciphermethods;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

public class VentanaCryptDecrypt extends JFrame {

	private JPanel contentPane;
	private JPanel panelConBorderLayout;
	private JPanel panelConBoxLayout;

	private JLabel lblTitulo;
	private String nombreMetodo;
	
	private JButton btnEncriptar;
	private JButton btnDesencriptar;
	
	private JButton btnAtras;

	private Dimension dimBtn = new Dimension(200, 30);
	private Dimension dimVentana = new Dimension(350, 240);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaCryptDecrypt frame = new VentanaCryptDecrypt();
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
	public VentanaCryptDecrypt() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(dimVentana);
		setLocationRelativeTo(null);

		//setMetodo();
		
		contentPane = new JPanel();
		setContentPane(contentPane);
		panelConBorderLayout = new JPanel();
		panelConBoxLayout = new JPanel();

		BorderLayout border = new BorderLayout();
		panelConBorderLayout.setLayout(border);
		BoxLayout box = new BoxLayout(panelConBoxLayout, BoxLayout.Y_AXIS);
		panelConBoxLayout.setLayout(box);

		contentPane.add(panelConBorderLayout);
		panelConBorderLayout.add(panelConBoxLayout, BorderLayout.CENTER);

		getTituloMonoPoli();
		

		getBtnEncriptar();
		getBtnDesencriptar();
		
		getBtnAtras();
		

	}

	private void getTituloMonoPoli() {
	
		lblTitulo = new JLabel(nombreMetodo);
		lblTitulo.setHorizontalAlignment(0);
		lblTitulo.setFont(new Font("Arial", Font.BOLD, 28));
		lblTitulo.setOpaque(true);
		lblTitulo.setForeground(Color.black);
		
		Border paddingBorder = BorderFactory.createEmptyBorder(10,10,10,10);
		Border border = BorderFactory.createBevelBorder(0);
		lblTitulo.setBorder(BorderFactory.createCompoundBorder(border,paddingBorder));

		panelConBorderLayout.add(lblTitulo, BorderLayout.NORTH);

	}


	private void getBtnEncriptar() {
		btnEncriptar = new JButton("Encriptar");
		btnEncriptar.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnEncriptar.setMinimumSize(dimBtn);
		btnEncriptar.setPreferredSize(dimBtn);
		btnEncriptar.setMaximumSize(new Dimension(Short.MAX_VALUE, Short.MAX_VALUE));
		
		btnEncriptar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				
			}
		});

		panelConBoxLayout.add(Box.createRigidArea(new Dimension(0, 15)));
		panelConBoxLayout.add(btnEncriptar);
	}

	private void getBtnDesencriptar() {
		btnDesencriptar = new JButton("Desencriptar");
		btnDesencriptar.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnDesencriptar.setMinimumSize(dimBtn);
		btnDesencriptar.setPreferredSize(dimBtn);
		btnDesencriptar.setMaximumSize(new Dimension(Short.MAX_VALUE, Short.MAX_VALUE));
		
		btnDesencriptar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
			
				
			}
		});

		panelConBoxLayout.add(Box.createRigidArea(new Dimension(0, 15)));
		panelConBoxLayout.add(btnDesencriptar);
	}
	
	public void setMetodo(String pClave){
		
		switch(pClave){
			case "Escitalo": setEscitalo();
			break;
		}
		//TODO
	}

	private void setEscitalo() {
		nombreMetodo = "Escitalo De Esparta";
		getTituloMonoPoli();
		btnEncriptar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					VentanaEscitaloDeEspartaCrypt frame = new VentanaEscitaloDeEspartaCrypt();
					frame.setVisible(true);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnDesencriptar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					VentanaEscitaloDeEspartaDecrypt frame = new VentanaEscitaloDeEspartaDecrypt();
					frame.setVisible(true);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		
	}
	
	private void getBtnAtras() {
		btnAtras = new JButton("<");
		btnAtras.setEnabled(true);
		btnAtras.setAlignmentX(Component.LEFT_ALIGNMENT);
		
		
		btnAtras.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					VentanaMonoPoli frame = new VentanaMonoPoli();
					frame.setVisible(true);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
				dispose();
				
			}
		});

		panelConBoxLayout.add(Box.createRigidArea(new Dimension(0, 15)));
		panelConBoxLayout.add(leftJustify(btnAtras));
		
	}
	
	private Component leftJustify( JButton btn )  {
	    Box  b = Box.createHorizontalBox();
	    b.add( btn );
	    b.add( Box.createHorizontalGlue() );
	  
	    return b;
	}

}