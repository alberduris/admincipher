package org.ciphermethods;

import java.math.BigInteger;

public class Afin {
	
	private static int primeraClave = 0; 
	private static int segundaClave = 0;
	private static int modulo = 26; //Longitud del alfabeto - 26 porque no se admite la 'ñ'
	
	private static String textoEntrada = "";
	private static String textoEncriptado = "";
	private static String textoSalida = "";
	
	public Afin(){
		
	}
	
	public void setPrimeraClave(Integer pPrimeraClave){
		primeraClave = pPrimeraClave;
	}
	
	public void setSegundaClave(Integer pSegundaClave){
		segundaClave = pSegundaClave;
	}
	
	public void setTextoAEncriptar(String pTexto){
		textoEntrada = pTexto;
	}
	
	public void setTextoADesencriptar(String pTexto) {
		textoEncriptado = pTexto;
		
	}
	

	/**Basado en el código extraído de Stack Overflow
	Pregunta: http://stackoverflow.com/questions/19605465/how-to-write-logic-for-affine-cipher-decryption-in-java
	Autor: http://stackoverflow.com/users/1196603/jk1
	Modificado por Alberto Blanco Garcés
	**/
	/*
	 * post: Encripta la cadena de texto almacenada en la variable global textoEntrada
	 * Fórmula: E(a;b)(M) = (aM + b) mod N
	 * Nota: La primera letra del alfabeto utilizado es la 'a' de ahí su uso
	 */
	public String encriptarAfin() {
		
		System.out.println(primeraClave);
		System.out.println(segundaClave);
		System.out.println(textoEntrada);
		
	    //Recorremos el textoEntrada 
	    for (int i = 0; i < textoEntrada.length(); i++) {
	        char charAux = textoEntrada.charAt(i);
	        
	        if (Character.isLetter(charAux)) { //Comprobamos que es una letra
	        	
	        	//El 'corazón' del método -- La fórmula matemática que lo define
	        	//E(a;b)(M) = (aM + b) mod N
	            charAux = (char) ((primeraClave * (charAux - 'a') + segundaClave) % modulo + 'a');
	        }
	        
	        //Se va generando el texto encriptado
	        textoEncriptado = textoEncriptado + charAux;
	    }
	    
	    return textoEncriptado;
	
	}

	/*
	 * post: Desencripta la cadena de texto almacenada en la variable global textoEntrada
	 * Fórmula: E(a;b)(M) = a^(-1)(x-b) mod M
	 * Nota: La primera letra del alfabeto utilizado es la 'a' de ahí su uso
	 */
	public String desencriptarAfin() {
	    
	    //Calculamos a^(-1)*mod(modulo)
		//Nota: Se recuerda la condición de que 'primeraClave' y 'módulo' deben ser primos entre si
	    BigInteger inversaMod = BigInteger.valueOf(primeraClave).modInverse(BigInteger.valueOf(modulo));
	    
	    
	    //Recorremos el textoEncriptado
	    for (int i = 0; i < textoEncriptado.length(); i++) {
	    	
	        char charAux = textoEncriptado.charAt(i);
	        
	        if (Character.isLetter(charAux)) {//Comprobamos que es una letra
	        	
	            int valorNumericoDesencriptado = inversaMod.intValue() * (charAux - 'a' - segundaClave + modulo);
	            charAux = (char) (valorNumericoDesencriptado % modulo + 'a');
	        }
	        
	        //Se va generado el texto de salida desencriptado
	        textoSalida = textoSalida + charAux;
	    }
	    return textoSalida;
	}
	
	public void reset(){
		primeraClave = 0;
		segundaClave = 0;
		textoEncriptado = "";
		textoEntrada = "";
	}

	

	

}
