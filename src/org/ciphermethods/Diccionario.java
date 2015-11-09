package org.ciphermethods;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;

public class Diccionario {
	
	private ArrayList<Character> alfabetoOriginal;
	private ArrayList<Character> alfabetoClave;
	private String palabraClave = "";
	
	private String textoEntrada = "";
	private String textoEncriptado = "";
	private String textoSalida = "";

	public Diccionario(){
		setAlfabetosIniciales();
	}
	
	public void encriptarDiccionario(){
		
		char auxEntrada = ' ';
		char auxEncriptado = ' ';
		int posAlfabetoOriginal = 0;
		StringBuilder strBuilder = new StringBuilder();
		
		for(int i = 0; i < textoEntrada.length(); i++ ){
			auxEntrada = textoEntrada.charAt(i);
			if(auxEntrada != ' '){
				if(auxEntrada == 'v') auxEntrada = 'u';
				posAlfabetoOriginal = alfabetoOriginal.indexOf(auxEntrada);
				auxEncriptado = alfabetoClave.get(posAlfabetoOriginal);
			}
			else{
				auxEncriptado = ' ';
			}
			strBuilder.append(auxEncriptado);
		}
		
		textoEncriptado = strBuilder.toString();
		
	}
	
public void desencriptarDiccionario(){
		
		char auxEncriptado = ' ';
		char auxSalida = ' ';
		int posAlfabetoClave = 0;
		StringBuilder strBuilder = new StringBuilder();
		
		for(int i = 0; i < textoEncriptado.length(); i++ ){
			auxEncriptado = textoEncriptado.charAt(i);
			if(auxEncriptado != ' '){
				posAlfabetoClave = alfabetoClave.indexOf(auxEncriptado);
				auxSalida = alfabetoOriginal.get(posAlfabetoClave);
			}
			else{
				auxSalida = ' ';
			}
			strBuilder.append(auxSalida);
		}
		
		textoSalida = strBuilder.toString();
		
	}
	
	private void setAlfabetosIniciales(){
		alfabetoClave = new ArrayList<Character>();
		alfabetoClave.add('a');alfabetoClave.add('b');alfabetoClave.add('c');alfabetoClave.add('d');
		alfabetoClave.add('e');alfabetoClave.add('f');alfabetoClave.add('g');alfabetoClave.add('h');
		alfabetoClave.add('i');alfabetoClave.add('j');alfabetoClave.add('k');alfabetoClave.add('l');
		alfabetoClave.add('m');alfabetoClave.add('n');alfabetoClave.add('o');alfabetoClave.add('p');
		alfabetoClave.add('q');alfabetoClave.add('r');alfabetoClave.add('s');alfabetoClave.add('t');
		alfabetoClave.add('u');alfabetoClave.add('w');alfabetoClave.add('x');alfabetoClave.add('y');
		alfabetoClave.add('z');
		
		alfabetoOriginal = new ArrayList<Character>();
		alfabetoOriginal.add('a');alfabetoOriginal.add('b');alfabetoOriginal.add('c');alfabetoOriginal.add('d');
		alfabetoOriginal.add('e');alfabetoOriginal.add('f');alfabetoOriginal.add('g');alfabetoOriginal.add('h');
		alfabetoOriginal.add('i');alfabetoOriginal.add('j');alfabetoOriginal.add('k');alfabetoOriginal.add('l');
		alfabetoOriginal.add('m');alfabetoOriginal.add('n');alfabetoOriginal.add('o');alfabetoOriginal.add('p');
		alfabetoOriginal.add('q');alfabetoOriginal.add('r');alfabetoOriginal.add('s');alfabetoOriginal.add('t');
		alfabetoOriginal.add('u');alfabetoOriginal.add('w');alfabetoOriginal.add('x');alfabetoOriginal.add('y');
		alfabetoOriginal.add('z');
	}
	
	private void setAlfabetoConPalabraClave(){
		
		char letra = ' ';
		
		for(int i = 0; i < palabraClave.length(); i++){
			letra = palabraClave.charAt(i);
			
			intercambiarLetra(letra, i);
		}
		
	}
	
	private void intercambiarLetra(char pLetra, int pPos) {
		char charOriginal = ' ';
		int posLetraASustituir = 0;
		
		charOriginal = alfabetoClave.get(pPos);
		posLetraASustituir = alfabetoClave.indexOf(pLetra);
		
		alfabetoClave.set(pPos, pLetra);
		alfabetoClave.set(posLetraASustituir, charOriginal);
	}
	
	private void imprimirAlfabetoClave(){
		for(int i = 0; i < alfabetoClave.size(); i++){
			System.out.print(alfabetoClave.get(i));
			if(i < alfabetoClave.size()-1) System.out.print("-");
		}
		System.out.println();
	}
	
	private void imprimirAlfabetoOriginal(){
		for(int i = 0; i < alfabetoOriginal.size(); i++){
			System.out.print(alfabetoOriginal.get(i));
			if(i < alfabetoOriginal.size()-1) System.out.print("-");
		}
		System.out.println();
	}
	
	private void setEntrada(String pTexto){
		textoEntrada = pTexto;
	}
	
	public void filtrarYSetPalabraClave(String pClave){
		
		char[] claveEnCadenaChar = pClave.toCharArray();
		
		Set<Character> charSet = new LinkedHashSet<Character>();
		for (char c : claveEnCadenaChar) {
		    charSet.add(c);
		}

		StringBuilder strBuilder = new StringBuilder();
		for (Character character : charSet) {
			if(Character.isLetter(character)){
				strBuilder.append(character);
			}
			
		}		
		palabraClave = strBuilder.toString().trim();
		setAlfabetoConPalabraClave();

	}
	
	private void generarPalabraClave(){
		Random rand = new Random();
		int longitud = rand.nextInt((25-15)+1)+15;
		int posAlfabetoOrig;
		char charAux;
		
		for(int i = 0; i < longitud; i++){
			posAlfabetoOrig = rand.nextInt(25);
			charAux = alfabetoOriginal.get(posAlfabetoOrig);
			if(!palabraClave.contains(Character.toString(charAux))){
				palabraClave = palabraClave + charAux;
			}
			else{
				i = i-1;
			}
			
		}
		
	}

	public static void main(String[] args) {
		
		Diccionario dic = new Diccionario();
		
		dic.generarPalabraClave();
		dic.setEntrada("test definitivo del metodo diccionario pagame mi honorario xdd rima lol");
		dic.setAlfabetoConPalabraClave();
		dic.imprimirAlfabetoOriginal();
		dic.imprimirAlfabetoClave();
		System.out.println(dic.textoEntrada);
		dic.encriptarDiccionario();
		System.out.println(dic.textoEncriptado);
		dic.desencriptarDiccionario();
		System.out.println(dic.textoSalida);
		 
	}

}
