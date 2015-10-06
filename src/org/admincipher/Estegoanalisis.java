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
	
	public Estegoanalisis(){
		
	}
	
		
	public String metodoPrincipal (String pRuta, String pRutaOriginal, int pBit){
		try {
			imagen = ImageIO.read(new File(pRuta));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			imagenOriginal = ImageIO.read(new File(pRutaOriginal));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		alto = imagen.getHeight();
		ancho = imagen.getWidth();
		sacarConOriginal(8-pBit);
		return mensaje;
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
				
				if(convBinario(R)[pBit] == convBinario(RO)[pBit]){
					numero[p] = 0;
				}else{
					numero[p] = 1;
				}
				p++;
				int G = c.getGreen();
				int GO = cO.getGreen();
				
				if(convBinario(G)[pBit] == convBinario(GO)[pBit]){
					numero[p] = 0;
				}else{
					numero[p] = 1;
				}
				p++;
				
				if(p < 7){
					int B = c.getBlue();
					int BO = cO.getBlue();
					
					if(convBinario(B)[pBit] == convBinario(BO)[pBit]){
						numero[p] = 0;
					}else{
						
						numero[p] = 1;
					}
					p++;
				}else{
					if(!terminar(numero)){
						fin = true;
					}else{
						mensaje += String.valueOf(Character.toChars(calcularASCII(numero)));
						
						for(int m = 0; m<8; m++){
							
						}
						
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
		Estegoanalisis es = new Estegoanalisis();
		es.metodoPrincipal("foto.bmp", "Ace-and-Luffy.bmp", 8);
		
	}
}
