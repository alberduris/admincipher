package org.admincipher;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

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
	 * @post: Oculta el mensaje en la imagen
	 */
	public void ocultarMensaje(String pRuta, String mensaje, int pBit) {
		
		int contMio = 0;
		
		BufferedImage img = null;
		
		//Leer la imagen de la ruta
		try {
			img = ImageIO.read(new File(pRuta));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		int contAux = 0;

		// Se crea el mensaje encapsulando todo
		crearMensaje(mensaje);
		
		//OK <-- AQUI LLEGA EL MENSAJE BIEN

		// Creamos la imagen
		/*
		 * @doc: TYPE_IN_RGB: Represents an image with 8-bit RGB color
		 * components packed into integer pixels.
		 */
		foto = new BufferedImage(img.getWidth(), img.getHeight(), BufferedImage.TYPE_INT_RGB);
		

		// Inserta el mensaje en la imagen bit a bit
		for (int i = 0; i < foto.getHeight(); i++) {// Filas
			for (int j = 0; j < foto.getWidth(); j++) {// Columnas
				
				
				color = new Color(img.getRGB(j, i));

				if (contAux <= msgBinario.length()) {
					// Conversion a binario
					String rojo = byteABinario((byte) color.getRed());
					String verde = byteABinario((byte) color.getGreen());
					String azul = byteABinario((byte) color.getBlue());
					// Reemplazar bit seleccionado
					rojo = reemplazarBit(pBit, rojo);
					verde = reemplazarBit(pBit, verde);
					azul = reemplazarBit(pBit, azul);
					// Binario a integer
					red = Integer.parseInt(rojo, 2);
					green = Integer.parseInt(verde, 2);
					blue = Integer.parseInt(azul, 2);
				} else {// Si el mensaje ya ha acabado
				
					red = color.getRed();
					green = color.getGreen();
					blue = color.getBlue();

				}

				// Vamos "creando" la imagen con contenido oculto
				Color colAux = new Color(red, green, blue);
				foto.setRGB(j, i, colAux.getRGB());

				// Cada letra son pixel son tres bytes (Uno por cada color)
				contAux =+ 3;
			}
		}
		
		//Se genera la nueva imagen con el mensaje oculto
		generarImagen(foto);
		
	}
	
	private void generarImagen(BufferedImage imagen){
		try {
			ImageIO.write(imagen, "bmp", new File("fotoSC.bmp"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*
	 * @post: Analiza la imagen en busca de la presencia de mensaje oculto y, si
	 * hay mensaje, lo extrae en forma de String tal y como se escribió
	 */
	public String extraerMensaje(String pRuta, int pBit) {
		
		
		
		BufferedImage img = null;
		
		//Leer la imagen de la ruta
		try {
			img = ImageIO.read(new File(pRuta));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		boolean terminado = false;

		msgOriginal = "";
		

		// Comprobamos el flag
		if (checkFlag(pBit,img)) {// Si hay mensaje oculto

			// Guardamos la longitud del mensaje
			getLongitudMensaje(pBit,img);
			

			// Preparamos un array de String con la longitud obtenida y un
			// String auxiliar
			String[] arrayStr = new String[longitud];
			String aux = "";

			// Extrae el mensaje de la foto bit a bit
			for (int i = 0; i < img.getHeight() && !terminado; i++) {
				for (int j = 0; j < img.getWidth() && !terminado; j++) {
					
					

					// Reutilizamos código del metodo ocultarMensaje
					color = new Color(img.getRGB(j, i));

					// Conversion a binario
					String rojo = byteABinario((byte) color.getRed());
					String verde = byteABinario((byte) color.getGreen());
					String azul = byteABinario((byte) color.getBlue());
					// Coger bit seleccionado
					rojo = getBit(pBit, rojo);
					verde = getBit(pBit, verde);
					azul = getBit(pBit, azul);

					// Se va extrayendo el mensaje
					if (aux.length() <= (longitud * 8)) {
						aux = aux + rojo + verde + azul;
					} else {// Si termina cambia el flag de terminado a true y
							// al siguiente ciclo termina
						terminado = true;
						
					}

					// Comienzan las conversiones para obtener el mensaje de
					// forma legible

				}
			} // Fin for

			int contAux = 0;
			for (int i = 0; i < (longitud * 8); i = i + 8) {
				arrayStr[contAux] = aux.substring(i, i + 8);
				contAux++;
			}

			msgOriginal = getMensajeDeArrayBinario(arrayStr);
		} else {// Si no hay mensaje oculto
			msgOriginal = "No hay mensaje oculto";
		}

		return msgOriginal;

	}

	public BufferedImage getFoto() {
		return this.foto;
	}

	/*
	 * @post: Guarda en la variable global longitud la longitud del mensaje
	 */
	private void getLongitudMensaje(int pN,BufferedImage imagen) {

		String longAux = "";

		for (int i = 5; i < 12; i++) {
			color = new Color(imagen.getRGB(i, 0));
			String rojo = byteABinario((byte) color.getRed());
			String verde = byteABinario((byte) color.getGreen());
			String azul = byteABinario((byte) color.getBlue());

			// Saca los LSB por pasarle el 8
			String lsbRojo = getBit(pN, rojo);
			String lsbVerde = getBit(pN, verde);
			String lsbAzul = getBit(pN, azul);

			longAux = longAux + lsbRojo + lsbVerde + lsbAzul;
		}

		this.longitud = stringBinarioAInteger(longAux.substring(1, 17));

	}

	/*
	 * @post: Comprueba el flag y devuelve un boolean que indica si la imagen
	 * tiene mensaje oculto o no
	 */
	private boolean checkFlag(int pBit, BufferedImage imagen) {

		
		
		boolean hayMensaje = false;

		String flagAux = "";

		for (int i = 0; i < 6; i++) {

			color = new Color(imagen.getRGB(i, 0));
			
			//OK
			

			String rojo = byteABinario((byte) color.getRed());
			String verde = byteABinario((byte) color.getGreen());
			String azul = byteABinario((byte) color.getBlue());
			
			
			
			
			// Saca los LSB por pasarle un 8
			String lsbRojo = getBit(pBit, rojo);
			String lsbVerde = getBit(pBit, verde);
			String lsbAzul = getBit(pBit, azul);
			
			

			
			
			flagAux = flagAux + lsbRojo + lsbVerde + lsbAzul;
		}
		
		

		if ((getCaracterEnFormaDeString(flagAux.substring(0, 8)).equals("f"))
				&& (getCaracterEnFormaDeString(flagAux.substring(8, 16)).equals("l"))) {
			hayMensaje = true;
		}

		return hayMensaje;

	}

	/*
	 * @post: Devuelve un string con el mensaje obtenido a partir del array con
	 * el mensaje en binario
	 */
	private String getMensajeDeArrayBinario(String[] arrayBinario) {
		String mensaje = "";

		for (int i = 4; i < arrayBinario.length; i++) {
			mensaje = mensaje + getCaracterEnFormaDeString(arrayBinario[i]);
		}

		return mensaje;
	}

	/*
	 * @post: Devuelve el caracter, en forma de String, del String en binario
	 * que se pasa como parámetro.
	 */
	private String getCaracterEnFormaDeString(String strBin) {
		int aux;
		String strChar;

		aux = Integer.parseInt(strBin, 2);
		strChar = new Character((char) aux).toString();

		return strChar;
	}

	/*
	 * @post: Se obtiene el String que se quiere ocultar compuesto por el
	 * mensaje original el flag y la longitud del mensaje.
	 */
	private void crearMensaje(String mensaje) {
		String longitudBinario = "";

		
		longitud = mensaje.length() + flag.length() *2;
		
		
		
		//longitudBinario = Integer.toBinaryString(longitud);
		
		for( int i = 15; i>=0; i--){
	           longitudBinario = longitudBinario + ( ( ( longitud & ( 1<<i ) ) > 0 ) ? "1" : "0" ) ;
		}
		
		//
		

		
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
		String strBin = "";
		//String strBin = String.format("%8s", Integer.toBinaryString(byteChar & 0xFF)).replace(' ', '0');
		//
		
        for( int i = 7; i>=0; i--){
           strBin = strBin + ( ( ( byteChar & ( 1<<i ) ) > 0 ) ? "1" : "0" ) ;
        }

		
		//
        
        
		
		return strBin;
	}

	/*
	 * @post: Devuelve el int, del caracter en binario que se pasa como String
	 * como parámetro.
	 */
	private int stringBinarioAInteger(String strBin) {
		int intChar;
		intChar = Integer.parseInt(strBin, 2);
		return intChar;
	}

	/*
	 * @post: Devuelve el bit que se indica con el int del primer parámetro de
	 * un byte dado.
	 * 
	 * @Nota: Si se le pasa un 8 devuelve el LSB. Es decir, el último bit.
	 */
	private String getBit(int pN, String unByte) {
		String res = "";
		switch(pN){
			case 1:res = unByte.substring(0, 1);
			break;
			case 2:res = unByte.substring(1, 2);
			break;
			case 3:res = unByte.substring(2, 3);
			break;
			case 4:res = unByte.substring(3, 4);
			break;
			case 5:res = unByte.substring(4, 5);
			break;
			case 6:res = unByte.substring(5, 6);
			break;
			case 7:res = unByte.substring(6, 7);
			break;
			case 8:res = unByte.substring(7, 8);
			break;
		}
	
		return res;
	}

	/*
	 * @post: Sobreescribe el bit elegido (pN) del String (byte) que se pasa
	 * como parametro
	 */
	private String reemplazarBit(int pN, String strColor) {
		if (cont < msgBinario.length()) {

			switch(pN){
				case 1: strColor = msgBinario.substring(cont, cont + 1) + strColor.substring(1,8);
				cont++;
				break;
				case 2: strColor = strColor.substring(0,1) +  msgBinario.substring(cont, cont + 1) + strColor.substring(2,8);
				cont++;
				break;
				case 3: strColor = strColor.substring(0,2) +  msgBinario.substring(cont, cont + 1) + strColor.substring(3,8);
				cont++;
				break;
				case 4: strColor = strColor.substring(0,3) +  msgBinario.substring(cont, cont + 1) + strColor.substring(4,8);
				cont++;
				break;
				case 5: strColor = strColor.substring(0,4) +  msgBinario.substring(cont, cont + 1) + strColor.substring(5,8);
				cont++;
				break;
				case 6: strColor = strColor.substring(0,5) +  msgBinario.substring(cont, cont + 1) + strColor.substring(6,8);
				cont++;
				break;
				case 7: strColor = strColor.substring(0,6) +  msgBinario.substring(cont, cont + 1) + strColor.substring(7,8);
				cont++;
				break;
				case 8: strColor = strColor.substring(0,7) + msgBinario.substring(cont, cont + 1);
				cont++;
				break;
					
			}
				
			
		}
		return strColor;

	}
	
	public static void main(String [] args){
		
		EsteganografiaSinComp es = new EsteganografiaSinComp();
		
		es.ocultarMensaje("Ace-and-Luffy.bmp", "Dime que funciona con el bit 3", 3);
		
		es.extraerMensaje("fotoSC.bmp", 3);
		
		System.out.println(es.msgOriginal);
		
	}

}
