package org.admincipher;


import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Esteganografia {
	private BufferedImage imagen;
	private String mensaje;
	private int alto, ancho;
	
	public Esteganografia() {
		
	}
	
	public void metodoPrincipalOcultar(String pRuta, String pMensaje, int pBit){
		try {
			imagen = ImageIO.read(new File(pRuta));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		alto = imagen.getHeight();
		ancho = imagen.getWidth();
		mensaje = pMensaje;
		esconder(8-pBit);
		try {
			ImageIO.write(imagen, "bmp", new File("foto.bmp"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void esconder(int pBit){
		int k = 0;
		int t = 2;
		int p = 0;
		int[] numero = new int[8];
		
		for(int i = 0; i<alto  && k<mensaje.length(); i++){
			for(int j = 0; j<ancho && k<mensaje.length(); j++){
				int RGB = imagen.getRGB(j,i);
				Color c = new Color(RGB);
				if(t == 2){
					numero = convBinario(mensaje.charAt(k));
					
					p = 0;
				}
				int R = c.getRed();
				
				if(numero[p] == 1){
					int[] red = new int[8];
					red = convBinario(R);
					if(red[pBit] == 1){
						red[pBit] = 0;
					}else{
						red[pBit] = 1;
					}
					R = calcularRGB(red);
				}
				
				p++;
				int G = c.getGreen();
				
				if(numero[p] == 1){
					int[] green = new int[8];
					green = convBinario(G);
					if(green[pBit] == 1){
						green[pBit] = 0;
					}else{
						green[pBit] = 1;
					}
					G = calcularRGB(green);
				}
				
				p++;
				int B = c.getBlue();
				
				if(p<8 && numero[p] == 1){
					int[] blue = new int[8];
					blue = convBinario(B);
					if(blue[pBit] == 1){
						blue[pBit] = 0;
					}else{
						blue[pBit] = 1;
					}
					B = calcularRGB(blue);
				}
				
				p++;	
				Color col = new Color(R, G, B);
				imagen.setRGB(j, i, col.getRGB());
				t--;
				if(t<0){
					t = 2;
					k++;
				}
			}
		}
	}
	public int[] convBinario(int numero){
		
		int[] res = new int[8]; 
		char[] aux = new char[0];
		Integer num = numero;
		
		String binStr = Integer.toBinaryString(num);
		aux = binStr.toCharArray();
		int k = 0;
		
		for(int i = 0; i < res.length; i++){
			if(i < 8-aux.length){
				res[i] = 0;
			}else{
				res[i] = Integer.parseInt(aux[k]+"");
				k++;
			}
		}
		return res;
		
	}
	private int calcularRGB(int[] pNum){
		int numero = 0;
		int k = 7;
		for(int i=0; i<8; i++){
			numero += pNum[i]*(int)Math.pow(2, k); 
			k--;
		}
		return numero;
	}
	
	public static void main(String[] args) throws IOException {
		Esteganografia es = new Esteganografia();
		es.metodoPrincipalOcultar("Ace-and-Luffy.bmp", "BEÑAT HOLA HHHOOLLA", 8);
		
	}
}
