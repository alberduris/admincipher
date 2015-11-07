package org.ciphermethods.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class VentanaEjemploConLayouts extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panelConBorderLayout;
	private JPanel panelConBoxLayout;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaEjemploConLayouts frame = new VentanaEjemploConLayouts();
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
	public VentanaEjemploConLayouts() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300, 230);
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
	}

}
