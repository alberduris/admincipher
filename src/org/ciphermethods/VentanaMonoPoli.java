package org.ciphermethods;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
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
import javax.swing.border.EmptyBorder;

public class VentanaMonoPoli extends JFrame {

	private JPanel contentPane;
	private JPanel panelConBorderLayout;
	private JPanel panelConBoxLayout;
	
	private JButton btnMono;
	private JButton btnPoli;
	
	private JLabel lblTitulo;
	
	private Dimension dimBtn = new Dimension(200,30);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaMonoPoli frame = new VentanaMonoPoli();
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
	public VentanaMonoPoli() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300, 200);
		setLocationRelativeTo(null);
		
		
		contentPane = new JPanel();
		setContentPane(contentPane);
		panelConBorderLayout = new JPanel();
		panelConBoxLayout = new JPanel();
		
		
		
		BorderLayout border = new BorderLayout();
		panelConBorderLayout.setLayout(border);
		BoxLayout box = new BoxLayout(panelConBoxLayout,BoxLayout.Y_AXIS);
		panelConBoxLayout.setLayout(box);
		
		
		contentPane.add(panelConBorderLayout);
		panelConBorderLayout.add(panelConBoxLayout,BorderLayout.CENTER);
		
		getTituloMonoPoli();
		
		getBtnMono();
		getBtnPoli();
		
		
		
	}
	
	private void getTituloMonoPoli(){
		
		lblTitulo = new JLabel("Tipo de método");
		lblTitulo.setHorizontalAlignment(0);
		lblTitulo.setFont(new Font("Arial", Font.BOLD, 28));
		lblTitulo.setOpaque(true);
		lblTitulo.setForeground(Color.black);
		
		panelConBorderLayout.add(lblTitulo, BorderLayout.NORTH);
		
	}
	
	private void getBtnMono(){
		btnMono = new JButton("Métodos monoalfabéticos");
		btnMono.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnMono.setMinimumSize(dimBtn);
		btnMono.setPreferredSize(dimBtn);
		btnMono.setMaximumSize(new Dimension(Short.MAX_VALUE, Short.MAX_VALUE));
		
		panelConBoxLayout.add(Box.createRigidArea(new Dimension(0,15)));
		panelConBoxLayout.add(btnMono);
	}
	
	private void getBtnPoli(){
		btnPoli = new JButton("Métodos polialfabéticos");
		btnPoli.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnPoli.setMinimumSize(dimBtn);
		btnPoli.setPreferredSize(dimBtn);
		btnPoli.setMaximumSize(new Dimension(Short.MAX_VALUE, Short.MAX_VALUE));
		
		
		panelConBoxLayout.add(Box.createRigidArea(new Dimension(0,15)));
		panelConBoxLayout.add(btnPoli);
	}

}
