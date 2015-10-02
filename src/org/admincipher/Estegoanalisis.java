package org.admincipher;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Estegoanalisis {
	private BufferedImage imagen, imagenOriginal;
	private String mensaje = "";
	private int alto, ancho;
	
	public Estegoanalisis(String pRuta, String pRutaOriginal, int pBit) throws IOException{
		imagen = ImageIO.read(new File(pRuta));
		imagenOriginal = ImageIO.read(new File(pRutaOriginal));
		alto = imagen.getHeight();
		ancho = imagen.getWidth();
		sacarConOriginal(8-pBit);
		System.out.println(mensaje);
	}
	public void sacarConOriginal(int pBit){
		int p = 0;
		int[] numero = new int[8];
		boolean fin = false;
		for(int i = 0; i<alto && !fin; i++){
			for(int j = 0; j<ancho && !fin; j++){
				int RGB = imagen.getRGB(j,i);
				int RGBOriginal = imagenOriginal.getRGB(j, i);
				Color c = new Color(RGB);
				Color cO = new Color(RGBOriginal);
				int R = c.getRed();
				int RO = cO.getRed();
				if(R == RO){
					numero[p] = 0;
				}else{
					numero[p] = 1;
				}
				p++;
				int G = c.getGreen();
				int GO = cO.getGreen();
				if(G == GO){
					numero[p] = 0;
				}else{
					numero[p] = 1;
				}
				p++;
				if(p < 7){
					int B = c.getBlue();
					int BO = cO.getBlue();
					if(B == BO){
						numero[p] = 0;
					}else{
						System.out.println(B + ":" +BO);
						numero[p] = 1;
					}
				}else{
					if(!terminar(numero)){
						fin = true;
					}else{
						mensaje += String.valueOf(Character.toChars(calcularASCII(numero)));
						System.out.print("LETRA: ");
						for(int m = 0; m<8; m++){
							System.out.print(numero[m]);
						}
						System.out.println();
					}
					p = 0;
				}
			}
		}
	}
	private boolean terminar(int[] pNum){
		boolean fin = false;
		for(int i = 0; i <pNum.length && !fin; i++){
			if(pNum[i] == 1){
				fin = true;
			}
		}
		return fin;
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
	private int calcularASCII(int[] pNum){
		int numero = 0;
		int k = 7;
		for(int i=0; i<8; i++){
			numero += pNum[i]*(int)Math.pow(2, k); 
			k--;
		}
		return numero;
	}
	
	public static void main(String[] args) throws IOException {
		Estegoanalisis es = new Estegoanalisis("foto.bmp", "Ace-and-Luffy.bmp", 8);
		
	}
}
