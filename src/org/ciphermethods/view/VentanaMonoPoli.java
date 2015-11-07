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

public class VentanaMonoPoli extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panelConBorderLayout;
	private JPanel panelConBoxLayout;

	private JLabel lblTitulo;
	private JLabel lblSubtitulo;

	private JButton btnExtras;
	private JButton btnMono;
	private JButton btnPoli;

	private Dimension dimBtn = new Dimension(200, 30);
	private Dimension dimVentana = new Dimension(350, 300);

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
		getSubtituloMonoPoli();

		getBtnMono();
		getBtnPoli();
		getBtnExtras();

	}

	private void getTituloMonoPoli() {
	
		lblTitulo = new JLabel("Suite de criptografía");
		lblTitulo.setHorizontalAlignment(0);
		lblTitulo.setFont(new Font("Arial", Font.BOLD, 28));
		lblTitulo.setOpaque(true);
		lblTitulo.setForeground(Color.black);
		
		Border paddingBorder = BorderFactory.createEmptyBorder(10,10,10,10);
		Border border = BorderFactory.createBevelBorder(0);
		lblTitulo.setBorder(BorderFactory.createCompoundBorder(border,paddingBorder));

		panelConBorderLayout.add(lblTitulo, BorderLayout.NORTH);

	}

	private void getSubtituloMonoPoli() {

		lblSubtitulo = new JLabel("Selección de tipo");
		lblSubtitulo.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblSubtitulo.setFont(new Font("Arial", Font.BOLD, 24));
		lblSubtitulo.setOpaque(true);
		lblSubtitulo.setForeground(Color.black);
		
		Border paddingBorder = BorderFactory.createEmptyBorder(10,10,10,10);
		Border border = BorderFactory.createBevelBorder(0);
		lblSubtitulo.setBorder(BorderFactory.createCompoundBorder(border,paddingBorder));

		panelConBoxLayout.add(lblSubtitulo);

	}

	private void getBtnExtras() {
		btnExtras = new JButton("Extras");
		btnExtras.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnExtras.setMinimumSize(dimBtn);
		btnExtras.setPreferredSize(dimBtn);
		btnExtras.setMaximumSize(new Dimension(Short.MAX_VALUE, Short.MAX_VALUE));

		btnExtras.setEnabled(false);

		panelConBoxLayout.add(Box.createRigidArea(new Dimension(0, 15)));
		panelConBoxLayout.add(btnExtras);
	}

	private void getBtnMono() {
		btnMono = new JButton("Métodos monoalfabéticos");
		btnMono.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnMono.setMinimumSize(dimBtn);
		btnMono.setPreferredSize(dimBtn);
		btnMono.setMaximumSize(new Dimension(Short.MAX_VALUE, Short.MAX_VALUE));
		
		btnMono.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				try {
					VentanaMonoalfabeticos frame = new VentanaMonoalfabeticos();
					frame.setVisible(true);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
				dispose();
				
			}
		});

		panelConBoxLayout.add(Box.createRigidArea(new Dimension(0, 15)));
		panelConBoxLayout.add(btnMono);
	}

	private void getBtnPoli() {
		btnPoli = new JButton("Métodos polialfabéticos");
		btnPoli.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnPoli.setMinimumSize(dimBtn);
		btnPoli.setPreferredSize(dimBtn);
		btnPoli.setMaximumSize(new Dimension(Short.MAX_VALUE, Short.MAX_VALUE));
		
		btnPoli.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				try {
					VentanaPolialfabeticos frame = new VentanaPolialfabeticos();
					frame.setVisible(true);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
				dispose();
				
			}
		});

		panelConBoxLayout.add(Box.createRigidArea(new Dimension(0, 15)));
		panelConBoxLayout.add(btnPoli);
	}

}