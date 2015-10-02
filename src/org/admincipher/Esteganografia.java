package org.admincipher;


import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Esteganografia {
	private BufferedImage imagen;
	private String mensaje;
	private int alto, ancho;
	
	public Esteganografia(String pRuta, String pMensaje) throws IOException{
		imagen = ImageIO.read(new File(pRuta));
		alto = imagen.getHeight();
		ancho = imagen.getWidth();
		mensaje = pMensaje;
		cambiar();
		ImageIO.write(imagen, "jpg", new File("foto.jpg"));
		//Image im = Toolkit.getDefaultToolkit().createImage(imagen.getSource());
	}
	public void cambiar(){
		int k = 0;
		int t = 2;
		int p = 0;
		int[] numero = new int[7];
		for(int i = 0; i<alto && k<mensaje.length(); i++){
			for(int j = 0; j<ancho && k<mensaje.length(); j++){
				int srcPixel = imagen.getRGB(j,i);
				Color c = new Color(srcPixel);
				if(t == 2){
					numero = calcularASCII(mensaje.charAt(k));
					k++;
					p = 0;
				}
				int valR = c.getRed();
				if(numero[p] == 1 && p<8){
					valR += 1;
				}
				p++;
				int valG = c.getGreen();
				if(numero[p] == 1 && p<8){
					valG += 1;
				}
				p++;
				int valB = c.getBlue();
				if(numero[p] == 1 && p<8){
					valB += 1;
				}
				p++;	
				Color col = new Color(valR, valG, valB);
				imagen.setRGB(j, i, col.getRGB());
				t--;
				if(t==0){
					t = 2;
				}
			}
		}
	}
	private int[] calcularASCII(int numero){
		int[] res = new int[7];
		int a, pos = 0;
		a = numero;
		while(a>=2){
			res[pos] = a%2;
			if(a == 2){
				res[pos] = 1;
			}else if(a == 3){
				res[pos] =0;
			}
			a = a/2;
		}
		return res;
	}
	
	public static void main(String[] args) throws IOException {
		Esteganografia es = new Esteganografia("Ace-and-Luffy.jpg", "HOLA ALBERTO");
	}
}
