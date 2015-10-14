package org.admincipher;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JDialog;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class VentanaPrincipal extends JFrame {
	private static final long serialVersionUID = 1L;
	static VentanaPrincipal ventana;
	JButton[] botones;
	JLabel tiempo;
	JPanel centro, sur, norte; 
	JDialog dialogFinal;
	
	
	
	public VentanaPrincipal(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(550,250);
		setLocationRelativeTo(null);
		setVisible(true);
		norte = new JPanel();
		
		centro = new JPanel();
		centro.setLayout(new GridLayout(5,3));
		botones = new JButton[3];
		centro.setBackground(Color.white);
		
		add(norte,"North");
		add(centro);
		
		crearBotones();
			
		sur = new JPanel();
		sur.setLayout(new GridLayout(1,5));
		add(sur,"South");
		}
		
	private void crearBotones(){
			botones[0] = new JButton("SIN COMPARACIÓN");
			MouseListener mouseListener = new MouseListener(){

				@Override
				public void mouseClicked(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mouseExited(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mousePressed(MouseEvent e) {
					VentanaPpalSC vnt = new VentanaPpalSC();
					vnt.setVisible(true);
				}

				@Override
				public void mouseReleased(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
			};
			botones[0].addMouseListener(mouseListener);
			botones[1] = new JButton("CON COMPARACIÓN");
			mouseListener = new MouseListener(){

				@Override
				public void mouseClicked(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mouseExited(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mousePressed(MouseEvent e) {
					VentanaPpalComp vnt = new VentanaPpalComp();
					vnt.setVisible(true);
				}

				@Override
				public void mouseReleased(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
			};
			botones[1].addMouseListener(mouseListener);
		for(int k =0; k< 3; k++){
			centro.add(new JLabel());
		}
		for(int i = 0; i < 2; i++){
			botones[i].setOpaque(true);
			botones[i].updateUI();
			centro.add(new JLabel());
			centro.add(botones[i]);
			centro.add(new JLabel());
			for(int k =0; k< 3; k++){
				centro.add(new JLabel());
			}
		}
	}	
		
	public static void main(String[] args) {
		VentanaPrincipal vnt = new VentanaPrincipal();
		vnt.setVisible(true);		
	}
}
