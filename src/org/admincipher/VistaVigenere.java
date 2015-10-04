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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import org.admincipher.descifrarKasiski;
import org.admincipher.descifrar_Vigenere;

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
				//COGER TEXTO Y CLAVE Y CIFRAR
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
				crearBotones();
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
				descifrar_Vigenere dV = descifrar_Vigenere.getDescifrarVigenere();
				dV.introducirTexto(texto.getText());
				dV.introducirClave(clave.getText());
				System.out.println(dV.descifrar());//	dV.descifrar();
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
				crearBotones();
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
				descifrarKasiski dK = descifrarKasiski.getKasiski();
				dK.introducirTexto(texto.getText());
				dK.introducirTamanoClave(Integer.parseInt(clave.getText()));
				crearJDialog(dK.sacarClave());
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
	
	//	WEDFM     LHRRV     WCODE     JBORC     WLIEK     VHIEN     MWASV     WFEED     WFUIS  GXSKB     SGGLV     SWOEK     VBEYK     TBAVX     LKAUY     WGLRM     SLAZX     VNDRL     DXMVX   LXNRN     AXYRE     FJUVO     DWOTD     GKDFB     EBATY     FXLSK     DVOEK     TBEID     GIOIR   AZIVX     WXRRD     SGACD     GLUGS     KHQLO     FHEIK     VXSLZ     GGEIA     MXPFB     SELZR  MUIVC     WXNKB     SWOVV     SLEJS     FHLRZ     GEITS     SGOVX     UHNKB     SUACK     HBSKK  VXAHE     WECIS  EXNPI     SBBRK     SUAEN     GGAIO     DTSLX     LHCLK     FWOCK     WLPFC    SRLRM     JBAUK     VXLDE     WKTFK     UNDZO     JHNUO     KIAMY     JBDRC     SEAAO     XTTLB   SLACD     SGDFN     WEORV     LHDVE     FTRDK     JBOYK     TBATK     AWOJY     TKECK     EXSRV  SLHRL     ATMZB     SWOCK     KAASS     SOIJD     GRDVC     HNEJR     SUIRR     MBDFZ     GKLRR  SUIKK     UBOEE     FTMRX     GLOCS     LTRZK     QOIMK     UHMFE     FTAIK     FTACV     AEAYK    TBAEN     WCAUY    WGCVB     JTDRM     GGLCK     NXEEO     DVURB     LHLCO     FTDVD   WKRFB     SVUUS     GEAGY     DBCZK     QXLAE     WSEIK     KNDVL     WKTIK     TTJFV     WLCFC   LHCRJ     SKLRW     SGOGO     JHLRM     SSAIY     FRTFN     GLLVK     YTRIK     JHNLX     VXDFZ   GKQLO     WKAMS     YHRFC     SVOIX     GLIVX     WELRB     SWITK     KXJLX     LTTFN     SEAWE    WKZRN     WNNYY     EURVP     MXRKO     INEYK     UXRTY     FXLCK     INECE     RBBRK     SKRFT   SKSFL     JXECC     MVEJY     UHMFC     WGTVX     UBAIV     SWEHE     AXNVB     STQLO     DEADK  FHDVC     HNEJN     WNNRV     SKGRZ     SNSRK     DCUVJ     KXLVY     UNRIS     GWAIV     WEAGV    MFAGK     JTQLO     VXCCK     JTSVZ     GKEJM     JBTFV     SFAEY     WGTFX     UXSVC     UKISS  GLOPV     SFAEY     VXRRW     AKOIE     ASAJO     KBNRN     GOICW     WGTVZ     GKECN     GVTFB   WGECR     GLPZD     SEYUO     KMRFJ     SWOTY     FXNJK     FTMZO     FMOVX     DTSRV     SWEUS  KXCTS     GGHVR     WVHFT     MLTZM  ATRVV     SMOKS     LNLRN     GEADK     FHEJM     JBTFZ   GKRRW     GGGFW     WSDVV     SLEIX     S 

	
	private void crearJDialog(int[][] pFrecuencias){
		JDialog jD = new JDialog();
		jD.setLayout(new GridLayout(pFrecuencias.length+1,pFrecuencias[0].length));
		JLabel jL;
		jD.setSize(pFrecuencias[0].length*50, pFrecuencias.length*100);
		for(int i=0; i<pFrecuencias[0].length;i++){
			jL = new JLabel(String.valueOf(Character.toChars(65+i)));
			jL.setBorder(LineBorder.createBlackLineBorder());
			jL.setHorizontalAlignment(WIDTH/2);
			jD.add(jL);
		}
		for(int k =0; k<pFrecuencias.length;k++){
			for(int i=0; i<pFrecuencias[k].length;i++){
				jL = new JLabel(pFrecuencias[k][i]+"");
				jL.setBorder(LineBorder.createBlackLineBorder());
				jL.setHorizontalAlignment(WIDTH/2);
				jD.add(jL);
			}
		}
		jD.setVisible(true);
		
	}
	
	
	public static void main(String[] args) {
		VistaVigenere vnt = new VistaVigenere();
		vnt.setVisible(true);		
	}
}
