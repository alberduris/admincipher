package org.ciphermethods;

public class Vigenere {
	private static Vigenere miVigenere;
	private String texto;
	private String textoClave;
	private String textoModificado;
	private char[][] sopa;
	
	private Vigenere(){
		crearSopa();
		textoModificado = "";
		texto = "";
	}
	
	public static Vigenere getVigenere(){
		if(miVigenere == null){
			miVigenere = new Vigenere();
		}
		return miVigenere;
	}
	
	public void introducirTexto(String pTexto){
		texto = "";
		for(int i =0; i<pTexto.length(); i++){
			if(pTexto.charAt(i) <= 90 && pTexto.charAt(i) >= 65){
				texto += pTexto.charAt(i);
			}else if(pTexto.charAt(i) == 'Ñ'){
				texto += 'N';
			}
		}
	}
	
	public void introducirClave(String pClave){
		int i =0;
		textoClave = "";
		while(textoClave.length() < texto.length()){
			if(pClave.charAt(i) < 91 && pClave.charAt(i) > 64) {
				textoClave += pClave.charAt(i);
			}else if(pClave.charAt(i) == 'Ñ'){
				textoClave += 'N';
			}
			i++;
			if(i == pClave.length()){
				i = 0;
			}
		}
	}
	
	private void crearSopa(){
		sopa = new char[26][26];
		char digito = 'A';
		for(int i = 0; i<26; i++){
			sopa[i][0] = digito;
			digito ++;
		}
		for(int i = 0; i<26; i++){
			digito = sopa[i][0];
			digito++;
			for(int j = 1; j<26; j++){
				if(digito > 90){
					digito = 'A';
				}
				sopa [i][j] = digito;
				digito ++;
			}
		}
	}
	//para pruebas
	private void imprimirSopa(){
		for(int i = 0; i<26; i++){
			for(int j = 0; j<26; j++){
				System.out.print(sopa[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public String cifrar(){
		for(int i = 0; i<texto.length(); i++){
			if(texto.charAt(i) > 90 && texto.charAt(i) <64){
				textoModificado = textoModificado + ' ';
			}else{
				textoModificado = textoModificado + sopa[texto.charAt(i)-65][textoClave.charAt(i)-65];
			}
		}
		return textoModificado;
	}
	
	public String descifrar(){
		for(int i = 0; i<texto.length(); i++){
			if(texto.charAt(i) > 90 && texto.charAt(i) <64){
				textoModificado = textoModificado + ' ';
			}else{
				textoModificado = textoModificado + sacarLetra(texto.charAt(i), textoClave.charAt(i));
			}
		}
		return textoModificado;
	}
	
	private char sacarLetra(char pLetra, char pLetraClave){
		int i = 0;
		boolean encontrado = false;
		while(!encontrado){
			if(sopa[i][pLetraClave-65] == pLetra){
				encontrado = true;
			}else{
				i++;
			}
		}
		char caracter = (char) (i+65);
		return caracter;
	}
	
	public void reset(){
		textoClave = "";
		texto = "";
		textoModificado = "";
	}

	
}
