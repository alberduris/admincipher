package org.ciphermethods.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
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

public class VentanaPolialfabeticos extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panelConBorderLayout;
	private JPanel panelConBoxLayout;

	private JLabel lblTitulo;

	private JButton btnDiscoAlberti;
	private JButton btnVigenere;
	private JButton btnAtbash;
	
	private JButton btnAtras;
	
	private Dimension dimBtn = new Dimension(200, 30);
	private Dimension dimVentana = new Dimension(400, 300);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPolialfabeticos frame = new VentanaPolialfabeticos();
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
	public VentanaPolialfabeticos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(dimVentana);
		setLocationRelativeTo(null);

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

		getBtnDiscoAlberti();
		getBtnVigenere();
		//getBtnAtbash();
		
		getBtnAtras();
	}

	private void getTituloMonoPoli() {
	
		lblTitulo = new JLabel("Métodos polialfabéticos");
		lblTitulo.setHorizontalAlignment(0);
		lblTitulo.setFont(new Font("Arial", Font.BOLD, 28));
		lblTitulo.setOpaque(true);
		lblTitulo.setForeground(Color.black);
		
		Border paddingBorder = BorderFactory.createEmptyBorder(10,10,10,10);
		Border border = BorderFactory.createBevelBorder(0);
		lblTitulo.setBorder(BorderFactory.createCompoundBorder(border,paddingBorder));

		panelConBorderLayout.add(lblTitulo, BorderLayout.NORTH);

	}



	private void getBtnDiscoAlberti() {
		btnDiscoAlberti = new JButton("Disco de Alberti");
		btnDiscoAlberti.setEnabled(true);
		btnDiscoAlberti.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnDiscoAlberti.setMinimumSize(dimBtn);
		btnDiscoAlberti.setPreferredSize(dimBtn);
		btnDiscoAlberti.setMaximumSize(new Dimension(Short.MAX_VALUE, Short.MAX_VALUE));
		
		btnDiscoAlberti.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaCryptDecrypt frame= null;
				
				try {
					frame = new VentanaCryptDecrypt();
					
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
				frame.setMetodo("Alberti");
				frame.setVisible(true);
				
				dispose();
				
			}
		});

		panelConBoxLayout.add(Box.createRigidArea(new Dimension(0, 15)));
		panelConBoxLayout.add(btnDiscoAlberti);
	}
	
	private void getBtnVigenere() {
		btnVigenere = new JButton("Vigenere");
		btnVigenere.setEnabled(true);
		btnVigenere.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnVigenere.setMinimumSize(dimBtn);
		btnVigenere.setPreferredSize(dimBtn);
		btnVigenere.setMaximumSize(new Dimension(Short.MAX_VALUE, Short.MAX_VALUE));
		
		btnVigenere.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaCryptDecrypt frame= null;
				
				try {
					frame = new VentanaCryptDecrypt();
					
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
				frame.setMetodo("Vigenere");
				frame.setVisible(true);
				
				dispose();
				
			}
		});

		panelConBoxLayout.add(Box.createRigidArea(new Dimension(0, 15)));
		panelConBoxLayout.add(btnVigenere);
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
