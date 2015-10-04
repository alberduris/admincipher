package org.admincipher;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import org.admincipher.DescifrarKasiski;
import org.admincipher.Vigenere;

public class VistaVigenere extends JFrame {
	private static final long serialVersionUID = 1L;
	static VistaVigenere ventana;
	JButton[] botones;
	JLabel tiempo;
	JPanel centro, sur, norte; 
	JDialog dialogFinal;
	
	
	
	public VistaVigenere(){
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
			botones[0] = new JButton("CIFRAR VIGENERE");
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
					centro.removeAll();
					crearCifrarVigenere();
					centro.updateUI();
				}

				@Override
				public void mouseReleased(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
			};
			botones[0].addMouseListener(mouseListener);
			botones[1] = new JButton("DESCIFRAR VIGENERE");
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
					centro.removeAll();
					sur.removeAll();
					centro.setLayout(new GridLayout(7,3));
					crearDescifrar();
					centro.updateUI();					
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
		
	private void crearCifrarVigenere(){
		JTextField texto;
		JTextField clave;
		centro.removeAll();
		GridBagConstraints cs = new GridBagConstraints(); 
		Font fuente = new Font("Arial",Font.ITALIC,16);
		texto = new JTextField();
		texto.setForeground(Color.BLACK);
		texto.setFont(fuente);
		cs.fill = GridBagConstraints.HORIZONTAL;
		cs.weighty = 0;
		cs.gridy = 1;
		clave = new JTextField();
		clave.setForeground(Color.BLACK);
		clave.setFont(fuente);
		
		botones[0] = new JButton("ATRAS");
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
				centro.removeAll();
				sur.removeAll();
				crearBotones();
				centro.updateUI();
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		};
		botones[0].addMouseListener(mouseListener);
		botones[1] = new JButton("CIFRAR");
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
				Vigenere dV = Vigenere.getDescifrarVigenere();
				dV.introducirTexto(texto.getText());
				dV.introducirClave(clave.getText());
				JDialog jD = new JDialog();
				jD.add(new JTextArea(dividirTexto(dV.cifrar())));
				jD.setSize(500, 500);
				jD.setVisible(true);
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		};
		botones[1].addMouseListener(mouseListener);
		for(int i=0; i<3; i++){
			centro.add(new JLabel());
		}
		centro.add(new JLabel("Texto"));
		centro.add(texto,cs);
		for(int i=0; i<4; i++){
			centro.add(new JLabel());
		}
		centro.add(new JLabel("Clave"));
		centro.add(clave, cs);
		for(int i=0; i<4; i++){
			centro.add(new JLabel());
		}
		centro.updateUI();
		sur.add(new JLabel());
		for(int i = 0; i < 2; i++){
			botones[i].setOpaque(true);
			botones[i].updateUI();
			sur.add(botones[i]);
			sur.add(new JLabel());
		}
		
	}	
	
	private void crearDescifrar(){
		botones[0] = new JButton("METODO VIGENERE");
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
				centro.removeAll();
				sur.removeAll();
				centro.setLayout(new GridLayout(5,3));
				crearDescifrarVigenere();
				centro.updateUI();
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		};
		botones[0].addMouseListener(mouseListener);
		botones[1] = new JButton("ATAQUE KASISKI");
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
				

				centro.removeAll();
				sur.removeAll();
				centro.setLayout(new GridLayout(5,3));
				crearDescifrarKasiski();
				centro.updateUI();
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		};
		botones[1].addMouseListener(mouseListener);
		botones[2] = new JButton("ATRAS");
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
				centro.removeAll();
				centro.setLayout(new GridLayout(5,3));
				crearBotones();
				centro.updateUI();
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		};
		botones[2].addMouseListener(mouseListener);
		for(int k =0; k< 3; k++){
			centro.add(new JLabel());
		}
		for(int i = 0; i < 3; i++){
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
	
	private void crearDescifrarVigenere(){
		JTextField texto;
		JTextField clave;
		GridBagConstraints cs = new GridBagConstraints(); 
		Font fuente = new Font("Arial",Font.ITALIC,16);
		texto = new JTextField();
		texto.setForeground(Color.BLACK);
		texto.setFont(fuente);
		cs.fill = 0;
		cs.weighty = 0;
		cs.gridy = 0;
		clave = new JTextField();
		clave.setForeground(Color.BLACK);
		clave.setFont(fuente);
		
		botones[0] = new JButton("ATRAS");
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
				centro.removeAll();
				sur.removeAll();
				centro.setLayout(new GridLayout(7,3));
				crearDescifrar();
				centro.updateUI();		
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		};
		botones[0].addMouseListener(mouseListener);
		botones[1] = new JButton("DESCIFRAR");
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
				Vigenere dV = Vigenere.getDescifrarVigenere();
				dV.introducirTexto(texto.getText());
				dV.introducirClave(clave.getText());
				JDialog jD = new JDialog();
				jD.add(new JTextArea(dividirTexto(dV.descifrar())));
				jD.setSize(500, 500);
				jD.setVisible(true);
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		};
		botones[1].addMouseListener(mouseListener);
		for(int i=0; i<3; i++){
			centro.add(new JLabel());
		}
		centro.add(new JLabel("Texto"));
		centro.add(texto,cs);
		for(int i=0; i<4; i++){
			centro.add(new JLabel());
		}
		centro.add(new JLabel("Clave"));
		centro.add(clave, cs);
		for(int i=0; i<4; i++){
			centro.add(new JLabel());
		}
		centro.updateUI();
		sur.add(new JLabel());
		for(int i = 0; i < 2; i++){
			botones[i].setOpaque(true);
			botones[i].updateUI();
			sur.add(botones[i]);
			sur.add(new JLabel());
		}
	}	
	
	private String dividirTexto(String pTexto){
		String texto = "";
		for(int i=0; i<pTexto.length(); i++){
			if(i % 50 == 0){
				texto += "\n";
			}
			texto += pTexto.charAt(i);
		}
		return texto;
	}
	
	private void crearDescifrarKasiski(){
		JTextField texto;
		JTextField clave;
		GridBagConstraints cs = new GridBagConstraints(); 
		Font fuente = new Font("Arial",Font.ITALIC,16);
		texto = new JTextField();
		texto.setForeground(Color.BLACK);
		texto.setFont(fuente);
		cs.fill = 0;
		cs.weighty = 0;
		cs.gridy = 0;
		clave = new JTextField();
		clave.setForeground(Color.BLACK);
		clave.setFont(fuente);
		
		botones[0] = new JButton("ATRAS");
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
				centro.removeAll();
				sur.removeAll();
				centro.setLayout(new GridLayout(7,3));
				crearDescifrar();
				centro.updateUI();		
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		};
		botones[0].addMouseListener(mouseListener);
		botones[1] = new JButton("DESCIFRAR");
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
				DescifrarKasiski dK = DescifrarKasiski.getKasiski();
				dK.introducirTexto(texto.getText());
				dK.introducirTamanoClave(Integer.parseInt(clave.getText()));
				crearjDialog(dK.sacarClave());
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		};
		botones[1].addMouseListener(mouseListener);
		for(int i=0; i<3; i++){
			centro.add(new JLabel());
		}
		centro.add(new JLabel("Texto"));
		centro.add(texto,cs);
		for(int i=0; i<4; i++){
			centro.add(new JLabel());
		}
		centro.add(new JLabel("Tamano Clave"));
		centro.add(clave, cs);
		for(int i=0; i<4; i++){
			centro.add(new JLabel());
		}
		centro.updateUI();
		sur.add(new JLabel());
		for(int i = 0; i < 2; i++){
			botones[i].setOpaque(true);
			botones[i].updateUI();
			sur.add(botones[i]);
			sur.add(new JLabel());
		}
	}	
	
	private void crearjDialog(int[][] pFrecuencias){
		JDialog jD = new JDialog();
		JPanel jP = new JPanel();
		jD.add(new JPanel(), "North");
		jP.setLayout(new GridLayout(pFrecuencias.length+1,pFrecuencias[0].length));
		JLabel[][] jL= new JLabel[pFrecuencias.length][pFrecuencias[0].length];
		jD.setSize(pFrecuencias[0].length*50, pFrecuencias.length*100);
		for(int i=0; i<pFrecuencias[0].length;i++){
			JLabel jLab = new JLabel(String.valueOf(Character.toChars(65+i)));
			jLab.setBorder(LineBorder.createBlackLineBorder());
			jLab.setHorizontalAlignment(WIDTH/2);
			jP.add(jLab);
		}
		for(int k =0; k<pFrecuencias.length;k++){
			for(int i=0; i<pFrecuencias[k].length;i++){
				jL[k][i] = new JLabel(pFrecuencias[k][i]+"");
				jL[k][i].setBorder(LineBorder.createBlackLineBorder());
				jL[k][i].setHorizontalAlignment(WIDTH/2);
			}
		}
		int[] max1 ;
		int[] max2 ;
		int[] max3 ;
		
		for(int i=0; i<pFrecuencias.length; i++){
			max1 = DescifrarKasiski.getKasiski().sacarMax(pFrecuencias[i], -1);
			max2 = DescifrarKasiski.getKasiski().sacarMax(pFrecuencias[i], max1[0]);
			max3 = DescifrarKasiski.getKasiski().sacarMax(pFrecuencias[i], max2[0]);		
			for(int j=0;j<max1.length; j++){
				jL[i][max1[j]].setBackground(Color.green);
				jL[i][max1[j]].setOpaque(true);
			}
			for(int j=0;j<max2.length; j++){
				jL[i][max2[j]].setBackground(Color.red);
				jL[i][max2[j]].setOpaque(true);
			}
			for(int j=0;j<max3.length; j++){
				jL[i][max3[j]].setBackground(Color.blue);
				jL[i][max3[j]].setOpaque(true);
			}
		}
		for(int i=0; i<pFrecuencias.length; i++){
			for(int j=0;j<pFrecuencias[i].length; j++){
				jP.add(jL[i][j]);
			}
		}
		jD.add(jP);
		JPanel sur = new JPanel();
		sur.setLayout(new GridLayout(1,10));
		JLabel jLab = new JLabel();
		jLab.setBackground(Color.green);
		jLab.setOpaque(true);
		sur.add(jLab);
		sur.add( new JLabel());
		sur.add(new JLabel("1ºFrecuencia"));
		sur.add(new JLabel());
		jLab = new JLabel();
		jLab.setBackground(Color.red);
		jLab.setOpaque(true);
		sur.add(jLab);
		sur.add( new JLabel());
		sur.add(new JLabel("2ºFrecuencia"));
		sur.add(new JLabel());
		jLab = new JLabel();
		jLab.setBackground(Color.blue);
		jLab.setOpaque(true);
		sur.add(jLab);
		sur.add( new JLabel());
		sur.add(new JLabel("3ºFrecuencia"));
		sur.add(new JLabel());
		
		jD.add(sur, "South");
		jD.setVisible(true);
		
	}
	
	
	public static void main(String[] args) {
		VistaVigenere vnt = new VistaVigenere();
		vnt.setVisible(true);		
	}
}
