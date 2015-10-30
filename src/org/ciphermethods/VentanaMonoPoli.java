package org.ciphermethods;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.FlowLayout;

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
		setSize(300, 500);
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
		panelConBorderLayout.add(lblTitulo, BorderLayout.NORTH);
		
	}
	
	private void getBtnMono(){
		btnMono = new JButton("Métodos monoalfabéticos");
		btnMono.setAlignmentX(Component.CENTER_ALIGNMENT);
		panelConBoxLayout.add(btnMono);
	}
	
	private void getBtnPoli(){
		btnPoli = new JButton("Métodos polialfabéticos");
		btnPoli.setAlignmentX(Component.CENTER_ALIGNMENT);
		panelConBoxLayout.add(btnPoli);
	}

}
