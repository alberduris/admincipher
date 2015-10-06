package org.admincipher;

import java.awt.Color;
import java.awt.image.BufferedImage;

public class EsteganografiaSinComp {

	// Flag que indica si la imagen contiene mensaje oculto
	private String flag = "fl";

	// Tamaño del mensaje + flag + tamaño propio
	private int longitud = 0;

	// Imagen
	private BufferedImage foto = null;
	private int red, green, blue;
	private Color color;

	// Mensaje
	private String msgBinario;
	private String msgOriginal;

	// Contador
	private int cont = 0;

	public EsteganografiaSinComp() {
		// Constructora vacia
	}
	
	
	/*
	 * @post: Guarda en la variable global longitud la longitud del mensaje
	 */
	private void getLongitudMensaje(BufferedImage imagen){
		
		String longAux = "";
		
		for(int i = 5; i < 12; i++){
			color = new Color(imagen.getRGB(i, 0));
			String rojo = byteABinario((byte) color.getRed() );
			String verde = byteABinario((byte) color.getGreen() );
			String azul = byteABinario((byte) color.getBlue() );
			
			String lsbRojo = getLSB(rojo);
			String lsbVerde = getLSB(verde);
			String lsbAzul = getLSB(azul);
			
			longAux = longAux + lsbRojo + lsbVerde + lsbAzul;
		}
		
		this.longitud = stringBinarioAInteger(longAux.substring(1,17));
		
	}

	   

	
	/*
	 * @post: Comprueba el flag y devuelve un boolean que indica si la imagen
	 * tiene mensaje oculto o no
	 */
	private boolean checkFlag(BufferedImage imagen){
	  
	  boolean hayMensaje = false;
	  
	  String flagAux = "";
	  
	  for(int i = 0; i < 6; i++){
		  
		  color = new Color(imagen.getRGB(i,0));
		  
		  String rojo = byteABinario((byte) color.getRed());
		  String verde = byteABinario((byte) color.getGreen());
		  String azul = byteABinario((byte) color.getBlue());
		  
		  String lsbRojo = getLSB(rojo);
		  String lsbVerde = getLSB(verde);
		  String lsbAzul = getLSB(azul);
		  
		  flagAux = flagAux + lsbRojo + lsbVerde + lsbAzul;
	  }
	  
	  if( (getCaracterEnFormaDeString(flagAux.substring(0,8)).equals("f")) && (getCaracterEnFormaDeString(flagAux.substring(8,16)).equals("l")) ){
		  hayMensaje = true;
	  }
	  
	  return hayMensaje;
		  

	  
  }
		
	/*
	 * @post: Devuelve el caracter, en forma de String, del String en binario que se pasa
	 * como parámetro.
	 */
	private String getCaracterEnFormaDeString(String strBin){
        int aux;
        String strChar;
        
        aux = Integer.parseInt(strBin ,2);
        strChar = new Character((char)aux).toString();
        
        return strChar;        
    }

	/*
	 * @post: Se obtiene el String que se quiere ocultar compuesto por el
	 * mensaje original el flag y la longitud del mensaje.
	 */
	private void crearMensaje(String mensaje) {
		String longitudBinario;

		longitud = 2 * (mensaje.length() + flag.length());

		longitudBinario = Integer.toBinaryString(longitud);

		msgBinario = stringABinario(flag) + longitudBinario + stringABinario(mensaje);
	}

	/*
	 * @post: Devuelve un String con el mensaje en String que recibe como
	 * parámetro pero lo devuelve en binario
	 */
	private String stringABinario(String mensaje) {
		String strBinario = "";

		char[] aux = mensaje.toCharArray();

		for (int i = 0; i < aux.length; i++) {
			strBinario = strBinario + byteABinario((byte) aux[i]);
		}

		return strBinario;
	}

	/*
	 * @post: Devuelve el binario en forma de String del byte del caracter que
	 * recibe como parámetro
	 */
	private String byteABinario(byte caracter) {
		byte byteChar = (byte) caracter;
		String strBin = String.format("%8s", Integer.toBinaryString(byteChar & 0xFF)).replace(' ', '0');
		return strBin;
	}

	
	/*
	 * @post: Devuelve el int, del caracter en binario que se pasa como String 
	 * como parámetro.
	 */
	private int stringBinarioAInteger(String strBin){
        int intChar;
        intChar = Integer.parseInt(strBin ,2);        
        return intChar;
    }

	
	
	/*
	 * @post: Devuelve el Least Significant Bit (LSB) de un byte dado. Es decir, el último bit.
	 */
	private String getLSB(String unByte){
		String res;
		res = unByte.substring(7, 8);
		return res;
	}

}
